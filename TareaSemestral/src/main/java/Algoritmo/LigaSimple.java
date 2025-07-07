package Algoritmo;


public class LigaSimple implements FormatoDeTorneo{
    public void jugarPartida(Encuentro partida) {
        if(FormatoDeTorneo.draw){
            partida.getJugadorUno().agregarPuntos(1);
            partida.getJugadorDos().agregarPuntos(1);
            partida.getJugadorUno().addDraws(1);
            partida.getJugadorDos().addDraws(1);

        }
        else if(FormatoDeTorneo.selectWinner){
            partida.getJugadorUno().agregarPuntos(3);
            partida.getJugadorUno().addWins(1);
            partida.getJugadorDos().addLosses(1);
        }
        else{
            partida.getJugadorDos().agregarPuntos(3);
            partida.getJugadorDos().addWins(1);
            partida.getJugadorUno().addLosses(1);
        }
        Torneo.participante.sort((p1, p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));
    }
    public String print(){
        return "LigaSimple";
    }
}
