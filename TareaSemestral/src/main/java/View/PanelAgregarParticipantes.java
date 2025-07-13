package View;

import Algoritmo.Organizacion;

import javax.swing.*;


public class PanelAgregarParticipantes extends JPanel {
    private Texto titulo;
    private Boton individual;
    private Boton equipo;
    private Organizacion eleccion;
    private boolean opcion;
    public PanelAgregarParticipantes() {
        super();
        setVisible(false);
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        Boton confirmar = new Boton("Continuar", 1500,900,350,80);
        confirmar.setColor("#4CAF50");

        titulo = new Texto("Seleccione el tipo de participante",0,100,1920,90);

        individual = new Boton("Individual",542,500,350,80);
        equipo = new Boton("Equipo",1027,500,350,80);

        individual.addActionListener(e -> {
            JOptionPane.showMessageDialog(Ventana.getInstancia(), "Se ha eligido deportistas");
            opcion = true;
        });
        equipo.addActionListener(e -> {
            opcion = false;
            JOptionPane.showMessageDialog(Ventana.getInstancia(), "Se ha eligido equipo");
        });

        confirmar.addActionListener(e ->{
            setVisible(false);

            if(opcion){
                eleccion = new Organizacion(PanelPrincipal.torneo,true,"Deportistas.txt");
            }
            else {
                eleccion = new Organizacion(PanelPrincipal.torneo,false,"Equipos.txt");
            }

            switch (PanelPrincipal.torneo.getFormato()){
                case "EliminacionDirecta":
                    PanelPrincipal.MSI.setVisible(true);
                    PanelPrincipal.MSI.generarEncuentros();
                    PanelPrincipal.MSI.setText(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    break;
                case "EliminacionDoble":
                    PanelPrincipal.Champions.setVisible(true);
                    PanelPrincipal.Champions.generarEncuentrosUpper();
                    PanelPrincipal.Champions.setTextButtom(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    break;
                case "LigaSimple":
                    PanelPrincipal.liga.setVisible(true);
                    PanelPrincipal.liga.generarEncuentro();
                    PanelPrincipal.liga.setText(PanelPrincipal.matches.getFirst().getJugadorUno().getNombre(), PanelPrincipal.matches.getFirst().getJugadorDos().getNombre());
                    break;
            }
        });
        add(confirmar);
        add(titulo);
        add(individual);
        add(equipo);
    }

}
