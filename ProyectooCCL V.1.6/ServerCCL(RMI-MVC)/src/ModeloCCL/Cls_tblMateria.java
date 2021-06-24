package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Cls_tblMateria {
    
    Connection cnn;
    int idmateria;
    String materia;

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    public Cls_tblMateria(){
        cnn=Cnn.getConection();
    }
    
    public String toString(){
        return this.materia;
    }
    
     public Vector<Cls_tblMateria> llenaComboMateria() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Cls_tblMateria> datosmateria = new Vector<Cls_tblMateria>();
        Cls_tblMateria dat = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblmaterias");
            dat = new Cls_tblMateria();
            dat.setIdmateria(0);
            dat.setMateria("Seleccione la materia:");
            datosmateria.add(dat);
            while (rs.next()) {
                dat = new Cls_tblMateria();
                dat.setIdmateria(rs.getInt("intidmaterias"));
                dat.setMateria(rs.getString("Materia"));
                datosmateria.add(dat);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datosmateria;
    }

    public ResultSet getSelect() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vw_materia");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet getSelectBusca(String grado) {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vw_materia WHERE vchGrado='" + grado + "' ");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
     public int inserta_materia(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spInsertaMateria(?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
    
    public int edita_grado(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spUpdateMateria(?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
    public int elimina_grado(int id){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spEliminarMateria("+id+");");

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
