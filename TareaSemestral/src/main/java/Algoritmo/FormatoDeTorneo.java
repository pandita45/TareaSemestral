package Algoritmo;

public interface FormatoDeTorneo {
    public static boolean selectWinner = true;
    public static boolean draw= true;
    //patron usado: Strategy Patron
    void jugarPartida(Encuentro partida);
    String print();
}
