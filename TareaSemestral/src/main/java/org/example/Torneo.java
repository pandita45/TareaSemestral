package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;


public class Torneo {
    public static ArrayList<Participante> participante;
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private ZonedDateTime fechaInicial;
    private ZonedDateTime fechaTermino;
    private int cantidadParticipantes;

    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
        this.participante = new ArrayList<>();
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

    public void getFormato() {
        formato.print();
    }
    public ZonedDateTime getFechaInicial() {
        return fechaInicial;
    }

    public ZonedDateTime getFechaTermino() {
        return fechaTermino;
    }

    public ArrayList<Participante> getParticipantes() {
        return participante;
    }
}
