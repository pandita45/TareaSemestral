package View;

import Algoritmo.Encuentro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PanelTorneoDirecto extends JPanel {
    private String img;
    private int sumY;
    private int cont = 0;
    private GeneradorEncuentros buttomMatches;
    public PanelTorneoDirecto(){
        super();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        buttomMatches = new GeneradorEncuentros(100,100,350,300);
        add(buttomMatches);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(PanelPrincipal.torneo != null && Objects.equals(PanelPrincipal.torneo.getFormato(), "EliminacionDirecta")) {
            Texto titulo = new Texto(PanelPrincipal.torneo.getNombre(), 0, 25, 1920, 90);
            titulo.setHorizontalAlignment(JTextField.CENTER);
            add(titulo);
            int CantidadParticipantes = PanelPrincipal.torneo.getParticipantes().size();
            switch (CantidadParticipantes) {
                case 4 -> img = "ElimDirecta4.png";
                case 8 -> img = "ElimDirecta8.png";
                case 16 -> img = "ElimDirecta16.png";
            }
            int k = 0;
            if (cont == 0) {
                for (int i = 0; i < 2; i++) {
                    sumY = 0;
                    for (int j = 0; j < CantidadParticipantes / 2; j++) {
                        if (CantidadParticipantes == 4) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 110 + i * 1247, 278 + j * 584, 450, 85);
                            texto.setHorizontalAlignment(JTextField.CENTER);
                            texto.setFont(new Font("SansSerif", Font.PLAIN, Escalar.X(45)));
                            add(texto);
                        } else if (CantidadParticipantes == 8) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 138 + i * 1348, 140 + j * 268, 300, 60);
                            texto.setHorizontalAlignment(JTextField.CENTER);
                            texto.setFont(new Font("SansSerif", Font.PLAIN, Escalar.X(45)));
                            add(texto);
                        } else if (CantidadParticipantes == 16) {
                            Texto texto = new Texto(PanelPrincipal.torneo.getParticipantes().get(k).getNombre(), 75 + i * 1518, 118 + sumY, 250, 45);
                            texto.setHorizontalAlignment(JTextField.CENTER);
                            texto.setFont(new Font("SansSerif", Font.PLAIN, Escalar.X(45)));
                            add(texto);
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
        PanelPrincipal.matches = buttomMatches.generarEncuentros();
    }
    public void setText(String nombre1,String nombre2){
        buttomMatches.setTextButtom(nombre1,nombre2);
    }
}
