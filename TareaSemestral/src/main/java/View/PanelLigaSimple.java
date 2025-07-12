package View;

import Algoritmo.Encuentro;
import Algoritmo.LigaSimple;
import Algoritmo.Participante;
import Algoritmo.Torneo;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class PanelLigaSimple extends JPanel {
    private PanelTabla tablaPosiciones;
    private int cont = 0;
    private GeneradorLigaSimple buttomMatches;
    private Boton boton1;
    private Boton boton2;
    private Boton boton3;
    
    public PanelLigaSimple() {
        super();
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        setLayout(null);
        setVisible(false);
        buttomMatches = new GeneradorLigaSimple();
        tablaPosiciones = new PanelTabla();
        tablaPosiciones.setBounds(Escalar.X(100), Escalar.Y(170), Escalar.X(800), Escalar.Y(800));
        tablaPosiciones.setBorder(null);

        boton1 = new Boton("j", 1200,170,200,150);
        boton3 = new Boton("Empate", 1400,170,200,150);
        boton2 = new Boton("", 1600,170,200,150);


        boton1.addActionListener(e->{
            if(!PanelPrincipal.matches.isEmpty()) {
                Torneo.selectWinner = true;
                PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
                tablaPosiciones.cargarDesdeTorneo();
                if(!PanelPrincipal.matches.isEmpty()){
                setText(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
            }
            }
            else {
                JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + tablaPosiciones.getGanador());
            }
        });
        boton2.addActionListener(e -> {
            if(!PanelPrincipal.matches.isEmpty()) {
                Torneo.selectWinner = false;
                PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
                tablaPosiciones.cargarDesdeTorneo();
                if(!PanelPrincipal.matches.isEmpty()){
                    setText(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                }
            }
            else {
                JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + tablaPosiciones.getGanador());
            }
        });
        boton3.addActionListener(e ->{
            if(!PanelPrincipal.matches.isEmpty()) {
                Torneo.draw = true;
                PanelPrincipal.torneo.jugar(PanelPrincipal.matches.removeFirst());
                tablaPosiciones.cargarDesdeTorneo();
                Torneo.draw = false;
                if(!PanelPrincipal.matches.isEmpty()){
                    setText(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                }
            }
            else {
            JOptionPane.showMessageDialog(Ventana.getInstancia(), "El ganador es " + tablaPosiciones.getGanador());
            }
        });

        add(tablaPosiciones);
        add(boton1);
        add(boton2);
        add(boton3);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (PanelPrincipal.torneo != null) {
            if(cont == 0){
                tablaPosiciones.cargarDesdeTorneo();
                Texto titulo = new Texto(PanelPrincipal.torneo.getNombre(), 0, 25, 1920, 90);
                add(titulo);
                cont++;
            }

        }
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("FondoLigaSimple.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image, Escalar.X(0), Escalar.Y(0), Escalar.X(1920), Escalar.Y(1080), null);

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen");
        }
        Ventana.actualizar();
    }

    public void generarEncuentro(){
        PanelPrincipal.matches = buttomMatches.generarEncuentroLiga();
    }

    public void setText(String nombre1,String nombre2){
        boton1.setText(nombre1);
        boton2.setText(nombre2);
    }
}

