package Algoritmo;

public abstract class Participante {
    private String nombre;
    private String contacto;
    private String edad;
    private int puntos;
    private int wins;
    private int losses;
    private int draws;

    /**
     * Super clase que engloba a equipos como jugadores, participantes del torneo creado
     * @param nombre  Nombre del jugador u equipo
     * @param contacto  Un contacto a manera de string, un correo electronico idealmente
     * @param edad Declarada como edad para el caso de deportistas, para equipos se da a entender que es la antiguedad del mismo
     */
    public Participante(String nombre, String contacto, String edad) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.edad = edad;
        this.wins=0;
        this.losses=0;
        this.draws=0;
    }

    /**
     * @return Obtiene el contacto del Participante
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Usada para mostrar en pantalla la cantidad de puntos de cada equipo, en caso de LigaSimple
     * @return Devuelve la cantidad de puntos de cada Participante
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Usada para visualizar en pantalla el nombre del participante
     * @return Devuelve el nombre del participante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Usada para mostrar en pantalla el estado actual, Liga simple
     * @return Devuelve las wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Usada para mostrar en pantalla el estado actual, Liga simple
     * @return Devuelve los empates
     */

    public int getDraws() {
        return draws;
    }

    /**
     * Usada para mostrar en pantalla el estado actual, Liga simple
     * @return Devuelve las partidas perdidas
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Con el fin de actualizar en pantalla los datos se agrega el parametro especificado a sus estadisticas
     * @param draws Agrega empates
     */
    public void addDraws(int draws) {
        this.draws += draws;
    }

    /**
     * Con el fin de actualizar en pantalla los datos se agrega el parametro especificado a sus estadisticas
     * @param losses Agrega derrotas
     */
    public void addLosses(int losses) {
        this.losses += losses;
    }

    /**
     * Con el fin de actualizar en pantalla los datos se agrega el parametro especificado a sus estadisticas
     * @param wins Agrega victorias
     */
    public void addWins(int wins) {
        this.wins += wins;
    }

    /**
     * Con el fin de actualizar en pantalla los datos se agrega el parametro especificado a sus estadisticas
     * @param puntos Agrega puntos correspondientes a victoria, derrota o empate
     */
    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }

    /**
     * @return Obtiene la edad del participante / o tiempo de antiguedad
     */
    public String  getEdad(){
        return this.edad;
    }
}
