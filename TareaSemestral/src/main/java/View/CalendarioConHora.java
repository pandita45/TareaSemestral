package View;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JCalendar;

/**
 * Clase generadora de Calendarios para las fechas de inicio y fin del torneo
 */
public class CalendarioConHora extends JPanel {
    private JCalendar calendario;
    private JSpinner horaSpinner;
    private JButton boton;
    private Date fecha;
    private Date hora;

    /**
     * Crea el calendario y lo asocia a un boton ya existente
     * @param button a que boton estara asociado el calendario
     * @param PosX que posicion en x tendra
     * @param PosY que posicion en y tendra
     */
    public CalendarioConHora(JButton button,int PosX, int PosY) {
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
            button.setText(formato.format(fecha));

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

    /**
     * Getter de la fecha seleccionada en el calendario
     * @return devuelve la fecha seleccionada
     */
    public Date getDate() {
        return this.fecha;
    }
}
