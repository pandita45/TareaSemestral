package View;

import Algoritmo.Encuentro;
import Algoritmo.Participante;
import Algoritmo.Torneo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class GeneradorEncuentrosDirecta extends JPanel {
    private Boton boton1;
    private Boton boton2;
    private int ancho;
    private int alto;
    public GeneradorEncuentrosDirecta(int x, int y, int ancho, int alto){
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
            Torneo.selectWinner = false;
            if(!PanelPrincipal.matches.isEmpty()) {
                if (PanelPrincipal.matches.size() == 1) {
                    setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    boton1.setText("Continuar");
                    boton2.setText("Continuar");
                }
                else {
                    setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                }
            }
            jugarEncuentro();
            PanelPrincipal.MSI.mostrarGanador();
        });
        boton2.addActionListener(e -> {
            Torneo.selectWinner = true;
            if(!PanelPrincipal.matches.isEmpty()) {
                System.out.println(PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                if (PanelPrincipal.matches.size() == 1) {
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
    public ArrayList<Encuentro> generarEncuentros(ArrayList<Participante> participantes) {
        ArrayList<Encuentro> temp = new ArrayList<>();
        int cantidadParticipantes = participantes.size();
        if (cantidadParticipantes > 1) {
            for (int i = 0; i <= cantidadParticipantes - 2; i += 2) {
                temp.add(new Encuentro(participantes.get(i), participantes.get(i + 1), new Date()));
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
        else if (generarEncuentros(Torneo.participante)!=null){
            PanelPrincipal.matches = generarEncuentros(Torneo.participante);
            setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
        }
    }
}
