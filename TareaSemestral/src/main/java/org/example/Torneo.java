package org.example;
import java.time.ZonedDateTime;


public class Torneo {
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private ZonedDateTime fechaInicial;
    private int cantidadParticipantes;
    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato,
                  ZonedDateTime fechaInicial, int cantidadParticipantes,
                  ZonedDateTime fechaTermino, ListaParticipantes listaParticipantes){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
        this.fechaInicial=fechaInicial;
        this.cantidadParticipantes=cantidadParticipantes;
    }
}
