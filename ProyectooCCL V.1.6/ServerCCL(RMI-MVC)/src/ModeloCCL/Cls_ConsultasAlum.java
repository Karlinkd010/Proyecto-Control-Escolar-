package ModeloCCL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Cls_ConsultasAlum {

    Connection cnn;

    public Cls_ConsultasAlum() {
        cnn = Cnn.getConection();
    }

    public ResultSet getSelect() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblalumnos");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet BuscaAlumno(String mat) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblalumnos WHERE vchMatricula ='" + mat + "' ");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return rs;
    }
    public ResultSet ConsultaImagen(String mat) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT vchimagen FROM tblalumnos WHERE vchMatricula='" + mat + "' ");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public int InsertarAlumnno(Object[] obj) {
        int r = 0;
        String Consul = "INSERT INTO tblalumnos VALUES ('" + obj[0] + "','" + obj[1] + "','" + obj[2] + "','" + obj[3] + "','" + obj[4] + "','" + obj[5] + "','" + obj[6] + "','" +(byte[]) obj[7] + "')";
        try {
            Statement stm = cnn.createStatement();
            
            r = stm.executeUpdate(Consul);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EditarAlumnno(Object[] obj) {
        int r = 0;
        String Consul = "UPDATE `tblalumnos`\n"
                + "SET `vchMatricula` = '" + obj[0] + "',\n"
                + "  `vchNombre` = '" + obj[1] + "',\n"
                + "  `vchCurp` = '" + obj[2] + "',\n"
                + "  `vchFechaNac` = '" + obj[3] + "',\n"
                + "  `vchTel` = " + obj[4] + ",\n"
                + "  `vchCorreo` = '" + obj[5] + "',\n"
                + "  `dtFechaIngreso` = '" + obj[6] + "'\n"
                + "WHERE `vchMatricula` = '" + obj[0] + "'";
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EliminarAlumno(int mat) {
        int r = 0;
        String Consul = "DELETE FROM tblalumnos WHERE vchMatricula=" + mat;
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
    }
    }
     public int inserta_imagen(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spinsertaalumnos(?,?,?,?,?,?,?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                stm.setString(3, objeto[2].toString());
                stm.setString(4, objeto[3].toString());
                stm.setString(5, objeto[4].toString());
                stm.setString(6, objeto[5].toString());
                stm.setString(7, objeto[6].toString());
                
                stm.setBytes(8, (byte[]) objeto[7]);
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
     public int edita_imagen(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spUpdatealumnos(?,?,?,?,?,?,?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                stm.setString(3, objeto[2].toString());
                stm.setString(4, objeto[3].toString());
                stm.setString(5, objeto[4].toString());
                stm.setString(6, objeto[5].toString());
                stm.setString(7, objeto[6].toString());
                
                stm.setBytes(8, (byte[]) objeto[7]);
        
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
}
