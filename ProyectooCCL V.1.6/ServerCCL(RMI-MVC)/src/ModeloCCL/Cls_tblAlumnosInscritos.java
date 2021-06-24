package ModeloCCL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Cls_tblAlumnosInscritos {

    Connection cnn;

    public Cls_tblAlumnosInscritos() {
        cnn = Cnn.getConection();
    }

    public ResultSet getSelectInscritos() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT * FROM vw_asigna");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet getSelectInscritosBusca(String g) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vw_asigna WHERE  vchGrado='"+g+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    public ResultSet ConsultaCalificacion(String g) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vw_ConsultaAlumno WHERE vchMatricula='"+g+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }


    public int InsertarAlumnnoInscrito(Object[] obj) {
        int r = 0;
        String Consul = "INSERT INTO tblalumnosinscritos VALUES ('" + obj[0] + "','" + obj[1] + "','" + obj[2] + "','" + obj[3] + "','" + obj[4] + "','" + obj[5] + "')";
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EditarAlumnnoInscrito(Object[] obj) {
        int r = 0;
        String Consul = "UPDATE `bdcontrolescolar`.`tblalumnosinscritos`\n"
                + "SET `intidinscritos` = '" + obj[0] + "',\n"

                + "  `chrgrupo` = '" + obj[1] + "',\n"

                + "  `fechainscripcion` = '" + obj[2] + "'\n"
                + "WHERE `intidinscritos` = '" + obj[0] + "'";
    
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EliminarAlumnnoInscrito(int clave) {
        int r = 0;
        String Consul = "DELETE FROM tblalumnosinscritos WHERE intidinscritos=" + clave;
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

}
