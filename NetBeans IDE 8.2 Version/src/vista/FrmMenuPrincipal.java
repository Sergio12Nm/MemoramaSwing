package vista;

// Importa la clase abstracta Memorama del modelo
import modelo.Memorama;
    // Importa la clase MemoramaAnimales del modelo
    import modelo.MemoramaAnimales;
    // Importa la clase MemoramaFrutas del modelo
    import modelo.MemoramaFrutas;
    // Importa la clase MemoramaPersonajes del modelo
    import modelo.MemoramaPersonajes;

// Clase que representa el menú principal de la aplicación
public class FrmMenuPrincipal extends javax.swing.JFrame {

    // Constructor de la ventana del menú principal
    public FrmMenuPrincipal() {
        // Inicializa los componentes gráficos de la ventana
        initComponents();
        // Personaliza la apariencia de la ventana
        personalizarVentana();
    }

    // Anotación que suprime advertencias de tipos sin especificar
    @SuppressWarnings("unchecked")
    // Comentario generado por NetBeans para los componentes automáticos
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Método generado automáticamente por NetBeans que inicializa los componentes
    private void initComponents() {

        // Crea la etiqueta 1 (se usa para otros componentes más adelante)
        jLabel1 = new javax.swing.JLabel();
        // Crea la etiqueta 2 (se usa para otros componentes más adelante)
        jLabel2 = new javax.swing.JLabel();
        // Crea la etiqueta 3 (se usa para otros componentes más adelante)
        jLabel3 = new javax.swing.JLabel();
        // Crea el ComboBox para seleccionar el modo de juego
        cmbModoJuego = new javax.swing.JComboBox<>();
        // Crea el ComboBox para seleccionar el tipo de memorama
        cmbMemorama = new javax.swing.JComboBox<>();
        // Crea el botón "Jugar"
        btnJugar = new javax.swing.JButton();

        // Configura que la operación por defecto al cerrar sea EXIT_ON_CLOSE
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Desactiva la solicitud automática de enfoque
        setAutoRequestFocus(false);
        // Establece el color de fondo de la ventana en gris oscuro
        setBackground(new java.awt.Color(30, 30, 30));

        // Configura la fuente de jLabel1 en Arial, Negrita, tamaño 28
        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        // Establece el color del texto de jLabel1 en dorado
        jLabel1.setForeground(new java.awt.Color(255, 215, 0));
        // Establece el texto de jLabel1 como "MEMORAMA"
        jLabel1.setText("MEMORAMA");

        // Configura la fuente de jLabel2 en Arial, Negrita, tamaño 18
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        // Establece el color del texto de jLabel2 en blanco
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        // Establece el texto de jLabel2 como "Selecciona el memorama:"
        jLabel2.setText("Selecciona el memorama:");

        // Configura la fuente de jLabel3 en Arial, Negrita, tamaño 18
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        // Establece el color del texto de jLabel3 en blanco
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        // Establece el texto de jLabel3 como "Modo de juego:"
        jLabel3.setText("Modo de juego:");

        // Configura la fuente del ComboBox de modo de juego en Segoe UI, tamaño 12
        cmbModoJuego.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        // Establece los elementos del ComboBox: "Jugador vs Máquina" y "Dos Jugadores"
        cmbModoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador vs Máquina", "Dos Jugadores" }));
        // Agrega un escuchador de acciones al ComboBox
        cmbModoJuego.addActionListener(new java.awt.event.ActionListener() {
            // Método que se ejecuta cuando cambia la selección del ComboBox
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Llama al método que maneja la acción del ComboBox
                cmbModoJuegoActionPerformed(evt);
            }
        });

        // Configura la fuente del ComboBox de memorama en Segoe UI, tamaño 12
        cmbMemorama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        // Establece los elementos del ComboBox: "Animales", "Frutas" y "Personajes"
        cmbMemorama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Frutas", "Personajes" }));

        // Establece el color de fondo del botón "Jugar" en azul oscuro
        btnJugar.setBackground(new java.awt.Color(70, 130, 180));
        // Configura la fuente del botón en Arial, Negrita, tamaño 14
        btnJugar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        // Establece el texto del botón como "Jugar"
        btnJugar.setText("Jugar");
        // Agrega un escuchador de acciones al botón
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            // Método que se ejecuta cuando se hace clic en el botón
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Llama al método que maneja la acción del botón "Jugar"
                btnJugarActionPerformed(evt);
            }
        });

        // Crea un GroupLayout para organizar los componentes horizontalmente
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        // Establece el layout como GroupLayout
        getContentPane().setLayout(layout);
        // Configura el grupo horizontal del layout
        layout.setHorizontalGroup(
            // Crea un grupo paralelo (elementos se pueden solapar)
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            // Crea un grupo secuencial (elementos uno tras otro)
            .addGroup(layout.createSequentialGroup()
                // Agrega espacio al contenedor
                .addContainerGap()
                // Agrega la etiqueta jLabel3 (Modo de juego:)
                .addComponent(jLabel3)
                // Agrega espacio preferido relacionado, máximo 66 píxeles
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                // Agrega el ComboBox de modo de juego
                .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                // Agrega espacio final de 53 píxeles
                .addGap(53, 53, 53))
            // Crea otro grupo secuencial
            .addGroup(layout.createSequentialGroup()
                // Crea un grupo paralelo para los componentes alineados a la izquierda
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // Crea un grupo secuencial para jLabel1
                    .addGroup(layout.createSequentialGroup()
                        // Agrega espacio de 109 píxeles
                        .addGap(109, 109, 109)
                        // Agrega el título jLabel1 (MEMORAMA)
                        .addComponent(jLabel1))
                    // Crea un grupo secuencial para jLabel2
                    .addGroup(layout.createSequentialGroup()
                        // Agrega espacio al contenedor
                        .addContainerGap()
                        // Agrega la etiqueta jLabel2 (Selecciona el memorama:)
                        .addComponent(jLabel2))
                    // Crea un grupo secuencial para el botón Jugar
                    .addGroup(layout.createSequentialGroup()
                        // Agrega espacio de 146 píxeles
                        .addGap(146, 146, 146)
                        // Agrega el botón "Jugar"
                        .addComponent(btnJugar)))
                // Agrega espacio al contenedor de forma predeterminada
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            // Crea un grupo paralelo para alinear el ComboBox de memorama
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                // Alinea el ComboBox a la derecha
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    // Agrega espacio máximo (263 píxeles por defecto)
                    .addContainerGap(263, Short.MAX_VALUE)
                    // Agrega el ComboBox de memorama
                    .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    // Agrega espacio final de 54 píxeles
                    .addGap(54, 54, 54)))
        );
        // Configura el grupo vertical del layout
        layout.setVerticalGroup(
            // Crea un grupo paralelo (elementos pueden solaparse)
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            // Crea un grupo secuencial (elementos uno tras otro verticalmente)
            .addGroup(layout.createSequentialGroup()
                // Agrega espacio superior de 28 píxeles
                .addGap(28, 28, 28)
                // Agrega el título jLabel1 (MEMORAMA)
                .addComponent(jLabel1)
                // Agrega espacio de 18 píxeles
                .addGap(18, 18, 18)
                // Agrega la etiqueta jLabel2 (Selecciona el memorama:)
                .addComponent(jLabel2)
                // Agrega espacio de 18 píxeles
                .addGap(18, 18, 18)
                // Crea un grupo paralelo para alinear el label jLabel3 y ComboBox en la misma línea
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    // Agrega la etiqueta jLabel3 (Modo de juego:)
                    .addComponent(jLabel3)
                    // Agrega el ComboBox de modo de juego
                    .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                // Agrega espacio de 43 píxeles
                .addGap(43, 43, 43)
                // Agrega el botón "Jugar"
                .addComponent(btnJugar)
                // Agrega espacio al pie de forma flexible (máximo 90 píxeles)
                .addContainerGap(90, Short.MAX_VALUE))
            // Crea otro grupo paralelo para el ComboBox de memorama
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                // Crea un grupo secuencial para posicionar el ComboBox
                .addGroup(layout.createSequentialGroup()
                    // Agrega espacio superior de 90 píxeles
                    .addGap(90, 90, 90)
                    // Agrega el ComboBox de memorama
                    .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    // Agrega espacio al pie de forma flexible (máximo 188 píxeles)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );

        // Empaqueta la ventana para que se ajuste al tamaño de sus componentes
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Manejador de evento del botón "Jugar"
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // Variable para almacenar el tipo de memorama seleccionado
        Memorama memoramaSeleccionado;

        // Obtiene la opción seleccionada en el ComboBox de memorama
        String opcionMemorama = cmbMemorama.getSelectedItem().toString();

        // Verifica si la opción seleccionada es "Animales"
        if (opcionMemorama.equals("Animales")) {

            // Crea una instancia de MemoramaAnimales
            memoramaSeleccionado = new MemoramaAnimales();

        // Verifica si la opción seleccionada es "Frutas"
        } else if (opcionMemorama.equals("Frutas")) {

            // Crea una instancia de MemoramaFrutas
            memoramaSeleccionado = new MemoramaFrutas();

        // Si no es Animales ni Frutas, debe ser Personajes
        } else {

            // Crea una instancia de MemoramaPersonajes
            memoramaSeleccionado = new MemoramaPersonajes();
        }

        // Variable para almacenar si se juega contra máquina o no
        boolean contraMaquina;

        // Obtiene la opción seleccionada en el ComboBox de modo de juego
        String modoJuego = cmbModoJuego.getSelectedItem().toString();

        // Verifica si el modo de juego es "Jugador vs Máquina" y asigna el resultado a contraMaquina
        contraMaquina = modoJuego.equals("Jugador vs Máquina");

        // Crea la ventana del juego pasando el memorama seleccionado y el modo de juego
        FrmJuegoMemorama juego = new FrmJuegoMemorama(memoramaSeleccionado, contraMaquina);

        // Hace visible la ventana del juego
        juego.setVisible(true);

        // Cierra la ventana del menú principal
        this.dispose();
    }//GEN-LAST:event_btnJugarActionPerformed

    // Manejador de evento del ComboBox de modo de juego
    private void cmbModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModoJuegoActionPerformed
        // Este método está vacío porque por ahora no se necesita ejecutar código cuando cambia el modo de juego
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModoJuegoActionPerformed

    // Método principal que inicia la aplicación
    public static void main(String args[]) {

        // Ejecuta el código de creación de la ventana en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {

            // Método que se ejecuta en el hilo de eventos
            @Override
            public void run() {

                // Crea la ventana del menú principal y la hace visible
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Método que personaliza la apariencia de la ventana
    private void personalizarVentana() {
        // Establece el color de fondo del contenedor en gris oscuro
        getContentPane().setBackground(new java.awt.Color(30, 30, 30));
        // Establece la fuente del ComboBox de memorama en Arial, normal, tamaño 14
        cmbMemorama.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        // Establece la fuente del ComboBox de modo de juego en Arial, normal, tamaño 14
        cmbModoJuego.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
    }

    // Comentario de NetBeans que indica el inicio de la declaración de variables
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Declaración del botón "Jugar"
    private javax.swing.JButton btnJugar;
    // Declaración del ComboBox para seleccionar el tipo de memorama
    private javax.swing.JComboBox<String> cmbMemorama;
    // Declaración del ComboBox para seleccionar el modo de juego
    private javax.swing.JComboBox<String> cmbModoJuego;
    // Declaración de la etiqueta 1 (título MEMORAMA)
    private javax.swing.JLabel jLabel1;
    // Declaración de la etiqueta 2 (texto "Selecciona el memorama:")
    private javax.swing.JLabel jLabel2;
    // Declaración de la etiqueta 3 (texto "Modo de juego:")
    private javax.swing.JLabel jLabel3;
    // Comentario de NetBeans que indica el final de la declaración de variables
    // End of variables declaration//GEN-END:variables
}
