package org.example;
import java.time.ZonedDateTime;


public class Torneo {
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private ZonedDateTime fechaInicial;
    private ZonedDateTime fechaTermino;
    private int cantidadParticipantes;
    private ListaDeportistas participante;

    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato,
                  ZonedDateTime fechaInicial, ZonedDateTime fechaTermino){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
        this.fechaInicial=fechaInicial;
    }

    public void agregarParticipantes(ListaDeportistas participante){
        this.participante = participante;
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

    public ListaDeportistas getParticipante() {
        return participante;
    }
}
