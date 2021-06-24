package controlador;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import vista.Cls_Validaciones;
import vista.FrmUsuarios;
import vista.FrmUsuariosEdit;

public class ControladorFrmUsuarios implements ActionListener {

    RMICliente modelo;
    private FrmUsuarios CatUser;
    private FrmUsuariosEdit CrudUser;
    FrmUsuariosEdit AbrirFrmUserEdit = null;

    public ControladorFrmUsuarios(FrmUsuarios CatUser, FrmUsuariosEdit CrudUser) {
        modelo = new RMICliente();
        this.CatUser = CatUser;
        this.CrudUser = CrudUser;
        llenaGrid();
        this.CatUser.btnAgrega.addActionListener(this);
        this.CatUser.btnactualiza.addActionListener(this);
        this.CatUser.btnelimna.addActionListener(this);
        this.CatUser.btnsalir.addActionListener(this);

        this.CrudUser.jbtnAceptar.addActionListener(this);
        this.CrudUser.jbtnActualizaDatos.addActionListener(this);
        this.CrudUser.jbtnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CatUser.btnAgrega) {
            AbreCrudUser();
        }
        if (e.getSource() == CatUser.btnactualiza) {
            ModificarCampos();
        }
        if (e.getSource() == CatUser.btnelimna) {
                Eliminar();
            

        }
        if (e.getSource() == CrudUser.jbtnAceptar) {
            try {
                insertaUser();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatUser.btnsalir) {
            apagar();
            CatUser.dispose();
        }
        if (e.getSource() == CrudUser.jbtnActualizaDatos) {
            ModificaUser();
        }
        if (e.getSource() == CrudUser.jbtnCancelar) {
            CrudUser.dispose();
        }
    }

    public void llenaGrid() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatUser.datosusuarios.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Login");

            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String user = arr[1].toString();
                String Contra = arr[2].toString();
                String Tipo = arr[3].toString();
                mode.addRow(new Object[]{id, user, Contra, Tipo});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AbreCrudUser() {
        Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudUser);
        CrudUser = new FrmUsuariosEdit(f, true);

        limpiar();
        CrudUser.titulo.setText("AGREGAR NUEVO ADMINISTRADOR");
        CrudUser.txtuser.setEditable(true);
        CrudUser.txtcontra.setEditable(true);
        CrudUser.txttipo.setEditable(false);
        CrudUser.txttipo.setText("ADMINISTRADOR");
        CrudUser.jbtnAceptar.setVisible(true);
        CrudUser.jbtnActualizaDatos.setVisible(false);
        llenaGrid();
        CrudUser.setLocationRelativeTo(null);
        CrudUser.setVisible(true);
    }

    public void ModificarCampos() {
        int row = CatUser.datosusuarios.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            limpiar();
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudUser);
            CrudUser = new FrmUsuariosEdit(f, true);

            CrudUser.titulo.setText("MODIFICAR USUARIO");
            CrudUser.txtuser.setEditable(false);
            CrudUser.txtcontra.setEditable(true);
            CrudUser.txttipo.setEditable(false);

            CrudUser.jbtnAceptar.setVisible(false);
            CrudUser.jbtnActualizaDatos.setVisible(true);

            int fila = CatUser.datosusuarios.getSelectedRow();

            CrudUser.txtuser.setText(CatUser.datosusuarios.getValueAt(fila, 1).toString());
            CrudUser.txtcontra.setText(CatUser.datosusuarios.getValueAt(fila, 2).toString());
            CrudUser.txttipo.setText(CatUser.datosusuarios.getValueAt(fila, 3).toString());
            llenaGrid();
            CrudUser.setLocationRelativeTo(null);

            CrudUser.setVisible(true);

        }
    }

    public void Eliminar() {
           DefaultTableModel mode = (DefaultTableModel) CatUser.datosusuarios.getModel();
           int row = CatUser.datosusuarios.getSelectedRow();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                
                int r;
        
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                if(CatUser.datosusuarios.getValueAt(row, 3).equals("ADMINISTRADOR")){
                r = modelo.Eliminar(clave, "User");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    llenaGrid();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "El regisro no se puede eliminar, Debido a que el usuario esta Inscrito en la institución");
                }
             
               
            }

        }
    }

    public void insertaUser() throws FileNotFoundException, IOException {
        if (CrudUser.txtuser.getText().equals("") && CrudUser.txtcontra.getText().equals("") && CrudUser.txttipo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            int r = modelo.Insertar(new Object[]{CrudUser.txtuser.getText(), CrudUser.txtcontra.getText(), CrudUser.txttipo.getText()}, "User");
            if (r != 0) {
                JOptionPane.showMessageDialog(null, " Se inserto Correctamente");
                llenaGrid();
                CrudUser.dispose();
            } else {
                JOptionPane.showMessageDialog(null, " Error al insertar");
            }
        }
    }

    private void ModificaUser() {
        if (CrudUser.txtuser.getText().equals("") && CrudUser.txtcontra.getText().equals("") && CrudUser.txttipo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {

            int r = modelo.Editar(new Object[]{CrudUser.txtuser.getText(), CrudUser.txtcontra.getText(), CrudUser.txttipo.getText()}, "User");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                CrudUser.dispose();
                llenaGrid();

            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
            llenaGrid();
        }
    }

    private void limpiar() {
        CrudUser.txtuser.setText("");
        CrudUser.txtcontra.setText("");
        CrudUser.txttipo.setText("");
    }

    private void apagar() {
        this.CatUser.btnAgrega.removeActionListener(this);
        this.CatUser.btnactualiza.removeActionListener(this);
        this.CatUser.btnelimna.removeActionListener(this);
        this.CatUser.btnsalir.removeActionListener(this);

        this.CrudUser.jbtnAceptar.removeActionListener(this);
        this.CrudUser.jbtnActualizaDatos.removeActionListener(this);
        this.CrudUser.jbtnCancelar.removeActionListener(this);
    }

}
