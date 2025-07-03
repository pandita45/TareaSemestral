package View;

import Algoritmo.FormatoDeTorneo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelBienvenida extends JPanel {
    private Texto textoBienvenida;

    public PanelBienvenida(){
        super();
        JButton formato = new JButton("Formato de torneo");
        formato.setBounds(Escalar.X(785),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        formato.setFont(new Font("SansSerif",Font.PLAIN, Escalar.X(40)));
        formato.setForeground(Color.BLACK);
        formato.setBackground(Color.decode("#146D8B").darker());
        formato.setBorder(new LineBorder(Color.GRAY, 2));
        JPopupMenu menu = new JPopupMenu();
        menu.setBackground(Color.decode("#146D8B").darker());
        menu.setBorder(new LineBorder(Color.gray,2));
        Menu opcion1 = new Menu("Eliminacion Directa", "hola");
        Menu opcion2 = new Menu("Eliminacion Doble", "hoo");
        Menu opcion3 = new Menu("Liga Simple", "holo");
        menu.setPreferredSize(new Dimension(Escalar.X(200),Escalar.Y(200)));


        textoBienvenida = new Texto("Bienvenido, rellene los campos para crear un torneo");
        textoBienvenida.setBounds(Escalar.X(260), Escalar.Y(100), Escalar.X(1650), Escalar.Y(90));
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        Fields Torneo_name = new Fields(40,Escalar.X(300),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        Fields Disciplina_name1 = new Fields(40,Escalar.X(1270),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        menu.add(opcion1.crear());
        menu.add(opcion2.crear());
        menu.add(opcion3.crear());
        formato.addActionListener(e -> menu.show(formato, 0, formato.getHeight()));
        add(textoBienvenida);
        add(Torneo_name.crear());
        add(Disciplina_name1.crear());
        add(formato);
    }
}
