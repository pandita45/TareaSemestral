package org.example;

public class Entrenador implements Participantes{
    private int puntos = 0;
    public Entrenador(String nombre,String contacto) {
    }
    @Override
    public void agregarPuntaje(int puntos) {
        this.puntos += puntos;
    }
}
