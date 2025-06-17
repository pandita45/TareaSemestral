package org.example;

public class EliminacionDoble implements FormatoDeTorneo{
    private Encuentro encuentro;
    public EliminacionDoble(){
        encuentro = new Encuentro();

    }
    public void jugarPartida(Participante a, Participante b) {
        encuentro.Jugar(a,b);
    }
}
