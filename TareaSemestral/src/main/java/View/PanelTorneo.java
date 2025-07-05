package View;

import Algoritmo.Torneo;

import javax.swing.*;
import java.util.Objects;

public class PanelTorneo extends JPanel {
    public static Torneo torneo;
    public PanelTorneo(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        if(Objects.equals(torneo.getFormato(), "EliminacionDirecta")){
            if(torneo.getParticipantes().size() == 4){

            }
        }
        else if(Objects.equals(torneo.getFormato(), "EliminacionDoble")){

        }
        else{

        }
    }
}
