package modelo;

// Clase que hereda de Memorama y carga cartas con imágenes de frutas
public class MemoramaFrutas extends Memorama {

    // Implementación del método abstracto cargarCartas específico para frutas
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas si había cartas previas
        cartas.clear();

        // Agrega dos cartas de Manzana (primera pareja)
        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));
        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));

        // Agrega dos cartas de Platano (segunda pareja)
        cartas.add(new Carta("Platano", "/imagenes/platano.png"));
        cartas.add(new Carta("Platano", "/imagenes/platano.png"));

        // Agrega dos cartas de Uva (tercera pareja)
        cartas.add(new Carta("Uva", "/imagenes/uva.png"));
        cartas.add(new Carta("Uva", "/imagenes/uva.png"));

        // Agrega dos cartas de Sandia (cuarta pareja)
        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
    }
}