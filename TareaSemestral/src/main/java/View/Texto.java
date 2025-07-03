package View;

import javax.swing.*;
import java.awt.*;

public class Texto extends JLabel {
    public static Font Font;

    public Texto(String Mensaje){
        super(Mensaje);
        setFont(Font);
        setForeground(Color.BLACK);
        setOpaque(false);
    }
    static {
        Font = new Font("Times New Roman", java.awt.Font.BOLD, Escalar.X(65));
    }
}