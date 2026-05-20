package vista;

    import modelo.Memorama;
    import modelo.MemoramaAnimales;
    import modelo.MemoramaFrutas;
    import modelo.MemoramaPersonajes;

public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName());

    public FrmMenuPrincipal() {
        initComponents();
        personalizarVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        cmbMemorama = new javax.swing.JComboBox<>();
        cmbModoJuego = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memorama");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(30, 30, 30));
        setForeground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 215, 0));
        jLabel1.setText("MEMORAMA");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona el memorama:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modo de juego:");
        jLabel3.setToolTipText("");

        btnJugar.setBackground(new java.awt.Color(70, 130, 180));
        btnJugar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(this::btnJugarActionPerformed);

        cmbMemorama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Frutas", "Personajes" }));

        cmbModoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador vs Máquina", "Dos Jugadores" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        Memorama memoramaSeleccionado;

        String opcionMemorama = cmbMemorama.getSelectedItem().toString();

        if (opcionMemorama.equals("Animales")) {

            memoramaSeleccionado = new MemoramaAnimales();

        } else if (opcionMemorama.equals("Frutas")) {

            memoramaSeleccionado = new MemoramaFrutas();

        } else {

            memoramaSeleccionado = new MemoramaPersonajes();
        }

        boolean contraMaquina;

        String modoJuego = cmbModoJuego.getSelectedItem().toString();

        contraMaquina = modoJuego.equals("Jugador vs Máquina");

        FrmJuegoMemorama juego = new FrmJuegoMemorama(memoramaSeleccionado, contraMaquina);

        juego.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnJugarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {

        FrmMenuPrincipal menu = new FrmMenuPrincipal();

        menu.setLocationRelativeTo(null);

        menu.setVisible(true);
    });
    }
    
    private void personalizarVentana() {
        getContentPane().setBackground(new java.awt.Color(30, 30, 30));
        cmbMemorama.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
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
