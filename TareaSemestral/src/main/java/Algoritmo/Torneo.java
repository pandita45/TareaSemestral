package Algoritmo;
import java.util.ArrayList;
import java.util.Date;


public class Torneo {
    public static ArrayList<Participante> participante;
    private String nombre;
    private String disciplina;
    private FormatoDeTorneo formato;
    private Date fechaInicial;
    private Date fechaTermino;

    public Torneo(String nombre, String disciplina, FormatoDeTorneo formato,
                  Date fechaInicial, Date fechaTermino){
        this.nombre=nombre;
        this.disciplina=disciplina;
        this.formato=formato;
        this.participante = new ArrayList<>();
        this.fechaInicial=fechaInicial;
        this.fechaTermino=fechaTermino;
    }

    public void agregarParticipantes(Participante participante){
        this.participante.add(participante);
    }

    public void jugar(Encuentro partida){
        formato.jugarPartida(partida);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getFormato() {
        return formato.print();
    }
    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public ArrayList<Participante> getParticipantes() {
        return participante;
    }
}
