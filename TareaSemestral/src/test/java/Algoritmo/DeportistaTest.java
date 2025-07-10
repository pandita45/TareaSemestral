package Algoritmo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeportistaTest {
    private Participante jugador1;

    @BeforeEach
    public void setup() {
        jugador1 = new Deportista("Ana", "99999", "22");
    }
    @Test
    public void agregarPuntos() {
        jugador1.agregarPuntos(23);
        assertEquals(23,jugador1.getPuntos());
    }
}