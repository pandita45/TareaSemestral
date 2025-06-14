package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Participantes> g = new ArrayList<>();
        Participantes participante1 = new Deportista("Balatrez Martinez", "BalatrezMartinez@Gmail.com", 24);
        g.add(participante1);
        Torneo torneo = new Torneo("Balatro Balatrez", "Balatro", FormatoDeTorneo.DOBLE, ZonedDateTime.now(), ZonedDateTime.now());
        System.out.println(ZonedDateTime.now());
    }
}
