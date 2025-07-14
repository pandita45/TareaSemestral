package View;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana en donde están contenidos todos los paneles
 */
public class Ventana extends JFrame{
    private PanelPrincipal principal;
    private static Ventana instancia;

    /**
     * Constructor privado en donde se le agrega el panel principal y se definen algunos parametros, se usa patron de diseño singleton
     * para no tener más de una instancia de Ventana
     */
    private Ventana() {
        super();
        setLayout(null);
        getContentPane().setBackground(Color.decode("#1E1E2F"));
        principal = new PanelPrincipal();
        add(principal);

        setTitle("Torneo super Wuau");
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Getter de la instancia de ventana, en caso de no haber una se crea la unica instancia posible
     * @return instancia de la ventana
     */
    public static Ventana getInstancia() {
        if (instancia == null) {
            instancia = new Ventana();
        }
        return instancia;
    }

    /**
     * Metodo para refrescar la ventana
     */
    public static void actualizar(){
        instancia.repaint();
    }
}