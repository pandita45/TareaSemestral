package View;

import Algoritmo.Encuentro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Clase generadora de los encuentros para liga simple
 */
public class GeneradorLigaSimple extends JPanel {
    /**
     * constructor donde se settea el tamaño y se dan caracteristicas al panel
     */
    public GeneradorLigaSimple(){
        super();
        setLayout(null);
        setOpaque(false);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setVisible(true);
    }

    /**
     * Metodo que genera los encuentros, de modalidad todos contra todos
     * @return devuelve el array con todos los encuentros generados
     */
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
