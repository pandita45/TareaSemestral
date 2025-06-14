package org.example;

abstract class Participantes {
    private String nombre;
    private String contacto;
    private int puntos;

    public Participantes(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getContacto() {
        return contacto;
    }
    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPuntaje(int punto){
    }
}
