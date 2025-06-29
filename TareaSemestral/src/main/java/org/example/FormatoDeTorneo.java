package org.example;

public interface FormatoDeTorneo {
    public static boolean selectWinner = true;
    public static boolean draw= true;
    //patron usado: Strategy Patron
    void jugarPartida(Participante a, Participante b);
    void print();
}
