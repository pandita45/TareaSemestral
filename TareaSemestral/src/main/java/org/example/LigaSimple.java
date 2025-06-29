package org.example;

import java.util.ArrayList;

public class LigaSimple implements FormatoDeTorneo{
    public void jugarPartida(Participante a, Participante b) {
        if(FormatoDeTorneo.draw){
            a.agregarPuntos(1);
            b.agregarPuntos(1);
        }
        else if(FormatoDeTorneo.selectWinner){
            a.agregarPuntos(3);
        }
        else{
            b.agregarPuntos(3);
        }
        Torneo.participante.sort((p1, p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));
    }
    public void print(){
        System.out.println("estas en LigaSimple");
    }
}
