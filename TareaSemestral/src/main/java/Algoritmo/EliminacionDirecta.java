package Algoritmo;

import java.util.ArrayList;

public class EliminacionDirecta implements FormatoDeTorneo{

    public EliminacionDirecta() {
    }
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
    public void eliminar(Participante a){
            Torneo.participante.remove(a);
    }
    public String print(){
        return "EliminacionDirecta";
    }


}
