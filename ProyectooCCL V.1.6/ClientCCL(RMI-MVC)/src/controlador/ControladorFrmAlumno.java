package controlador;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.RMICliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.Cls_Validaciones;
import vista.FrmAlumnos;
import vista.FrmAlumnosEdit;

public class ControladorFrmAlumno implements ActionListener {

    RMICliente modelo;
    private FrmAlumnos CatAlumnos;
    private FrmAlumnosEdit CrudAlumno;
    FrmAlumnos AbrirFrmAlumno = null;
    File fichero;
    tdaCombo combo;
    String ruta;
    FileInputStream fis;
    int opc = 0;

    public ControladorFrmAlumno(FrmAlumnos CatAlumnos, FrmAlumnosEdit CrudAlumno) {
        modelo = new RMICliente();
       
        this.llenaGrid();
        this.CatAlumnos = CatAlumnos;
        this.CrudAlumno = CrudAlumno;
        
//this.CatAlumnos.set
       
        this.CatAlumnos.jbtnActualizar.addActionListener(this);
        this.CatAlumnos.jbtnAgregar.addActionListener(this);
        this.CatAlumnos.btnBus.addActionListener(this);
        this.CatAlumnos.jbtnEliminar.addActionListener(this);
        this.CatAlumnos.jbtnMuestra.addActionListener(this);

        this.CrudAlumno.jbtnAceptar.addActionListener(this);
        this.CrudAlumno.jbtnseleccionar.addActionListener(this);
        this.CrudAlumno.jbtnActualizaDatos.addActionListener(this);
        this.CrudAlumno.jbtnCancelar.addActionListener(this);
        this.CatAlumnos.salirCat.addActionListener(this);

    }
    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == CatAlumnos.btnBus) {
            llenaGridBusca();
        }
       
        if (e.getSource() == CatAlumnos.jbtnMuestra) {
            llenaGrid();
        }
        if (e.getSource() == CatAlumnos.jbtnAgregar) {
            AbreCrudAlumno();
        }
        if (e.getSource() == CatAlumnos.jbtnActualizar) {
            ModificarCampos();

        }
        if (e.getSource() == CatAlumnos.jbtnEliminar) {
            Eliminar();
        }
        if (e.getSource() == CrudAlumno.jbtnCancelar) {
            CrudAlumno.dispose();
        }
        if (e.getSource() == CrudAlumno.jbtnAceptar) {
            try {
                insertIMG();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == CrudAlumno.jbtnActualizaDatos) {
            if(ruta==null){
                try {
                    EditaAlumnoSinfoto();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorFrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    EditaAlumnoConfoto();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorFrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (e.getSource() == CrudAlumno.jbtnseleccionar) {
            Abririmagen();
        }
        if (e.getSource() == CatAlumnos.salirCat) {
            apagar();
            CatAlumnos.dispose();
        }

    }
   

    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYY-MM-dd");
        return formatofecha.format(fecha);
    }

    public void AbreCrudAlumno() {
        Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudAlumno);
        CrudAlumno = new FrmAlumnosEdit(f, true);

        LimpiarCajas();
        CrudAlumno.titulo.setText("ADMINISTRAR NUEVO ALUMNO");
        CrudAlumno.txtmatricula.setEditable(true);
        CrudAlumno.txtmatricula.setEditable(true);
        CrudAlumno.txtnombre.setEditable(true);
        CrudAlumno.txtcurp.setEditable(true);
        CrudAlumno.txtDate.setEnabled(true);
        CrudAlumno.txttelefono.setEditable(true);
        CrudAlumno.txtcorreo.setEditable(true);
        CrudAlumno.txtingreso.setEditable(true);
        CrudAlumno.jbtnActualizaDatos.setVisible(false);
        CrudAlumno.jbtnseleccionar.setVisible(true);
        CrudAlumno.txtingreso.setText(FechaActual());

        CrudAlumno.jbtnActualizaDatos.setVisible(false);
        CrudAlumno.jbtnAceptar.setVisible(true);
        llenaGrid();
         CrudAlumno.setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
        CrudAlumno.setLocationRelativeTo(null);
        CrudAlumno.setVisible(true);
    }

//    public void InsertaAlumno() throws FileNotFoundException, IOException {
//        if (CrudAlumno.txtmatricula.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtnacimiento1.getText().equals("") || CrudAlumno.txttelefono.getText().equals("") || CrudAlumno.txtcorreo.getText().equals("") || CrudAlumno.txtingreso.getText().equals("")) {
//            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
//        } else {
//            fis = new FileInputStream(fichero);
//            JOptionPane.showMessageDialog(null, "ruta " + fichero);
//            JOptionPane.showMessageDialog(null, "Fiochero " + fis);
//            byte dato[] = Cls_Conversion.datos(fis);
//            JOptionPane.showMessageDialog(null, "imGEN CONVERTIDO" + dato);
//
//            int r = modelo.Insertar(new Object[]{CrudAlumno.txtmatricula.getText(), CrudAlumno.txtnombre.getText(), CrudAlumno.txtcurp.getText(), CrudAlumno.txtnacimiento1.getText(), CrudAlumno.txttelefono.getText(), CrudAlumno.txtcorreo.getText(), CrudAlumno.txtingreso.getText(), dato}, "Alumno");
//            JOptionPane.showMessageDialog(null, "llego al Cliente Respuesta" + r);
//            if (r != 0) {
//                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
//                CrudAlumno.dispose();
//                llenaGrid();
//
//            } else {
//
//                JOptionPane.showMessageDialog(null, "error al insertar");
//            }
//        }
//
//    }
    

    public void insertIMG() throws FileNotFoundException, IOException {
       if (CrudAlumno.txtmatricula.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtDate.getDate().equals("") || CrudAlumno.txttelefono.getText().equals("") || CrudAlumno.txtcorreo.getText().equals("") || CrudAlumno.txtingreso.getText().equals("") || ruta==null ) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
        
        fis = new FileInputStream(fichero);
        byte datos[] = Cls_Conversion.datos(fis);
        Date date =CrudAlumno.txtDate.getDate();
        long d=date.getTime();
        java.sql.Date fecha =new java.sql.Date(d);
       

        int r = modelo.Insertar(new Object[]{CrudAlumno.txtmatricula.getText(),CrudAlumno.txtnombre.getText() , CrudAlumno.txtcurp.getText(), fecha, CrudAlumno.txttelefono.getText(), CrudAlumno.txtcorreo.getText(), CrudAlumno.txtingreso.getText(), datos}, "Alumno");
        if (r != 0) {
            JOptionPane.showMessageDialog(null, " Se inserto Correctamente");
            CrudAlumno.dispose();
            llenaGrid();
        } else {
            JOptionPane.showMessageDialog(null, " Error al insertar");
        }
    }
       }

    public void EditaAlumnoConfoto() throws FileNotFoundException, IOException {
        if (CrudAlumno.txtmatricula.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtDate.getDate().equals("") || CrudAlumno.txttelefono.getText().equals("") || CrudAlumno.txtcorreo.getText().equals("") || CrudAlumno.txtingreso.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
        fis = new FileInputStream(fichero);
        byte datos[] = Cls_Conversion.datos(fis);
        
        Date date =CrudAlumno.txtDate.getDate();
        long d=date.getTime();
        java.sql.Date fecha =new java.sql.Date(d);
        
            int r = modelo.Editar(new Object[]{CrudAlumno.txtmatricula.getText(), CrudAlumno.txtnombre.getText(), CrudAlumno.txtcurp.getText(),fecha, CrudAlumno.txttelefono.getText(), CrudAlumno.txtcorreo.getText(), CrudAlumno.txtingreso.getText(),datos}, "Alumno");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                CrudAlumno.dispose();
                llenaGrid();

            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
        }

    }
    public void EditaAlumnoSinfoto() throws FileNotFoundException, IOException {
        if (CrudAlumno.txtmatricula.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtnombre.getText().equals("") || CrudAlumno.txtDate.getDate().equals("") || CrudAlumno.txttelefono.getText().equals("") || CrudAlumno.txtcorreo.getText().equals("") || CrudAlumno.txtingreso.getText().equals("")) {
            Cls_Validaciones.mensajeAdvertencia("Introduce datos!!", "Aviso");
        } else {
    Date date =CrudAlumno.txtDate.getDate();
        long d=date.getTime();
        java.sql.Date fecha =new java.sql.Date(d);
            int r = modelo.Editar(new Object[]{CrudAlumno.txtmatricula.getText(), CrudAlumno.txtnombre.getText(), CrudAlumno.txtcurp.getText(),fecha, CrudAlumno.txttelefono.getText(), CrudAlumno.txtcorreo.getText(), CrudAlumno.txtingreso.getText()}, "AlumnoSinFoto");

            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                CrudAlumno.dispose();
                llenaGrid();

            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
        }

    }
    public void llenaGridBusca() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatAlumnos.DatosAlumnos.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Busca(CatAlumnos.txtbuscar.getText(),"BuscaAlumnos");
            //byte img[] = new byte[1000000];
            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String matricula = arr[0].toString();
                String Nombre = arr[1].toString();
                String curp = arr[2].toString();
                String fechanacimiento = arr[3].toString();
                String tel = arr[4].toString();
                String cooreo = arr[5].toString();
                String fechaingrso = arr[6].toString();
                String img =arr[7].toString();
                //img = (byte[]) arr[7];
                mode.addRow(new Object[]{matricula, Nombre, curp, fechanacimiento, tel, cooreo, fechaingrso, img});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void llenaGrid() {
        try {
            DefaultTableModel mode = (DefaultTableModel) CatAlumnos.DatosAlumnos.getModel();
            Object[] arr;
            List<Object[]> lista = modelo.Llenado("Alumno");
            //byte img[] = new byte[1000000];
            while (mode.getRowCount() > 0) {
                mode.removeRow(0);
            }
            for (int x = 0; x < lista.size(); x++) {
                arr = lista.get(x);
                String matricula = arr[0].toString();
                String Nombre = arr[1].toString();
                String curp = arr[2].toString();
                String fechanacimiento = arr[3].toString();
                String tel = arr[4].toString();
                String cooreo = arr[5].toString();
                String fechaingrso = arr[6].toString();
                String img =arr[7].toString();
                //img = (byte[]) arr[7];
                mode.addRow(new Object[]{matricula, Nombre, curp, fechanacimiento, tel, cooreo, fechaingrso, img});
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    public void LimpiarCajas() {
        CrudAlumno.txtmatricula.setText("");
        CrudAlumno.txtnombre.setText("");
        CrudAlumno.txtcurp.setText("");
        CrudAlumno.txtDate.setDate(null);
        CrudAlumno.txtingreso.setText("");
        CrudAlumno.txttelefono.setText("");
        CrudAlumno.txtcorreo.setText("");
        CrudAlumno.lblimgen.setIcon(null);

    }

    public void ModificarCampos() {
        int row = CatAlumnos.DatosAlumnos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudAlumno);
            CrudAlumno = new FrmAlumnosEdit(f, true);

            CrudAlumno.titulo.setText("ACTUALIZAR DATOS DEL ALUMNO");
            CrudAlumno.txtmatricula.setEditable(false);
            CrudAlumno.jbtnAceptar.setVisible(false);
            CrudAlumno.jbtnActualizaDatos.setVisible(true);
            int fila = CatAlumnos.DatosAlumnos.getSelectedRow();

            CrudAlumno.txtmatricula.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 0).toString());
            CrudAlumno.txtnombre.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 1).toString());
            CrudAlumno.txtcurp.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 2).toString());
            CrudAlumno.txtDate.setDateFormatString(CatAlumnos.DatosAlumnos.getValueAt(fila, 3).toString());
            CrudAlumno.txttelefono.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 4).toString());
            CrudAlumno.txtcorreo.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 5).toString());
            CrudAlumno.txtingreso.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 6).toString());
            CrudAlumno.setLocationRelativeTo(null);
            llenar_foto();
            
            CrudAlumno.setVisible(true);
            llenaGrid();

        }
    }

    private void Ver() {
        int row = CatAlumnos.DatosAlumnos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            Frame f = javax.swing.JOptionPane.getFrameForComponent(CrudAlumno);
            CrudAlumno = new FrmAlumnosEdit(f, true);

            CrudAlumno.titulo.setText("DATOS DEL ALUMNO");
            CrudAlumno.txtmatricula.setEditable(false);
            CrudAlumno.txtnombre.setEditable(false);
            CrudAlumno.txtcurp.setEditable(false);
            CrudAlumno.txtDate.setEnabled(false);
            CrudAlumno.txttelefono.setEditable(false);
            CrudAlumno.txtcorreo.setEditable(false);
            CrudAlumno.txtingreso.setEditable(false);

            CrudAlumno.jbtnAceptar.setVisible(false);
            CrudAlumno.jbtnActualizaDatos.setVisible(false);
            CrudAlumno.jbtnseleccionar.setVisible(false);
            int fila = CatAlumnos.DatosAlumnos.getSelectedRow();

            CrudAlumno.txtmatricula.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 0).toString());
            CrudAlumno.txtnombre.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 1).toString());
            CrudAlumno.txtcurp.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 2).toString());
            CrudAlumno.txtDate.setDateFormatString(CatAlumnos.DatosAlumnos.getValueAt(fila, 3).toString());
            CrudAlumno.txttelefono.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 4).toString());
            CrudAlumno.txtcorreo.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 5).toString());
            CrudAlumno.txtingreso.setText(CatAlumnos.DatosAlumnos.getValueAt(fila, 6).toString());

            CrudAlumno.setVisible(true);

        }
    }

    void llenar_foto() {
        try {
            Object[] x;
            CrudAlumno.lblimgen.setText(null);

            String mat = CatAlumnos.DatosAlumnos.getValueAt(CatAlumnos.DatosAlumnos.getSelectedRow(), 0).toString();
            List<Object[]> lista = modelo.Busca(mat, "Alumno");
            byte imagen[] = new byte[100000];
            BufferedImage buffin = null;
            x = lista.get(0);
            imagen = (byte[]) x[0];
            try (InputStream img = new ByteArrayInputStream(imagen)) {
                buffin = ImageIO.read(img);

                ImageIcon icon = new ImageIcon(buffin);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudAlumno.lblimgen.getWidth(), CrudAlumno.lblimgen.getHeight(), Image.SCALE_DEFAULT));
                CrudAlumno.lblimgen.setText(null);
                CrudAlumno.lblimgen.setIcon(icono);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar() {
        int row = CatAlumnos.DatosAlumnos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una Columna!!");
        } else {
            int dato = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar ?");
            if (dato == 0) {
                DefaultTableModel mode = (DefaultTableModel) CatAlumnos.DatosAlumnos.getModel();
                int clave = Integer.valueOf(mode.getValueAt(row, 0).toString());
                int r;
                r = modelo.Eliminar(clave, "Alumno");

                if (r != 0) {

                    JOptionPane.showMessageDialog(null, "El Registro se eliminó correctamente");
                    llenaGrid();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Registro");
                }
            }

        }
    }

    public void Reporte() throws JRException, RemoteException {

        JasperPrint jprint = null;

        JasperReport reporte = null;
        String path = "src\\reporte\\ReportAlumnos.jasper";

        //Map parametro =new HashMap();
        // parametro.get(modelo.llenado());
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        jprint = JasperFillManager.fillReport(path, null);
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

    private void Abririmagen() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG Y PNG", "jpg", "png");
        fc.setFileFilter(filtro);
        int selecion = fc.showOpenDialog(CrudAlumno);

        if (selecion == JFileChooser.APPROVE_OPTION) {
            try {
                fichero = fc.getSelectedFile();
                ruta = fichero.getAbsolutePath();

                fis = new FileInputStream(fichero);
                ImageIcon icon = new ImageIcon(ruta.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudAlumno.lblimgen.getWidth(), CrudAlumno.lblimgen.getHeight(), Image.SCALE_DEFAULT));
                CrudAlumno.lblimgen.setText(null);
                CrudAlumno.lblimgen.setIcon(icono);
                fis.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UNA IMAGEN");
        }
    }

    public void apagar() {
        this.CatAlumnos.jbtnActualizar.removeActionListener(this);
        this.CatAlumnos.jbtnAgregar.removeActionListener(this);
    
        this.CatAlumnos.jbtnEliminar.removeActionListener(this);
        this.CatAlumnos.jbtnMuestra.removeActionListener(this);
        this.CrudAlumno.jbtnAceptar.removeActionListener(this);
        this.CrudAlumno.jbtnActualizaDatos.removeActionListener(this);
        this.CrudAlumno.jbtnCancelar.removeActionListener(this);
        this.CrudAlumno.jbtnseleccionar.removeActionListener(this);
    }

}
