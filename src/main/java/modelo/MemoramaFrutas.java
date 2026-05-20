package modelo;

public class MemoramaFrutas extends Memorama {

    @Override
    public void cargarCartas() {

        cartas.clear();

        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));
        cartas.add(new Carta("Manzana", "/imagenes/manzana.png"));

        cartas.add(new Carta("Platano", "/imagenes/platano.png"));
        cartas.add(new Carta("Platano", "/imagenes/platano.png"));

        cartas.add(new Carta("Uva", "/imagenes/uva.png"));
        cartas.add(new Carta("Uva", "/imagenes/uva.png"));

        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
        cartas.add(new Carta("Sandia", "/imagenes/sandia.png"));
    }
}