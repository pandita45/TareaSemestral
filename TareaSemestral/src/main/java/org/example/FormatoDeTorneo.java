package org.example;

public interface FormatoDeTorneo {
    public static boolean selectWinner = true;
    public static boolean draw= false;
    //patron usado: Strategy Patron
    void jugarPartida(Encuentro partida);
    void print();
}
