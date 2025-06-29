package org.example;
import java.util.Random;

public class Encuentro{
    private Participante uno;
    private Participante dos;
    private  int resultado;
    public Encuentro() {
    }
    public void Jugar(Participante uno, Participante dos){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2);
        if(numeroAleatorio == 0){
            uno.agregarPuntos(3);
        }
        else{
            dos.agregarPuntos(3);
        }

    }
}
