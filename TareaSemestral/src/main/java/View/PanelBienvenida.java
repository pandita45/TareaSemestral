package View;
import Algoritmo.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelBienvenida extends JPanel {
    private Texto textoBienvenida;


    public PanelBienvenida(){
        super();
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        Boton confirmarDatos = new Boton("Continuar", 1500,900,350,80);
        Boton calendarioInicio = new Boton("Fecha inicio", 542, 600, 350, 80);
        Boton calendarioTermino = new Boton("Fecha termino", 1027, 600, 350, 80);
        Boton formato = new Boton("Formato de torneo", 785, 400, 350, 80);

        JPopupMenu menu = new JPopupMenu();

        Fields torneoName = new Fields(40,Escalar.X(300),Escalar.Y(400),Escalar.X(350),Escalar.Y(80), "Nombre de torneo");
        Fields disciplinaName = new Fields(40,Escalar.X(1270),Escalar.Y(400),Escalar.X(350),Escalar.Y(80), "Disciplina");

        CalendarioConHora calendario = new CalendarioConHora(calendarioInicio,522,680);
        CalendarioConHora calendarioFinal = new CalendarioConHora(calendarioTermino,1003,680);

        confirmarDatos.setColor("#4CAF50");

        menu.setBackground(Color.decode("#146D8B").darker());
        menu.setBorder(new LineBorder(Color.gray,2));

        Menu opcion1 = new Menu("Eliminacion directa", "Haz seleccionado Eliminacion directa",formato, 1);
        Menu opcion2 = new Menu("Eliminacion doble", "Haz seleccionado Eliminacion doble",formato, 2);
        Menu opcion3 = new Menu("Liga simple", "Haz seleccionado Liga simple",formato, 3);

        menu.setPreferredSize(new Dimension(Escalar.X(200),Escalar.Y(200)));
        textoBienvenida = new Texto("Bienvenido, rellene los campos para crear un torneo",0,100,1920,90);

        menu.add(opcion1.crear());
        menu.add(opcion2.crear());
        menu.add(opcion3.crear());
        formato.addActionListener(e -> menu.show(formato, 0, formato.getHeight()));
        calendarioInicio.addActionListener(e -> calendario.setVisible(true));
        calendarioTermino.addActionListener(e -> calendarioFinal.setVisible(true));
        confirmarDatos.addActionListener(e -> {
            int var1 = opcion1.getVar1();
            switch (var1) {
                case 1 -> PanelPrincipal.torneo = new Torneo(torneoName.getTexto(),
                        disciplinaName.getTexto(),new EliminacionDirecta(), calendario.getDate(), calendarioFinal.getDate());

                case 2 -> PanelPrincipal.torneo = new Torneo(torneoName.getTexto(),
                        disciplinaName.getTexto(),new EliminacionDoble(), calendario.getDate(), calendarioFinal.getDate());

                case 3 -> PanelPrincipal.torneo = new Torneo(torneoName.getTexto(),
                        disciplinaName.getTexto(),new LigaSimple(), calendario.getDate(), calendarioFinal.getDate());
            }
            setVisible(false);
            PanelPrincipal.agregarParticipantes.setVisible(true);


        });
        add(calendario);
        add(calendarioFinal);
        add(confirmarDatos);
        add(calendarioInicio);
        add(calendarioTermino);
        add(textoBienvenida);
        add(torneoName.crear());
        add(disciplinaName.crear());
        add(formato);
    }

}
