package org.example;

public class Equipo implements Participantes{
    private int puntos = 0;
    public Equipo(String nombre, String contacto, ListaParticipantes deportistas , Entrenador entrenador) {
    }

    @Override
    public void agregarPuntaje(int puntos) {
        this.puntos += puntos;
    }
}
