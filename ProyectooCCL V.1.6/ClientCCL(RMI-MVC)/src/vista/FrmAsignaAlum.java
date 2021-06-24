
package vista;


public class FrmAsignaAlum extends javax.swing.JInternalFrame {

    public FrmAsignaAlum() {
        initComponents();
    }

   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        jbtnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Eliminar.png"))); // NOI18N
        jbtnEliminarP.setText("Eliminar");

        jbtnActualizarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Actualizar.png"))); // NOI18N
        jbtnActualizarP.setText("Actualizar");

        jbtnAgregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Agregar.png"))); // NOI18N
        jbtnAgregarP.setText("Agregar");

        jbtnMuestraP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Ver.png"))); // NOI18N
        jbtnMuestraP.setText("Nuevo Asigna");

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jbtnSelect.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jbtnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1805.png"))); // NOI18N
        jbtnSelect.setText("Alumnos");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });

        jtbnInsert.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jtbnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1907.png"))); // NOI18N
        jtbnInsert.setText("Agregar");

        jbtnUpdate.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jbtnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1470.png"))); // NOI18N
        jbtnUpdate.setText("Actualizar");

        jbtnDelete.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1472.png"))); // NOI18N
        jbtnDelete.setText("Eliminar");

        jbtnreporte.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jbtnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1822.png"))); // NOI18N
        jbtnreporte.setText("Reporte");

        salirCat.setFont(new java.awt.Font("Ebrima", 2, 12)); // NOI18N
        salirCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1423.png"))); // NOI18N
        salirCat.setText("Regresar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtbnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbtnSelect)
                .addGap(18, 18, 18)
                .addComponent(jtbnInsert)
                .addGap(18, 18, 18)
                .addComponent(jbtnUpdate)
                .addGap(18, 18, 18)
                .addComponent(jbtnDelete)
                .addGap(18, 18, 18)
                .addComponent(jbtnreporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(salirCat)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("CATÁLOGO  ASIGNA ALUMNOS");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1479.png"))); // NOI18N
        jLabel3.setText("Alumnos Por:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        TblAsigaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Matricula", "Nombre", "Curp", "Grupo", "Grado", "Periodo", "Fecha De Inscripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblAsigaAlumnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TblAsigaAlumnos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JComboBox<String> Combo = new javax.swing.JComboBox<>();
    public static final javax.swing.JTable TblAsigaAlumnos = new javax.swing.JTable();
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JButton jbtnActualizarP = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnAgregarP = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnDelete = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnEliminarP = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnMuestraP = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnSelect = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnUpdate = new javax.swing.JButton();
    public static final javax.swing.JButton jbtnreporte = new javax.swing.JButton();
    public static final javax.swing.JButton jtbnInsert = new javax.swing.JButton();
    public static final javax.swing.JButton salirCat = new javax.swing.JButton();
    // End of variables declaration//GEN-END:variables
}
