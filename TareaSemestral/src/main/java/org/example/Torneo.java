package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;


public class Torneo {
    //Para poder acceder al arraylist desde cualquier clase
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
    }

    public void agregarParticipantes(ArrayList<Participante> participante){
        this.participante = participante;
    }


    public void jugar(Participante a, Participante b){
        for (Participante participante: Torneo.participante) {
            System.out.print(participante.getNombre() + ", ");
        }
        System.out.println();
        System.out.println(a.getNombre());
        System.out.println(b.getNombre());
        formato.jugarPartida(a,b);
        System.out.println("-------------sebaaa, la casa---------------");
        for (Participante participante: Torneo.participante) {
            System.out.print(participante.getNombre() + ", ");
        }
        System.out.println();
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
