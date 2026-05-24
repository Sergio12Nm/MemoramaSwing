package modelo;

// Clase que representa una carta del juego de Memorama
public class Carta {

    // Nombre o identificador de la carta
    private String nombre;
    // Ruta al archivo de imagen que representa la carta
    private String rutaImagen;
    // Bandera que indica si la carta ha sido encontrada (pareada correctamente)
    private boolean encontrada;
    // Bandera que indica si la carta está actualmente volteada (visible)
    private boolean volteada;

    // Constructor que inicializa una nueva carta con nombre e imagen
    public Carta(String nombre, String rutaImagen) {
        // Asigna el nombre de la carta
        this.nombre = nombre;
        // Asigna la ruta de la imagen de la carta
        this.rutaImagen = rutaImagen;
        // Inicializa la carta como no encontrada
        this.encontrada = false;
        // Inicializa la carta como no volteada
        this.volteada = false;
    }

    // Método getter que retorna el nombre de la carta
    public String getNombre() {
        // Retorna el nombre almacenado en la carta
        return nombre;
    }

    // Método setter que asigna un nuevo nombre a la carta
    public void setNombre(String nombre) {
        // Modifica el nombre de la carta
        this.nombre = nombre;
    }

    // Método getter que retorna la ruta de la imagen de la carta
    public String getRutaImagen() {
        // Retorna la ruta almacenada de la imagen
        return rutaImagen;
    }

    // Método setter que asigna una nueva ruta de imagen a la carta
    public void setRutaImagen(String rutaImagen) {
        // Modifica la ruta de la imagen de la carta
        this.rutaImagen = rutaImagen;
    }

    // Método getter que verifica si la carta ha sido encontrada
    public boolean isEncontrada() {
        // Retorna el estado de si la carta fue encontrada
        return encontrada;
    }

    // Método setter que marca una carta como encontrada o no
    public void setEncontrada(boolean encontrada) {
        // Modifica el estado de encontrada de la carta
        this.encontrada = encontrada;
    }

    // Método getter que verifica si la carta está volteada
    public boolean isVolteada() {
        // Retorna el estado de si la carta está volteada
        return volteada;
    }

    // Método setter que voltea una carta o la voltea boca abajo
    public void setVolteada(boolean volteada) {
        // Modifica el estado de volteada de la carta
        this.volteada = volteada;
    }
}