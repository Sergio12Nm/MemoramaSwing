package modelo;

// Clase que hereda de Memorama y carga cartas con imágenes de animales
public class MemoramaAnimales extends Memorama {

    // Implementación del método abstracto cargarCartas específico para animales
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas si había cartas previas
        cartas.clear();

        // Agrega dos cartas de Perro (primera pareja)
        cartas.add(new Carta("Perro", "/imagenes/perro.png"));
        cartas.add(new Carta("Perro", "/imagenes/perro.png"));

        // Agrega dos cartas de Gato (segunda pareja)
        cartas.add(new Carta("Gato", "/imagenes/gato.png"));
        cartas.add(new Carta("Gato", "/imagenes/gato.png"));

        // Agrega dos cartas de Leon (tercera pareja)
        cartas.add(new Carta("Leon", "/imagenes/leon.png"));
        cartas.add(new Carta("Leon", "/imagenes/leon.png"));

        // Agrega dos cartas de Tigre (cuarta pareja)
        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
    }
}