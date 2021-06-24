package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.RMICliente;
import vista.FrmLogin;
import vista.FrmPrincipal;

public class ControladorFrmLogin implements ActionListener {

    private RMICliente modelo = new RMICliente();
    FrmLogin VistaLogin = null;
    FrmPrincipal VistaMdi = null;
    boolean existe;
    String usuario;
    String contrasena;
    String tipo;
    int opc = 0;

    public ControladorFrmLogin(FrmLogin VistaLogin) {
        this.VistaLogin = VistaLogin;
        this.VistaLogin.setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

        this.VistaLogin.btnacceder.addActionListener(this);
        this.VistaLogin.btncancelar.addActionListener(this);
        this.VistaLogin.cmbtipo.addActionListener(this);
    }

    public boolean BuscaUsuarioExistente(String user, String pass, String type) throws RemoteException {

        Object[] x;
        List<Object[]> lista = this.modelo.Llenado("Login");

        for (int i = 0; i < lista.size(); i++) {
            x = lista.get(i);

            usuario = x[1].toString();
            contrasena = x[2].toString();
            tipo = x[3].toString();

            if (usuario.equals(user) && contrasena.equals(pass) && tipo.equals(type)) {
                existe = true;
                break;
            } else {
                existe = false;
            }
        }

        return existe;
    }

    public boolean Bienvenida() throws RemoteException {

        if (BuscaUsuarioExistente(VistaLogin.txtuser.getText(), VistaLogin.txtpassword.getText(), String.valueOf(VistaLogin.cmbtipo.getSelectedItem()))) {
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema  ");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Invalido");
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaLogin.btnacceder) {
            try {
                if (Bienvenida() == true) {

                    Accesoprovilegios();

                }
            } catch (RemoteException ex) {
                Logger.getLogger(ControladorFrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == VistaLogin.btncancelar) {
            VistaLogin.dispose();
        }

    }

    private void Accesoprovilegios() throws RemoteException {
       
       
        String Comparar= String.valueOf(VistaLogin.cmbtipo.getSelectedItem());
        
        if(Comparar.equals("ADMINISTRADOR")){
            VistaLogin.dispose();
        VistaMdi = new FrmPrincipal();
        ControladorPrincipal ctr = new ControladorPrincipal(VistaMdi);
        VistaMdi.setTitle("Consulta De Calificaciones Escolar "+usuario);
        
        VistaMdi.setExtendedState(VistaMdi.MAXIMIZED_BOTH);

        VistaMdi.desktopPane.setSize(2147483647, 2147483647);
        VistaMdi.bienvenida.setText("BIENVENIDO "+tipo+": "+usuario);
        VistaMdi.menuConsultaCal.setVisible(false);
        VistaMdi.MenúCatalogo.setVisible(true);
        VistaMdi.menuadmistrar.setVisible(true);
        
        VistaMdi.setVisible(true);
        }else if(Comparar.equals("ALUMNO")){
        VistaLogin.dispose();
        VistaMdi = new FrmPrincipal();
        ControladorPrincipal ctr = new ControladorPrincipal(VistaMdi);
        
        VistaMdi.setExtendedState(VistaMdi.MAXIMIZED_BOTH);
        VistaMdi.desktopPane.setSize(2147483647, 2147483647);
        VistaMdi.MenúCatalogo.setVisible(false);
        VistaMdi.menuadmistrar.setVisible(false);
        VistaMdi.menuConsultaCal.setVisible(true);
         String User = VistaLogin.txtuser.getText();
        
        try {
            Object[] arr;
            List<Object[]> lista = modelo.Busca(User,"ConsultaCalificacion");
           
            
            for (int x = 0; x <= lista.size(); x++) {
                arr = lista.get(x);
             
                
                String UsurioAcceder = arr[1].toString();
                VistaMdi.setTitle("Consulta De Calificaciones Escolar "+UsurioAcceder);
                 VistaMdi.bienvenida.setText("BIENVENIDO "+tipo+": "+UsurioAcceder);
                
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        VistaMdi.setVisible(true);
        }
  
    }

}

