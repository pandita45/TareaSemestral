package org.example;

abstract class Participante {
    private String nombre;
    private String contacto;
    private int puntos;

    public Participante(String nombre, String contacto) {
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
