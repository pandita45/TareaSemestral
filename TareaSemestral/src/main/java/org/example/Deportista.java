package org.example;

public class Deportista implements Participantes{
    private int puntos = 0;
    public Deportista() {
    }

    @Override
    public void agregarPuntaje(int puntos) {
        this.puntos += puntos;

    }
}
