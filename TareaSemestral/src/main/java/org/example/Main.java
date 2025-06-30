package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {


        Torneo t = new Torneo("balatro", "balatrez", new LigaSimple());
        Organizacion orga = new Organizacion(t, true);

        for( Participante par: Torneo.participante){
            System.out.println(par.getPuntos()+" "+par.getNombre() + " " + par.getContacto() + " " + par.getEdad());
        }
    }
}
