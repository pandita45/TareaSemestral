package View;

import Algoritmo.Encuentro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class GeneradorEncuentros extends JPanel {
    private Boton boton1;
    private Boton boton2;
    public GeneradorEncuentros(int x, int y, int ancho, int alto){
        super();
        setLayout(null);
        setOpaque(false);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setVisible(true);
        boton1 = new Boton("j", x,y,ancho,alto);
        boton2 = new Boton("N", x + 200,y,ancho,alto);
        boton1.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = false;
            if(!PanelPrincipal.matches.isEmpty()) {
                System.out.println(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre());
                setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
            }
            jugarEncuentro();
        });
        boton2.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = true;
            jugarEncuentro();
            if(!PanelPrincipal.matches.isEmpty()) {
                setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
            }
        });

        add(boton1);
        add(boton2);
    }
    public ArrayList<Encuentro> generarEncuentros(){
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = PanelPrincipal.torneo.getParticipantes().size();
        for(int i = 0; i <= cantidadParticipantes - 2; i += 2){
            temp.add(new Encuentro(PanelPrincipal.torneo.getParticipantes().get(i), PanelPrincipal.torneo.getParticipantes().get(i+1), new Date()));
        }
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).getJugadorUno().getNombre()  + "  VS  " + temp.get(i).getJugadorDos().getNombre());
        }
        System.out.println("RONDA TERMINADA");
        return temp;
    }
    public void setTextButtom(String nombre1, String nombre2){
        this.boton1.setText(nombre1);
        this.boton2.setText(nombre2);
    }
    public void jugarEncuentro(){
        if(!PanelPrincipal.matches.isEmpty()){
            PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
        }
        else{
            PanelPrincipal.matches = generarEncuentros();
        }
    }
}
