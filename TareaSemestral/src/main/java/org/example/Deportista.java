package org.example;

public class Deportista extends Participante{
    private int edad;

    public Deportista(String nombre, String contacto, int edad) {
        super(nombre,contacto);
        this.edad = edad;
    }

    @Override
    public void agregarPuntaje(int puntos) {
        super.agregarPuntaje(puntos);
    }
    public int getPuntos() {
        return super.getPuntos();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getContacto() {
        return super.getContacto();
    }

    public int getEdad() {
        return edad;
    }
}
