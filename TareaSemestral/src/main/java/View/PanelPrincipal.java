package View;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelTorneo MSI;
    private PanelBienvenida bienvenida;
    public static PanelAgregarParticipantes agregarParticipantes;
    public PanelPrincipal(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        bienvenida = new PanelBienvenida();
        agregarParticipantes = new PanelAgregarParticipantes();
        MSI = new PanelTorneo();
        add(agregarParticipantes);
        add(bienvenida);
        add(MSI);
    }
}