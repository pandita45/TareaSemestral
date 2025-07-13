package Algoritmo;
import View.PanelPrincipal;

import java.util.ArrayList;
import java.util.Date;

import static Algoritmo.EliminacionDoble.lowerBracket;


public class Torneo {
    public static boolean selectWinner = true;
    public static boolean draw= false;
    public static ArrayList<Participante> participante;
    public static ArrayList<Participante> ganadores;
    public static ArrayList<Participante> perdedores;
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
        perdedores = new ArrayList<>();
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

    public String getDisciplina() {
        return disciplina;
    }

    public String getFormato() {
        return formato.print();
    }
    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaTermino() {
        return fechaTermino;
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
}
