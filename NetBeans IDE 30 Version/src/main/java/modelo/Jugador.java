package modelo;

// Clase que representa un jugador en el juego de Memorama
public class Jugador {

    // Nombre del jugador
    private String nombre;
    // Puntos acumulados por el jugador
    private int puntos;

    // Constructor que inicializa un nuevo jugador con su nombre
    public Jugador(String nombre) {
        // Asigna el nombre del jugador
        this.nombre = nombre;
        // Inicializa los puntos en cero
        this.puntos = 0;
    }

    // Método getter que retorna el nombre del jugador
    public String getNombre() {
        // Retorna el nombre almacenado del jugador
        return nombre;
    }

    // Método setter que asigna un nuevo nombre al jugador
    public void setNombre(String nombre) {
        // Modifica el nombre del jugador
        this.nombre = nombre;
    }

    // Método getter que retorna los puntos actuales del jugador
    public int getPuntos() {
        // Retorna la cantidad de puntos acumulados
        return puntos;
    }

    // Método que incrementa en uno los puntos del jugador
    public void sumarPunto() {
        // Incrementa el contador de puntos del jugador en 1
        puntos++;
    }
}