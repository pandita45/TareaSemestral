package Algoritmo;

public abstract class Participante {
    private String nombre;
    private String contacto;
    private int puntos;
    private String edad;
    private int wins;
    private int losses;
    private int draws;
    public Participante(String nombre, String contacto, String edad) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.edad = edad;
        this.wins=0;
        this.losses=0;
        this.draws=0;
    }

    public String getContacto() {
        return contacto;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public void addDraws(int draws) {
        this.draws += draws;
    }

    public void addLosses(int losses) {
        this.losses += losses;
    }

    public void addWins(int wins) {
        this.wins += wins;
    }

    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }
    public String  getEdad(){
        return this.edad;
    }
}
