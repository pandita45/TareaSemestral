package Algoritmo;

import java.util.ArrayList;

public class Equipo extends Participante{
    private ArrayList<Deportista> miembros;

    /**
     * Clase que contiene un array donde se guardan los Deportistas
     * @param nombre Se ingresa el nombre del equipo
     * @param contacto Un contacto, idealmente un correo electronico
     * @param antiguedad El tiempo de antiguedad
     */
    public Equipo(String nombre, String contacto, String antiguedad) {
        super(nombre,contacto, antiguedad);
        this.miembros = new ArrayList<Deportista>();
    }

    /**
     * @param puntos Agrega puntos correspondientes a victoria, derrota o empate
     */
    public void agregarPuntos(int puntos) {
        super.agregarPuntos(puntos);
    }

    /**
     * Metodo para agregar deportistas al equipo, usado en organizacion para llenar los equipos con jugadores
     * @param d Deportista a agregar
     */
    public void agregarDeportista(Deportista d){
        this.miembros.add(d);
    }

    /**
     * @return Devuelve la cantidad de puntos almacenada
     */

    public int getPuntos() {
        return super.getPuntos();
    }

    /**
     * @return Devuelve el Nombre del equipo
     */

    public String getNombre() {
        return super.getNombre();
    }

    /**
     * @return Devuelve el array con todos los jugadores del equipo
     */

    public ArrayList<Deportista> getMiembros(){
        return miembros;
    }

    /**
     * @return Devuelve el contacto
     */
    public String getContacto() {
        return super.getContacto();
    }

    /**
     * @return Devuelve la antiguedad
     */
    public String getEdad(){
        return super.getEdad();
    }
}
