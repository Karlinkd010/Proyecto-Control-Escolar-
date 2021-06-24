package vista;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Cls_Validaciones {

    public static boolean validarLongitudMaximo(JTextField caja, KeyEvent evt, int longitudMaxima) {
        if (caja.getText().length() == longitudMaxima) {
            evt.consume();
            return true;
        }
        return false;
    }
    public  void validaCorreo(JTextField caja, String correoElectronico) {

        // Patrón para validar el email
        Pattern patron = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = patron.matcher(correoElectronico);

        if (mather.find() == true) {

        }else {
            JOptionPane.showMessageDialog(null, "Correo no valido");
            caja.setText("");
            caja.getCursor();
        }

    }

    public static void validarNumero(KeyEvent evt) {
        char l = evt.getKeyChar();
        if (!(l >= '0' & l <= '9')) {
            evt.consume();
            
        }
    }

    public static void validarLetras(KeyEvent evt) {
        char l = evt.getKeyChar();
        if (Character.isDigit(l) ||  l==64 ) {
            evt.consume();
        }
    }
 
    public static void mensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeAdvertencia(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

}
