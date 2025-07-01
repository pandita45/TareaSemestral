package org.example;

public class EliminacionDirecta implements FormatoDeTorneo{
    @Override
    public void jugarPartida(Encuentro partida) {
        if(FormatoDeTorneo.selectWinner){
            eliminar(partida.getJugadorUno());
        }
        else{
            eliminar(partida.getJugadorDos());
        }
    }
    public void eliminar(Participante a){
            Torneo.participante.remove(a);
    }
    public void print(){
        System.out.println("Estas en EliminacionDirecta");
    }
}
