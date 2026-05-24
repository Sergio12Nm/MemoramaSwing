package modelo;

// Importa ArrayList para almacenar colecciones dinámicas
import java.util.ArrayList;
// Importa Collections para manipular colecciones (barajar)
import java.util.Collections;
// Importa List para trabajar con listas genéricas
import java.util.List;

// Clase abstracta que define la estructura base para los diferentes tipos de Memorama
public abstract class Memorama {

    // Lista que almacena todas las cartas del juego
    protected List<Carta> cartas;

    // Constructor que inicializa la lista de cartas vacía
    public Memorama() {
        // Crea una nueva lista ArrayList para almacenar cartas
        cartas = new ArrayList<>();
    }

    // Método abstracto que debe ser implementado por las subclases para cargar cartas específicas
    public abstract void cargarCartas();

    // Método que baraja las cartas en orden aleatorio
    public void barajarCartas() {
        // Usa Collections.shuffle para cambiar el orden de las cartas aleatoriamente
        Collections.shuffle(cartas);
    }

    // Método que retorna la lista de cartas del memorama
    public List<Carta> getCartas() {
        // Retorna la lista de cartas
        return cartas;
    }
}