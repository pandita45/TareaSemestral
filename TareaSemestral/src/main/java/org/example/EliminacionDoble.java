package org.example;

import java.util.ArrayList;

public class EliminacionDoble implements FormatoDeTorneo{
    public static ArrayList<Participante> lowerBracket;
    public EliminacionDoble(){
        lowerBracket = new ArrayList<>();
    }
    public void jugarPartida(Participante a, Participante b) {
        if(FormatoDeTorneo.selectWinner){
            if(lowerBracket.contains(a)){
                eliminar(a);
            }
            else{
                lowerBracket.add(a);
                Torneo.participante.remove(a);
            }
        }
        else{
            if(lowerBracket.contains(b)){
                eliminar(b);
            }
            else{
                lowerBracket.add(b);
                Torneo.participante.remove(b);
            }
        }
        for (Participante participante: lowerBracket) {
            System.out.print(participante.getNombre() + ", ");
        }
        System.out.println();
    }
    public Participante jugarFinal(){
        if(FormatoDeTorneo.selectWinner){
            return lowerBracket.get(0);
        }
        else{
            return Torneo.participante.get(0);
        }
    }
    public void eliminar(Participante a){
        lowerBracket.remove(a);
    }
    public void print(){
        System.out.println("Estas en EliminacionDoble");
    }
}
