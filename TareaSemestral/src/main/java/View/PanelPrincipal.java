package View;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelBienvenida bienvenida;
    public PanelPrincipal(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        bienvenida = new PanelBienvenida();
        add(bienvenida);
    }
}