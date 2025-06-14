package org.example;

public class Equipo extends Participantes{
    private ListaDeportistas miembros;
    private Entrenador entrenador;

    public Equipo(String nombre, String contacto, ListaDeportistas deportistas , Entrenador entrenador) {
        super(nombre,contacto);
        this.miembros = deportistas;
        this.entrenador = entrenador;
    }
    public void agregarPuntaje(int puntos) {
        super.agregarPuntaje(puntos);
    }

    public ListaDeportistas getParticipantes(){
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

    public ListaDeportistas getMiembros() {
        return miembros;
    }

    public String getContacto() {
        return super.getContacto();
    }
}
