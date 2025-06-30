package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {


        Torneo t = new Torneo("balatro", "balatrez", new LigaSimple());
        Organizacion orga = new Organizacion(t, false);
    }
}
