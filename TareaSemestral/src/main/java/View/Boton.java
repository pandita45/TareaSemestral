package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * Clase para generar la mayoria de botones del programa
 */
public class Boton extends JButton {
    /**
     * Constructor de la clase en donde se crea el boton con los parametros dados
     * @param texto que mensaje va a tener el boton
     * @param x posicion en x del boton
     * @param y posicion en y del boton
     * @param ancho ancho del boton
     * @param alto alto del boton
     */
    public Boton(String texto, int x, int y, int ancho, int alto) {
        super(texto);

        setBounds(Escalar.X(x), Escalar.Y(y), Escalar.X(ancho), Escalar.Y(alto));
        setFont(new Font("SansSerif", Font.PLAIN, Escalar.X(40)));
        setForeground(Color.decode(	"#EAEAEA"));
        setBackground(Color.decode("#4C84FF"));
        setBorder(new LineBorder(Color.decode("#44475a"), 2));
    }

    /**
     * Setter del color de fondo del boton
     * @param color a que color se quiere cambiar
     */
    public void setColor(String color){
        setBackground(Color.decode(color));
    }

}
