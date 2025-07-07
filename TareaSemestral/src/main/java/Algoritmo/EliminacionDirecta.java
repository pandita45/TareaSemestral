package Algoritmo;

public class EliminacionDirecta implements FormatoDeTorneo{
    @Override
    public void jugarPartida(Encuentro partida) {
        if(Torneo.selectWinner){
            eliminar(partida.getJugadorUno());
        }
        else{
            eliminar(partida.getJugadorDos());
        }
    }
    public void eliminar(Participante a){
            Torneo.participante.remove(a);
    }
    public String print(){
        return "EliminacionDirecta";
    }
}
