package Algoritmo;

import java.util.ArrayList;

public class EliminacionDoble implements FormatoDeTorneo {
    public static ArrayList<Participante> lowerBracket;

    public EliminacionDoble() {
        lowerBracket = new ArrayList<>();
    }

    /**
     * Se juega la partida de eliminacion doble, donde si el perdedor, se cuentra en el lowerBracket es eliminado del torneo
     * En caso de que el perdedor no este en lowerBracket, es agregado a el
     * El ganador sigue en participantes, considerado como el upperBracket
     * @param partida Encuentro entregado como parametro
     */
    public void jugarPartida(Encuentro partida) {
        if (Torneo.selectWinner) { // gana el segundo cuando selectwinner es true
            if (lowerBracket.contains(partida.getJugadorUno())) {
                eliminar(partida.getJugadorUno());
            } else {
                lowerBracket.add(partida.getJugadorUno());
                Torneo.ganadores.add(partida.getJugadorDos());
                Torneo.participante.remove(partida.getJugadorUno());
            }
        } else { // gana el primero cuando el selectwinner es false
            if (lowerBracket.contains(partida.getJugadorDos())) {
                eliminar(partida.getJugadorDos());
            } else {
                lowerBracket.add(partida.getJugadorDos());
                Torneo.ganadores.add(partida.getJugadorUno());
                Torneo.participante.remove(partida.getJugadorDos());
            }
        }
    }

    /**
     * Elimina un participante del lowerBracket, eliminacion completa
     * @param a Participante a eliminar
     */
    public void eliminar(Participante a){
        lowerBracket.remove(a);
    }

    public String print(){
        return "EliminacionDoble";
    }
}
