package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Boton extends JButton {
    public Boton(String texto, int x, int y, int ancho, int alto) {
        super(texto);

        setBounds(Escalar.X(x), Escalar.Y(y), Escalar.X(ancho), Escalar.Y(alto));
        setFont(new Font("SansSerif", Font.PLAIN, Escalar.X(40)));
        setForeground(Color.decode(	"#EAEAEA"));
        setBackground(Color.decode("#4C84FF"));
        setBorder(new LineBorder(Color.decode("#44475a"), 2));
    }
    public void setColor(String color){
        setBackground(Color.decode(color));
    }
}
