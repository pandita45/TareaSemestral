package Algoritmo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


class EliminacionDobleTest {
    private Participante jugador1;
    private Participante jugador2;
    private Participante jugador3;
    private Participante jugador4;

    private Torneo torneo;
    private Encuentro encuentro1;
    private Encuentro encuentro2;
    @BeforeEach
    public void setup() {
        jugador1 = new Deportista("Ana", "99999", "22");
        jugador2 = new Deportista("Ana1", "99999", "22");
        jugador3 = new Deportista("Ana2", "99999", "22");
        jugador4 = new Deportista("3", "99999", "22");
        torneo = new Torneo("Prueba", "prueba", new EliminacionDoble(), new Date(), new Date());
        torneo.agregarParticipantes(jugador1);
        torneo.agregarParticipantes(jugador2);
        torneo.agregarParticipantes(jugador3);
        torneo.agregarParticipantes(jugador4);
        encuentro1 = new Encuentro(jugador1, jugador2,new Date());
        encuentro2 = new Encuentro(jugador3,jugador4,new Date());

    }
    @Test
    void jugarPartida() {
        torneo.selectWinner= true; //Gana el primero
        torneo.jugar(encuentro1);
        assertEquals(true,torneo.getParticipantes().contains(jugador1));
        assertEquals(false,torneo.getParticipantes().contains(jugador2));
    }

    @Test
    void eliminar() {

    }
}