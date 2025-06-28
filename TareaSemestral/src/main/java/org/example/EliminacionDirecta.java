package org.example;

import java.util.ArrayList;

public class EliminacionDirecta implements FormatoDeTorneo{
    @Override
    public void jugarPartida(Participante a, Participante b) {
        if(FormatoDeTorneo.selectWinner){
            eliminar(a);
        }
        else{
            eliminar(b);
        }
    }
    public void eliminar(Participante a){
            Torneo.participante.remove(a);
    }
    public void print(){
        System.out.println("Estas en EliminacionDirecta");
    }
}
