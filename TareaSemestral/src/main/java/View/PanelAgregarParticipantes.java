package View;

import Algoritmo.Equipo;
import Algoritmo.Organizacion;

import javax.swing.*;


public class PanelAgregarParticipantes extends JPanel {
    private Texto titulo;
    private Boton individual;
    private Boton equipo;
    private Organizacion eleccion;
    public PanelAgregarParticipantes() {
        super();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        titulo = new Texto("Seleccione el tipo de participante",450,100,1650,90);
        individual = new Boton("Individual",542,500,350,80);
        equipo = new Boton("Equipo",1027,500,350,80);
        individual.addActionListener(e -> {
            eleccion = new Organizacion(PanelTorneo.torneo,true,"Deportistas.txt");
            setVisible(false);
        });
        equipo.addActionListener(e -> {
            eleccion = new Organizacion(PanelTorneo.torneo,false,"Equipos.txt");
            setVisible(false);
        });
        add(titulo);
        add(individual);
        add(equipo);
    }
}
