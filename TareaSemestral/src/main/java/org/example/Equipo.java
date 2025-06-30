package org.example;

import java.util.ArrayList;

public class Equipo extends Participante{
    private ArrayList<Deportista> miembros;
    public Equipo(String nombre, String contacto, String antiguedad) {
        super(nombre,contacto, antiguedad);
        this.miembros = new ArrayList<Deportista>();
    }
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
    }
    public void agregarDeportista(Deportista d){
        this.miembros.add(d);
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
    public String getEdad(){
        return super.getEdad();
    }
}
