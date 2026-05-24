package modelo;

// Clase que hereda de Memorama y carga cartas con imágenes de personajes
public class MemoramaPersonajes extends Memorama {

    // Implementación del método abstracto cargarCartas específico para personajes
    @Override
    public void cargarCartas() {

        // Limpia la lista de cartas si había cartas previas
        cartas.clear();

        // Agrega dos cartas de Mario (primera pareja)
        cartas.add(new Carta("Mario", "/imagenes/mario.png"));
        cartas.add(new Carta("Mario", "/imagenes/mario.png"));

        // Agrega dos cartas de Luigi (segunda pareja)
        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));
        cartas.add(new Carta("Luigi", "/imagenes/luigi.png"));

        // Agrega dos cartas de Sonic (tercera pareja)
        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));
        cartas.add(new Carta("Sonic", "/imagenes/sonic.png"));

        // Agrega dos cartas de Pikachu (cuarta pareja)
        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
        cartas.add(new Carta("Pikachu", "/imagenes/pikachu.png"));
    }
}