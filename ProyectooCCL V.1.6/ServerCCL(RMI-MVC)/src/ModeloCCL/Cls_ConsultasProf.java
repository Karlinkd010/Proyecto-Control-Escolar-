package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//CONSULTAS PROFESORES

public class Cls_ConsultasProf {

    Connection cnn;

    public Cls_ConsultasProf() {
        cnn = Cnn.getConection();
    }

    public ResultSet getSelectProfesores() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vista_profesorgrado");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet ConsultaImagen(String id) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT Imagen FROM tblprofesor WHERE `intidprofesor`='" + id + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getSelectProfesor(String nombre) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT * FROM tblprofesor WHERE Nombre LIKE '%" + nombre + "%' ");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public int InsertarProfesor(Object[] objeto) {
       int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spinsertaprof(?,?,?,?,?,?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                stm.setString(3, objeto[2].toString());
                stm.setString(4, objeto[3].toString());
                stm.setString(5, objeto[4].toString());
                stm.setString(6, objeto[5].toString());
                stm.setString(7, objeto[6].toString());
            
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }

    public int EditarProfesor(Object[] obj) {
        int r = 0;
        String Consul = "UPDATE `tblprofesor`\n"
                + "SET `intidprofesor` = " + obj[0] + ",\n"
                + "  `Nombre` = '" + obj[1] + "',\n"
                + "  `Direccion` = '" + obj[2] + "',\n"
                + "  `Telefono` = '" + obj[3] + "',\n"
                + "  `email` = '" + obj[4] + ",',\n"
                + "  `ruta` = '" + obj[5] + "',\n"
                + "  `Imagen` = '" + obj[6] + "'\n"
                + "WHERE `intidprofesor` = " + obj[0] + "";
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EliminarProfesor(int id) {
        int r = 0;
        String Consul = "DELETE FROM tblprofesor WHERE intidprofesor=" + id;
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int InsertaAsignaProf(Object[] obj) {
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spinsertatblAsignaProf(?,?);");
                stm.setString(1, obj[0].toString());
                stm.setString(2, obj[1].toString()); 
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }

    public int EditaAsignaProf(Object[] obj) {
        int r = 0;
        String Consul = "UPDATE `bdcontrolescolar`.`tblasignaprofesores`\n"
                + "SET `intidasigna` = '" + obj[0] + "',\n"
                + "  `inidprofesor` = '" + obj[1] + "',\n"
                + "  `intidgrado` = '" + obj[2] + "'\n"
                + "WHERE `intidasigna` = '" + obj[0] + "'";
        try {
            Statement stm = cnn.createStatement();
            r = stm.executeUpdate(Consul);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return r;
        }
    }

    public int EliminaAsignaP(int mat) {
        int r = 0;
        String Consul = "DELETE\n"
                + "FROM `bdcontrolescolar`.`tblasignaprofesores`\n"
                + "WHERE `intidasigna` = '" + mat;
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
