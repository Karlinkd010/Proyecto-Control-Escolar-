package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import vista.Cls_Validaciones;
import vista.FrmGrado;

public class ControladorFrmGrado implements ActionListener {

    RMICliente modelo;
    private FrmGrado CatGrado;
    FrmGrado AbrirGrado = null;
    int opc = 0;

    public ControladorFrmGrado(FrmGrado CatGrado) {
        modelo = new RMICliente();
        llenaGrid();
        this.CatGrado = CatGrado;
        this.CatGrado.btnagregargrado.addActionListener(this);
        this.CatGrado.btnactualizargrado.addActionListener(this);
        this.CatGrado.btneliminargrado.addActionListener(this);
        this.CatGrado.btnsalir.addActionListener(this);
        this.CatGrado.ver.addActionListener(this);

        
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == CatGrado.btnactualizargrado) {
            ModificarGrado();
        }
        if (e.getSource() == CatGrado.btnagregargrado) {
            try {
                insertaGrado();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmGrado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatGrado.btneliminargrado) {
            Eliminar();
        }
        if (e.getSource() == CatGrado.btnsalir) {
            apagar();
            CatGrado.dispose();
        }
       
        if (e.getSource() == CatGrado.ver) {
            Modificar();
        }
        
 
        

    }

    public void llenaGrid() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatGrado.jblgrado.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Grado");

            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String grad = arr[1].toString();

                mode.addRow(new Object[]{id, grad});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Eliminar() {
        int row = CatGrado.jblgrado.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                DefaultTableModel mode = (DefaultTableModel) CatGrado.jblgrado.getModel();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                int r;
                r = modelo.Eliminar(clave,"Grado");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    llenaGrid();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro");
                }
            }

        }
    }

    public void insertaGrado() throws FileNotFoundException, IOException {
        if (CatGrado.txtgrado.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {

            int r = modelo.Insertar(new Object[]{CatGrado.txtgrado.getText()}, "Grado");
            if (r != 0) {
                JOptionPane.showMessageDialog(null, " Se inserto Correctamente");
                llenaGrid();
            } else {
                JOptionPane.showMessageDialog(null, " Error al insertar");
            }
        }
    }

    public void Modificar() {
    int row = CatGrado.jblgrado.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        }else{
            int fila = CatGrado.jblgrado.getSelectedRow();

        CatGrado.txtgrado.setText(CatGrado.jblgrado.getValueAt(fila, 1).toString());
        }
        

    }

    private void ModificarGrado() {
        if (CatGrado.txtgrado.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {

            int fila = CatGrado.jblgrado.getSelectedRow();
            int clave;
            clave = Integer.valueOf(CatGrado.jblgrado.getValueAt(fila, 0).toString());

            int r = modelo.Editar(new Object[]{clave, CatGrado.txtgrado.getText()}, "Grado");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");

                llenaGrid();

            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
            llenaGrid();
        }
    }

    public void apagar() {
        this.CatGrado.btnactualizargrado.removeActionListener(this);
        this.CatGrado.btnagregargrado.removeActionListener(this);
        this.CatGrado.btneliminargrado.removeActionListener(this);

    }

}
