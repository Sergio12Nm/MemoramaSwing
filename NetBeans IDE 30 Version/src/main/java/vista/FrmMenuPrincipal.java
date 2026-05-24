package vista;

    // Importa la clase abstracta Memorama
    import modelo.Memorama;
    // Importa la clase MemoramaAnimales para jugar con animales
    import modelo.MemoramaAnimales;
    // Importa la clase MemoramaFrutas para jugar con frutas
    import modelo.MemoramaFrutas;
    // Importa la clase MemoramaPersonajes para jugar con personajes
    import modelo.MemoramaPersonajes;

// Clase que extiende JFrame para crear la ventana del menú principal
public class FrmMenuPrincipal extends javax.swing.JFrame {

    // Crea un logger para registrar eventos e información de depuración
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName());

    // Constructor que inicializa la ventana del menú principal
    public FrmMenuPrincipal() {
        // Inicializa todos los componentes visuales de la interfaz
        initComponents();
        // Personaliza la apariencia de la ventana
        personalizarVentana();
    }

    @SuppressWarnings("unchecked")
    // Método generado automáticamente que inicializa los componentes visuales
    private void initComponents() {

        // Crea un objeto JLabel para el título principal
        jLabel1 = new javax.swing.JLabel();
        // Crea un objeto JLabel para la etiqueta de selección de memorama
        jLabel2 = new javax.swing.JLabel();
        // Crea un objeto JLabel para la etiqueta de modo de juego
        jLabel3 = new javax.swing.JLabel();
        // Crea un botón para comenzar el juego
        btnJugar = new javax.swing.JButton();
        // Crea un ComboBox para seleccionar el tipo de memorama
        cmbMemorama = new javax.swing.JComboBox<>();
        // Crea un ComboBox para seleccionar el modo de juego
        cmbModoJuego = new javax.swing.JComboBox<>();

        // Establece que la ventana se cierre al hacer clic en el botón X
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Asigna el título de la ventana
        setTitle("Memorama");
        // Evita que la ventana reciba el enfoque automáticamente
        setAutoRequestFocus(false);
        // Establece el color de fondo gris oscuro de la ventana
        setBackground(new java.awt.Color(30, 30, 30));
        // Establece el color de primer plano gris oscuro
        setForeground(new java.awt.Color(30, 30, 30));

        // Establece la fuente Arial negrita tamaño 28 para el título
        jLabel1.setFont(new java.awt.Font("Arial", 1, 28));
        // Establece el color del texto en oro para el título
        jLabel1.setForeground(new java.awt.Color(255, 215, 0));
        // Asigna el texto "MEMORAMA" al título
        jLabel1.setText("MEMORAMA");

        // Establece la fuente Arial negrita tamaño 18 para la etiqueta del memorama
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18));
        // Establece el color del texto en blanco para la etiqueta
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        // Asigna el texto de instrucción para seleccionar memorama
        jLabel2.setText("Selecciona el memorama:");
        // Asigna una pista de herramienta vacía
        jLabel2.setToolTipText("");

        // Establece la fuente Arial negrita tamaño 18 para la etiqueta del modo
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18));
        // Establece el color del texto en blanco para la etiqueta
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        // Asigna el texto de instrucción para el modo de juego
        jLabel3.setText("Modo de juego:");
        // Asigna una pista de herramienta vacía
        jLabel3.setToolTipText("");

        // Establece el color de fondo azul grisáceo del botón Jugar
        btnJugar.setBackground(new java.awt.Color(70, 130, 180));
        // Establece la fuente Arial negrita tamaño 14 para el botón
        btnJugar.setFont(new java.awt.Font("Arial", 1, 14));
        // Asigna el texto "Jugar" al botón
        btnJugar.setText("Jugar");
        // Añade un evento de acción al botón Jugar
        btnJugar.addActionListener(this::btnJugarActionPerformed);

        // Asigna las opciones de memorama al ComboBox
        cmbMemorama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Frutas", "Personajes" }));

        // Asigna las opciones de modo de juego al ComboBox
        cmbModoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador vs Máquina", "Dos Jugadores" }));

        // Crea un layout manager para distribuir los componentes en la ventana
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        // Asigna el layout al panel de contenido
        getContentPane().setLayout(layout);
        // Configura la distribución horizontal de los componentes
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnJugar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // Configura la distribución vertical de los componentes
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnJugar)
                .addGap(80, 80, 80))
        );

        // Ajusta el tamaño de la ventana al contenido
        pack();
    }

    // Método que se ejecuta cuando se hace clic en el botón "Jugar"
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {
        // Declara una variable para almacenar el memorama seleccionado
        Memorama memoramaSeleccionado;

        // Obtiene la opción de memorama seleccionada en el ComboBox como string
        String opcionMemorama = cmbMemorama.getSelectedItem().toString();

        // Verifica si la opción seleccionada es "Animales"
        if (opcionMemorama.equals("Animales")) {

            // Crea una nueva instancia de MemoramaAnimales
            memoramaSeleccionado = new MemoramaAnimales();

        // Verifica si la opción seleccionada es "Frutas"
        } else if (opcionMemorama.equals("Frutas")) {

            // Crea una nueva instancia de MemoramaFrutas
            memoramaSeleccionado = new MemoramaFrutas();

        // Si no es ninguna de las anteriores, entonces es "Personajes"
        } else {

            // Crea una nueva instancia de MemoramaPersonajes
            memoramaSeleccionado = new MemoramaPersonajes();
        }

        // Declara una variable booleana para indicar si es contra la máquina
        boolean contraMaquina;

        // Obtiene el modo de juego seleccionado en el ComboBox
        String modoJuego = cmbModoJuego.getSelectedItem().toString();

        // Asigna true si el modo es "Jugador vs Máquina", false si es "Dos Jugadores"
        contraMaquina = modoJuego.equals("Jugador vs Máquina");

        // Crea una nueva ventana del juego pasando el memorama y el modo
        FrmJuegoMemorama juego = new FrmJuegoMemorama(memoramaSeleccionado, contraMaquina);

        // Hace visible la ventana del juego
        juego.setVisible(true);

        // Cierra la ventana del menú principal
        this.dispose();
    }

    // Método principal que inicia la aplicación
    public static void main(String args[]) {
        // Ejecuta el código de la interfaz gráfica en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {

        // Crea una nueva instancia de FrmMenuPrincipal
        FrmMenuPrincipal menu = new FrmMenuPrincipal();

        // Posiciona la ventana en el centro de la pantalla
        menu.setLocationRelativeTo(null);

        // Hace visible la ventana del menú
        menu.setVisible(true);
    });
    }
    
    // Método que personaliza la apariencia de la ventana
    private void personalizarVentana() {
        // Establece el color de fondo gris oscuro del panel de contenido
        getContentPane().setBackground(new java.awt.Color(30, 30, 30));
        // Establece la fuente Arial tamaño 14 para el ComboBox de memorama
        cmbMemorama.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        // Establece la fuente Arial tamaño 14 para el ComboBox de modo de juego
        cmbModoJuego.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JComboBox<String> cmbMemorama;
    private javax.swing.JComboBox<String> cmbModoJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
