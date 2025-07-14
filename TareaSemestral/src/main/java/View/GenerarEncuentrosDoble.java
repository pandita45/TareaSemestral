package View;

import Algoritmo.Encuentro;
import Algoritmo.Participante;
import Algoritmo.Torneo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que se usa para generar encuentros en el upper bracket de eliminacion doble
 */
public class GenerarEncuentrosDoble{
    /**
     * Metodo que genera los encuentros al igual que el de Eliminacion directa
     * @param participantes array desde el que se generaran los encuentros
     * @return devuelve el array con todos los encuentros generados
     */
    public ArrayList<Encuentro> generarEncuentros(ArrayList<Participante> participantes){
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = participantes.size();
        if (cantidadParticipantes > 1) {
            Torneo.hayEnfrentamientoEnLower = false;
            for (int i = 0; i <= cantidadParticipantes - 2; i += 2) {
                temp.add(new Encuentro(participantes.get(i), participantes.get(i + 1), new Date()));
            }
            return temp;
        }
        else {
            return null;
        }
    }
}
