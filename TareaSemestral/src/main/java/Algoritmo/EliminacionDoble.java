package Algoritmo;

import java.util.ArrayList;

public class EliminacionDoble implements FormatoDeTorneo{
    public static ArrayList<Participante> lowerBracket;
    public EliminacionDoble(){
        lowerBracket = new ArrayList<>();
    }
    public void jugarPartida(Encuentro partida) {
        if(Torneo.selectWinner){
            if(lowerBracket.contains(partida.getJugadorUno())){
                eliminar(partida.getJugadorUno());
            }
            else{
                lowerBracket.add(partida.getJugadorUno());
                Torneo.ganadores.add(partida.getJugadorDos());
                Torneo.participante.remove(partida.getJugadorUno());
            }
        }
        else{
            if(lowerBracket.contains(partida.getJugadorDos())){
                eliminar(partida.getJugadorDos());
            }
            else{
                lowerBracket.add(partida.getJugadorDos());
                Torneo.ganadores.add(partida.getJugadorUno());
                Torneo.participante.remove(partida.getJugadorDos());
            }
        }
    }

    public void eliminar(Participante a){
        lowerBracket.remove(a);
    }


    public String print(){
        return "EliminacionDoble";
    }
}
