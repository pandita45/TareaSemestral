package View;

import Algoritmo.Torneo;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    public static Torneo torneo;
    private PanelBienvenida bienvenida;
    public static PanelTorneoDirecto MSI;
    public static PanelAgregarParticipantes agregarParticipantes;
    public static PanelTorneoDoble Champions;
    public static Boton botonBracket;
    public PanelPrincipal(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        bienvenida = new PanelBienvenida();
        Champions = new PanelTorneoDoble();
        agregarParticipantes = new PanelAgregarParticipantes();
        MSI = new PanelTorneoDirecto();
        add(Champions);
        add(agregarParticipantes);
        add(bienvenida);
        add(MSI);
    }

}