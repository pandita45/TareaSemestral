package org.example;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Participante p = new Deportista("Yuuzito1", "Gonzalez",12);
        Participante p2 = new Deportista("Bryan2", "Aguirre",13);
        Participante p3 = new Deportista("Yuuzito3", "Gonzalez",14);
        Participante p4 = new Deportista("Bryan4", "Aguirre",15);
        Participante p5 = new Deportista("Yuuzito5", "Gonzalez",16);
        Participante p6 = new Deportista("Bryan6", "Aguirre",17);
        Participante p7 = new Deportista("Yuuzito7", "Gonzalez",18);
        Participante p8 = new Deportista("Bryan8", "Aguirre",2);
        ArrayList<Participante> lista = new ArrayList<>();
        lista.add(p);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);
        Torneo t = new Torneo("balatro", "balatrez", new EliminacionDirecta());
        t.agregarParticipantes(lista);
        while(Torneo.participante.size() != 1){
        int variable = Torneo.participante.size()/2;
        for (int i = 0; i < variable; i++){
            t.jugar(Torneo.participante.get(i), Torneo.participante.get(i + 1));
        }
        }
    }
}
