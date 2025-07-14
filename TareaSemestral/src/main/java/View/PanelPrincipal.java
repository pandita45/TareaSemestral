package View;

import Algoritmo.Encuentro;
import Algoritmo.Torneo;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Panel al que se le agregan todos los otros paneles
 */
public class PanelPrincipal extends JPanel {
    public static ArrayList<Encuentro> matches;
    public static Torneo torneo;
    public static PanelBienvenida bienvenida;
    public static PanelTorneoDirecto MSI;
    public static PanelAgregarParticipantes agregarParticipantes;
    public static PanelTorneoDoble Champions;
    public static PanelLigaSimple liga;

    /**
     * Se le dan los parametros y se le agregan todos los otros paneles necesarios
     */
    public PanelPrincipal(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        bienvenida = new PanelBienvenida();
        Champions = new PanelTorneoDoble();
        liga = new PanelLigaSimple();
        agregarParticipantes = new PanelAgregarParticipantes();
        MSI = new PanelTorneoDirecto();
        add(Champions);
        add(agregarParticipantes);
        add(bienvenida);
        add(MSI);
        add(liga);
    }

}