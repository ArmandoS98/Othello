package com.tecnologiatransaccional.othello.Validaciones;

import com.tecnologiatransaccional.othello.Pojos.Indices;

import java.util.ArrayList;

public class Validaciones {

    public Validaciones(ArrayList<Indices> arrayList, int pos, int fila, int columna, boolean turnoJugador) {
        analizarHorizontalAtras(arrayList, pos, fila, columna, turnoJugador);
    }

    private void analizarHorizontalAtras(ArrayList<Indices> arrayList, int pos, int fila, int columna, boolean turnoJugador) {
        boolean convertir = false;
        int i = arrayList.get(pos).getColumna() - 1;
        int cal = pos - 1;
        String jugador = "";

        while (!convertir) {
            if (i == 0)
                convertir = true;
            else {
                if (!arrayList.get(cal).getJugador().equals("")) {
                    jugador = arrayList.get(cal).getJugador();
                    i = arrayList.get(cal).getColumna() - 1;
                    cal -= 1;
                } else
                    convertir = true;
            }
        }


        if (turnoJugador) {
            if (jugador.equals("X"))
                for (int z = (cal + 1); z <= pos; z++) {
                    arrayList.get(z).setJugador("X");
                }
        } else {
            if (jugador.equals("0"))
                for (int z = (cal + 1); z <= pos; z++) {
                    arrayList.get(z).setJugador("0");
                }
        }

        analizarHorizontalAdelante(arrayList, pos, fila, columna, turnoJugador);
    }


    private void analizarHorizontalAdelante(ArrayList<Indices> arrayList, int pos, int fila, int columna, boolean turnoJugador) {
        boolean convertir = false;
        int i = arrayList.get(pos).getColumna() + 1;
        int cal = pos + 1;
        String jugador = "";

        while (!convertir) {
            //Log.d(TAG, "analizarHorizontalAdelante: " + i);
            if (i == 0)
                convertir = true;
            else {
                if (!arrayList.get(cal).getJugador().equals("")) {
                    jugador = arrayList.get(cal).getJugador();
                    //Log.d(TAG, "analizarHorizontalAtras: val: " + i + " = " + jugador);
                    i = arrayList.get(cal).getColumna() + 1;
                    cal += 1;
                } else
                    convertir = true;
            }
        }


        if (turnoJugador) {
            if (jugador.equals("X"))
                //Log.d(TAG, "analizarHorizontalAtras: " + (cal + 1) + " P: " + pos);
                for (int z = pos; z <= (cal - 1); z++) {
                    // Log.d(TAG, "analizarHorizontalAtras: P" + z);
                    arrayList.get(z).setJugador("X");
                }
        } else {
            if (jugador.equals("0"))
                //Log.d(TAG, "analizarHorizontalAtras: " + (cal + 1) + " P: " + pos);
                for (int z = pos; z <= (cal - 1); z++) {
                    // Log.d(TAG, "analizarHorizontalAtras: P" + z);
                    arrayList.get(z).setJugador("0");
                }
        }
    }
}
