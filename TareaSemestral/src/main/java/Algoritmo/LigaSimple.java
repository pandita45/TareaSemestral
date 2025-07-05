package Algoritmo;

public class LigaSimple implements FormatoDeTorneo{
    public void jugarPartida(Encuentro partida) {
        if(FormatoDeTorneo.draw){
            partida.getJugadorUno().agregarPuntos(1);
            partida.getJugadorDos().agregarPuntos(1);
        }
        else if(FormatoDeTorneo.selectWinner){
            partida.getJugadorUno().agregarPuntos(3);
        }
        else{
            partida.getJugadorDos().agregarPuntos(3);
        }
        Torneo.participante.sort((p1, p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));
    }
    public String print(){
        return "LigaSimple";
    }
}
