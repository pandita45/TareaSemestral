package View;

import Algoritmo.Encuentro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class GeneradorLigaSimple extends JPanel {
    public GeneradorLigaSimple(){
        super();
        setLayout(null);
        setOpaque(false);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setVisible(true);
    }
    public ArrayList<Encuentro> generarEncuentroLiga(){
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = PanelPrincipal.torneo.getParticipantes().size();
        if(cantidadParticipantes > 1){
        for (int i = 0; i < cantidadParticipantes; i++) {
            for (int j = i + 1; j < cantidadParticipantes; j++) {
                temp.add(new Encuentro(PanelPrincipal.torneo.getParticipantes().get(i),PanelPrincipal.torneo.getParticipantes().get(j), new Date()));
            }
        }
        }
        Collections.shuffle(temp);
        return temp;
    }

}
