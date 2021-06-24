package vista;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));
        desktopPane.setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/System.png"))); // NOI18N
        jLabel1.setText("Sistema Control Escolar V.02");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(20, 150, 740, 390);

        bienvenida.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        bienvenida.setForeground(new java.awt.Color(0, 0, 0));
        desktopPane.add(bienvenida);
        bienvenida.setBounds(10, 40, 780, 60);

        menuBar.setBackground(new java.awt.Color(153, 153, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 0, 102), java.awt.Color.pink, java.awt.Color.gray));
        menuBar.setAlignmentX(0.7F);
        menuBar.setAlignmentY(0.7F);
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        menuBar.setPreferredSize(new java.awt.Dimension(399, 40));

        MenúCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User.png"))); // NOI18N
        MenúCatalogo.setMnemonic('f');
        MenúCatalogo.setText("Catalagos");
        MenúCatalogo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        AbreFrmAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1806.png"))); // NOI18N
        AbreFrmAlumno.setMnemonic('o');
        AbreFrmAlumno.setText("Alumnos");
        MenúCatalogo.add(AbreFrmAlumno);

        AbreFrmProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1840.png"))); // NOI18N
        AbreFrmProfesor.setMnemonic('s');
        AbreFrmProfesor.setText("Profesores");
        AbreFrmProfesor.setPreferredSize(new java.awt.Dimension(139, 37));
        AbreFrmProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreFrmProfesorActionPerformed(evt);
            }
        });
        MenúCatalogo.add(AbreFrmProfesor);

        AbreUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1906.png"))); // NOI18N
        AbreUsuarios.setMnemonic('x');
        AbreUsuarios.setText("Usuarios");
        AbreUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreUsuariosActionPerformed(evt);
            }
        });
        MenúCatalogo.add(AbreUsuarios);

        menuBar.add(MenúCatalogo);

        menuadmistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_Menu_32px_1.png"))); // NOI18N
        menuadmistrar.setMnemonic('e');
        menuadmistrar.setText(" Administrar");
        menuadmistrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        AbreAsignaAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1903.png"))); // NOI18N
        AbreAsignaAlumno.setMnemonic('t');
        AbreAsignaAlumno.setText("Administrar Alumnos");
        menuadmistrar.add(AbreAsignaAlumno);

        AbreMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1906.png"))); // NOI18N
        AbreMateria.setMnemonic('x');
        AbreMateria.setText("Administrar Materias");
        menuadmistrar.add(AbreMateria);

        Abregrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1822.png"))); // NOI18N
        Abregrado.setMnemonic('a');
        Abregrado.setText("Administrar  Grado");
        menuadmistrar.add(Abregrado);

        AbrePeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1912.png"))); // NOI18N
        AbrePeriodo.setMnemonic('x');
        AbrePeriodo.setText("Administrar Periodo");
        menuadmistrar.add(AbrePeriodo);

        AbreCalificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1916.png"))); // NOI18N
        AbreCalificaciones.setMnemonic('x');
        AbreCalificaciones.setText("Administar Calificaciones");
        AbreCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreCalificacionesActionPerformed(evt);
            }
        });
        menuadmistrar.add(AbreCalificaciones);

        menuBar.add(menuadmistrar);

        menuConsultaCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-reporte-de-negocios-24.png"))); // NOI18N
        menuConsultaCal.setMnemonic('h');
        menuConsultaCal.setText("Consular Calificacion");

        AbreConsutorCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1916.png"))); // NOI18N
        AbreConsutorCal.setMnemonic('a');
        AbreConsutorCal.setText("Calificaciones");
        menuConsultaCal.add(AbreConsutorCal);

        menuBar.add(menuConsultaCal);

        menuacercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconx2-000000.png"))); // NOI18N
        menuacercade.setMnemonic('h');
        menuacercade.setText("Acerca de");

        AbreAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1025.png"))); // NOI18N
        AbreAcercade.setMnemonic('x');
        AbreAcercade.setText("CCL");
        AbreAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreAcercadeActionPerformed(evt);
            }
        });
        menuacercade.add(AbreAcercade);

        menuBar.add(menuacercade);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-cerrar-ventana-26.png"))); // NOI18N
        Salir.setMnemonic('h');
        Salir.setText("Salir");

        AbreSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_Multiply_32px.png"))); // NOI18N
        AbreSalir.setMnemonic('x');
        AbreSalir.setText("Salir");
        AbreSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreSalirActionPerformed(evt);
            }
        });
        Salir.add(AbreSalir);

        AbreSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_Expand_Arrow_32px.png"))); // NOI18N
        AbreSalir1.setMnemonic('x');
        AbreSalir1.setText("Cerrar Sesión");
        AbreSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbreSalir1ActionPerformed(evt);
            }
        });
        Salir.add(AbreSalir1);

        menuBar.add(Salir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbreCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreCalificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreCalificacionesActionPerformed

    private void AbreUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreUsuariosActionPerformed

    private void AbreAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreAcercadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreAcercadeActionPerformed

    private void AbreSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreSalirActionPerformed

    private void AbreSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreSalir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreSalir1ActionPerformed

    private void AbreFrmProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbreFrmProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbreFrmProfesorActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JMenuItem AbreAcercade = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreAsignaAlumno = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreCalificaciones = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreConsutorCal = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreFrmAlumno = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreFrmProfesor = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreMateria = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbrePeriodo = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreSalir = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreSalir1 = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem AbreUsuarios = new javax.swing.JMenuItem();
    public static final javax.swing.JMenuItem Abregrado = new javax.swing.JMenuItem();
    public static final javax.swing.JMenu MenúCatalogo = new javax.swing.JMenu();
    public static final javax.swing.JMenu Salir = new javax.swing.JMenu();
    public static final javax.swing.JLabel bienvenida = new javax.swing.JLabel();
    public static final javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
    private javax.swing.JLabel jLabel1;
    public static final javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
    public static final javax.swing.JMenu menuConsultaCal = new javax.swing.JMenu();
    public static final javax.swing.JMenu menuacercade = new javax.swing.JMenu();
    public static final javax.swing.JMenu menuadmistrar = new javax.swing.JMenu();
    // End of variables declaration//GEN-END:variables

}
