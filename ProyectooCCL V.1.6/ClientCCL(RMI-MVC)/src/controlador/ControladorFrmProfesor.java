package controlador;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import vista.Cls_Validaciones;

import vista.FrmProfesores;
import vista.FrmProfesoresEdit;

public final class ControladorFrmProfesor implements ActionListener {

    RMICliente modelo;
    File fichero = null;
    tdaCombo combo;
    private FrmProfesores CatProfeso;
    private FrmProfesoresEdit CrudProfesor;
    FrmProfesores AbrirProfesor = null;

    public ControladorFrmProfesor(FrmProfesores CatProfeso, FrmProfesoresEdit CrudProfesor) {
        modelo = new RMICliente();
        this.llenaGridProfesores();
        this.CatProfeso = CatProfeso;
        this.CrudProfesor = CrudProfesor;
        this.CatProfeso.jbtnActualizarP.addActionListener(this);
        this.CatProfeso.jbtnAgregarP.addActionListener(this);
        this.CatProfeso.jbtnBuscarP.addActionListener(this);
        this.CatProfeso.jbtnEliminarP.addActionListener(this);
        this.CatProfeso.jbtnMuestraP.addActionListener(this);
        this.CatProfeso.salirCat.addActionListener(this);
        this.CrudProfesor.jbtnAceptar.addActionListener(this);
        this.CrudProfesor.jbtnActualizaDatos.addActionListener(this);
        this.CrudProfesor.jbtnCancelar.addActionListener(this);
        this.CrudProfesor.btn_examinar.addActionListener(this);
        this.CrudProfesor.cmbGrado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == CatProfeso.jbtnBuscarP) {
            //BuscaAlumno();
        }

        if (e.getSource() == CatProfeso.jbtnMuestraP) {
            llenaGridProfesores();
        }
        if (e.getSource() == CatProfeso.jbtnAgregarP) {
            try {
                AbreCrudAProfesor();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatProfeso.jbtnActualizarP) {
            try {
                ModifocarProfesor();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatProfeso.jbtnEliminarP){
            Eliminar();
        }
        if (e.getSource() == CrudProfesor.jbtnCancelar) {
            CrudProfesor.dispose();
        }
        if (e.getSource() == CrudProfesor.jbtnAceptar) {
            try {
                InsertatblAsignaProf();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CrudProfesor.jbtnActualizaDatos) {
            try {
                EditaProfesor();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatProfeso.salirCat) {
            apagar();
            CatProfeso.dispose();
        }
        if (e.getSource() == CrudProfesor.btn_examinar) {
            examina_img();
        }
        if (e.getSource() == CrudProfesor.cmbGrado) {
            
            try {
                InsertaProfesor();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void AbreCrudAProfesor() throws RemoteException {
        Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudProfesor);
        CrudProfesor = new FrmProfesoresEdit(f, true);

        LimpiaCajasP();
        CrudProfesor.titulo.setText("ADMINISTRAR NUEVO PROFESOR");
        CrudProfesor.jbtnActualizaDatos.setVisible(false);
        CrudProfesor.jbtnAceptar.setVisible(true);
        CrudProfesor.jtxtid.setEditable(true);
        llenaGridProfesores();
        ComboGrad();
        CrudProfesor.setLocationRelativeTo(null);
        CrudProfesor.setVisible(true);
    }

    public void llenaGridProfesores() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatProfeso.jtblProfesores.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Profesor");
            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }

            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);

                String id = arr[0].toString();
                String Nombre = arr[1].toString();
                String direc = arr[2].toString();
                String tel = arr[3].toString();
                String email = arr[4].toString();
                String rut = arr[5].toString();
                String rt = arr[6].toString();
                mode.addRow(new Object[]{id, Nombre, direc, tel, email, rut,rt});
            }

            arr = lista.get(1);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    int id;

     private void ModifocarProfesor() throws RemoteException {
        int row = CatProfeso.jtblProfesores.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudProfesor);
            CrudProfesor = new FrmProfesoresEdit(f, true);

            CrudProfesor.titulo.setText("ACTUALIZAR DATOS DEL PROFESOR");
            CrudProfesor.jbtnAceptar.setVisible(false);
            CrudProfesor.jtxtid.setEditable(false);
            CrudProfesor.jbtnActualizaDatos.setVisible(true);
            int fila = CatProfeso.jtblProfesores.getSelectedRow();

            CrudProfesor.jtxtid.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 0).toString());
            CrudProfesor.jtxtName.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 1).toString());
            CrudProfesor.jtxtDir.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 2).toString());
            CrudProfesor.jtxtTel.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 3).toString());
            CrudProfesor.jtxtCorreo.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 4).toString());
            CrudProfesor.txtimg.setText(this.CatProfeso.jtblProfesores.getValueAt(fila, 5).toString());
            Object[] arr;
            String imagen_string = null;
            List<Object[]> lista = modelo.Busca(CrudProfesor.jtxtid.getText(), "Profesor");
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                imagen_string = arr[0].toString();
            }
            BufferedImage img = null;
            img = decodeToImage(imagen_string);
            ImageIcon icon = new ImageIcon(img);
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudProfesor.lbl_foto.getWidth(), CrudProfesor.lbl_foto.getHeight(), Image.SCALE_DEFAULT));
            CrudProfesor.lbl_foto.setText(null);
            CrudProfesor.lbl_foto.setIcon(icono);
            llenaGridProfesores();
            CrudProfesor.setLocationRelativeTo(null);
            CrudProfesor.setVisible(true);
        }
    }

    public void InsertaProfesor() throws IOException, IOException {
        if (CrudProfesor.jtxtid.getText().equals("") || CrudProfesor.jtxtName.getText().equals("") || CrudProfesor.jtxtDir.getText().equals("") || CrudProfesor.jtxtTel.getText().equals(modelo) || CrudProfesor.jtxtCorreo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            BufferedImage img = ImageIO.read(new File(fichero.toString()));
            String image_string = encodeToString(img);
     

            int r = modelo.Insertar(new Object[]{CrudProfesor.jtxtid.getText(), CrudProfesor.jtxtName.getText(), CrudProfesor.jtxtDir.getText(), CrudProfesor.jtxtTel.getText(), CrudProfesor.jtxtCorreo.getText(), CrudProfesor.txtimg.getText(), image_string}, "Profesor");
            //int s = modelo.Insertar(new Object[]{CrudProfesor.jtxtid.getText(),grado.getId()}, "AsingaP");
            
            if (r != 0) {
              JOptionPane.showMessageDialog(null, "Se inserto correctamente");
//                llenaGridProfesores();
//                CrudProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "error al insertar");
            }
        }

    }
    public void InsertatblAsignaProf() throws IOException, IOException {
        
             tdaCombo grado = (tdaCombo) CrudProfesor.cmbGrado.getSelectedItem();

            //int r = modelo.Insertar(new Object[]{CrudProfesor.jtxtid.getText(), CrudProfesor.jtxtName.getText(), CrudProfesor.jtxtDir.getText(), CrudProfesor.jtxtTel.getText(), CrudProfesor.jtxtCorreo.getText(), CrudProfesor.txtimg.getText(), image_string}, "Profesor");
            int s = modelo.Insertar(new Object[]{CrudProfesor.jtxtid.getText(),grado.getId()}, "AsingaP");
            
            if (s != 0) {
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                llenaGridProfesores();
                CrudProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "error al insertar");
            }
        

    }
    
    public void ComboGrad() throws RemoteException {
        DefaultComboBoxModel model;
        Object[] arr;
        model = new DefaultComboBoxModel();
        List<Object[]> lista = modelo.Llenado("Grado");
        combo = new tdaCombo();
        combo.setId(0);
        combo.setNombre("Seleccione el Grado");
        model.addElement(combo);
        for (int i = 0; i < lista.size(); i++) {
            arr = lista.get(i);

            int id = Integer.valueOf(arr[0].toString());
            String nombre = arr[1].toString();
            model.addElement(new tdaCombo(id, nombre));
        }
        CrudProfesor.cmbGrado.setModel(model);
    }

    public void examina_img() {
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Seleccionar Imagen", "jpg", "png");
        file.setFileFilter(filtro);

        if (file.showOpenDialog(CrudProfesor) == JFileChooser.APPROVE_OPTION) {
            fichero = file.getSelectedFile();
            CrudProfesor.txtimg.setText(fichero.getAbsolutePath());
            ImageIcon icon = new ImageIcon(fichero.toString());

            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudProfesor.lbl_foto.getWidth(), CrudProfesor.lbl_foto.getHeight(), Image.SCALE_DEFAULT));
            CrudProfesor.lbl_foto.setText(null);
            CrudProfesor.lbl_foto.setIcon(icono);

        }

    }

    public void EditaProfesor() throws IOException {
        if (CrudProfesor.jtxtid.getText().equals("") || CrudProfesor.jtxtName.getText().equals("") || CrudProfesor.jtxtDir.getText().equals("") || CrudProfesor.jtxtTel.getText().equals("") || CrudProfesor.jtxtCorreo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            BufferedImage img = ImageIO.read(new File(fichero.toString()));
            String image_string = encodeToString(img);
            int r = modelo.Editar(new Object[]{CrudProfesor.jtxtid.getText(), CrudProfesor.jtxtName.getText(), CrudProfesor.jtxtDir.getText(), CrudProfesor.jtxtTel.getText(), this.CrudProfesor.jtxtCorreo.getText(),CrudProfesor.txtimg.getText(), image_string}, "Profesor");
          
            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                llenaGridProfesores();
                CrudProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
        }
    }

    public void Eliminar() {
        int row = CatProfeso.jtblProfesores.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                DefaultTableModel mode = (DefaultTableModel) CatProfeso.jtblProfesores.getModel();

                int r;

                int fila = CatProfeso.jtblProfesores.getSelectedRow();
                id = Integer.valueOf(this.CatProfeso.jtblProfesores.getValueAt(fila, 0).toString());

                r = modelo.Eliminar(id, "Profesor");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    this.llenaGridProfesores();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro " + r);
                }
            }
        }
    }

    private void LimpiaCajasP() {
        CrudProfesor.jtxtid.setText("");
        CrudProfesor.jtxtName.setText("");
        CrudProfesor.jtxtDir.setText("");
        CrudProfesor.jtxtTel.setText("");
        CrudProfesor.jtxtCorreo.setText("");
    }

    public void apagar() {
        this.CatProfeso.jbtnActualizarP.removeActionListener(this);
        this.CatProfeso.jbtnAgregarP.removeActionListener(this);
        this.CatProfeso.jbtnBuscarP.removeActionListener(this);
        this.CatProfeso.jbtnEliminarP.removeActionListener(this);
        this.CatProfeso.jbtnMuestraP.removeActionListener(this);
        this.CrudProfesor.jbtnCancelar.removeActionListener(this);
        this.CrudProfesor.jbtnAceptar.removeActionListener(this);
        this.CrudProfesor.jbtnCancelar.removeActionListener(this);
    }

    private String encodeToString(BufferedImage img) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(img, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
        }
        return imageString;
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            try (ByteArrayInputStream bis = new ByteArrayInputStream(imageByte)) {
                image = ImageIO.read(bis);
            }
        } catch (Exception e) {
        }
        return image;
    }

}
