package vista;

// Importa clases de color para personalizar la interfaz gráfica
import java.awt.Color;
// Importa clase para configurar fuentes de texto
import java.awt.Font;
// Importa clase para generar números aleatorios
import java.util.Random;
// Importa GridLayout para organizar componentes en una cuadrícula
import java.awt.GridLayout;
// Importa clase para manipular imágenes
import java.awt.Image;
// Importa clase para capturar eventos de acciones (clics de botones)
import java.awt.event.ActionEvent;
// Importa interfaz para escuchar eventos de acción
import java.awt.event.ActionListener;
// Importa List para trabajar con listas genéricas
import java.util.List;

// Importa ImageIcon para cargar y mostrar imágenes en botones
import javax.swing.ImageIcon;
// Importa JButton para crear botones
import javax.swing.JButton;
// Importa JFrame para crear la ventana principal
import javax.swing.JFrame;
// Importa JLabel para mostrar texto e imágenes
import javax.swing.JLabel;
// Importa JOptionPane para mostrar diálogos emergentes
import javax.swing.JOptionPane;
// Importa JPanel para crear paneles contenedores
import javax.swing.JPanel;

// Importa la clase Carta del modelo
import modelo.Carta;
// Importa la clase abstracta Memorama del modelo
import modelo.Memorama;

// Clase principal que representa la ventana del juego Memorama
public class FrmJuegoMemorama extends JFrame {

    // Label que muestra el título "MEMORAMA"
    private JLabel lblTitulo;

    // Panel que contiene los botones con las cartas del juego
    private JPanel pnlCartas;

    // Label que muestra de quién es el turno actual
    private JLabel lblTurno;
    // Label que muestra los puntos del Jugador 1
    private JLabel lblJugador1;
    // Label que muestra los puntos del Jugador 2
    private JLabel lblJugador2;

    // Botón para reiniciar el juego
    private JButton btnReiniciar;

    // Objeto Memorama seleccionado (Animales, Frutas o Personajes)
    private Memorama memorama;
    // Lista que almacena todas las cartas del juego
    private List<Carta> cartas;

    // Array de botones que representa cada carta en la interfaz
    private JButton[] botones;

    // Almacena la referencia de la primera carta seleccionada
    private Carta primeraCarta;
    // Almacena la referencia de la segunda carta seleccionada
    private Carta segundaCarta;

    // Almacena el botón correspondiente a la primera carta
    private JButton primerBoton;
    // Almacena el botón correspondiente a la segunda carta
    private JButton segundoBoton;

    // Bandera que impide seleccionar más cartas mientras se verifica una pareja
    private boolean bloqueado = false;

    // Contador de puntos del Jugador 1
    private int puntosJugador1 = 0;
    // Contador de puntos del Jugador 2
    private int puntosJugador2 = 0;

    // Bandera que indica si es el turno del Jugador 1 (verdadero) o Jugador 2 (falso)
    private boolean turnoJugador1 = true;

    // Bandera que indica si se juega contra la máquina (verdadero) o dos jugadores (falso)
    private boolean contraMaquina = false;

    // Constructor que recibe el tipo de Memorama seleccionado y si se juega contra máquina
    public FrmJuegoMemorama(Memorama memoramaSeleccionado, boolean maquina) {

        // Asigna el memorama seleccionado a la variable de instancia
        this.memorama = memoramaSeleccionado;

        // Asigna el modo de juego (contra máquina o dos jugadores)
        this.contraMaquina = maquina;

        // Establece el título de la ventana en "Memorama"
        setTitle("Memorama");

        // Establece el tamaño de la ventana (ancho: 950, alto: 650)
        setSize(950, 650);

        // Configura que la aplicación se cierre cuando se cierre esta ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el layout de la ventana como null (posicionamiento absoluto)
        setLayout(null);

        // Establece el color de fondo de la ventana (gris oscuro)
        getContentPane().setBackground(new Color(30, 30, 30));

        // Llama al método para crear y configurar todos los componentes gráficos
        iniciarComponentes();

        // Llama al método para cargar y preparar el juego
        iniciarJuego();

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hace la ventana visible
        setVisible(true);
    }

    // Método que inicializa y configura todos los componentes de la interfaz
    private void iniciarComponentes() {

        // Crea el Label para el título MEMORAMA
        lblTitulo = new JLabel("MEMORAMA");

        // Establece la posición y tamaño del título (x: 20, y: 230, ancho: 250, alto: 50)
        lblTitulo.setBounds(20, 230, 250, 50);

        // Establece el color del texto del título en dorado
        lblTitulo.setForeground(new Color(255, 215, 0));

        // Establece la fuente del título (Arial, Negrita, tamaño 28)
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));

        // Agrega el Label del título a la ventana
        add(lblTitulo);

        // Crea el Label que muestra el turno actual
        lblTurno = new JLabel("Turno: Jugador 1");

        // Establece el color del texto en blanco
        lblTurno.setForeground(Color.WHITE);

        // Establece la fuente del Label de turno (Arial, Negrita, tamaño 18)
        lblTurno.setFont(new Font("Arial", Font.BOLD, 18));

        // Establece la posición y tamaño del Label de turno
        lblTurno.setBounds(20, 20, 200, 30);

        // Agrega el Label de turno a la ventana
        add(lblTurno);

        // Crea el Label que muestra los puntos del Jugador 1
        lblJugador1 = new JLabel("Jugador 1: 0");

        // Establece el color del texto en blanco
        lblJugador1.setForeground(Color.WHITE);

        // Establece la fuente del Label (Arial, Negrita, tamaño 16)
        lblJugador1.setFont(new Font("Arial", Font.BOLD, 16));

        // Establece la posición y tamaño del Label de Jugador 1
        lblJugador1.setBounds(20, 60, 200, 30);

        // Agrega el Label de Jugador 1 a la ventana
        add(lblJugador1);

        // Crea el Label que muestra los puntos del Jugador 2
        lblJugador2 = new JLabel("Jugador 2: 0");

        // Establece el color del texto en blanco
        lblJugador2.setForeground(Color.WHITE);

        // Establece la fuente del Label (Arial, Negrita, tamaño 16)
        lblJugador2.setFont(new Font("Arial", Font.BOLD, 16));

        // Establece la posición y tamaño del Label de Jugador 2
        lblJugador2.setBounds(20, 100, 200, 30);

        // Agrega el Label de Jugador 2 a la ventana
        add(lblJugador2);

        // Crea el botón para reiniciar el juego
        btnReiniciar = new JButton("Reiniciar");

        // Establece el color de fondo del botón en azul oscuro
        btnReiniciar.setBackground(new Color(70, 130, 180));

        // Establece el color del texto del botón en blanco
        btnReiniciar.setForeground(Color.WHITE);

        // Desactiva el borde de enfoque del botón para mejor apariencia
        btnReiniciar.setFocusPainted(false);

        // Establece la fuente del botón (Arial, Negrita, tamaño 14)
        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 14));

        // Establece la posición y tamaño del botón Reiniciar
        btnReiniciar.setBounds(20, 150, 120, 40);

        // Agrega un escuchador de acciones al botón para detectar clics
        btnReiniciar.addActionListener(new ActionListener() {

            // Método que se ejecuta cuando se hace clic en el botón
            @Override
            public void actionPerformed(ActionEvent e) {

                // Llama al método para reiniciar el juego
                reiniciarJuego();
            }
        });

        // Agrega el botón Reiniciar a la ventana
        add(btnReiniciar);

        // Crea el panel que contendrá los botones de las cartas
        pnlCartas = new JPanel();

        // Establece el color de fondo del panel en gris oscuro
        pnlCartas.setBackground(new Color(40, 40, 40));

        // Establece la posición y tamaño del panel (x: 260, y: 20, ancho: 620, alto: 520)
        pnlCartas.setBounds(260, 20, 620, 520);

        // Agrega el panel a la ventana
        add(pnlCartas);
    }

    // Método que inicia el juego cargando y preparando las cartas
    private void iniciarJuego() {

        // Llama al método del memorama para cargar las cartas específicas
        memorama.cargarCartas();

        // Baraja las cartas en orden aleatorio
        memorama.barajarCartas();

        // Obtiene la lista de cartas del memorama
        cartas = memorama.getCartas();

        // Crea el tablero de juego con los botones de las cartas
        crearTablero();
    }

    // Método que crea el tablero con los botones de las cartas
    private void crearTablero() {

        // Elimina todos los componentes del panel para limpiar el tablero anterior
        pnlCartas.removeAll();

        // Establece el layout del panel como una cuadrícula de 2 filas por 4 columnas con separación
        pnlCartas.setLayout(new GridLayout(2, 4, 10, 10));

        // Crea un array de botones con tamaño igual al número de cartas
        botones = new JButton[cartas.size()];

        // Itera sobre todas las cartas para crear un botón por cada una
        for (int i = 0; i < cartas.size(); i++) {

            // Crea un nuevo botón
            JButton boton = new JButton();

            // Establece el color de fondo del botón en gris oscuro
            boton.setBackground(new Color(60, 60, 60));

            // Desactiva el borde de enfoque del botón
            boton.setFocusPainted(false);

            // Establece la imagen de la parte posterior de la carta (back.png)
            boton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

            // Almacena el índice de la carta en el botón para identificarla luego
            boton.putClientProperty("indice", i);

            // Agrega un escuchador de acciones al botón para detectar clics
            boton.addActionListener(new ActionListener() {

                // Método que se ejecuta cuando se hace clic en el botón
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Llama al método para seleccionar la carta
                    seleccionarCarta(boton);
                }
            });

            // Almacena el botón en el array
            botones[i] = boton;

            // Agrega el botón al panel
            pnlCartas.add(boton);
        }

        // Recalcula el layout del panel
        pnlCartas.revalidate();

        // Redibuja el panel en la pantalla
        pnlCartas.repaint();
    }

    // Método que procesa la selección de una carta cuando se hace clic en el botón
    private void seleccionarCarta(JButton boton) {

        // Verifica si el tablero está bloqueado (esperando verificación de pareja)
        if (bloqueado) {
            // Si está bloqueado, no permite más selecciones
            return;
        }

        // Obtiene el índice de la carta del botón presionado
        int indice = (int) boton.getClientProperty("indice");

        // Obtiene la carta correspondiente del índice
        Carta carta = cartas.get(indice);

        // Verifica si la carta ya está volteada o fue encontrada
        if (carta.isVolteada() || carta.isEncontrada()) {
            // Si ya está volteada o encontrada, no permite seleccionarla de nuevo
            return;
        }

        // Establece la imagen del botón con la imagen de la carta
        boton.setIcon(redimensionarImagen(carta.getRutaImagen(), 120, 140));

        // Marca la carta como volteada (destapada)
        carta.setVolteada(true);

        // Verifica si esta es la primera carta seleccionada
        if (primeraCarta == null) {

            // Asigna esta carta como la primera carta
            primeraCarta = carta;

            // Asigna este botón como el botón de la primera carta
            primerBoton = boton;

        } else {

            // Asigna esta carta como la segunda carta
            segundaCarta = carta;

            // Asigna este botón como el botón de la segunda carta
            segundoBoton = boton;

            // Verifica si las dos cartas forman una pareja
            verificarPareja();
        }
    }

    // Método que verifica si las dos cartas seleccionadas forman una pareja válida
    private void verificarPareja() {

        // Bloquea el tablero para evitar que se seleccionen más cartas durante la verificación
        bloqueado = true;

        // Verifica si el nombre de ambas cartas es igual (son pareja)
        if (primeraCarta.getNombre().equals(segundaCarta.getNombre())) {

            // Marca la primera carta como encontrada
            primeraCarta.setEncontrada(true);

            // Marca la segunda carta como encontrada
            segundaCarta.setEncontrada(true);

            // Verifica si es el turno del Jugador 1
            if (turnoJugador1) {

                // Incrementa los puntos del Jugador 1
                puntosJugador1++;

                // Actualiza el Label con los nuevos puntos del Jugador 1
                lblJugador1.setText("Jugador 1: " + puntosJugador1);

            } else {

                // Incrementa los puntos del Jugador 2
                puntosJugador2++;

                // Actualiza el Label con los nuevos puntos del Jugador 2
                lblJugador2.setText("Jugador 2: " + puntosJugador2);
            }

            // Limpia las variables de selección para preparar la siguiente pareja
            limpiarSeleccion();

            // Desbloquea el tablero para permitir nuevas selecciones
            bloqueado = false;

            // Verifica si el juego ha terminado
            verificarFinJuego();

            // Verifica si se juega contra máquina y es su turno
            if (contraMaquina && !turnoJugador1) {

                // Ejecuta el turno automático de la máquina
                turnoMaquina();
            }

        } else {

            // Si no es pareja, crea un temporizador para voltear las cartas después de 1 segundo
            javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {

                // Método que se ejecuta cuando expira el temporizador
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Vuelve a mostrar la parte posterior de la primera carta
                    primerBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    // Vuelve a mostrar la parte posterior de la segunda carta
                    segundoBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    // Marca la primera carta como no volteada
                    primeraCarta.setVolteada(false);

                    // Marca la segunda carta como no volteada
                    segundaCarta.setVolteada(false);

                    // Cambia al siguiente jugador
                    cambiarTurno();

                    // Limpia las variables de selección
                    limpiarSeleccion();

                    // Desbloquea el tablero para permitir nuevas selecciones
                    bloqueado = false;

                    // Verifica si se juega contra máquina y es su turno
                    if (contraMaquina && !turnoJugador1) {

                        // Ejecuta el turno automático de la máquina
                        turnoMaquina();
                    }
                }
            });

            // Configura el temporizador para que se ejecute solo una vez
            timer.setRepeats(false);

            // Inicia el temporizador
            timer.start();
        }
    }

    // Método que ejecuta el turno automático de la máquina
    private void turnoMaquina() {

        // Crea un temporizador de 1 segundo para el turno de la máquina
        javax.swing.Timer timerMaquina = new javax.swing.Timer(1000, new ActionListener() {

            // Método que se ejecuta cuando expira el temporizador
            @Override
            public void actionPerformed(ActionEvent e) {

                // Crea un generador de números aleatorios
                Random random = new Random();

                // Variable para almacenar el índice de la primera carta aleatoria
                int primerIndice;
                // Variable para almacenar el índice de la segunda carta aleatoria
                int segundoIndice;

                // Bucle do-while que genera un índice aleatorio válido para la primera carta
                do {

                    // Genera un índice aleatorio entre 0 y el número de cartas
                    primerIndice = random.nextInt(cartas.size());

                // Continúa generando mientras la carta esté encontrada o volteada
                } while (cartas.get(primerIndice).isEncontrada()
                        || cartas.get(primerIndice).isVolteada());

                // Selecciona la primera carta aleatorias de la máquina
                seleccionarCarta(botones[primerIndice]);

                // Bucle do-while que genera un índice aleatorio válido para la segunda carta
                do {

                    // Genera un índice aleatorio entre 0 y el número de cartas
                    segundoIndice = random.nextInt(cartas.size());

                // Continúa generando mientras sea igual al primer índice, esté encontrada o volteada
                } while (segundoIndice == primerIndice
                        || cartas.get(segundoIndice).isEncontrada()
                        || cartas.get(segundoIndice).isVolteada());

                // Selecciona la segunda carta aleatoria de la máquina
                seleccionarCarta(botones[segundoIndice]);
            }
        });

        // Configura el temporizador para que se ejecute solo una vez
        timerMaquina.setRepeats(false);

        // Inicia el temporizador
        timerMaquina.start();
    }

    // Método que limpia las variables de selección después de verificar una pareja
    private void limpiarSeleccion() {

        // Establece la primera carta como nula
        primeraCarta = null;

        // Establece la segunda carta como nula
        segundaCarta = null;

        // Establece el botón de la primera carta como nulo
        primerBoton = null;

        // Establece el botón de la segunda carta como nulo
        segundoBoton = null;
    }

    // Método que cambia el turno entre jugadores
    private void cambiarTurno() {

        // Invierte el estado del turno (de Jugador 1 a Jugador 2 o viceversa)
        turnoJugador1 = !turnoJugador1;

        // Verifica si ahora es el turno del Jugador 1
        if (turnoJugador1) {

            // Actualiza el Label indicando que es turno del Jugador 1
            lblTurno.setText("Turno: Jugador 1");

        } else {

            // Verifica si se juega contra máquina
            if (contraMaquina) {

                // Actualiza el Label indicando que es turno de la Máquina
                lblTurno.setText("Turno: Máquina");

            } else {

                // Actualiza el Label indicando que es turno del Jugador 2
                lblTurno.setText("Turno: Jugador 2");
            }
        }
    }

    // Método que verifica si el juego ha terminado (todas las cartas encontradas)
    private void verificarFinJuego() {

        // Itera sobre todas las cartas para verificar si todas fueron encontradas
        for (Carta carta : cartas) {

            // Si encuentra una carta que no ha sido encontrada
            if (!carta.isEncontrada()) {
                // Sale del método sin mostrar el mensaje de fin de juego
                return;
            }
        }

        // Variable que almacenará el mensaje del ganador
        String mensaje;

        // Verifica si el Jugador 1 tiene más puntos que el Jugador 2
        if (puntosJugador1 > puntosJugador2) {

            // Asigna el mensaje de que gana el Jugador 1
            mensaje = "Gana Jugador 1";

        // Si el Jugador 2 tiene más puntos que el Jugador 1
        } else if (puntosJugador2 > puntosJugador1) {

            // Verifica si se juega contra máquina
            if (contraMaquina) {

                // Asigna el mensaje de que gana la Máquina
                mensaje = "Gana la Máquina";

            } else {

                // Asigna el mensaje de que gana el Jugador 2
                mensaje = "Gana Jugador 2";
            }

        } else {

            // Asigna el mensaje de empate si tienen los mismos puntos
            mensaje = "Empate";
        }

        // Muestra un diálogo con el resultado final del juego
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Método que reinicia el juego reseteando todos los valores
    private void reiniciarJuego() {

        // Reinicia los puntos del Jugador 1 a cero
        puntosJugador1 = 0;

        // Reinicia los puntos del Jugador 2 a cero
        puntosJugador2 = 0;

        // Actualiza el Label del Jugador 1 con los puntos reseteados
        lblJugador1.setText("Jugador 1: 0");

        // Actualiza el Label del Jugador 2 con los puntos reseteados
        lblJugador2.setText("Jugador 2: 0");

        // Reinicia el turno al Jugador 1
        turnoJugador1 = true;

        // Actualiza el Label de turno indicando que es turno del Jugador 1
        lblTurno.setText("Turno: Jugador 1");

        // Llama al método para cargar el juego de nuevo
        iniciarJuego();
    }

    // Método que redimensiona una imagen a un tamaño específico
    private ImageIcon redimensionarImagen(String ruta, int ancho, int alto) {

        // Carga la imagen desde la ruta especificada
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));

        // Obtiene la imagen del icono
        Image imagen = icono.getImage();

        // Redimensiona la imagen al ancho y alto especificados con calidad suave
        Image nuevaImagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        // Crea y retorna un nuevo ImageIcon con la imagen redimensionada
        return new ImageIcon(nuevaImagen);
    }
}