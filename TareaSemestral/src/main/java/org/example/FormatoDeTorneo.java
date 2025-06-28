package org.example;

public interface FormatoDeTorneo {
    public static boolean selectWinner = true;
    //patron usado: Strategy Patron
    void jugarPartida(Participante a, Participante b);
    void print();
}
