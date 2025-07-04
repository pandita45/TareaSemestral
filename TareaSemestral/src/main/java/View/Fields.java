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
    private String texto;
    private JTextField campoText;
    public Fields(int fuente_Size,int posX, int posY,int ancho,int largo, String texto) {
        this.posX=posX;
        this.posY=posY;
        this.ancho=ancho;
        this.largo=largo;
        this.fuente_Size=fuente_Size;
        this.fuente = new Font("SansSerif", Font.PLAIN, Escalar.X(fuente_Size));
        this.texto = texto;
    }

    public JTextField crear() {
        Color colorTexto = Color.decode("#EAEAEA");
        Color colorBorde = Color.decode("#44475A");

        JTextField field = new JTextField(texto);
        field.setFont(fuente);
        field.setBounds(posX, posY, ancho, largo);

        field.setForeground(colorTexto);
        field.setCaretColor(colorTexto);
        field.setBackground(Color.decode("#4C84FF").darker().darker());


        Border paddingInterno = new EmptyBorder(5, 10, 5, 10);
        Border bordeExterior = BorderFactory.createLineBorder(colorBorde, 2, true);
        field.setBorder(new CompoundBorder(bordeExterior, paddingInterno));


        field.setForeground(Color.GRAY);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(texto)) {
                    field.setText("");
                    field.setForeground(colorTexto.darker());
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(texto);
                    field.setForeground(Color.GRAY.darker());
                }
            }
        });
        this.campoText = field;
        return field;
    }
    public String getTexto(){
        return campoText.getText();
    }
}
