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
    private Date fecha;
    private Date hora;
    public CalendarioConHora(JButton buttom,int PosX, int PosY) {
        setSize(Escalar.X(400), Escalar.Y(350));
        setBounds(Escalar.X(PosX),Escalar.Y(PosY),Escalar.X(400),Escalar.Y(300));
        setLayout(new BorderLayout());

        calendario = new JCalendar();

        SpinnerDateModel modeloHora = new SpinnerDateModel();
        horaSpinner = new JSpinner(modeloHora);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(horaSpinner, "HH:mm");
        horaSpinner.setEditor(editor);

        boton = new JButton("Confirmar fecha y hora");

        boton.addActionListener(e -> {
            fecha = calendario.getDate();
            hora = (Date) horaSpinner.getValue();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            fecha.setHours(hora.getHours());
            fecha.setMinutes(hora.getMinutes());
            buttom.setText(formato.format(fecha));

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

    public Date getDate() {
        return this.fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
