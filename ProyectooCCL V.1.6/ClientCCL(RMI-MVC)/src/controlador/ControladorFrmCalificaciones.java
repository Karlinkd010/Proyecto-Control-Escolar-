package controlador;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import vista.FrmCalificacion;
import vista.FrmCalificacionEdit;


public class ControladorFrmCalificaciones implements ActionListener {

    RMICliente modelo;
    private FrmCalificacion Calificaciiines;
    private FrmCalificacionEdit CatCalificacionesEdit;
    FrmCalificacionEdit AbrirCalificacionEdit = null;
    int opc = 0;

    public ControladorFrmCalificaciones(FrmCalificacion calificaciones, FrmCalificacionEdit CatCalificacionesEdit) {
        modelo = new RMICliente();
        this.Calificaciiines = calificaciones;
        this.CatCalificacionesEdit = CatCalificacionesEdit;
        llenaGrid();
        this.CatCalificacionesEdit.setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

        this.Calificaciiines.jbtnActualizarcal.addActionListener(this);
        this.Calificaciiines.btnsalir.addActionListener(this);
        this.CatCalificacionesEdit.btnactualizarregistro.addActionListener(this);
        this.CatCalificacionesEdit.btncancelregistro.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == CatCalificacionesEdit.btnactualizarregistro) {
            Busca();
        }
        if (e.getSource() == CatCalificacionesEdit.btncancelregistro) {
            CatCalificacionesEdit.dispose();
        }
        if (e.getSource() == Calificaciiines.btnsalir) {
  apagar();
            Calificaciiines.dispose();
        }
        if (e.getSource() == Calificaciiines.jbtnActualizarcal) {
            Busca();
        }

    }

    public void llenaGrid() {
        try {
            DefaultTableModel mode = (DefaultTableModel) Calificaciiines.Datoscalificacion.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("ConsultaCal");

            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
     
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String mat = arr[0].toString();
                String nom = arr[1].toString();
                String grd = arr[2].toString();
                String pe = arr[3].toString();

                mode.addRow(new Object[]{mat, nom, grd, pe});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Busca() {
        int row = Calificaciiines.Datoscalificacion.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CatCalificacionesEdit);
        CatCalificacionesEdit = new FrmCalificacionEdit(f, true);
            int fila = Calificaciiines.Datoscalificacion.getSelectedRow();
        String id;
        id=Calificaciiines.Datoscalificacion.getValueAt(fila, 0).toString();
        
        
        try {
            Object[] arr;
            List<Object[]> lista = modelo.Busca(id,"ConsultaCalificacion");
           
            byte imagen[] = new byte[100000];
            BufferedImage buffin = null;
            for (int x = 0; x <= lista.size(); x++) {
                arr = lista.get(x);
             
                CatCalificacionesEdit.lblmatricula.setText(arr[0].toString()); 
                CatCalificacionesEdit.lblnombre.setText(arr[1].toString());
                CatCalificacionesEdit.lblgrado.setText(arr[2].toString());
                CatCalificacionesEdit.lblgrupo.setText(arr[3].toString());
                CatCalificacionesEdit.lblperiodo.setText(arr[4].toString());
                imagen = (byte[]) arr[5];
                 try (InputStream img = new ByteArrayInputStream(imagen)) {
                buffin = ImageIO.read(img);

                ImageIcon icon = new ImageIcon(buffin);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CatCalificacionesEdit.foto.getWidth(), CatCalificacionesEdit.foto.getHeight(), Image.SCALE_DEFAULT));
                CatCalificacionesEdit.foto.setText(null);
                CatCalificacionesEdit.foto.setIcon(icono);
            } catch (IOException ex) {
               
            }
                
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        CatCalificacionesEdit.btnactualizarregistro.setVisible(true);
        CatCalificacionesEdit.jLabel3.setVisible(true);
        CatCalificacionesEdit.imprimir.setVisible(false);
        CatCalificacionesEdit.setLocationRelativeTo(null);
       
            CatCalificacionesEdit.setVisible(true);
        }
        
    
    }
    public void apagar(){
        this.Calificaciiines.jbtnActualizarcal.removeActionListener(this);

        
        this.CatCalificacionesEdit.btnactualizarregistro.removeActionListener(this);
        this.CatCalificacionesEdit.btncancelregistro.removeActionListener(this);
    }

}
