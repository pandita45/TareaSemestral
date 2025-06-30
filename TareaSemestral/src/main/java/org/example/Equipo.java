package org.example;

import java.util.ArrayList;

public class Equipo extends Participante{
    private ArrayList<Deportista> miembros;
    private Entrenador entrenador;
    private int edad;
    public Equipo(String nombre, String contacto, ArrayList<Deportista> deportistas , Entrenador entrenador, int edad) {
        super(nombre,contacto, edad);
        this.miembros = deportistas;
        this.entrenador = entrenador;
    }
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
    }

    public ArrayList<Deportista> getParticipantes(){
        return miembros;
    }
    public Entrenador getEntrenador(){
        return entrenador;
    }

    public int getPuntos() {
        return super.getPuntos();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public ArrayList<Deportista> getMiembros() {
        return miembros;
    }

    public String getContacto() {
        return super.getContacto();
    }
    public int getEdad(){
        return super.getEdad();
    }
}
