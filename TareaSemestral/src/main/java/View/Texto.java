package View;

import javax.swing.*;
import java.awt.*;

public class Texto extends JLabel {
    public static Font Font;

    public Texto(String Mensaje){
        super(Mensaje);
        setFont(Font);
        setForeground(Color.decode("#EAEAEA"));
        setOpaque(false);
    }
    static {
        Font = new Font("SansSerif", java.awt.Font.BOLD, Escalar.X(65));
    }
}