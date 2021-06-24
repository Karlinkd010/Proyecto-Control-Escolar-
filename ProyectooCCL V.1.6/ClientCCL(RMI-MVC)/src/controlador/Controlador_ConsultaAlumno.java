
package controlador;


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
import modelo.RMICliente;
import vista.FrmAcercade;
import vista.FrmCalificacionEdit;
import vista.FrmLogin;
import vista.FrmPrincipal;



public class Controlador_ConsultaAlumno implements ActionListener{
    RMICliente modelo;
    private FrmCalificacionEdit CrudCal;
    private FrmAcercade Cat;
    FrmLogin login;
    private FrmPrincipal mdi;
    

    
    Controlador_ConsultaAlumno(FrmCalificacionEdit CrudCal,FrmAcercade Cat){
        modelo=new RMICliente();
        Busca();
       this.CrudCal = CrudCal;
       this.Cat =Cat;
       this.CrudCal.imprimir.addActionListener(this);
        this.CrudCal.btncancelregistro.addActionListener(this);
        this.Cat.btncancelregistro.addActionListener(this);
       
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == CrudCal.imprimir) {
               JOptionPane.showMessageDialog(null, "En este Versión Aun no se encuentra Disponible ");
        }
           if (e.getSource() == CrudCal.btncancelregistro) {
               CrudCal.dispose();
        }
           if (e.getSource() == Cat.btncancelregistro) {
               Cat.dispose();
        }
    }
    
    
    public void Busca() {
        String User = login.txtuser.getText();
        
        try {
            Object[] arr;
            List<Object[]> lista = modelo.Busca(User,"ConsultaCalificacion");
           
            byte imagen[] = new byte[100000];
            BufferedImage buffin = null;
            for (int x = 0; x <= lista.size(); x++) {
                arr = lista.get(x);
             
                CrudCal.lblmatricula.setText(arr[0].toString()); 
                CrudCal.lblnombre.setText(arr[1].toString());
                CrudCal.lblgrado.setText(arr[2].toString());
                CrudCal.lblgrupo.setText(arr[3].toString());
               CrudCal.lblperiodo.setText(arr[4].toString());
                imagen = (byte[]) arr[5];
                 try (InputStream img = new ByteArrayInputStream(imagen)) {
                buffin = ImageIO.read(img);

                ImageIcon icon = new ImageIcon(buffin);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(CrudCal.foto.getWidth(), CrudCal.foto.getHeight(), Image.SCALE_DEFAULT));
                CrudCal.foto.setText(null);
                CrudCal.foto.setIcon(icono);
            } catch (IOException ex) {
               
            }
                
            }
            arr = lista.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        }

}
