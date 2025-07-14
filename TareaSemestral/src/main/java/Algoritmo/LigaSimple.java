package Algoritmo;

public class LigaSimple implements FormatoDeTorneo{
    /**
     * Este metodo recibe una partida y la juega, al estar en liga, debe sumar puntos y estadisticas segun corresponda
     * 3 puntos para los vencedores, 1 por empate y 0 por derrota, asi como sumar un victoria, derrota o empate
     * @param partida Encuentro a jugar
     */
    public void jugarPartida(Encuentro partida) {
        if(Torneo.draw){
            partida.getJugadorUno().agregarPuntos(1);
            partida.getJugadorDos().agregarPuntos(1);
            partida.getJugadorUno().addDraws(1);
            partida.getJugadorDos().addDraws(1);

        }
        else if(Torneo.selectWinner){
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
