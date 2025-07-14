package View;
import java.awt.*;

/**
 * Clase usada en todos los tamaños y posiciones para que sean compatibles con cualquier resolucion
 */
public class Escalar {
    private static final int BASE_ANCHO = 1920;
    private static final int BASE_ALTO = 1080;
    private static final Dimension RESOLUCION_ACTUAL = Toolkit.getDefaultToolkit().getScreenSize();

    private static final int ACTUAL_ANCHO = RESOLUCION_ACTUAL.width;
    private static final int ACTUAL_ALTO = RESOLUCION_ACTUAL.height;

    /**
     * Escala las posiciones en "x" y anchos
     * @param x el numero que se escalara
     * @return el numero escalado
     */
    public static int X(int x) {
        return (x * ACTUAL_ANCHO) / BASE_ANCHO;
    }

    /**
     * Escala las posiciones en "y" y altos
     * @param y numero que se escalara
     * @return numero escalado
     */
    public static int Y(int y) {
        return (y * ACTUAL_ALTO) / BASE_ALTO;
    }
}