package Algoritmo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


class EliminacionDobleTest {
    private Participante jugador1;
    private Participante jugador2;
    private Participante jugador4;
    private Torneo torneo;
    private Encuentro encuentro1;
    private Encuentro encuentro2;
    @BeforeEach
    public void setup() {
        jugador1 = new Deportista("Ana", "99999", "22");
        jugador2 = new Deportista("Ana1", "99999", "22");
        jugador4 = new Deportista("Ana3", "99999", "22");
        torneo = new Torneo("Prueba", "prueba", new EliminacionDoble(), new Date(), new Date());
        torneo.agregarParticipantes(jugador1);
        torneo.agregarParticipantes(jugador2);
        torneo.agregarParticipantes(jugador4);
        encuentro1 = new Encuentro(jugador1, jugador2,new Date());
        encuentro2 = new Encuentro(jugador4,jugador2,new Date());

    }
    @Test
    void jugarPartida() {
        torneo.selectWinner= false; //Gana el primero
        torneo.jugar(encuentro1);
        assertEquals(true,torneo.getParticipantes().contains(jugador1));  // el ganador se queda en participantes
        assertEquals(false,torneo.getParticipantes().contains(jugador2)); // el perdedor se va de participantes
        assertEquals(true,torneo.getLowerBracket().contains(jugador2)); // el perdedor queda en el array lowerBracket
        torneo.jugar(encuentro2);    // pierde el jugador 2
        assertEquals(false,torneo.getLowerBracket().contains(jugador2)); // jugador 2, con un derrota ahora se va del array lowerBracket
    }
}