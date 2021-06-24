package controlador;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.Cls_Validaciones;
import vista.FrmAsignaAlum;
import vista.FrmAsignaAlumnoEdit;

public final class ControladorFrmAsigaAlumno implements ActionListener {

    RMICliente modelo;
    tdaCombo combo;
    private FrmAsignaAlum CatAsigna;
    private FrmAsignaAlumnoEdit CrudAsigna;
    FrmAsignaAlumnoEdit AbrirFrmAsigna = null;
    int opc = 0;
    String idmatricula;
    int idgrupo, idperiodo;

    public ControladorFrmAsigaAlumno(FrmAsignaAlum CatAsigna, FrmAsignaAlumnoEdit CrudAsigna) throws RemoteException {
        modelo = new RMICliente();
        ComboGrad();

        this.llenaGridAsigna();
        this.CatAsigna = CatAsigna;
        
        this.CrudAsigna = CrudAsigna;
this.CrudAsigna .setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
        this.CatAsigna.jbtnSelect.addActionListener(this);
        this.CatAsigna.Combo.addActionListener(this);
        this.CatAsigna.jbtnreporte.addActionListener(this);
        this.CatAsigna.jtbnInsert.addActionListener(this);
        this.CatAsigna.jbtnUpdate.addActionListener(this);
        this.CatAsigna.salirCat.addActionListener(this);
        this.CatAsigna.jbtnDelete.addActionListener(this);
        this.CrudAsigna.jbtnAceptar.addActionListener(this);
        this.CrudAsigna.jbtnActualizaDatos.addActionListener(this);
        this.CrudAsigna.jbtnCancelar.addActionListener(this);
        this.CrudAsigna.ComboGrado.addActionListener(this);
        this.CrudAsigna.ComboMatricula.addActionListener(this);
        this.CrudAsigna.ComboPeriodo.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CatAsigna.jtbnInsert) {
            try {
                AbreCrud();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmAsigaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == CatAsigna.jbtnDelete) {
            Eliminar();
        }
        if (e.getSource() == CatAsigna.jbtnreporte) {
            
            try {
                modelo.Busca("re","Reporte");
                CreaReporte();
            } catch (JRException | RemoteException ex) {
                Logger.getLogger(ControladorFrmAsigaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        if (e.getSource() == CatAsigna.jbtnUpdate) {
            try {
                ModificarCampos();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmAsigaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CatAsigna.jbtnSelect) {
            llenaGridAsigna();
        }
        if (e.getSource() == CatAsigna.Combo) {
            Busca();
        }

        if (e.getSource() == CrudAsigna.jbtnAceptar) {
            Inserta();
        }
        if (e.getSource() == CrudAsigna.jbtnActualizaDatos) {
            EditaAlumno();
        }
        if (e.getSource() == CrudAsigna.jbtnCancelar) {
            CrudAsigna.dispose();
        }
        if (e.getSource() == CatAsigna.salirCat) {
            apagar();
            CatAsigna.dispose();
        }
        if (e.getSource() == CrudAsigna.ComboMatricula) {
          
                ComboImg();

        }

    }
  
    public void AbreCrud() throws RemoteException {
        Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudAsigna);
        CrudAsigna = new FrmAsignaAlumnoEdit(f, true);
        Limpia();
        CrudAsigna.titulo.setText("ASIGNA NUEVO ALUMNO");
        CrudAsigna.txtid.setEditable(true);
        CrudAsigna.txtFecha.setText(FechaActual());
        CrudAsigna.jbtnActualizaDatos.setVisible(false);
        CrudAsigna.jbtnAceptar.setVisible(true);
//        CrudAsigna.ComboMatricula.setEditable(true);
//            CrudAsigna.ComboGrado.setEditable(true);
//            CrudAsigna.ComboPeriodo.setEditable(true);
        ComboMat();
        ComboGrad();
        ComboPerio();
        llenaGridAsigna();
        CrudAsigna.setLocationRelativeTo(null);
        
        CrudAsigna.setVisible(true);
    }

    public void llenaGridAsigna() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatAsigna.TblAsigaAlumnos.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Inscrito");
            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String matricula = arr[1].toString();
                String Nombre = arr[2].toString();
                String curp = arr[3].toString();
                String grupo = arr[4].toString();
                String grado = arr[5].toString();
                String periodo = arr[6].toString();
                String fecha = arr[7].toString();
                mode.addRow(new Object[]{id, matricula, Nombre, curp, grupo, grado, periodo, fecha});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Busca() {
        try {
             tdaCombo grado = (tdaCombo) CrudAsigna.ComboGrado.getSelectedItem();
            DefaultTableModel mode = (DefaultTableModel) CatAsigna.TblAsigaAlumnos.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Busca(grado.getNombre(),"BuscaAlumnosGrado");
            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x <= lista.size(); x++) {
                arr = lista.get(x);
                String id = arr[0].toString();
                String matricula = arr[1].toString();
                String Nombre = arr[2].toString();
                String curp = arr[3].toString();
                String grupo = arr[4].toString();
                String grad = arr[5].toString();
                String periodo = arr[6].toString();
                String fecha = arr[7].toString();
                mode.addRow(new Object[]{id, matricula, Nombre, curp, grupo, grad, periodo, fecha});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYY-MM-dd");
        return formatofecha.format(fecha);
    }

    public void Inserta() {
        

        if (CrudAsigna.txtFecha.getText().equals("") || CrudAsigna.txtGrupo.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
            tdaCombo grado = (tdaCombo) CrudAsigna.ComboGrado.getSelectedItem();
            tdaCombo periodo = (tdaCombo) CrudAsigna.ComboPeriodo.getSelectedItem();
            tdaCombo mat = (tdaCombo) CrudAsigna.ComboMatricula.getSelectedItem();
            String matricula = String.valueOf(mat.getId());

            int r = modelo.Insertar(new Object[]{CrudAsigna.txtid.getText(), matricula, periodo.getId(), CrudAsigna.txtGrupo.getText(), grado.getId(), CrudAsigna.txtFecha.getText()}, "Inscrito");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                CrudAsigna.dispose();
                llenaGridAsigna();
            } else {
                JOptionPane.showMessageDialog(null, "error al insertar");
            }
        }
    }

    public void Eliminar() {
        int row = CatAsigna.TblAsigaAlumnos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                DefaultTableModel mode = (DefaultTableModel) CatAsigna.TblAsigaAlumnos.getModel();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                int r;
                r = modelo.Eliminar(clave, "Inscrito");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    llenaGridAsigna();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro");
                }
            }

        }
    }

    public void ComboMat() throws RemoteException {
        DefaultComboBoxModel model;
        Object[] arr;
        model = new DefaultComboBoxModel();
        List<Object[]> lista = modelo.Llenado("Alumno");
        combo = new tdaCombo();
        combo.setId(0);
        combo.setNombre("Seleccione el Alumno");
        model.addElement(combo);
        for (int i = 0; i < lista.size(); i++) {
            arr = lista.get(i);
            int id = Integer.valueOf(arr[0].toString());
            String nombre = arr[1].toString();
            model.addElement(new tdaCombo(id, nombre));
        }
        CrudAsigna.ComboMatricula.setModel(model);
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
        CrudAsigna.ComboGrado.setModel(model);
        CatAsigna.Combo.setModel(model);
    }

    public void ComboPerio() throws RemoteException {
        DefaultComboBoxModel model;
        Object[] arr;
        model = new DefaultComboBoxModel();
        List<Object[]> lista = modelo.Llenado("Periodo");
        combo = new tdaCombo();
        combo.setId(0);
        combo.setNombre("Seleccione el Periodo");
        model.addElement(combo);
        for (int i = 0; i < lista.size(); i++) {
            arr = lista.get(i);
            int id = Integer.valueOf(arr[0].toString());
            String nombre = arr[1].toString();
            model.addElement(new tdaCombo(id, nombre));
        }
        CrudAsigna.ComboPeriodo.setModel(model);
    }

    public void Limpia() {
        CrudAsigna.titulo.setText("");
        CrudAsigna.txtGrupo.setText("");
        CrudAsigna.txtid.setText("");
    }

    public void ModificarCampos() throws RemoteException {
        int row = CatAsigna.TblAsigaAlumnos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudAsigna);
            CrudAsigna = new FrmAsignaAlumnoEdit(f, true);

            CrudAsigna.titulo.setText("ACTUALIZAR ");
            CrudAsigna.txtid.setEditable(false);
            CrudAsigna.jbtnAceptar.setVisible(false);
            CrudAsigna.jbtnActualizaDatos.setVisible(true);
            int fila = CatAsigna.TblAsigaAlumnos.getSelectedRow();

            CrudAsigna.txtid.setText(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 0).toString());
            CrudAsigna.ComboMatricula.addItem(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 1).toString());
            CrudAsigna.ComboPeriodo.addItem(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 6).toString());
            CrudAsigna.ComboGrado.addItem(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 5).toString());
            CrudAsigna.txtGrupo.setText(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 4).toString());
            CrudAsigna.txtFecha.setText(CatAsigna.TblAsigaAlumnos.getValueAt(fila, 7).toString());
            CrudAsigna.ComboMatricula.setEditable(false);
            CrudAsigna.ComboGrado.setEditable(false);
            CrudAsigna.ComboPeriodo.setEditable(false);
            CrudAsigna.setVisible(true);
            llenaGridAsigna();

        }
    }

    public void EditaAlumno() {
        if (CrudAsigna.txtFecha.getText().equals("") || CrudAsigna.txtGrupo.getText().equals("") || CrudAsigna.txtid.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {

            int r = modelo.Editar(new Object[]{CrudAsigna.txtid.getText(), CrudAsigna.txtGrupo.getText(), CrudAsigna.txtFecha.getText()}, "Inscrito");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                CrudAsigna.dispose();
                llenaGridAsigna();

            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
        }

    }

    private void CreaReporte() throws JRException, RemoteException {
        Cls_reporte Reporte;
        List<Cls_reporte> lista = new ArrayList<>();
        
        for (int i = 0; i < CatAsigna.TblAsigaAlumnos.getRowCount(); i++) {
            Reporte = new Cls_reporte(CatAsigna.TblAsigaAlumnos.getValueAt(i, 1).toString(), CatAsigna.TblAsigaAlumnos.getValueAt(i, 2).toString(), CatAsigna.TblAsigaAlumnos.getValueAt(i, 3).toString(),
                    CatAsigna.TblAsigaAlumnos.getValueAt(i, 4).toString(), CatAsigna.TblAsigaAlumnos.getValueAt(i, 5).toString(), CatAsigna.TblAsigaAlumnos.getValueAt(i, 6).toString());

            lista.add(Reporte);
        }
        JasperReport reporte;
        String path = "C:\\Users\\josenm\\Desktop\\CCl v.1.4\\ClientCCL(RMI-MVC)\\src\\vista\\Reporteccl.jasper";
       
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        modelo.Busca("re","Reporte");
        view.setVisible(true);

    }
    public void ComboImg(){
                 tdaCombo mat = (tdaCombo) CrudAsigna.ComboMatricula.getSelectedItem();
            String matricula = String.valueOf(mat.getId());
            CrudAsigna.lblimg.setText(null);

            Object[] x;
            List<Object[]> lista = null;
            try {
                lista = modelo.Busca(matricula, "Alumno");
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmAsigaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte imagen[] = new byte[100000];
            BufferedImage buffin = null;
            x = lista.get(0);
            imagen = (byte[]) x[0];
            try (InputStream img = new ByteArrayInputStream(imagen)) {
                buffin = ImageIO.read(img);

                ImageIcon icon = new ImageIcon(buffin);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudAsigna.lblimg.getWidth(), CrudAsigna.lblimg.getHeight(), Image.SCALE_DEFAULT));
                CrudAsigna.lblimg.setText(null);
                CrudAsigna.lblimg.setIcon(icono);
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmAsigaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void apagar() {
       
        this.CatAsigna.jbtnDelete.removeActionListener(this);
        this.CatAsigna.jbtnSelect.removeActionListener(this);
        this.CatAsigna.jbtnUpdate.removeActionListener(this);
        this.CatAsigna.jbtnreporte.removeActionListener(this);

        this.CatAsigna.jtbnInsert.removeActionListener(this);

        this.CrudAsigna.jbtnCancelar.removeActionListener(this);
        this.CrudAsigna.jbtnAceptar.removeActionListener(this);
        this.CrudAsigna.jbtnCancelar.removeActionListener(this);

    }
}
