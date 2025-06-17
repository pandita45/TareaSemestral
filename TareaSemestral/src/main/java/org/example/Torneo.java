package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;


public class Torneo {
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private ZonedDateTime fechaInicial;
    private ZonedDateTime fechaTermino;
    private int cantidadParticipantes;
    private ArrayList<Participante> participante;

    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
    }

    public void agregarParticipantes(ArrayList<Participante> participante){
        this.participante = participante;
    }
    public void jugar(String a){
        for(Participante participante: participante){
            if(participante.getNombre().equals(a)){

            }
        }
    }



    public String getNombre() {
        return nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public FormatoDeTorneo getFormato() {
        return formato;
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
