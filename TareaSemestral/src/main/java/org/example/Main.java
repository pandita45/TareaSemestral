package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Torneo t = new Torneo("balatro", "balatrez", new LigaSimple());
        Organizacion orga = new Organizacion(t, false);
        Equipo l = new Equipo("yuuzito chupalo","mihn chupalo","Quiero birra");
        Participante p = Torneo.participante.get(0);
        Participante p1 = Torneo.participante.get(1);
        Participante p2 = Torneo.participante.get(2);
        t.jugar(p,l);
        t.jugar(p1,l);
        t.jugar(p2,l);
        System.out.println(p.getNombre()+" "+ p.getContacto()+ " "+ p.getContacto()+" "+ p.getPuntos());
        System.out.println(p1.getNombre()+" "+ p1.getContacto()+ " "+ p1.getContacto()+" "+ p1.getPuntos());
        System.out.println(p2.getNombre()+" "+ p2.getContacto()+ " "+ p2.getContacto()+" "+ p2.getPuntos());
        }
    }

