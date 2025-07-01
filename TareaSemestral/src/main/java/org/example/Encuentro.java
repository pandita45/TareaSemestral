package org.example;

public class Encuentro{
    private Participante JugadorUno;
    private Participante JugadorDos;
    public Encuentro(Participante a , Participante b) {
        this.JugadorUno =a;
        this.JugadorDos =b;
    }

    public Participante getJugadorUno() {
        return JugadorUno;
    }

    public Participante getJugadorDos() {
        return JugadorDos;
    }
}
