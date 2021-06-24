
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import vista.Cls_Validaciones;
import vista.FrmMateria;


public class ControladorFrmMateria implements ActionListener {
    
    RMICliente modelo;
    tdaCombo combo;
    private FrmMateria CatMateria;
    FrmMateria AbrirMateria = null;
    int opc = 0;
    
    public ControladorFrmMateria(FrmMateria CatMateria) throws RemoteException {
        modelo = new RMICliente();
        llenaGrid();
        ComboGrad();
        this.CatMateria =CatMateria;
       
        this.CatMateria.btnagregarmateria.addActionListener(this);
        this.CatMateria.btnactualizarmateria.addActionListener(this);
        this.CatMateria.btneliminarmateria.addActionListener(this);
        this.CatMateria.btnsalir.addActionListener(this);
        this.CatMateria.cmbgrado.addActionListener(this);
        this.CatMateria.ver.addActionListener(this);
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == CatMateria.btnactualizarmateria) {
            ModificarMateria();
        }
        if (e.getSource() == CatMateria.btnagregarmateria) {
            try {
                insertaMateria();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmMateria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatMateria.btneliminarmateria) {
            Eliminar();
        }
        if (e.getSource() == CatMateria.ver) {
            Modificar();
        }
        if (e.getSource() == CatMateria.btnsalir) {
            apagar();
            CatMateria.dispose();
        }
        if (e.getSource() == CatMateria.cmbgrado) {
            llenaBuscador();
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
        CatMateria.cmbgrado.setModel(model);
        
    }

    public void llenaGrid() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatMateria.jtblmateria.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Materia");

            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String mat = arr[1].toString();
                String ma = arr[2].toString();

                mode.addRow(new Object[]{id, mat,ma});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void llenaBuscador() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatMateria.jtblmateria.getModel();
            Object[] arr;
            tdaCombo grado = (tdaCombo) CatMateria.cmbgrado.getSelectedItem();
            
            List<Object[]>  lista = modelo.Busca(grado.getNombre(), "BuscaMateria");

            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String mat = arr[1].toString();
                String ma = arr[2].toString();

                mode.addRow(new Object[]{id, mat,ma});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
        public void Eliminar() {
        int row = CatMateria.jtblmateria.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                DefaultTableModel mode = (DefaultTableModel) CatMateria.jtblmateria.getModel();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                int r;
                r = modelo.Eliminar(clave, "Materia");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    llenaGrid();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro");
                }
            }

        }
    }
    public void insertaMateria() throws FileNotFoundException, IOException {
        if (CatMateria.txtmat.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
tdaCombo grado = (tdaCombo) CatMateria.cmbgrado.getSelectedItem();
            int r = modelo.Insertar(new Object[]{CatMateria.txtmat.getText(),grado.getId()}, "Materia");
            if (r != 0) {
                JOptionPane.showMessageDialog(null, " Se inserto Correctamente");
                llenaGrid();
            } else {
                JOptionPane.showMessageDialog(null, " Error al insertar");
            }
        }
    }
    
    public void Modificar() {
        int row = CatMateria.jtblmateria.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        }else{
     
            int fila = CatMateria.jtblmateria.getSelectedRow();
           
            CatMateria.txtmat.setText(CatMateria.jtblmateria.getValueAt(fila, 1).toString());   
    }
    }
    
    private void ModificarMateria(){
        if(CatMateria.txtmat.getText().equals("")){
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            
    int fila = CatMateria.jtblmateria.getSelectedRow();
            int clave;
            clave=Integer.valueOf(CatMateria.jtblmateria.getValueAt(fila, 0).toString());
            
            tdaCombo grado = (tdaCombo) CatMateria.cmbgrado.getSelectedItem();
            
            int r = modelo.Editar(new Object[]{CatMateria.txtmat.getText(),grado.getId(),clave}, "Materia");

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
        this.CatMateria.btnactualizarmateria.removeActionListener(this);
        this.CatMateria.btnagregarmateria.removeActionListener(this);
        this.CatMateria.btneliminarmateria.removeActionListener(this);

    }
}
