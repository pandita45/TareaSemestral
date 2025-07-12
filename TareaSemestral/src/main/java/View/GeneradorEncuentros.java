package View;

import Algoritmo.Encuentro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class GeneradorEncuentros extends JPanel {
    private Boton boton1;
    private Boton boton2;
    private int ancho;
    private int alto;
    public GeneradorEncuentros(int x, int y, int ancho, int alto){
        super();
        setLayout(null);
        setOpaque(false);
        setSize(Escalar.X(1920),Escalar.Y(1080));
        setVisible(true);
        this.ancho=ancho;
        this.alto=alto;
        boton1 = new Boton("j", x,y,ancho,alto);
        boton2 = new Boton("N", x + 300,y,ancho,alto);
        boton1.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = false;
            if(!PanelPrincipal.matches.isEmpty()) {
                System.out.println(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre());
                if (PanelPrincipal.matches.size() == 1) {
                    setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    boton1.setText("Continuar");
                    boton2.setText("Continuar");
                }
                else if (PanelPrincipal.matches.size() > 1) {
                    setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                }
            }
            jugarEncuentro();
            PanelPrincipal.MSI.mostrarGanador();
        });
        boton2.addActionListener(e -> {
            PanelPrincipal.torneo.selectWinner = true;
            if(!PanelPrincipal.matches.isEmpty()) {
                System.out.println(PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                if (PanelPrincipal.matches.size() == 1) {
                    setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    boton1.setText("Continuar");
                    boton2.setText("Continuar");
                }
                else if (PanelPrincipal.matches.size() > 1) {
                    setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                }
            }
            jugarEncuentro();
            PanelPrincipal.MSI.mostrarGanador();
        });
        add(boton1);
        add(boton2);
    }
    public ArrayList<Encuentro> generarEncuentros() {
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = PanelPrincipal.torneo.getParticipantes().size();
        if (cantidadParticipantes > 1) {
            for (int i = 0; i <= cantidadParticipantes - 2; i += 2) {
                temp.add(new Encuentro(PanelPrincipal.torneo.getParticipantes().get(i), PanelPrincipal.torneo.getParticipantes().get(i + 1), new Date()));
            }
            return temp;
        }
        else {
            JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + PanelPrincipal.torneo.getParticipantes().getFirst().getNombre());
            return null;
        }

    }
    public void setTextButtom(String nombre1, String nombre2){
        this.boton1.setText(nombre1);
        this.boton2.setText(nombre2);
    }
    public void setPosicion(int x , int y){
        boton1.setBounds(x,y,ancho,alto);
        boton2.setBounds(x+300,y,ancho,alto);
    }
    public void jugarEncuentro(){
        if(!PanelPrincipal.matches.isEmpty()){
            PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
        }
        else if (generarEncuentros()!=null){
            PanelPrincipal.matches = generarEncuentros();
            setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
        }
    }
}
