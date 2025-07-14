package View;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que sirve para crear un menu de opciones
 */
public class Menu extends JMenuItem {
    private static int var1;
    private int var2;
    private String formato;
    private String texto;
    private JButton boton;

    /**
     * Constructor donde se inicializan variables locales
     * @param formato El formato asociado a la opcion del menu
     * @param texto Que texto tendra la opcion del menu
     * @param boton Encargado de darle la funcion a la opcion del menu
     * @param var2 Que valor numerico esta asociado a la opcion del menu
     */
    public Menu(String formato, String texto, JButton boton, int var2) {
        this.formato = formato;
        this.texto = texto;
        this.boton = boton;
        this.var2 = var2;
    }

    /**
     * Metodo en donde se crea el menu
     * @return devuelve el menu creado
     */
    public JMenuItem crear(){
        JMenuItem menu = new JMenuItem(formato);
        menu.setBackground(Color.decode("#146D8B").darker());
        menu.setForeground(Color.BLACK);
        menu.setOpaque(true);
        menu.addActionListener(e ->{
            boton.setText(formato);
            switch (var2){
                case 1 -> var1 = 1;
                case 2 -> var1 = 2;
                case 3 -> var1 = 3;
            }
    });
        menu.setFont(new Font("SansSerif",Font.PLAIN, Escalar.X(20)));
        return menu;
    }

    /**
     * Metodo getter de var1
     * @return devuelve el entero relacionado a la opcion seleccionada
     */
    public int getVar1() {
        return var1;
    }
}
