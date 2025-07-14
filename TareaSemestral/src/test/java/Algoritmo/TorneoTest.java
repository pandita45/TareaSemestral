package Algoritmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TorneoTest {
    private Participante jugador1;
    private Participante jugador2;
    private Participante equipo1;
    private Participante equipo2;
    private Torneo torneo;
    private Torneo torneo1;
    @BeforeEach
    public void setup() {
        jugador1 = new Deportista("Ana", "99999", "22");
        jugador2 = new Deportista("Ana1", "99999", "22");
        equipo1 = new Equipo("FC","9999","190");
        equipo2 = new Equipo("FC1","9999","190");
        torneo = new Torneo("Prueba", "prueba", new EliminacionDirecta(), new Date(), new Date());
        torneo1 = new Torneo("Prueba1", "prueba", new EliminacionDirecta(), new Date(), new Date());
    }

    @Test
    void agregarParticipantes() {
        torneo.agregarParticipantes(jugador1);
        torneo.agregarParticipantes(jugador2);
        assertEquals(true,torneo.getParticipantes().contains(jugador1));
        assertEquals(true,torneo.getParticipantes().contains(jugador2));
        torneo1.agregarParticipantes(equipo1);
        torneo1.agregarParticipantes(equipo2);
        assertEquals(true,torneo1.getParticipantes().contains(equipo1));
        assertEquals(true,torneo1.getParticipantes().contains(equipo2));

    }
}