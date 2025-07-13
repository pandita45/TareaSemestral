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

    public void agregarParticipantes(Participante participante){
        this.participante.add(participante);
    }

    public void jugar(Encuentro partida){
        formato.jugarPartida(partida);
    }

    public String getNombre() {
        return nombre;
    }

    public String getFormato() {
        return formato.print();
    }

    public ArrayList<Participante> getParticipantes() {
        return participante;
    }
    public ArrayList<Participante>getLowerBracket() {
        return lowerBracket;
    }

    public ArrayList<Participante> getGanadores() {
        return ganadores;
    }

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
