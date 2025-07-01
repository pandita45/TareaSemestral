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
        Font = new Font("Arial", java.awt.Font.BOLD, 65);
    }
}