package modelo;

public class MemoramaPersonajes extends Memorama {

    @Override
    public void cargarCartas() {

        cartas.clear();

        cartas.add(new Carta("Mario", "/imagenes/mario.png"));
        cartas.add(new Carta("Mario", "/imagenes/mario.png"));

        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));
        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));

        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));
        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));

        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
    }
}