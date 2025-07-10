package Algoritmo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LigaSimpleTest {
    private Torneo torneo;
    private Encuentro e;
    private Encuentro e1;
    private Encuentro e2;
    private Participante jugador1;
    private Participante jugador2;
    private Participante jugador3;
    private Participante jugador4;
    private Participante jugador5;
    private Participante jugador6;


    @BeforeEach
    public void setup() {
        torneo = new Torneo("Prueba", "prueba", new LigaSimple(), new Date(), new Date());
        jugador1 = new Deportista("Ana", "99999", "22");
        jugador2 = new Deportista("JOEL", "99999", "22");
        jugador3 = new Deportista("Tomi", "99999", "22");
        jugador4 = new Deportista("Dogo", "99999", "22");
        jugador5 = new Deportista("Carlos", "99999", "22");
        jugador6 = new Deportista("Juan", "99999", "22");
        e = new Encuentro(jugador1, jugador2,new Date());
        e1 = new Encuentro(jugador3,jugador4,new Date());
        e2 = new Encuentro(jugador5,jugador6,new Date());
    }
    @Test
    public void jugar() {
        torneo.draw = true; //Empate
        torneo.jugar(e);
        assertEquals(1,jugador1.getPuntos());
        assertEquals(1,jugador2.getPuntos());
        assertEquals(1,jugador1.getDraws());
        assertEquals(1,jugador2.getDraws());
        torneo.draw = false;

        torneo.selectWinner = true; // Gana el primer jugador
        torneo.jugar(e1);
        assertEquals(3,jugador3.getPuntos());
        assertEquals(0,jugador4.getPuntos());
        assertEquals(1,jugador3.getWins());
        assertEquals(0,jugador3.getLosses());
        assertEquals(0,jugador4.getWins());
        assertEquals(1,jugador4.getLosses());

        torneo.selectWinner = false; // Gana el segundo jugador
        torneo.jugar(e2);
        assertEquals(0,jugador5.getPuntos());
        assertEquals(3,jugador6.getPuntos());
        assertEquals(0,jugador5.getWins());
        assertEquals(1,jugador5.getLosses());
        assertEquals(1,jugador6.getWins());
        assertEquals(0,jugador6.getLosses());
    }
}