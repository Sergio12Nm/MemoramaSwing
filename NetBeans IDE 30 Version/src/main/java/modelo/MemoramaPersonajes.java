package modelo;

// Clase que extiende Memorama para crear un juego con cartas de personajes
public class MemoramaPersonajes extends Memorama {

    // Método que sobrescribe el método abstracto cargarCartas para cargar personajes
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas para empezar de cero
        cartas.clear();

        // Añade la primera carta de Mario con su imagen
        cartas.add(new Carta("Mario", "/imagenes/mario.png"));
        // Añade la segunda carta de Mario (pareja de la anterior)
        cartas.add(new Carta("Mario", "/imagenes/mario.png"));

        // Añade la primera carta de Luigi con su imagen
        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));
        // Añade la segunda carta de Luigi (pareja de la anterior)
        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));

        // Añade la primera carta de Sonic con su imagen
        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));
        // Añade la segunda carta de Sonic (pareja de la anterior)
        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));

        // Añade la primera carta de Pikachu con su imagen
        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
        // Añade la segunda carta de Pikachu (pareja de la anterior)
        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
    }
}