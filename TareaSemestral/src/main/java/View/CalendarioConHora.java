package View;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JCalendar;

public class CalendarioConHora extends JPanel {
    private JCalendar calendario;
    private JSpinner horaSpinner;
    private JButton boton;

    public CalendarioConHora() {
        setSize(400, 350);
        setBounds(800,700,400,300);
        setLayout(new BorderLayout());

        calendario = new JCalendar();

        SpinnerDateModel modeloHora = new SpinnerDateModel();
        horaSpinner = new JSpinner(modeloHora);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(horaSpinner, "HH:mm");
        horaSpinner.setEditor(editor);

        boton = new JButton("Mostrar fecha y hora");

        boton.addActionListener(e -> {
            Date fecha = calendario.getDate();
            Date hora = (Date) horaSpinner.getValue();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            fecha.setHours(hora.getHours());
            fecha.setMinutes(hora.getMinutes());

            JOptionPane.showMessageDialog(this, "Fecha y hora seleccionada: " + formato.format(fecha));
            setVisible(false);
        });

        JPanel panelInferior = new JPanel(new FlowLayout());
        panelInferior.add(new JLabel("Hora:"));
        panelInferior.add(horaSpinner);
        panelInferior.add(boton);

        add(calendario, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        setVisible(false);
    }
}
