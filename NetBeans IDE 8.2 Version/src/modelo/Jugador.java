package modelo;

// Clase que representa un jugador en el juego Memorama
public class Jugador {

    // Almacena el nombre del jugador
    private String nombre;
    // Almacena los puntos acumulados por el jugador (pares encontrados)
    private int puntos;

    // Constructor que inicializa un jugador con su nombre
    public Jugador(String nombre) {
        // Asigna el nombre al jugador
        this.nombre = nombre;
        // Inicializa los puntos del jugador en cero
        this.puntos = 0;
    }

    // Método getter que retorna el nombre del jugador
    public String getNombre() {
        // Retorna el nombre del jugador
        return nombre;
    }

    // Método setter que modifica el nombre del jugador
    public void setNombre(String nombre) {
        // Asigna el nuevo nombre al jugador
        this.nombre = nombre;
    }

    // Método getter que retorna los puntos del jugador
    public int getPuntos() {
        // Retorna la cantidad de puntos acumulados
        return puntos;
    }

    // Método que incrementa los puntos del jugador en una unidad
    public void sumarPunto() {
        // Incrementa el contador de puntos en 1
        puntos++;
    }
}