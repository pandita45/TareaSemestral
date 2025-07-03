package View;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Fields {
    private Font fuente;
    private int fuente_Size;
    private int posX;
    private int posY;
    private int ancho;
    private int largo;
    public Fields(int fuente_Size,int posX, int posY,int ancho,int largo) {
        this.posX=posX;
        this.posY=posY;
        this.ancho=ancho;
        this.largo=largo;
        this.fuente_Size=fuente_Size;
        this.fuente = new Font("SansSerif", Font.PLAIN, Escalar.X(fuente_Size));


    }

    public JTextField crear() {
        Color colorPrincipal = Color.decode("#146D8B");
        Color colorTexto = Color.BLACK;
        Color colorFondo = colorPrincipal.darker();
        JTextField field = new JTextField();
        field.setFont(fuente);
        field.setBounds(posX,posY,ancho,largo);
        field.setBackground(colorFondo);
        field.setForeground(colorTexto);
        field.setCaretColor(colorTexto);
        Border paddingInterno = new EmptyBorder(5, 10, 5, 10);
        Border bordeExterior= BorderFactory.createLineBorder(Color.gray, 2, true);
        field.setBorder(new CompoundBorder(bordeExterior, paddingInterno));
        return field;
    }
}
