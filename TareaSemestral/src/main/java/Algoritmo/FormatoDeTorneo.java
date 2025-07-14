package Algoritmo;

public interface FormatoDeTorneo {
    /**
     * Interfaz utilizada para crear distintos tipos de torneo y jugar sus partidas
     * @param partida Encuentro entregado como parametro
     */
    void jugarPartida(Encuentro partida);
    String print();
}
