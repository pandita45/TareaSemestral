package org.example;

abstract class Participante {
    private String nombre;
    private String contacto;
    private int puntos;
    private String edad;
    public Participante(String nombre, String contacto, String edad) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.edad = edad;
    }

    public String getContacto() {
        return contacto;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }
    public String  getEdad(){
        return this.edad;
    }
}
