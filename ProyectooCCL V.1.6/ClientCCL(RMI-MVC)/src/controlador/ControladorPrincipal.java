package controlador;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.RMICliente;
import vista.FrmAcercade;
import vista.FrmAlumnos;
import vista.FrmAlumnosEdit;
import vista.FrmAsignaAlum;

import vista.FrmAsignaAlumnoEdit;
import vista.FrmCalificacion;
import vista.FrmCalificacionEdit;
import vista.FrmGrado;
import vista.FrmLogin;
import vista.FrmMateria;
import vista.FrmPeriodo;
import vista.FrmPrincipal;
import static vista.FrmPrincipal.desktopPane;
import vista.FrmProfesores;
import vista.FrmProfesoresEdit;
import vista.FrmUsuarios;
import vista.FrmUsuariosEdit;

public class ControladorPrincipal implements ActionListener {

    private final FrmPrincipal MdiPrincipal;
    FrmAlumnos AbrirFrmAlumno = null;
    FrmProfesores AbrirProfesor=null;
    FrmAsignaAlum AbrirAsignaAlumno=null;
    FrmGrado AbrirGrado=null;
    FrmPeriodo AbrirPeriodo=null;
    FrmMateria AbrirMateria=null;
    FrmCalificacion AbrirCalificacionesEdit=null;
    FrmUsuarios AbrirUsuarios;
    FrmLogin abrelogin=null;
    FrmCalificacionEdit ConsuktaCal;
    FrmAcercade acerca;
  
    ControladorFrmAlumno objet;
    RMICliente modelo;

    public ControladorPrincipal(FrmPrincipal MdiPrincipal) {
        
        modelo=new RMICliente();

        this.MdiPrincipal = MdiPrincipal;
        this.MdiPrincipal.setIconImage(new ImageIcon(getClass().getResource("/Icon/System.png")).getImage());
        this.MdiPrincipal.AbreFrmAlumno.addActionListener(this);
        this.MdiPrincipal.AbreFrmProfesor.addActionListener(this);
        this.MdiPrincipal.AbreAsignaAlumno.addActionListener(this);
        this.MdiPrincipal.Abregrado.addActionListener(this);
        this.MdiPrincipal.AbrePeriodo.addActionListener(this);
        this.MdiPrincipal.AbreMateria.addActionListener(this);
        this.MdiPrincipal.AbreCalificaciones.addActionListener(this);
        this.MdiPrincipal.AbreUsuarios.addActionListener(this);
        this.MdiPrincipal.AbreSalir.addActionListener(this);
        this.MdiPrincipal.AbreConsutorCal.addActionListener(this);
        this.MdiPrincipal.AbreAcercade.addActionListener(this);
        this.ConfiguracionMdi();
    }

    public static void main(String args[]) {
        
        FrmLogin logeo = new FrmLogin();//Loque Carga en el maing
        ControladorFrmLogin ctr = new ControladorFrmLogin(logeo);
        logeo.setTitle("Acceso al Sistema Control Escolar");
        //logeo.setExtendedState(logeo.MAXIMIZED_BOTH);
        
        logeo.setLocationRelativeTo(null);
        logeo.setVisible(true);
    }
    public static void ConfiguracionMdi() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == MdiPrincipal.AbreFrmAlumno) {
            try {
                AbreCatalagoAlumno();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == MdiPrincipal.AbreFrmProfesor) {
            try {
                AbreCatalagoProfesor();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == MdiPrincipal.AbreAsignaAlumno) {
            try {
                AbreCatalagoAsignaAluno();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == MdiPrincipal.Abregrado) {
            AbreCatalagoGrado();
        }
        if (e.getSource() == MdiPrincipal.AbrePeriodo) {
            AbreCatalagoPeriodo();
        }
        if(e.getSource()==MdiPrincipal.AbreMateria){
            try {
                AbreCatalogoMateria();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==MdiPrincipal.AbreCalificaciones){
            try {
                AbreCatalogoCalificacionesEdit();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==MdiPrincipal.AbreUsuarios){
            try {
                AbreCatalagoUser();
            } catch (PropertyVetoException | RemoteException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==MdiPrincipal.AbreSalir){
           MdiPrincipal.dispose();
        }
        if(e.getSource()==MdiPrincipal.AbreConsutorCal){
            try {
                AbreConsultaCal();
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==MdiPrincipal.AbreAcercade){
            Abreacerca();
        }
        

    }

    public void AbreCatalagoAlumno() throws PropertyVetoException {
        if (AbrirFrmAlumno == null || AbrirFrmAlumno.isClosed()) {
            AbrirFrmAlumno = new FrmAlumnos();
            FrmAlumnosEdit Abre = new FrmAlumnosEdit();
            ControladorFrmAlumno ctrl = new ControladorFrmAlumno(AbrirFrmAlumno, Abre);
           
            ctrl.llenaGrid();
            
            MdiPrincipal.desktopPane.add(AbrirFrmAlumno);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        AbrirFrmAlumno.setMaximum(true);
        
        AbrirFrmAlumno.setVisible(true);
        
    }
    public void AbreCatalagoProfesor() throws PropertyVetoException {
        if (AbrirProfesor== null || AbrirProfesor.isClosed()) {
            AbrirProfesor = new FrmProfesores();
            FrmProfesoresEdit Abre = new FrmProfesoresEdit();
            ControladorFrmProfesor ctrl = new ControladorFrmProfesor(AbrirProfesor, Abre);
            ctrl.llenaGridProfesores();
            MdiPrincipal.desktopPane.add(AbrirProfesor);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        AbrirProfesor.setMaximum(true);
        AbrirProfesor.setVisible(true);
    }
    public void AbreCatalagoAsignaAluno() throws PropertyVetoException, RemoteException {
        if (AbrirAsignaAlumno == null || AbrirAsignaAlumno.isClosed()) {
            AbrirAsignaAlumno = new FrmAsignaAlum();
            FrmAsignaAlumnoEdit Abre = new FrmAsignaAlumnoEdit();
            ControladorFrmAsigaAlumno ctrl = new ControladorFrmAsigaAlumno(AbrirAsignaAlumno, Abre);          
            ctrl.llenaGridAsigna();
            MdiPrincipal.desktopPane.add(AbrirAsignaAlumno);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        AbrirAsignaAlumno.setMaximum(true);
        AbrirAsignaAlumno.setVisible(true);      
    }
    
    public void AbreCatalagoGrado() {
        if (AbrirGrado == null || AbrirGrado.isClosed()) {
            AbrirGrado = new FrmGrado();
           
            ControladorFrmGrado ctrl = new ControladorFrmGrado(AbrirGrado);          
            ctrl.llenaGrid();
            MdiPrincipal.desktopPane.add(AbrirGrado);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = AbrirGrado.getSize();
        AbrirGrado.setLocation((desktopSize.width-FrameSize.height)/2, 0);
        AbrirGrado.setVisible(true);
        
    }
    public void AbreCatalagoPeriodo() {
        if (AbrirPeriodo == null || AbrirPeriodo.isClosed()) {
            AbrirPeriodo = new FrmPeriodo();
           
             ControladorFrmPeriodo ctrl = new ControladorFrmPeriodo(AbrirPeriodo);          
            ctrl.llenaGrid();
            MdiPrincipal.desktopPane.add(AbrirPeriodo);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = AbrirPeriodo.getSize();
        AbrirPeriodo.setLocation((desktopSize.width-FrameSize.height)/2, 0);
        AbrirPeriodo.setVisible(true);
        
    }
    public void AbreCatalogoMateria() throws RemoteException {
            if (AbrirMateria == null || AbrirMateria.isClosed()) {
            AbrirMateria = new FrmMateria();
           
             ControladorFrmMateria ctrl = new ControladorFrmMateria(AbrirMateria);          
            ctrl.llenaGrid();
            MdiPrincipal.desktopPane.add(AbrirMateria);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize =  AbrirMateria.getSize();
         AbrirMateria.setLocation((desktopSize.width-FrameSize.height)/2, 0);  
        AbrirMateria.setVisible(true);
        
    }
    public void AbreCatalogoCalificacionesEdit() throws PropertyVetoException {
            if (AbrirCalificacionesEdit == null || AbrirCalificacionesEdit.isClosed()) {
            AbrirCalificacionesEdit = new FrmCalificacion();
           FrmCalificacionEdit Abre =new FrmCalificacionEdit();
             ControladorFrmCalificaciones ctrl = new ControladorFrmCalificaciones(AbrirCalificacionesEdit,Abre);          
            ctrl.llenaGrid();
            MdiPrincipal.desktopPane.add(AbrirCalificacionesEdit);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize =  AbrirCalificacionesEdit.getSize();
        AbrirCalificacionesEdit.setLocation((desktopSize.width-FrameSize.height)/2, 0);
        AbrirCalificacionesEdit.setVisible(true);
        
    }
    public void AbreCatalagoUser() throws PropertyVetoException, RemoteException {
        if (AbrirUsuarios == null || AbrirUsuarios.isClosed()) {
            AbrirUsuarios = new FrmUsuarios();
            FrmUsuariosEdit Abre = new  FrmUsuariosEdit();
            ControladorFrmUsuarios ctrl = new ControladorFrmUsuarios(AbrirUsuarios , Abre);          
            ctrl.llenaGrid();
            MdiPrincipal.desktopPane.add(AbrirUsuarios);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario Abierto!!!");
        }
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize =  AbrirUsuarios.getSize();
         AbrirUsuarios.setLocation((desktopSize.width-FrameSize.height)/2, 0);  
        AbrirUsuarios.setVisible(true);      
    }
    public void AbreConsultaCal() throws RemoteException {
             ConsuktaCal= new FrmCalificacionEdit();
              acerca= new FrmAcercade();
        Frame f = javax.swing.JOptionPane.getFrameForComponent(ConsuktaCal);
        ConsuktaCal = new FrmCalificacionEdit(f, true);
        Controlador_ConsultaAlumno con=new Controlador_ConsultaAlumno(ConsuktaCal,acerca);
        con.Busca();
        ConsuktaCal.setLocationRelativeTo(null);
        ConsuktaCal.btnactualizarregistro.setVisible(false);
        ConsuktaCal.jLabel3.setVisible(false);
        ConsuktaCal.setVisible(true);
    }
     public void Abreacerca() {
          ConsuktaCal= new FrmCalificacionEdit();
             acerca= new FrmAcercade();
        Frame f = javax.swing.JOptionPane.getFrameForComponent(acerca);
         acerca = new FrmAcercade(f, true);
        Controlador_ConsultaAlumno con=new Controlador_ConsultaAlumno(ConsuktaCal,acerca);
        
        acerca.setLocationRelativeTo(null);

        acerca.setVisible(true);
    }

        
    
}
