package View;

import Algoritmo.Encuentro;
import Algoritmo.LigaSimple;
import Algoritmo.Participante;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class PanelLigaSimple extends JPanel {
    private PanelTabla tablaPosiciones;
    private static int  sizeTableY;
    private Boton a;
    private int aa =0;
    public PanelLigaSimple() {
        super();
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        setLayout(null);
        setVisible(false);

        tablaPosiciones = new PanelTabla();
        tablaPosiciones.setBounds(Escalar.X(100), Escalar.Y(170), Escalar.X(800), Escalar.Y(800));
        tablaPosiciones.setBorder(null);
        add(tablaPosiciones);
        a = new Boton("jugar", 1000, 600, 200, 200);
        add(a);
        a.addActionListener(e -> {
            Encuentro ee = new Encuentro(PanelPrincipal.torneo.getParticipantes().get(aa), PanelPrincipal.torneo.getParticipantes().get(aa + 1), new Date());
            PanelPrincipal.torneo.jugar(ee);
            aa++;
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (PanelPrincipal.torneo != null) {
            Texto titulo = new Texto(PanelPrincipal.torneo.getNombre(), 0, 25, 1920, 90);
            titulo.setHorizontalAlignment(JTextField.CENTER);
            add(titulo);
        }
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("FondoLigaSimple.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image, Escalar.X(0), Escalar.Y(0), Escalar.X(1920), Escalar.Y(1080), null);

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen");
        }
        Ventana.actualizar();
        tablaPosiciones.cargarDesdeTorneo();
    }
}

