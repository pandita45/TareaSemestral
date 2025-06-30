package org.example;

import java.util.ArrayList;

public class Equipo extends Participante{
    private ArrayList<Deportista> miembros;
    public Equipo(String nombre, String contacto, int antiguedad) {
        super(nombre,contacto, antiguedad);
    }
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
    }
    public void agregarDeportista(Deportista d){
        miembros.add(d);
    }
    public ArrayList<Deportista> getParticipantes(){
        return miembros;
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
