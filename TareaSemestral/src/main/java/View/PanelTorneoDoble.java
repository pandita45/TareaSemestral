package View;

import Algoritmo.*;

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
    public static Boolean estoyEnUpper = false;
    public Boton boton1;
    public Boton boton2;
    private PanelTexto nombresUpper;
    private PanelTexto nombresLower;
    private GenerarEncuentrosDoble encuentrosDoble;
    private int[][] posicionesGanadores;
    private ArrayList<Encuentro> lowerBracket;
    private int cont1 = 8;
    private int cont2 = 1;
    private Participante ganadorUpper;

    public PanelTorneoDoble() {
        super();
        encuentrosDoble = new GenerarEncuentrosDoble();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        posicionesGanadores = new int[][]{
                {75, 115},
                {75, 243},
                {75, 345},
                {75, 473},
                {75, 570},
                {75, 700},
                {75, 797},
                {75, 927},
                {267, 180},
                {267, 410},
                {267, 640},
                {267, 865},
                {475, 288},
                {475, 745},
                {670, 525},
                {1125, 140},
                {1420, 140},
                {1340, 275}, //ultimo upper bracket index = 17
                {55, 395},
                {55, 530},
                {55, 600},
                {55, 735},
                {450, 325},
                {450, 530},
                {450, 460},
                {450, 665},
                {840, 390},
                {840, 605},
                {1240, 320},
                {1240, 498},
                {1630, 390},
        };
        nombresUpper = new PanelTexto(false, posicionesGanadores);
        nombresLower = new PanelTexto(true, posicionesGanadores);

        botonBracket = new Boton("Lower Bracket", 1500, 900, 350, 80);
        botonBracket.addActionListener(e -> {
            if (queBracket) {
                botonBracket.setText("Upper Bracket");
                queBracket = false;
            } else {
                botonBracket.setText("Lower Bracket");
                queBracket = true;
            }
        });

        boton1 = new Boton("j", 1100, 700, 200, 100);
        boton2 = new Boton("j", 1400, 700, 200, 100);


        boton1.addActionListener(e -> {
            if (queBracket) {
                Torneo.selectWinner = false;
                if (!PanelPrincipal.matches.isEmpty()) {
                    if (PanelPrincipal.matches.size() == 1) {
                        setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                        boton1.setText("Juegue el Lower Bracket");
                        boton2.setText("Juegue el LB");
                    } else {
                        setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                    }
                    jugarEncuentro(PanelPrincipal.matches);
                }
            }
            else{
                Torneo.selectWinner = false;
                if (!PanelPrincipal.matches.isEmpty()) {
                    if (PanelPrincipal.matches.size() == 1) {
                        setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                        boton1.setText("Juegue el Lower Bracket");
                        boton2.setText("Juegue el LB");
                    } else {
                        setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                    }
                    jugarEncuentro(PanelPrincipal.matches);
                }
            }
            for (Participante p : PanelPrincipal.torneo.getParticipantes()) {
                System.out.println(p.getNombre() + " ");
            }
            for (Participante p : PanelPrincipal.torneo.getLowerBracket()) {
                System.out.print(p.getNombre() + " ");
            }
            PanelPrincipal.Champions.mostrarGanador();
        });
        boton2.addActionListener(e -> {
            if (queBracket) {
                Torneo.selectWinner = true;
                if (!PanelPrincipal.matches.isEmpty()) {
                    if (PanelPrincipal.matches.size() == 1) {
                        setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                        boton1.setText("Continuar");
                        boton2.setText("Continuar");
                        System.out.println(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre() + " " + PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    } else {
                        setTextButtom(PanelPrincipal.matches.get(1).getJugadorUno().getNombre(), PanelPrincipal.matches.get(1).getJugadorDos().getNombre());
                    }
                }
                jugarEncuentro(PanelPrincipal.matches);
                PanelPrincipal.Champions.mostrarGanador();
            }
            if (PanelPrincipal.torneo.getParticipantes().size() == 4) {
                jugarEncuentro(lowerBracket);
                PanelPrincipal.Champions.mostrarGanador();
            }
        });

        add(boton2);
        add(boton1);
        add(botonBracket);
        add(nombresUpper);
        add(nombresLower);
    }

    public void mostrarGanador() {
        if (queBracket && PanelPrincipal.torneo != null && !Torneo.ganadores.isEmpty()) {
            Participante p = Torneo.ganadores.removeFirst();
            Texto ganador = new Texto(p.getNombre(), 0, 0, 0, 0);
            ganador.setBound(posicionesGanadores[cont1][0], posicionesGanadores[cont1][1], 250, 50);
            nombresUpper.add(ganador);
            Ventana.actualizar();
            cont1++;
        }
        if (PanelPrincipal.torneo.getLowerBracket() != null && !PanelPrincipal.torneo.getLowerBracket().isEmpty()) {
            Participante p = Torneo.perdedores.removeFirst();
            Texto ganador = new Texto(p.getNombre(), 0, 0, 0, 0);
            ganador.setBound(posicionesGanadores[cont2 + 17][0], posicionesGanadores[cont2 + 17][1], 250, 50);
            nombresLower.add(ganador);
            Ventana.actualizar();
            cont2++;
        }
    }


    public void generarEncuentrosUpper() {
        PanelPrincipal.matches = encuentrosDoble.generarEncuentros(Torneo.participante);
    }


    public void setTextButtom(String nombre1, String nombre2) {
        boton1.setText(nombre1);
        boton2.setText(nombre2);
    }


    public void jugarEncuentro(ArrayList<Encuentro> encuentros) {
        if (!encuentros.isEmpty()) {
            PanelPrincipal.torneo.jugar(encuentros.removeFirst());
            if (!encuentros.isEmpty()) {
                setTextButtom(
                        encuentros.getFirst().getJugadorUno().getNombre(),
                        encuentros.getFirst().getJugadorDos().getNombre()
                );
            } else {
                ArrayList<Encuentro> nuevos = null;
                if (estoyEnUpper) {
                    nuevos = encuentrosDoble.generarEncuentros(Torneo.participante);
                    estoyEnUpper = false;
                } else {
                    nuevos = PanelPrincipal.torneo.generarEncuentrosLower();
                    estoyEnUpper = true;
                }
                if (nuevos != null && !nuevos.isEmpty()) {
                    PanelPrincipal.matches = nuevos;
                    setTextButtom(
                            nuevos.getFirst().getJugadorUno().getNombre(),
                            nuevos.getFirst().getJugadorDos().getNombre()
                    );
                }
            }
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(cont == 0){
            nombresUpper.escribir();
            LOU = false;
            cont++;
        }
        if (PanelPrincipal.torneo != null) {
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
}
