package modelo;

// Clase que extiende Memorama para crear un juego con cartas de frutas
public class MemoramaFrutas extends Memorama {

    // Método que sobrescribe el método abstracto cargarCartas para cargar frutas
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas para empezar de cero
        cartas.clear();

        // Añade la primera carta de Manzana con su imagen
        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));
        // Añade la segunda carta de Manzana (pareja de la anterior)
        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));

        // Añade la primera carta de Plátano con su imagen
        cartas.add(new Carta("Platano", "/imagenes/platano.png"));
        // Añade la segunda carta de Plátano (pareja de la anterior)
        cartas.add(new Carta("Platano", "/imagenes/platano.png"));

        // Añade la primera carta de Uva con su imagen
        cartas.add(new Carta("Uva", "/imagenes/uva.png"));
        // Añade la segunda carta de Uva (pareja de la anterior)
        cartas.add(new Carta("Uva", "/imagenes/uva.png"));

        // Añade la primera carta de Sandía con su imagen
        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
        // Añade la segunda carta de Sandía (pareja de la anterior)
        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
    }
}