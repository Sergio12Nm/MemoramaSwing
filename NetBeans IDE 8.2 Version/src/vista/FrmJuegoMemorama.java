package vista;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.Memorama;

public class FrmJuegoMemorama extends JFrame {

    private JLabel lblTitulo;

    private JPanel pnlCartas;

    private JLabel lblTurno;
    private JLabel lblJugador1;
    private JLabel lblJugador2;

    private JButton btnReiniciar;

    private Memorama memorama;
    private List<Carta> cartas;

    private JButton[] botones;

    private Carta primeraCarta;
    private Carta segundaCarta;

    private JButton primerBoton;
    private JButton segundoBoton;

    private boolean bloqueado = false;

    private int puntosJugador1 = 0;
    private int puntosJugador2 = 0;

    private boolean turnoJugador1 = true;

    private boolean contraMaquina = false;

    // CONSTRUCTOR
    public FrmJuegoMemorama(Memorama memoramaSeleccionado, boolean maquina) {

        this.memorama = memoramaSeleccionado;

        this.contraMaquina = maquina;

        setTitle("Memorama");

        setSize(950, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(new Color(30, 30, 30));

        iniciarComponentes();

        iniciarJuego();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void iniciarComponentes() {

        // TITULO
        lblTitulo = new JLabel("MEMORAMA");

        lblTitulo.setBounds(20, 230, 250, 50);

        lblTitulo.setForeground(new Color(255, 215, 0));

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        
        add(lblTitulo);

        // TURNO
        lblTurno = new JLabel("Turno: Jugador 1");

        lblTurno.setForeground(Color.WHITE);

        lblTurno.setFont(new Font("Arial", Font.BOLD, 18));

        lblTurno.setBounds(20, 20, 200, 30);

        add(lblTurno);

        // JUGADOR 1
        lblJugador1 = new JLabel("Jugador 1: 0");

        lblJugador1.setForeground(Color.WHITE);

        lblJugador1.setFont(new Font("Arial", Font.BOLD, 16));

        lblJugador1.setBounds(20, 60, 200, 30);

        add(lblJugador1);

        // JUGADOR 2
        lblJugador2 = new JLabel("Jugador 2: 0");

        lblJugador2.setForeground(Color.WHITE);

        lblJugador2.setFont(new Font("Arial", Font.BOLD, 16));

        lblJugador2.setBounds(20, 100, 200, 30);

        add(lblJugador2);

        // BOTON REINICIAR
        btnReiniciar = new JButton("Reiniciar");

        btnReiniciar.setBackground(new Color(70, 130, 180));

        btnReiniciar.setForeground(Color.WHITE);

        btnReiniciar.setFocusPainted(false);

        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 14));

        btnReiniciar.setBounds(20, 150, 120, 40);

        btnReiniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                reiniciarJuego();
            }
        });

        add(btnReiniciar);

        // PANEL DE CARTAS
        pnlCartas = new JPanel();

        pnlCartas.setBackground(new Color(40, 40, 40));

        pnlCartas.setBounds(260, 20, 620, 520);

        add(pnlCartas);
    }

    private void iniciarJuego() {

        memorama.cargarCartas();

        memorama.barajarCartas();

        cartas = memorama.getCartas();

        crearTablero();
    }

    private void crearTablero() {

        pnlCartas.removeAll();

        pnlCartas.setLayout(new GridLayout(2, 4, 10, 10));

        botones = new JButton[cartas.size()];

        for (int i = 0; i < cartas.size(); i++) {

            JButton boton = new JButton();

            boton.setBackground(new Color(60, 60, 60));

            boton.setFocusPainted(false);

            boton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

            boton.putClientProperty("indice", i);

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    seleccionarCarta(boton);
                }
            });

            botones[i] = boton;

            pnlCartas.add(boton);
        }

        pnlCartas.revalidate();

        pnlCartas.repaint();
    }

    private void seleccionarCarta(JButton boton) {

        if (bloqueado) {
            return;
        }

        int indice = (int) boton.getClientProperty("indice");

        Carta carta = cartas.get(indice);

        if (carta.isVolteada() || carta.isEncontrada()) {
            return;
        }

        boton.setIcon(redimensionarImagen(carta.getRutaImagen(), 120, 140));

        carta.setVolteada(true);

        if (primeraCarta == null) {

            primeraCarta = carta;

            primerBoton = boton;

        } else {

            segundaCarta = carta;

            segundoBoton = boton;

            verificarPareja();
        }
    }

    private void verificarPareja() {

        bloqueado = true;

        if (primeraCarta.getNombre().equals(segundaCarta.getNombre())) {

            primeraCarta.setEncontrada(true);

            segundaCarta.setEncontrada(true);

            if (turnoJugador1) {

                puntosJugador1++;

                lblJugador1.setText("Jugador 1: " + puntosJugador1);

            } else {

                puntosJugador2++;

                lblJugador2.setText("Jugador 2: " + puntosJugador2);
            }

            limpiarSeleccion();

            bloqueado = false;

            verificarFinJuego();

            if (contraMaquina && !turnoJugador1) {

                turnoMaquina();
            }

        } else {

            javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    primerBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    segundoBoton.setIcon(redimensionarImagen("/imagenes/back.png", 120, 140));

                    primeraCarta.setVolteada(false);

                    segundaCarta.setVolteada(false);

                    cambiarTurno();

                    limpiarSeleccion();

                    bloqueado = false;

                    if (contraMaquina && !turnoJugador1) {

                        turnoMaquina();
                    }
                }
            });

            timer.setRepeats(false);

            timer.start();
        }
    }

    private void turnoMaquina() {

        javax.swing.Timer timerMaquina = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Random random = new Random();

                int primerIndice;
                int segundoIndice;

                do {

                    primerIndice = random.nextInt(cartas.size());

                } while (cartas.get(primerIndice).isEncontrada()
                        || cartas.get(primerIndice).isVolteada());

                seleccionarCarta(botones[primerIndice]);

                do {

                    segundoIndice = random.nextInt(cartas.size());

                } while (segundoIndice == primerIndice
                        || cartas.get(segundoIndice).isEncontrada()
                        || cartas.get(segundoIndice).isVolteada());

                seleccionarCarta(botones[segundoIndice]);
            }
        });

        timerMaquina.setRepeats(false);

        timerMaquina.start();
    }

    private void limpiarSeleccion() {

        primeraCarta = null;

        segundaCarta = null;

        primerBoton = null;

        segundoBoton = null;
    }

    private void cambiarTurno() {

        turnoJugador1 = !turnoJugador1;

        if (turnoJugador1) {

            lblTurno.setText("Turno: Jugador 1");

        } else {

            if (contraMaquina) {

                lblTurno.setText("Turno: Máquina");

            } else {

                lblTurno.setText("Turno: Jugador 2");
            }
        }
    }

    private void verificarFinJuego() {

        for (Carta carta : cartas) {

            if (!carta.isEncontrada()) {
                return;
            }
        }

        String mensaje;

        if (puntosJugador1 > puntosJugador2) {

            mensaje = "Gana Jugador 1";

        } else if (puntosJugador2 > puntosJugador1) {

            if (contraMaquina) {

                mensaje = "Gana la Máquina";

            } else {

                mensaje = "Gana Jugador 2";
            }

        } else {

            mensaje = "Empate";
        }

        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void reiniciarJuego() {

        puntosJugador1 = 0;

        puntosJugador2 = 0;

        lblJugador1.setText("Jugador 1: 0");

        lblJugador2.setText("Jugador 2: 0");

        turnoJugador1 = true;

        lblTurno.setText("Turno: Jugador 1");

        iniciarJuego();
    }

    private ImageIcon redimensionarImagen(String ruta, int ancho, int alto) {

        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));

        Image imagen = icono.getImage();

        Image nuevaImagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        return new ImageIcon(nuevaImagen);
    }
}