package View;

import javax.swing.*;
import java.awt.*;

public class Menu extends JMenuItem {
    private static int var1;
    private int var2;
    private String formato;
    private String texto;
    private JButton boton;
    public Menu(String formato, String texto, JButton boton, int var2) {
        this.formato = formato;
        this.texto = texto;
        this.boton = boton;
        this.var2 = var2;
    }

    public JMenuItem crear(){
        JMenuItem menu = new JMenuItem(formato);
        menu.setBackground(Color.decode("#146D8B").darker());
        menu.setForeground(Color.BLACK);
        menu.setOpaque(true);
        menu.addActionListener(e ->{
            boton.setText(formato);
            JOptionPane.showMessageDialog(Ventana.getInstancia(), texto);
            switch (var2){
                case 1 -> var1 = 1;
                case 2 -> var1 = 2;
                case 3 -> var1 = 3;
            }
            System.out.println(var1);
    });
        menu.setFont(new Font("SansSerif",Font.PLAIN, Escalar.X(20)));
        return menu;
    }

    public int getVar1() {
        return var1;
    }
}
