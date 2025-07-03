package View;

import javax.swing.*;
import java.awt.*;

public class Menu extends JMenuItem {
    private String formato;
    private String texto;
    public Menu(String formato, String texto) {
        this.formato = formato;
        this.texto = texto;
    }

    public JMenuItem crear(){
        JMenuItem menu = new JMenuItem(formato);
        menu.setBackground(Color.decode("#146D8B").darker());
        menu.setForeground(Color.BLACK);
        menu.setOpaque(true);
        menu.addActionListener(e -> JOptionPane.showMessageDialog(Ventana.getInstancia(), texto));
        menu.setFont(new Font("SansSerif",Font.PLAIN, Escalar.X(20)));
        return menu;
    }
}
