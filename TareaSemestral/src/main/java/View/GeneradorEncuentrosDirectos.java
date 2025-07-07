package View;

import Algoritmo.Encuentro;

import javax.swing.*;

public class GeneradorEncuentrosDirectos extends JPanel {
    private Boton boton1;
    private Boton boton2;
    private int cantidadParticipantes;
    private int n = 0;
    private boolean salirDelWhile = false;
    public GeneradorEncuentrosDirectos(){
        super();
        setLayout(null);
        setOpaque(false);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setVisible(true);
        boton1 = new Boton("J1",100,100,100,100);
        boton2 = new Boton("J3",100,200,100,100);
        boton1.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = false;
        });
        boton2.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = true;
        });
        add(boton1);
        add(boton2);
    }
    public void GenerarYJugarEncuentros(){
        cantidadParticipantes = PanelTorneoDirecto.CantidadParticipantes;
        for(int i = 0;i<cantidadParticipantes-1;i++){
            if(PanelPrincipal.torneo.getParticipantes().size() == cantidadParticipantes/2){
                n = 0;
            }
            Encuentro encuentro = new Encuentro(PanelPrincipal.torneo.getParticipantes().get(n),PanelPrincipal.torneo.getParticipantes().get(n+1),null);
            System.out.println(n);
            PanelPrincipal.torneo.jugar(encuentro);
            n++;
        }
    }
}
