package Algoritmo;
import View.PanelPrincipal;
import View.Ventana;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

import static Algoritmo.EliminacionDoble.lowerBracket;


public class Torneo {
    public static boolean selectWinner = true;
    public static boolean draw= false;
    public static ArrayList<Participante> participante;
    public static ArrayList<Participante> ganadores;
    public static boolean hayEnfrentamientoEnLower = false;
    private int cont=0;
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private Date fechaInicial;
    private Date fechaTermino;

    /**
     * Clase principal, recibe 5 parametros para ser creada
     * @param nombre   Nombre asignado al torneo
     * @param disciplina   Disciplina elegida
     * @param formato      Se selecciona un formato, Directa, doble o liga
     * @param fechaInicial  Se setea una fecha inicial
     * @param fechaTermino  Se setea una fecha de termino
     */
    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato,
                  Date fechaInicial, Date fechaTermino){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
        participante = new ArrayList<>();
        ganadores=new ArrayList<>();
        this.fechaInicial=fechaInicial;
        this.fechaTermino=fechaTermino;
    }

    /**
     * Agrega un participante al array de participantes interno del torneo
     * @param participante  Participante, puede ser un equipo u deportista individual
     */

    public void agregarParticipantes(Participante participante){
        this.participante.add(participante);
    }

    /**
     * Juega un encuentro, las caracteristicas de jugar, se definen dentro de cada formato, implementacion del patron Strategy
     * @param partida Un encuentro creado entre 2 jugadores
     */

    public void jugar(Encuentro partida){
        formato.jugarPartida(partida);
    }

    /**
     * @return Devuelve el nombre del torneo creado, para posterior visualizacion
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * @return Obtiene como string el formato elegido, usado para posterior comprobacion en metodos de visualizacion
     */

    public String getFormato() {
        return formato.print();
    }

    /**
     * @return Devuelve el array de participantes
     */
    public ArrayList<Participante> getParticipantes() {
        return participante;
    }

    /**
     * @return Devuelve el array donde estan los jugadores del lowerBracket, usado en eliminacion doble
     */
    public ArrayList<Participante>getLowerBracket() {
        return lowerBracket;
    }

    /**
     * @return Devuelve el array donde son almacenados los gandaores, usado para mostrar en pantalla los vencedores
     */

    public ArrayList<Participante> getGanadores() {
        return ganadores;
    }

    /** Genera los encuentros para el lowerBracket (Funcional a nivel de logica)
     * Implementacion visual imcompleta, Leer Redmi para mas informacion
     * @return Devuelve un array con encuentros listos para jugar, correspondiente al lower
     */

    public ArrayList<Encuentro> generarEncuentrosLower(){
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = lowerBracket.size();
        if(cont == 0) {
            hayEnfrentamientoEnLower = true;
            cont++;
            if (cantidadParticipantes > 1) {
                for (int i = 0; i <= cantidadParticipantes - 2; i += 2) {
                    temp.add(new Encuentro(lowerBracket.get(i), lowerBracket.get(i + 1), new Date()));
                }
                return temp;
            } else {
                JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + PanelPrincipal.torneo.getParticipantes().getFirst().getNombre());
                return null;
            }
        }
        else{
            cont--;
            if (cantidadParticipantes > 1) {
                for (int i = 0; i <= cantidadParticipantes - 3; i += 1) {
                    temp.add(new Encuentro(lowerBracket.get(i), lowerBracket.get(i + 2), new Date()));
                }
                return temp;
            } else {
                JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + PanelPrincipal.torneo.getParticipantes().getFirst().getNombre());
                return null;
            }
        }
    }
}
