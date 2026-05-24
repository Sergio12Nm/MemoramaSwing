package modelo;

// Clase que representa una carta individual del juego Memorama
public class Carta {

    // Almacena el nombre o identificador de la carta
    private String nombre;
    // Almacena la ruta de la imagen que se muestra cuando la carta está destapada
    private String rutaImagen;
    // Indica si la carta ha sido encontrada (pareja ya formada)
    private boolean encontrada;
    // Indica si la carta está volteada (destapada) o boca abajo (tapada)
    private boolean volteada;

    // Constructor que inicializa una carta con su nombre e imagen
    public Carta(String nombre, String rutaImagen) {
        // Asigna el nombre de la carta
        this.nombre = nombre;
        // Asigna la ruta de la imagen de la carta
        this.rutaImagen = rutaImagen;
        // Inicializa la carta como no encontrada
        this.encontrada = false;
        // Inicializa la carta como no volteada (tapada)
        this.volteada = false;
    }

    // Método getter que retorna el nombre de la carta
    public String getNombre() {
        // Retorna el valor de la variable nombre
        return nombre;
    }

    // Método setter que modifica el nombre de la carta
    public void setNombre(String nombre) {
        // Asigna el nuevo nombre a la carta
        this.nombre = nombre;
    }

    // Método getter que retorna la ruta de la imagen de la carta
    public String getRutaImagen() {
        // Retorna la ruta de la imagen
        return rutaImagen;
    }

    // Método setter que modifica la ruta de la imagen de la carta
    public void setRutaImagen(String rutaImagen) {
        // Asigna la nueva ruta de imagen a la carta
        this.rutaImagen = rutaImagen;
    }

    // Método getter que retorna si la carta ha sido encontrada
    public boolean isEncontrada() {
        // Retorna verdadero si la pareja de la carta ya fue encontrada
        return encontrada;
    }

    // Método setter que marca si la carta ha sido encontrada
    public void setEncontrada(boolean encontrada) {
        // Asigna el estado de encontrada a la carta
        this.encontrada = encontrada;
    }

    // Método getter que retorna si la carta está volteada
    public boolean isVolteada() {
        // Retorna verdadero si la carta está destapada (boca arriba)
        return volteada;
    }

    // Método setter que modifica el estado de volteo de la carta
    public void setVolteada(boolean volteada) {
        // Asigna el estado de volteo a la carta
        this.volteada = volteada;
    }
}