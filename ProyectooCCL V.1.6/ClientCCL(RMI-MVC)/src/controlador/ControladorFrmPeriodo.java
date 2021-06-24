
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
import vista.FrmPeriodo;


public class ControladorFrmPeriodo implements ActionListener {
    RMICliente modelo;
    private FrmPeriodo CatPeriodo;
    FrmPeriodo AbrirPeriodo=null;
    int opc=0;
    
public ControladorFrmPeriodo(FrmPeriodo CatPeriodo){
    modelo=new RMICliente();
    llenaGrid();
    this.CatPeriodo=CatPeriodo;
    this.CatPeriodo.btnagregarperiodo.addActionListener(this);
    this.CatPeriodo.btnactualizarperiodo.addActionListener(this);
    this.CatPeriodo.btneliminarperiodo.addActionListener(this);
    this.CatPeriodo.btnsalir.addActionListener(this);
    this.CatPeriodo.btnver1.addActionListener(this);
    
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==CatPeriodo.btnagregarperiodo){
            try {
                insertaPeriodo();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmGrado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==CatPeriodo.btnactualizarperiodo){
            ModificarPeriodo();
        }
        if(e.getSource()==CatPeriodo.btneliminarperiodo){
            Eliminar();
        }
        if(e.getSource()==CatPeriodo.btnver1){
            Modificar();    
        }
        if(e.getSource()==CatPeriodo.btnsalir){
            apagar();
            CatPeriodo.dispose();   
            
       }
    }
    
    public void llenaGrid(){
        try{
            DefaultTableModel mode = (DefaultTableModel) CatPeriodo.tblperiodo.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Periodo");
            
            while (mode.getRowCount()>0){
                mode.removeRow(0);
            }
            for(int x=0;x< lista.size();x++){
                arr = lista.get(x);
                String id = arr[0].toString();
                String grad = arr[1].toString();
                
                mode.addRow(new Object[]{id,grad});
            }
            arr=lista.get(1);
        }catch(Exception e ){
            System.out.println(e);
            }
        }
    
    public void Eliminar(){
        int row = CatPeriodo.tblperiodo.getSelectedRow();
        if(row== -1){
            JOptionPane.showMessageDialog(null, "seleccione una columna!!");
        }else{
            int dato=JOptionPane.showConfirmDialog(null, "Desea eliminar ?");
            if(dato==0){
                DefaultTableModel mode = (DefaultTableModel) CatPeriodo.tblperiodo.getModel();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                int r;
                r= modelo.Eliminar(clave, "Periodo");
                
                if(r!=0){
                    JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
                    llenaGrid();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                }       
            }
        }
    }
    
    public void insertaPeriodo()throws FileNotFoundException, IOException {
        if (CatPeriodo.txPeriodo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {

            int r = modelo.Insertar(new Object[]{CatPeriodo.txPeriodo.getText()}, "Periodo");
            if (r != 0) {
                JOptionPane.showMessageDialog(null, " Se inserto Correctamente");
                llenaGrid();
            } else {
                JOptionPane.showMessageDialog(null, " Error al insertar");
            }
        }
    }
    
    public void Modificar() {
        int row = CatPeriodo.tblperiodo.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        }else{
            int fila = CatPeriodo.tblperiodo.getSelectedRow();
            
            CatPeriodo.txPeriodo.setText(CatPeriodo.tblperiodo.getValueAt(fila, 1).toString());
            
        }
     
            

        
    }
    private void ModificarPeriodo(){
        if(CatPeriodo.txPeriodo.getText().equals("")){
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            
    int fila = CatPeriodo.tblperiodo.getSelectedRow();
            int clave;
            clave=Integer.valueOf(CatPeriodo.tblperiodo.getValueAt(fila, 0).toString());
            
            
            
            int r = modelo.Editar(new Object[]{clave,CatPeriodo.txPeriodo.getText()}, "Periodo");

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
        this.CatPeriodo.btnactualizarperiodo.removeActionListener(this);
        this.CatPeriodo.btnagregarperiodo.removeActionListener(this);
        this.CatPeriodo.btneliminarperiodo.removeActionListener(this);

    }
  
}

    




