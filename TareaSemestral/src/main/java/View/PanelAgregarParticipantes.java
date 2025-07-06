package View;

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
            eleccion = new Organizacion(PanelPrincipal.torneo,true,"Deportistas.txt");
            setVisible(false);
            switch (PanelPrincipal.torneo.getFormato()){
                case "EliminacionDirecta" -> PanelPrincipal.MSI.setVisible(true);
                case "EliminacionDoble" -> PanelPrincipal.Champions.setVisible(true);
            }
        });
        equipo.addActionListener(e -> {
            eleccion = new Organizacion(PanelPrincipal.torneo,false,"Equipos.txt");
            setVisible(false);
            PanelPrincipal.MSI.setVisible(true);
        });
        add(titulo);
        add(individual);
        add(equipo);
    }
}
