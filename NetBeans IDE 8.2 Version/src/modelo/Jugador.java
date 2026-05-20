package modelo;

public class Jugador {

    private String nombre;
    private int puntos;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter puntos
    public int getPuntos() {
        return puntos;
    }

    // Sumar puntos
    public void sumarPunto() {
        puntos++;
    }
}