package View;
import Algoritmo.EliminacionDoble;

import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {
    public static Boolean LOU;
    public PanelTexto(boolean LOU){
        super();
        setLayout(null);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setOpaque(false);
        this.LOU = LOU;
    }

    public void escribir() {
        if (LOU && PanelPrincipal.torneo != null) {
            int sumY = 0;
            int k = 0;
            for (int i = 0; i < PanelPrincipal.torneo.getParticipantes().size() / 2; i++) {
                Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 75, 115 + sumY, 250, 50);
                add(texto);
                k++;
                if (i % 2 == 0) {
                    sumY += 130;
                } else {
                    sumY += 98;

                }
            }
        } else {
            int k = 0;
            if (EliminacionDoble.lowerBracket != null) {
                int sumY = 0;
                for (int i = 0; i < EliminacionDoble.lowerBracket.size() / 2; i++) {
                    Texto texto = new Texto(EliminacionDoble.lowerBracket.get(k).getNombre(), 30, 378 + sumY, 300, 85);
                    add(texto);
                    k++;
                    if (i % 2 == 0) {
                        sumY += 130;
                    } else {
                        sumY += 80;

                    }
                }
            }
        }
    }
}
