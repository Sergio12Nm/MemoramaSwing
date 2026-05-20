package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Memorama {

    protected List<Carta> cartas;

    // Constructor
    public Memorama() {
        cartas = new ArrayList<>();
    }

    // Método abstracto
    public abstract void cargarCartas();

    // Barajear cartas
    public void barajarCartas() {
        Collections.shuffle(cartas);
    }

    // Obtener cartas
    public List<Carta> getCartas() {
        return cartas;
    }
}