package View;

import Algoritmo.Deportista;
import Algoritmo.EliminacionDoble;
import Algoritmo.Encuentro;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.Date;


public class PanelTorneoDoble extends JPanel {
    private int cont = 0;
    public static Boton botonBracket;
    public static Boolean queBracket = true;
    private PanelTexto nombresUpper;
    private PanelTexto nombresLower;
    public PanelTorneoDoble(){
        super();
        Date b = new Date();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
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
}
