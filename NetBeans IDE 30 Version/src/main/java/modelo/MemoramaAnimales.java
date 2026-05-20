package modelo;

public class MemoramaAnimales extends Memorama {

    @Override
    public void cargarCartas() {

        cartas.clear();

        cartas.add(new Carta("Perro", "/imagenes/perro.png"));
        cartas.add(new Carta("Perro", "/imagenes/perro.png"));

        cartas.add(new Carta("Gato", "/imagenes/gato.png"));
        cartas.add(new Carta("Gato", "/imagenes/gato.png"));

        cartas.add(new Carta("Leon", "/imagenes/leon.png"));
        cartas.add(new Carta("Leon", "/imagenes/leon.png"));

        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
        cartas.add(new Carta("Tigre", "/imagenes/tigre.png"));
    }
}