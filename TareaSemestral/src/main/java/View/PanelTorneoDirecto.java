package View;

import Algoritmo.Torneo;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelTorneoDirecto extends JPanel {
    private String img;
    private int sumY;
    private int cont = 0;
    private int cont_1=0;
    private int[][] posicionesGanadores;
    private GeneradorEncuentrosDirecta buttomMatches;
    private int CantidadParticipantes;
    public PanelTorneoDirecto(){
        super();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        posicionesGanadores = new int[][]{
                {447,572},
                {1037,572},
                {735,850}, //pos ganador del torneo
                {380,265},
                {380,805},
                {1240,265},
                {1240,805},
                {615,540},
                {1005,540},
                {810,730}, //pos ganador del torneo
                {270,185},
                {270,412},
                {270,640},
                {270,868},
                {1400,185},
                {1400,412},
                {1400,640},
                {1400,868},
                {475,292},
                {475,747},
                {1195,292},
                {1195,747},
                {670,525},
                {995,525},
                {835,680} //pos ganador del torneo
        };
        buttomMatches = new GeneradorEncuentrosDirecta(700,900,200,100);
        add(buttomMatches);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(PanelPrincipal.torneo != null && Objects.equals(PanelPrincipal.torneo.getFormato(), "EliminacionDirecta")) {
            Texto titulo = new Texto(PanelPrincipal.torneo.getNombre(), 0, 25, 1920, 90);
            add(titulo);
            int k = 0;
            if (cont == 0) {
                CantidadParticipantes = PanelPrincipal.torneo.getParticipantes().size();
                switch (CantidadParticipantes) {
                    case 4 -> img = "ElimDirecta4.png";
                    case 8 -> img = "ElimDirecta8.png";
                    case 16 -> img = "ElimDirecta16.png";
                }
                Texto vs = new Texto("VS", 725 , 910, 450, 85);
                for (int i = 0; i < 2; i++) {
                    sumY = 0;
                    for (int j = 0; j < CantidadParticipantes / 2; j++) {
                        if (CantidadParticipantes == 4) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 110 + i * 1247, 278 + j * 584, 450, 85);
                            add(texto);
                            vs.setBounds(725,340,450,85);
                            add(vs);
                            buttomMatches.setPosicion(700,330);
                        } else if (CantidadParticipantes == 8) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 138 + i * 1348, 140 + j * 268, 300, 60);
                            add(texto);
                            add(vs);
                        } else if (CantidadParticipantes == 16) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 75 + i * 1518, 118 + sumY, 250, 45);
                            add(texto);
                            add(vs);
                            if (j % 2 == 0) {
                                sumY += 133;
                            } else {
                                sumY += 94;
                            }
                        }
                        k++;
                    }
                }
                this.cont++;
            }
        }

        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(img));
            Image image = imageIcon.getImage();
            g.drawImage(image, Escalar.X(0), Escalar.Y(0), Escalar.X(1920), Escalar.Y(1080), null);

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen");
        }
    }
    public void generarEncuentros(){
        PanelPrincipal.matches = buttomMatches.generarEncuentros(Torneo.participante);
    }
    public void setText(String nombre1,String nombre2){
        buttomMatches.setTextButtom(nombre1,nombre2);
    }
    public void mostrarGanador() {
        if (!PanelPrincipal.torneo.ganadores.isEmpty()) {
            Texto ganador = new Texto(PanelPrincipal.torneo.ganadores.removeFirst().getNombre(),0,0,0,0);
            switch (CantidadParticipantes){
                case 16 -> ganador.setBound(posicionesGanadores[10+cont_1][0],posicionesGanadores[10+cont_1][1],250,45);
                case 8 -> ganador.setBound(posicionesGanadores[3+cont_1][0],posicionesGanadores[3+cont_1][1],300,60);
                case 4 -> ganador.setBound(posicionesGanadores[cont_1][0],posicionesGanadores[cont_1][1],450,85);
            }
            add(ganador);
            Ventana.actualizar();
            cont_1++;
        }
    }
}