package org.example;


public class Entrenador extends Participante{
    private int edad;
    public Entrenador(String nombre,String contacto, int edad) {
        super(nombre,contacto);
        this.edad = edad;
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
