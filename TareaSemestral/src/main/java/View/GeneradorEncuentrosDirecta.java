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

    /**
     * Constructor en donde se le agregan botones al panel, los cuales serviran para determinar los ganadores de
     * los enfrentamientos generados en otro metodo de esta misma clase, llamado por los botones
     * @param x posicion en x de los botones
     * @param y altura a la que estaran los botones
     * @param ancho ancho de los botones
     * @param alto alto de los botones
     */
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
                    setTextButton(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    boton1.setText("Continuar");
                    boton2.setText("Continuar");
                }
                else {
                    setTextButton(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
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
                    setTextButton(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                }
            }
            jugarEncuentro();
            PanelPrincipal.MSI.mostrarGanador();
        });

        add(boton1);
        add(boton2);
    }

    /**
     * Metodo que genera encuentros a partir de un array dado
     * @param participantes array desde el que se generan los encuentros
     * @return devuelve el array de encuentros creado
     */
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

    /**
     * Metodo setter para los textos de los botones
     * @param nombre1 texto boton 1
     * @param nombre2 texto boton 2
     */
    public void setTextButton(String nombre1, String nombre2){
        this.boton1.setText(nombre1);
        this.boton2.setText(nombre2);
    }

    /**
     * Metodo setter posicion de los botones
     * @param x posicion en x
     * @param y posicion en y
     */
    public void setPosicion(int x , int y){
        boton1.setBounds(x,y,ancho,alto);
        boton2.setBounds(x+300,y,ancho,alto);
    }

    /**
     * Metodo para jugar un encuentro, si el array de encuentros no esta vacio, se juega el encuentro de indice 0
     */
    public void jugarEncuentro(){
        if(!PanelPrincipal.matches.isEmpty()){
            PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
        }
        else if (generarEncuentros(Torneo.participante)!=null){
            PanelPrincipal.matches = generarEncuentros(Torneo.participante);
            setTextButton(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
        }
    }
}
