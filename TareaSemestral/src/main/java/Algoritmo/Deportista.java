package Algoritmo;

public class Deportista extends Participante{
    /**
     * Se crea el deportista, ya sea individual o perteneciente a algun equipo
     * @param nombre Nombre del Deportista
     * @param contacto Contacto, Idealmente correo electronico
     * @param edad Edad en formato String
     */
    public Deportista(String nombre, String contacto, String edad) {
        super(nombre,contacto,edad);
    }

    /**
     * Se agregan los puntos en caso de ganar o empatar
     * @param puntos Agrega puntos correspondientes a victoria, derrota o empate
     */
    @Override
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
    }

    /**
     * @return Se obtiene los puntos almacenados, para posterior visualizacion
     */
    public int getPuntos() {
        return super.getPuntos();
    }

    /**
     * @return Devuelve el nombre para visualizarlo
     */
    public String getNombre() {
        return super.getNombre();
    }

    /**
     * @return Devuelve el contacto
     */
    public String getContacto() {
        return super.getContacto();
    }

    /**
     * @return Devuelve la edad
     */
    public String getEdad() {
        return super.getEdad();
    }
}
