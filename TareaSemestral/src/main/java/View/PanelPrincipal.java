package View;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelBienvenida bienvenida;
    public static PanelTorneoDirecto MSI;
    public static PanelAgregarParticipantes agregarParticipantes;
    public PanelPrincipal(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        bienvenida = new PanelBienvenida();
        agregarParticipantes = new PanelAgregarParticipantes();
        MSI = new PanelTorneoDirecto();
        add(agregarParticipantes);
        add(bienvenida);
        add(MSI);
    }
}