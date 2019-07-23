package com.tecnologiatransaccional.othello.interfaces;

import com.tecnologiatransaccional.othello.Pojos.Indices;

import java.util.ArrayList;

public interface TableroPOS {
    void Pos(int fila, int columna);

    void Posx(ArrayList<Indices> arrayList, int fila, int columna, int pos, boolean turnoJugador);
}
