package com.tecnologiatransaccional.othello.Adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecnologiatransaccional.othello.Pojos.Indices;
import com.tecnologiatransaccional.othello.R;
import com.tecnologiatransaccional.othello.interfaces.TableroPOS;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Indices> datos;
    private TableroPOS mTableroPOS;
    private boolean jugador;

    public ViewAdapter(Context mContext, ArrayList<Indices> datos, boolean jugador) {
        this.mContext = mContext;
        this.datos = datos;
        this.jugador = jugador;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(/*"[" + datos.get(i).getFila() + ", " + datos.get(i).getColumna() + "]"*/  datos.get(i).getJugador());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mTableroPOS = (TableroPOS) mContext;
    }

    public void actualizacion(boolean turnoJugador) {
        notifyDataSetChanged();
        this.jugador = turnoJugador;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mTableroPOS.Posx(datos, datos.get(getAdapterPosition()).getFila(), datos.get(getAdapterPosition()).getColumna(), getAdapterPosition(), jugador);
        }
    }
}
