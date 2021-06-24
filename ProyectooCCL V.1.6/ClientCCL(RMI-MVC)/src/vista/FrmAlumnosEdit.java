package vista;

public class FrmAlumnosEdit extends javax.swing.JDialog {
    public FrmAlumnosEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmAlumnosEdit() {
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre3 = new javax.swing.JTextField();
        txtnombre5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblmat3 = new javax.swing.JLabel();
        lblmat4 = new javax.swing.JLabel();
        lblmat5 = new javax.swing.JLabel();
        lblmat6 = new javax.swing.JLabel();
        lblmat = new javax.swing.JLabel();
        lblmat1 = new javax.swing.JLabel();
        lblmat2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(129, 169, 169));

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cancelar.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");

        jbtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Guardar.png"))); // NOI18N
        jbtnAceptar.setText("Aceptar");

        jbtnActualizaDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Actualizar.png"))); // NOI18N
        jbtnActualizaDatos.setText("Actualizar");
        jbtnActualizaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizaDatosActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jbtnseleccionar.setText("Selecionar");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtDate.setDateFormatString("YYY-MM-dd");

        txtcurp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcurpKeyTyped(evt);
            }
        });

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        lblmat3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat3.setText("Fecha Nacimiento:");

        txtingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtingresoKeyTyped(evt);
            }
        });

        lblmat4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat4.setText("Telefono:");

        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });

        lblmat5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat5.setText("Correo:");

        lblmat6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat6.setText("Fecha Ingreso:");

        lblmat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat.setText("Nombre:");

        titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblmat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat1.setText("Matricula:");

        lblmat2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmat2.setText("Curp:");

        lblimgen.setBorder(new javax.swing.border.MatteBorder(null));

        txtmatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmatriculaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnseleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(lblimgen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmat1)
                            .addComponent(lblmat)
                            .addComponent(lblmat2)
                            .addComponent(lblmat4)
                            .addComponent(lblmat5)
                            .addComponent(lblmat6)
                            .addComponent(lblmat3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtingreso, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtcorreo)
                                .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtcurp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtmatricula, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblmat1)
                        .addGap(18, 18, 18)
                        .addComponent(lblmat)
                        .addGap(18, 18, 18)
                        .addComponent(lblmat2)
                        .addGap(18, 18, 18)
                        .addComponent(lblmat3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmat4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmat5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmat6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblimgen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnseleccionar)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnActualizaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar)
                    .addComponent(jbtnAceptar)
                    .addComponent(jbtnActualizaDatos))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatriculaKeyTyped
        if (!Cls_Validaciones.validarLongitudMaximo(txtmatricula, evt, 10)) {
            Cls_Validaciones.validarNumero(evt);
        }
    }//GEN-LAST:event_txtmatriculaKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        if (!Cls_Validaciones.validarLongitudMaximo(txtnombre, evt, 100)) {
            Cls_Validaciones.validarLetras(evt);
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtcurpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcurpKeyTyped
       if (!Cls_Validaciones.validarLongitudMaximo(txtcurp, evt, 12)){
            
        }
    }//GEN-LAST:event_txtcurpKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        if (!Cls_Validaciones.validarLongitudMaximo(txttelefono, evt,9)) {
            Cls_Validaciones.validarNumero(evt);
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
        if (!Cls_Validaciones.validarLongitudMaximo(txtcorreo, evt, 100)){
            
        }
    }//GEN-LAST:event_txtcorreoKeyTyped

    private void txtingresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtingresoKeyTyped
        if (!Cls_Validaciones.validarLongitudMaximo(txtcorreo, evt, 30)){
            
        }
    }//GEN-LAST:event_txtingresoKeyTyped

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void jbtnActualizaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizaDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnActualizaDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public static final javax.swing.JButton jbtnAceptar = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnActualizaDatos = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnCancelar = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnseleccionar = new javax.swing.JButton();
    public static final javax.swing.JLabel lblimgen = new javax.swing.JLabel();
    private javax.swing.JLabel lblmat;
    private javax.swing.JLabel lblmat1;
    private javax.swing.JLabel lblmat2;
    private javax.swing.JLabel lblmat3;
    private javax.swing.JLabel lblmat4;
    private javax.swing.JLabel lblmat5;
    private javax.swing.JLabel lblmat6;
    public static final javax.swing.JLabel titulo = new javax.swing.JLabel();
    public static final com.toedter.calendar.JDateChooser txtDate = new com.toedter.calendar.JDateChooser();
    public static final javax.swing.JTextField txtcorreo = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtcurp = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtingreso = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtmatricula = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnombre = new javax.swing.JTextField();
    private javax.swing.JTextField txtnombre3;
    private javax.swing.JTextField txtnombre5;
    public static final javax.swing.JTextField txttelefono = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
