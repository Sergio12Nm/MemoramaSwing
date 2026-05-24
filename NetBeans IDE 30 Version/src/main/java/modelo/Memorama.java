package modelo;

// Importa ArrayList para almacenar una lista dinámmica de cartas
import java.util.ArrayList;
// Importa Collections para poder barajar las cartas
import java.util.Collections;
// Importa List como interfaz para la colección de cartas
import java.util.List;

// Clase abstracta que define la estructura base del juego Memorama
public abstract class Memorama {

    // Lista que almacena todas las cartas del juego
    protected List<Carta> cartas;

    // Constructor que inicializa la lista de cartas vacía
    public Memorama() {
        // Crea una nueva lista de tipo ArrayList para almacenar las cartas
        cartas = new ArrayList<>();
    }

    // Método abstracto que debe ser implementado por las subclases para cargar las cartas
    public abstract void cargarCartas();

    // Método que baraja las cartas de forma aleatoria
    public void barajarCartas() {
        // Utiliza Collections.shuffle para desordenar aleatoriamente las cartas
        Collections.shuffle(cartas);
    }

    // Método getter que retorna la lista completa de cartas
    public List<Carta> getCartas() {
        // Retorna la lista de cartas del memorama
        return cartas;
    }
}