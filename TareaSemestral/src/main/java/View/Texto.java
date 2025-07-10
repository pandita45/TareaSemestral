package View;

import javax.swing.*;
import java.awt.*;

public class Texto extends JLabel {
    public static Font Font;

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
    public void setBound(int posX, int posY,int ancho,int alto){
        setBounds(Escalar.X(posX),Escalar.Y(posY),Escalar.X(ancho),Escalar.Y(alto));
    }
}