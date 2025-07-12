package View;

import Algoritmo.Deportista;
import Algoritmo.EliminacionDoble;
import Algoritmo.Encuentro;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static View.PanelTexto.LOU;


public class PanelTorneoDoble extends JPanel {
    private int cont = 0;
    public static Boton botonBracket;
    public static Boolean queBracket = true;
    private PanelTexto nombresUpper;
    private PanelTexto nombresLower;
    private GeneradorEncuentrosDirecta EncuentrosUpper;
    private GeneradorEncuentrosDirecta EncuentrosLower;
    private int[][] posicionesGanadores;
    private int cont1;
    private int cont2;
    public PanelTorneoDoble(){
        super();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        posicionesGanadores = new int[][]{
                {75,115},
                {75,145},
                {75,243},
                {75,373},
                {75,471},
                {75,601},
                {75,699},
                {75,829},
                {267,180},
                {267,410},
                {267,640},
                {267,865},
                {475,288},
                {475,745},
                {670,525},
                {1125,140},
                {1420,140},
                {1340,275}, //ultimo upper bracket index = 17
                {55,395},
                {55,530},
                {55,600},
                {55,735},
                {450,325},
                {450,460},
                {450,530},
                {450,665},
                {840,390},
                {840,605},
                {1240,320},
                {1240,498},
                {1630,390},
        };
        nombresUpper = new PanelTexto(true);
        nombresLower = new PanelTexto(false);
        botonBracket = new Boton("Lower Bracket", 1500,900,350,80);
        botonBracket.addActionListener(e -> {
            if (queBracket){
                botonBracket.setText("Upper Bracket");
                queBracket = false;
            }
            else {
                botonBracket.setText("Lower Bracket");
                queBracket = true;
            }
        });
        EncuentrosUpper = new GeneradorEncuentrosDirecta(1100,700,200,100);
        EncuentrosLower = new GeneradorEncuentrosDirecta(1100,700,200,100);
        nombresLower.add(EncuentrosLower);
        nombresUpper.add(EncuentrosUpper);
        add(botonBracket);
        add(nombresUpper);
        add(nombresLower);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (PanelPrincipal.torneo != null) {
            escribir();
            if (queBracket) {
                nombresLower.setVisible(false);
                nombresUpper.setVisible(true);
                try {
                    ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("UpperBracket.png"));
                    Image image = imageIcon.getImage();
                    g.drawImage(image, Escalar.X(0), Escalar.Y(0), Escalar.X(1920), Escalar.Y(1080), null);

                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen");
                }
                Ventana.actualizar();
            } else {
                nombresLower.setVisible(true);
                nombresUpper.setVisible(false);
                try {
                    ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("lowerBracket.png"));
                    Image image = imageIcon.getImage();
                    g.drawImage(image, Escalar.X(0), Escalar.Y(0), Escalar.X(1920), Escalar.Y(1080), null);

                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen");
                }
                Ventana.actualizar();

            }
        }
    }
    public void escribir(){
        if(cont == 0){
        nombresUpper.escribir();
        cont++;
        }
        else{
        }
    }
    public void mostrarGanador() {
        if (LOU && PanelPrincipal.torneo != null) {
            Texto ganador = new Texto(PanelPrincipal.torneo.getParticipantes().removeFirst().getNombre(), 0, 0, 0, 0);
            ganador.setBound(posicionesGanadores[cont1][0], posicionesGanadores[cont1][1], 250, 50);
            add(ganador);
            Ventana.actualizar();
            cont1++;
        }
        else if(EliminacionDoble.lowerBracket != null){
            Texto ganador = new Texto(PanelPrincipal.torneo.getParticipantes().removeFirst().getNombre(), 0, 0, 0, 0);
            ganador.setBound(posicionesGanadores[cont2+17][0], posicionesGanadores[cont2+17][1], 250, 50);
            add(ganador);
            Ventana.actualizar();
            cont2++;
        }
    }
    public ArrayList<Encuentro> generarEncuentrosUpper(){
        return EncuentrosUpper.generarEncuentros();
    }
    public ArrayList<Encuentro> generarEncuentrosLower(){
        return EncuentrosLower.generarEncuentros();
    }
}
