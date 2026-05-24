package modelo;

// Clase que extiende Memorama para crear un juego con cartas de animales
public class MemoramaAnimales extends Memorama {

    // Método que sobrescribe el método abstracto cargarCartas para cargar animales
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas para empezar de cero
        cartas.clear();

        // Añade la primera carta de Perro con su imagen
        cartas.add(new Carta("Perro", "/imagenes/perro.png"));
        // Añade la segunda carta de Perro (pareja de la anterior)
        cartas.add(new Carta("Perro", "/imagenes/perro.png"));

        // Añade la primera carta de Gato con su imagen
        cartas.add(new Carta("Gato", "/imagenes/gato.png"));
        // Añade la segunda carta de Gato (pareja de la anterior)
        cartas.add(new Carta("Gato", "/imagenes/gato.png"));

        // Añade la primera carta de León con su imagen
        cartas.add(new Carta("Leon", "/imagenes/leon.png"));
        // Añade la segunda carta de León (pareja de la anterior)
        cartas.add(new Carta("Leon", "/imagenes/leon.png"));

        // Añade la primera carta de Tigre con su imagen
        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
        // Añade la segunda carta de Tigre (pareja de la anterior)
        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
    }
}