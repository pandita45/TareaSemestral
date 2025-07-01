package Algoritmo;

public class Deportista extends Participante{
    private int edad;
    public Deportista(String nombre, String contacto, String edad) {
        super(nombre,contacto,edad);
    }

    @Override
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
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

    public String getEdad() {
        return super.getEdad();
    }
}
