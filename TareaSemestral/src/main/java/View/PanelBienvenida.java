package View;

import javax.swing.*;

public class PanelBienvenida extends JPanel {
    private Texto textoBienvenida;
    public PanelBienvenida(){
        super();
        textoBienvenida = new Texto("Bienvenido, ingrese datos para crear torneo");
        textoBienvenida.setBounds(Escalar.X(255), Escalar.Y(100), Escalar.X(1500), Escalar.Y(90));
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        add(textoBienvenida);
    }
}
