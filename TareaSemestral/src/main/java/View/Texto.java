package View;

import javax.swing.*;
import java.awt.*;

/**
 * Metodo generador de Labels
 */
public class Texto extends JLabel {
    public static Font Font;

    /**
     * Constructor en donde se genera el texto
     * @param Mensaje Mensaje que tendra el texto
     * @param posX posicion en x
     * @param posY posicion en y
     * @param ancho ancho de la caja de texto
     * @param alto alto de la caja de texto
     */
    public Texto(String Mensaje,int posX, int posY,int ancho,int alto){
        super(Mensaje);
        setFont(Font);
        setForeground(Color.decode("#1A2E68").brighter().brighter().brighter().brighter());
        setOpaque(false);
        setBounds(Escalar.X(posX),Escalar.Y(posY),Escalar.X(ancho),Escalar.Y(alto));
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    static {
        Font = new Font("SansSerif", java.awt.Font.BOLD, Escalar.X(40));
    }

    /**
     * Version propia de setBounds pero escalado
     * @param posX posicion en x
     * @param posY posicion en y
     * @param ancho ancho de la caja de texto
     * @param alto alto de la caja de texto
     */
    public void setBound(int posX, int posY,int ancho,int alto){
        setBounds(Escalar.X(posX),Escalar.Y(posY),Escalar.X(ancho),Escalar.Y(alto));
    }
}