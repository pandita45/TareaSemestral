package org.example;
import java.util.Random;

public class Encuentro{
    private Participantes uno;
    private Participantes dos;
    private  int resultado;
    public Encuentro() {
    }
    public void Jugar(Participantes uno, Participantes dos){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2);
        if(numeroAleatorio == 0){
            uno.agregarPuntaje(3);
        }
        else{
            dos.agregarPuntaje(3);
        }

    }
}
