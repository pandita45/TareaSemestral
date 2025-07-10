package Algoritmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {
    private Equipo e1;
    private Equipo e2;
    private Deportista d;
    private Deportista d1;
    @BeforeEach
    public void setup() {
        e1 = new Equipo("PRUEBA","PRUEBA","190");
        e2 = new Equipo("PRUEBA2","PRUEBA2","190");
        d = new Deportista("TOMI Iiommy","9999","56");
        d1 = new Deportista("Carlos","91","56");
    }
    @Test
    void agregarPuntos() {
        e1.agregarPuntos(3);
        e2.agregarPuntos(1);
        assertEquals(3,e1.getPuntos());
        assertEquals(1,e2.getPuntos());
        e1.agregarPuntos(23);
        e2.agregarPuntos(0);
        assertEquals(3+23,e1.getPuntos());
        assertEquals(1,e2.getPuntos());
    }

    @Test
    void agregarDeportista() {
        e1.agregarDeportista(d);
        e1.agregarDeportista(d1);
       assertEquals(d,e1.getMiembros().get(0));
       assertEquals(d1,e1.getMiembros().get(1));
    }
}