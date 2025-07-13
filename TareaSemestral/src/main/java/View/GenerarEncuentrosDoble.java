package View;

import Algoritmo.Encuentro;
import Algoritmo.Participante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class GenerarEncuentrosDoble{
    public GenerarEncuentrosDoble(){

    }
    public ArrayList<Encuentro> generarEncuentros(ArrayList<Participante> participantes){
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = participantes.size();
        if (cantidadParticipantes > 1) {
            for (int i = 0; i <= cantidadParticipantes - 2; i += 2) {
                temp.add(new Encuentro(participantes.get(i), participantes.get(i + 1), new Date()));
            }
            return temp;
        }
        else {
            return null;
        }
    }
    public ArrayList<Encuentro> generarEncuentrosLower(ArrayList<Encuentro> encuentros, ArrayList<Participante> participantes){
        if(participantes.size() >= 2){
            encuentros.add(new Encuentro(participantes.get(0),participantes.get(1),new Date()));
        }
        return encuentros;
    }
}
