package Algoritmo;

import java.util.ArrayList;

public class EliminacionDirecta implements FormatoDeTorneo{

    public EliminacionDirecta() {
    }

    /**
     * Se juega la partida de eliminacion directa, en la que el perdedor es retirado del array de participantes
     * Mientras que el ganador se guarda en ganadores para su posterior visualizacion
     * @param partida Encuentro entregado como parametro
     */
    @Override
    public void jugarPartida(Encuentro partida) {
        if(Torneo.selectWinner){
            eliminar(partida.getJugadorUno());
            Torneo.ganadores.add(partida.getJugadorDos());

        }
        else{
            eliminar(partida.getJugadorDos());
            Torneo.ganadores.add(partida.getJugadorUno());
        }
    }

    /**
     * Se elimina del torneo al Participante seleccionado
     * @param a Participante a eliminar
     */
    public void eliminar(Participante a){
            Torneo.participante.remove(a);
    }
    public String print(){
        return "EliminacionDirecta";
    }


}
