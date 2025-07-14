package Algoritmo;
import java.util.Date;

public class Encuentro{
    private Participante JugadorUno;
    private Participante JugadorDos;
    private Date fechaHora;

    /**
     * Crea encuentros entre 2 Participantes, para luego ser jugado
     * @param a Primer Participante
     * @param b Segundo Participante
     * @param fechaHora Fecha del encuentro
     */
    public Encuentro(Participante a , Participante b,Date fechaHora) {
        this.JugadorUno =a;
        this.JugadorDos =b;
        this.fechaHora=fechaHora;
    }

    /**
     * @return Devuelve el primer participante
     */
    public Participante getJugadorUno() {
        return JugadorUno;
    }

    /**
     * @return Devuelve el segundo participante
     */

    public Participante getJugadorDos() {
        return JugadorDos;
    }

}
