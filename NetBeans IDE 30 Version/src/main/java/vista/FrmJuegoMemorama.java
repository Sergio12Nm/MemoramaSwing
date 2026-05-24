package vista;

// Importa la clase Color para manejar colores en la interfaz gráfica
import java.awt.Color;
// Importa la clase Font para personalizar fuentes de texto
import java.awt.Font;
// Importa Random para generar números aleatorios
import java.util.Random;
// Importa GridLayout para organizar componentes en una cuadrícula
import java.awt.GridLayout;
// Importa Image para manipular imágenes
import java.awt.Image;
// Importa ActionEvent para manejar eventos de acciones
import java.awt.event.ActionEvent;
// Importa ActionListener para escuchar eventos de acciones
import java.awt.event.ActionListener;
// Importa List como interfaz para colecciones
import java.util.List;

// Importa ImageIcon para manejar iconos de imágenes
import javax.swing.ImageIcon;
// Importa JButton para crear botones
import javax.swing.JButton;
// Importa JFrame para la ventana principal
import javax.swing.JFrame;
// Importa JLabel para mostrar etiquetas de texto
import javax.swing.JLabel;
// Importa JOptionPane para diálogos de información
import javax.swing.JOptionPane;
// Importa JPanel para crear paneles contenedores
import javax.swing.JPanel;

// Importa la clase Carta del modelo
import modelo.Carta;
// Importa la clase Memorama del modelo
import modelo.Memorama;

// Clase principal del juego que extiende JFrame para crear la ventana
public class FrmJuegoMemorama extends JFrame {

    // Etiqueta que muestra el título del juego
    private JLabel lblTitulo;

    // Panel que contiene todas las cartas del juego
    private JPanel pnlCartas;

    // Etiqueta que muestra de quién es el turno
    private JLabel lblTurno;
    // Etiqueta que muestra los puntos del jugador 1
    private JLabel lblJugador1;
    // Etiqueta que muestra los puntos del jugador 2
    private JLabel lblJugador2;

    // Botón para reiniciar el juego
    private JButton btnReiniciar;

    // Objeto que contiene la lógica del memorama
    private Memorama memorama;
    // Lista que almacena todas las cartas del juego
    private List<Carta> cartas;

    // Array que almacena todos los botones visuales de las cartas
    private JButton[] botones;

    // Variable que almacena la primera carta seleccionada
    private Carta primeraCarta;
    // Variable que almacena la segunda carta seleccionada
    private Carta segundaCarta;

    // Variable que almacena el botón visual de la primera carta
    private JButton primerBoton;
    // Variable que almacena el botón visual de la segunda carta
    private JButton segundoBoton;

    // Bandera que bloquea la selección mientras se verifica la pareja
    private boolean bloqueado = false;

    // Puntos acumulados del jugador 1
    private int puntosJugador1 = 0;
    // Puntos acumulados del jugador 2
    private int puntosJugador2 = 0;

    // Bandera que indica si es el turno del jugador 1
    private boolean turnoJugador1 = true;

    // Bandera que indica si se juega contra la máquina
    private boolean contraMaquina = false;

    // Constructor que inicializa la ventana del juego
    public FrmJuegoMemorama(Memorama memoramaSeleccionado, boolean maquina) {

        // Asigna el memorama seleccionado a la variable de instancia
        this.memorama = memoramaSeleccionado;

        // Asigna el modo de juego (si es contra máquina)
        this.contraMaquina = maquina;

        // Establece el título de la ventana
        setTitle("Memorama");

        // Establece el tamaño de la ventana (ancho x alto)
        setSize(950, 650);

        // Establece que al cerrar la ventana se cierre la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Desactiva el layout automático para usar posicionamiento manual
        setLayout(null);

        // Establece el color de fondo gris oscuro
        getContentPane().setBackground(new Color(30, 30, 30));

        // Inicializa todos los componentes visuales
        iniciarComponentes();

        // Inicia la lógica del juego
        iniciarJuego();

        // Posiciona la ventana en el centro de la pantalla
        setLocationRelativeTo(null);

        // Hace visible la ventana
        setVisible(true);
    }

    // Método que inicializa todos los componentes visuales de la interfaz
    private void iniciarComponentes() {

        // Crea la etiqueta para mostrar el título "MEMORAMA"
        lblTitulo = new JLabel("MEMORAMA");

        // Posiciona la etiqueta en la ventana (x, y, ancho, alto)
        lblTitulo.setBounds(20, 230, 250, 50);

        // Establece el color del texto en oro para el título
        lblTitulo.setForeground(new Color(255, 215, 0));

        // Establece la fuente Arial negrita tamaño 28 para el título
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));

        // Añade la etiqueta del título al panel principal
        add(lblTitulo);

        // Crea la etiqueta que muestra de quién es el turno
        lblTurno = new JLabel("Turno: Jugador 1");

        // Establece el color del texto en blanco
        lblTurno.setForeground(Color.WHITE);

        // Establece la fuente Arial negrita tamaño 18
        lblTurno.setFont(new Font("Arial", Font.BOLD, 18));

        // Posiciona la etiqueta en la ventana
        lblTurno.setBounds(20, 20, 200, 30);

        // Añade la etiqueta del turno al panel principal
        add(lblTurno);

        // Crea la etiqueta que muestra los puntos del jugador 1
        lblJugador1 = new JLabel("Jugador 1: 0");

        // Establece el color del texto en blanco
        lblJugador1.setForeground(Color.WHITE);

        // Establece la fuente Arial negrita tamaño 16
        lblJugador1.setFont(new Font("Arial", Font.BOLD, 16));

        // Posiciona la etiqueta en la ventana
        lblJugador1.setBounds(20, 60, 200, 30);

        // Añade la etiqueta del jugador 1 al panel principal
        add(lblJugador1);

        // Crea la etiqueta que muestra los puntos del jugador 2
        lblJugador2 = new JLabel("Jugador 2: 0");

        // Establece el color del texto en blanco
        lblJugador2.setForeground(Color.WHITE);

        // Establece la fuente Arial negrita tamaño 16
        lblJugador2.setFont(new Font("Arial", Font.BOLD, 16));

        // Posiciona la etiqueta en la ventana
        lblJugador2.setBounds(20, 100, 200, 30);

        // Añade la etiqueta del jugador 2 al panel principal
        add(lblJugador2);

        // Crea el botón para reiniciar el juego
        btnReiniciar = new JButton("Reiniciar");

        // Establece el color de fondo azul grisáceo del botón
        btnReiniciar.setBackground(new Color(70, 130, 180));

        // Establece el color del texto en blanco
        btnReiniciar.setForeground(Color.WHITE);

        // Desactiva el efecto de enfoque visual del botón
        btnReiniciar.setFocusPainted(false);

        // Establece la fuente Arial negrita tamaño 14
        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 14));

        // Posiciona el botón en la ventana
        btnReiniciar.setBounds(20, 150, 120, 40);

        // Añade un evento de acción al botón Reiniciar
        btnReiniciar.addActionListener(new ActionListener() {

            // Método que se ejecuta cuando se hace clic en el botón
            @Override
            public void actionPerformed(ActionEvent e) {

                // Llama al método que reinicia el juego
                reiniciarJuego();
            }
        });

        // Añade el botón Reiniciar al panel principal
        add(btnReiniciar);

        // Crea el panel que contendrá todas las cartas
        pnlCartas = new JPanel();

        // Establece el color de fondo gris oscuro para el panel
        pnlCartas.setBackground(new Color(40, 40, 40));

        // Posiciona el panel en la ventana
        pnlCartas.setBounds(260, 20, 620, 520);

        // Añade el panel de cartas al panel principal
        add(pnlCartas);
    }

    // Método que inicializa la lógica del juego
    private void iniciarJuego() {

        // Carga las cartas específicas del memorama seleccionado
        memorama.cargarCartas();

        // Baraja las cartas de forma aleatoria
        memorama.barajarCartas();

        // Obtiene la lista de cartas del memorama
        cartas = memorama.getCartas();

        // Crea el tablero visual con los botones de las cartas
        crearTablero();
    }

    // Método que crea el tablero visual con los botones de las cartas
    private void crearTablero() {

        // Elimina todos los componentes anteriores del panel de cartas
        pnlCartas.removeAll();

        // Establece un layout de cuadrícula de 2 filas y 4 columnas con espacio entre componentes
        pnlCartas.setLayout(new GridLayout(2, 4, 10, 10));

        // Crea un array de botones del tamaño del número de cartas
        botones = new JButton[cartas.size()];

        // Itera sobre todas las cartas para crear un botón para cada una
        for (int i = 0; i < cartas.size(); i++) {

            // Crea un nuevo botón
            JButton boton = new JButton();

            // Establece el color de fondo gris para el botón
            boton.setBackground(new Color(60, 60, 60));

            // Desactiva el efecto de enfoque visual del botón
            boton.setFocusPainted(false);

            // Asigna la imagen de dorso de carta al botón
            boton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

            // Almacena el índice de la carta en las propiedades del botón
            boton.putClientProperty("indice", i);

            // Añade un evento de acción al botón
            boton.addActionListener(new ActionListener() {

                // Método que se ejecuta cuando se hace clic en el botón
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Selecciona la carta correspondiente
                    seleccionarCarta(boton);
                }
            });

            // Almacena el botón en el array de botones
            botones[i] = boton;

            // Añade el botón al panel de cartas
            pnlCartas.add(boton);
        }

        // Actualiza el diseño del panel
        pnlCartas.revalidate();

        // Redibuja el panel
        pnlCartas.repaint();
    }

    // Método que maneja la selección de una carta
    private void seleccionarCarta(JButton boton) {

        // Si el juego está bloqueado, no permite seleccionar más cartas
        if (bloqueado) {
            return;
        }

        // Obtiene el índice de la carta del botón
        int indice = (int) boton.getClientProperty("indice");

        // Obtiene la carta de la lista según el índice
        Carta carta = cartas.get(indice);

        // Si la carta ya está volteada o encontrada, no la selecciona de nuevo
        if (carta.isVolteada() || carta.isEncontrada()) {
            return;
        }

        // Muestra la imagen de la carta en el botón
        boton.setIcon(redimensionarImagen(carta.getRutaImagen(), 120, 140));

        // Marca la carta como volteada
        carta.setVolteada(true);

        // Si no hay una primera carta seleccionada, esta es la primera
        if (primeraCarta == null) {

            // Asigna esta carta como la primera carta seleccionada
            primeraCarta = carta;

            // Asigna este botón como el botón de la primera carta
            primerBoton = boton;

        // Si ya hay una primera carta, esta es la segunda
        } else {

            // Asigna esta carta como la segunda carta seleccionada
            segundaCarta = carta;

            // Asigna este botón como el botón de la segunda carta
            segundoBoton = boton;

            // Verifica si las dos cartas forman una pareja
            verificarPareja();
        }
    }

    // Método que verifica si las dos cartas seleccionadas forman una pareja
    private void verificarPareja() {

        // Bloquea la interfaz para evitar selecciones adicionales
        bloqueado = true;

        // Compara si el nombre de ambas cartas es igual
        if (primeraCarta.getNombre().equals(segundaCarta.getNombre())) {

            // Marca la primera carta como encontrada
            primeraCarta.setEncontrada(true);

            // Marca la segunda carta como encontrada
            segundaCarta.setEncontrada(true);

            // Si es el turno del jugador 1, incrementa sus puntos
            if (turnoJugador1) {

                // Incrementa los puntos del jugador 1
                puntosJugador1++;

                // Actualiza la etiqueta con los nuevos puntos
                lblJugador1.setText("Jugador 1: " + puntosJugador1);

            // Si es el turno del jugador 2, incrementa sus puntos
            } else {

                // Incrementa los puntos del jugador 2
                puntosJugador2++;

                // Actualiza la etiqueta con los nuevos puntos
                lblJugador2.setText("Jugador 2: " + puntosJugador2);
            }

            // Limpia las variables de selección
            limpiarSeleccion();

            // Desbloquea la interfaz
            bloqueado = false;

            // Verifica si el juego ha terminado
            verificarFinJuego();

            // Si es contra máquina y es el turno de la máquina, ejecuta su turno
            if (contraMaquina && !turnoJugador1) {

                // Ejecuta el turno de la máquina
                turnoMaquina();
            }

        // Si las cartas no coinciden
        } else {

            // Crea un temporizador que espera 1000 milisegundos (1 segundo)
            javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {

                // Método que se ejecuta cuando termina el tiempo
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Voltea la primera carta mostrando el dorso
                    primerBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    // Voltea la segunda carta mostrando el dorso
                    segundoBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    // Marca la primera carta como no volteada
                    primeraCarta.setVolteada(false);

                    // Marca la segunda carta como no volteada
                    segundaCarta.setVolteada(false);

                    // Cambia el turno al otro jugador
                    cambiarTurno();

                    // Limpia las variables de selección
                    limpiarSeleccion();

                    // Desbloquea la interfaz
                    bloqueado = false;

                    // Si es contra máquina y es el turno de la máquina, ejecuta su turno
                    if (contraMaquina && !turnoJugador1) {

                        // Ejecuta el turno de la máquina
                        turnoMaquina();
                    }
                }
            });

            // Establece que el temporizador solo se ejecute una vez
            timer.setRepeats(false);

            // Inicia el temporizador
            timer.start();
        }
    }

    // Método que ejecuta el turno de la máquina
    private void turnoMaquina() {

        // Crea un temporizador que espera 1000 milisegundos antes de que la máquina juegue
        javax.swing.Timer timerMaquina = new javax.swing.Timer(1000, new ActionListener() {

            // Método que se ejecuta cuando termina el tiempo
            @Override
            public void actionPerformed(ActionEvent e) {

                // Crea un generador de números aleatorios
                Random random = new Random();

                // Variable para almacenar el índice de la primera carta
                int primerIndice;
                // Variable para almacenar el índice de la segunda carta
                int segundoIndice;

                // Genera el índice de la primera carta aleatoriamente
                do {

                    // Genera un número aleatorio entre 0 y el tamaño de las cartas
                    primerIndice = random.nextInt(cartas.size());

                // Repite mientras la carta ya esté encontrada o volteada
                } while (cartas.get(primerIndice).isEncontrada()
                        || cartas.get(primerIndice).isVolteada());

                // Selecciona la primera carta
                seleccionarCarta(botones[primerIndice]);

                // Genera el índice de la segunda carta aleatoriamente
                do {

                    // Genera un número aleatorio entre 0 y el tamaño de las cartas
                    segundoIndice = random.nextInt(cartas.size());

                // Repite mientras sea el mismo índice, esté encontrada o volteada
                } while (segundoIndice == primerIndice
                        || cartas.get(segundoIndice).isEncontrada()
                        || cartas.get(segundoIndice).isVolteada());

                // Selecciona la segunda carta
                seleccionarCarta(botones[segundoIndice]);
            }
        });

        // Establece que el temporizador solo se ejecute una vez
        timerMaquina.setRepeats(false);

        // Inicia el temporizador
        timerMaquina.start();
    }

    // Método que limpia las variables de selección
    private void limpiarSeleccion() {

        // Asigna null a la primera carta para limpiarla
        primeraCarta = null;

        // Asigna null a la segunda carta para limpiarla
        segundaCarta = null;

        // Asigna null al primer botón para limpiarlo
        primerBoton = null;

        // Asigna null al segundo botón para limpiarlo
        segundoBoton = null;
    }

    // Método que cambia el turno al otro jugador
    private void cambiarTurno() {

        // Invierte el valor de turnoJugador1 (true se convierte en false y viceversa)
        turnoJugador1 = !turnoJugador1;

        // Si ahora es el turno del jugador 1
        if (turnoJugador1) {

            // Actualiza la etiqueta para mostrar el turno del jugador 1
            lblTurno.setText("Turno: Jugador 1");

        // Si ahora es el turno del jugador 2
        } else {

            // Si se juega contra máquina
            if (contraMaquina) {

                // Actualiza la etiqueta para mostrar el turno de la máquina
                lblTurno.setText("Turno: Máquina");

            // Si se juega entre dos jugadores
            } else {

                // Actualiza la etiqueta para mostrar el turno del jugador 2
                lblTurno.setText("Turno: Jugador 2");
            }
        }
    }

    // Método que verifica si el juego ha terminado
    private void verificarFinJuego() {

        // Itera sobre todas las cartas
        for (Carta carta : cartas) {

            // Si encuentra una carta que no ha sido encontrada
            if (!carta.isEncontrada()) {
                // Retorna sin hacer nada, el juego continúa
                return;
            }
        }

        // Variable que almacenará el mensaje de ganador
        String mensaje;

        // Si el jugador 1 tiene más puntos que el jugador 2
        if (puntosJugador1 > puntosJugador2) {

            // Asigna el mensaje de victoria del jugador 1
            mensaje = "Gana Jugador 1";

        // Si el jugador 2 tiene más puntos que el jugador 1
        } else if (puntosJugador2 > puntosJugador1) {

            // Si se juega contra máquina
            if (contraMaquina) {

                // Asigna el mensaje de victoria de la máquina
                mensaje = "Gana la Máquina";

            // Si se juega entre dos jugadores
            } else {

                // Asigna el mensaje de victoria del jugador 2
                mensaje = "Gana Jugador 2";
            }

        // Si tienen los mismos puntos
        } else {

            // Asigna el mensaje de empate
            mensaje = "Empate";
        }

        // Muestra un diálogo con el resultado del juego
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Método que reinicia el juego
    private void reiniciarJuego() {

        // Reinicia los puntos del jugador 1 a cero
        puntosJugador1 = 0;

        // Reinicia los puntos del jugador 2 a cero
        puntosJugador2 = 0;

        // Actualiza la etiqueta del jugador 1 mostrando 0 puntos
        lblJugador1.setText("Jugador 1: 0");

        // Actualiza la etiqueta del jugador 2 mostrando 0 puntos
        lblJugador2.setText("Jugador 2: 0");

        // Establece que sea el turno del jugador 1
        turnoJugador1 = true;

        // Actualiza la etiqueta del turno
        lblTurno.setText("Turno: Jugador 1");

        // Inicia nuevamente el juego
        iniciarJuego();
    }

    // Método que redimensiona una imagen según el ancho y alto especificados
    private ImageIcon redimensionarImagen(String ruta, int ancho, int alto) {

        // Crea un ImageIcon cargando la imagen desde la ruta especificada
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));

        // Obtiene la imagen del icono
        Image imagen = icono.getImage();

        // Redimensiona la imagen al ancho y alto especificados con suavizado
        Image nuevaImagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        // Retorna un nuevo ImageIcon con la imagen redimensionada
        return new ImageIcon(nuevaImagen);
    }
}