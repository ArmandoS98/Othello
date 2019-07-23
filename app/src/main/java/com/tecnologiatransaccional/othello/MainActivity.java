package com.tecnologiatransaccional.othello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.tecnologiatransaccional.othello.Adaptador.ViewAdapter;
import com.tecnologiatransaccional.othello.Pojos.Board;
import com.tecnologiatransaccional.othello.Pojos.Indices;
import com.tecnologiatransaccional.othello.Validaciones.Validaciones;
import com.tecnologiatransaccional.othello.interfaces.TableroPOS;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TableroPOS {
    private static final String TAG = "MainActivity";

    private Board b = new Board();

    private TextView mTextViewJugador;
    RecyclerView recyclerView;
    ViewAdapter mViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewJugador = findViewById(R.id.tv_jugador);
        recyclerView = findViewById(R.id.recyclerview);

        inittablero(StudentDataPrepare(), true);

    }

    private void inittablero(ArrayList<Indices> valor, boolean turnoJugador) {
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 8);
        recyclerView.setLayoutManager(manager);
        mViewAdapter = new ViewAdapter(this, valor, turnoJugador);
        recyclerView.setAdapter(mViewAdapter);
    }

    private ArrayList<Indices> StudentDataPrepare() {
        ArrayList<Indices> datos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 3 && j == 3 || i == 4 && j == 4)
                    datos.add(new Indices(i, j, "X"));
                else if (i == 3 && j == 4 || i == 4 && j == 3)
                    datos.add(new Indices(i, j, "0"));
                else
                    datos.add(new Indices(i, j, ""));
            }
        }

        return datos;
    }

    @Override
    public void Pos(int fila, int columna) {
        Toast.makeText(this, "Fila: " + fila + " Columna: " + columna, Toast.LENGTH_SHORT).show();
        //analizarHorizontalAtras(arrayList,p fila, columna);
    }

    @Override
    public void Posx(ArrayList<Indices> arrayList, int fila, int columna, int pos, boolean turnoJugador) {
        //Toast.makeText(this, "POS: " + pos, Toast.LENGTH_SHORT).show();
        //Log.d(TAG, "Posx: " + arrayList.get(pos).getJugador());

        new Validaciones(arrayList, pos, fila, columna, turnoJugador);

        if (turnoJugador) {
            mViewAdapter.actualizacion(false);
            mTextViewJugador.setText("Turno del jugador: 0");
        } else {
            mViewAdapter.actualizacion(true);
            mTextViewJugador.setText("Turno del jugador: X");
        }
    }


}
