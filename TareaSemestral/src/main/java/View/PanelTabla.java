package View;

import Algoritmo.Participante;
import Algoritmo.Torneo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelTabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelTabla() {
        setLayout(new BorderLayout());
        setOpaque(false);

        String[] columnas = {"#", "Equipo", "PG", "PE", "PP", "Pts"};

        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(30);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));
        tabla.setBorder(null);
        tabla.setOpaque(false);
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        UIManager.put("Table.scrollPaneBorder", BorderFactory.createEmptyBorder());
        cargarDesdeTorneo();
        add(scrollPane, BorderLayout.CENTER);
    }
    public void cargarDesdeTorneo() {
        tabla.removeAll();
        List<Object[]> datos = new ArrayList<>();
        int posicion = 1;
        if (PanelPrincipal.torneo != null) {
            for (Participante p : Torneo.participante) {
                int pts = p.getPuntos();
                datos.add(new Object[]{
                        posicion++,
                        p.getNombre(),
                        p.getWins(),
                        p.getDraws(),
                        p.getLosses(),
                        pts
                });
            }
            actualizarTabla(datos);
        }


    }
    public void actualizarTabla(List<Object[]> nuevasFilas) {
        modelo.setRowCount(0);
        for (Object[] fila : nuevasFilas) {
            modelo.addRow(fila);
        }
    }
    public String getGanador(){
        return (String) modelo.getValueAt(0, 1);
    }
}
