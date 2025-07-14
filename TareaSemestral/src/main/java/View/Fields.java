package View;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Clase generadora de text fields (donde se introduce informacion por teclado)
 */
public class Fields {
    private int fuente_Size;
    private int posX;
    private int posY;
    private int ancho;
    private int alto;
    private Font fuente;
    private String texto;
    private JTextField campoText;

    /**
     * Constructor donde se inicializan las variables del Text Field
     * @param fuente_Size de que tamaño sera la fuente del Text Field
     * @param posX posicion en x
     * @param posY posicion en y
     * @param ancho ancho de la "caja"
     * @param alto alto de la "caja"
     * @param texto que texto de fondo tendra el Text Field
     */
    public Fields(int fuente_Size,int posX, int posY,int ancho,int alto, String texto) {
        this.posX=posX;
        this.posY=posY;
        this.ancho=ancho;
        this.alto =alto;
        this.fuente_Size=fuente_Size;
        this.fuente = new Font("SansSerif", Font.PLAIN, Escalar.X(fuente_Size));
        this.texto = texto;
    }

    /**
     * Metodo que crea el Text Field con los parametros definidos anteriormente
     * @return devuelve el Text Field creado
     */
    public JTextField crear() {
        Color colorTexto = Color.decode("#EAEAEA");
        Color colorBorde = Color.decode("#44475A");

        JTextField field = new JTextField(texto);
        field.setFont(fuente);
        field.setBounds(posX, posY, ancho, alto);

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

    /**
     * Getter del texto ingresado
     * @return texto ingresado por usuario
     */
    public String getTexto(){
        return campoText.getText();
    }
}
