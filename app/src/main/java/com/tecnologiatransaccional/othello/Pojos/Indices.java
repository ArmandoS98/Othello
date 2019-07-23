package com.tecnologiatransaccional.othello.Pojos;

public class Indices {
    private int fila;
    private int columna;
    private String jugador;

    public Indices() {
    }

    public Indices(int fila, int columna, String jugador) {
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Indices{" +
                "fila=" + fila +
                ", columna=" + columna +
                ", jugador='" + jugador + '\'' +
                '}';
    }
}
