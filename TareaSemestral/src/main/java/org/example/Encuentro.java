package org.example;
import java.util.Date;

public class Encuentro{
    private Participante JugadorUno;
    private Participante JugadorDos;
    private Date fechaHora;
    public Encuentro(Participante a , Participante b,Date fechaHora) {
        this.JugadorUno =a;
        this.JugadorDos =b;
        this.fechaHora=fechaHora;
    }

    public Participante getJugadorUno() {
        return JugadorUno;
    }

    public Participante getJugadorDos() {
        return JugadorDos;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
