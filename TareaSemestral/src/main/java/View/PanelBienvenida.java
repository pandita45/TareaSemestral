package View;

import javax.swing.*;

public class PanelBienvenida extends JPanel {
    private Texto textoBienvenida;
    public PanelBienvenida(){
        super();
        textoBienvenida = new Texto("Bienvenido, rellene los campos para crear un torneo");
        textoBienvenida.setBounds(Escalar.X(260), Escalar.Y(100), Escalar.X(1650), Escalar.Y(90));
        setLayout(null);
        setSize(Escalar.X(1920), Escalar.Y(1080));
        setOpaque(false);
        Fields Torneo_name = new Fields(40,Escalar.X(300),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        Fields Disciplina_name = new Fields(40,Escalar.X(785),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        Fields Disciplina_name1 = new Fields(40,Escalar.X(1270),Escalar.Y(400),Escalar.X(350),Escalar.Y(80));
        add(textoBienvenida);
        add(Torneo_name.crear());
        add(Disciplina_name.crear());
        add(Disciplina_name1.crear());
    }
}
