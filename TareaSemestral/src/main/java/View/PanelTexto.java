package View;
import Algoritmo.EliminacionDoble;

import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {
    public static Boolean LOU;
    private int[][] posiciones;
    public PanelTexto(boolean LOU,int[][] posiciones){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        this.LOU = LOU;
        this.posiciones = posiciones;
    }

    public void escribir() {
        if (LOU && PanelPrincipal.torneo != null) {

            for (int i = 0; i < 8; i++) {
                Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(i).getNombre(), posiciones[i][0], posiciones[i][1], 250, 50);
                add(texto);
            }
        } else {
            if (EliminacionDoble.lowerBracket != null) {
                for (int i = 0; i < EliminacionDoble.lowerBracket.size(); i++) {
                    Texto texto = new Texto(EliminacionDoble.lowerBracket.get(i).getNombre(), 30, 378 , 300, 85);
                    add(texto);
                }
            }
        }
        Ventana.actualizar();
    }
}
