package vista;

import modelo.Memorama;
    import modelo.MemoramaAnimales;
    import modelo.MemoramaFrutas;
    import modelo.MemoramaPersonajes;

public class FrmMenuPrincipal extends javax.swing.JFrame {

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
        cmbModoJuego = new javax.swing.JComboBox<>();
        cmbMemorama = new javax.swing.JComboBox<>();
        btnJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 215, 0));
        jLabel1.setText("MEMORAMA");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona el memorama:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modo de juego:");

        cmbModoJuego.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbModoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador vs Máquina", "Dos Jugadores" }));
        cmbModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModoJuegoActionPerformed(evt);
            }
        });

        cmbMemorama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbMemorama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Frutas", "Personajes" }));

        btnJugar.setBackground(new java.awt.Color(70, 130, 180));
        btnJugar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnJugar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(263, Short.MAX_VALUE)
                    .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(54, 54, 54)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnJugar)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(cmbMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(188, Short.MAX_VALUE)))
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

    private void cmbModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModoJuegoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModoJuegoActionPerformed

    public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {

            new FrmMenuPrincipal().setVisible(true);
        }
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
