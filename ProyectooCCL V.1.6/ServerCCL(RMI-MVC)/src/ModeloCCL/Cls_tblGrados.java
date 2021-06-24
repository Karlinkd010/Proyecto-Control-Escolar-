package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Cls_tblGrados {

    Connection cnn;
    int idgrado;
    String grado;

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Cls_tblGrados() {
        cnn = Cnn.getConection();
    }

    public String toString() {
        return this.grado;
    }

    public Vector<Cls_tblGrados> llenaComboGrados() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Cls_tblGrados> datosgrado = new Vector<Cls_tblGrados>();
        Cls_tblGrados dat = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblgrados");
            dat = new Cls_tblGrados();
            dat.setIdgrado(0);
            dat.setGrado("Seleccione el Grado");
            datosgrado.add(dat);
            while (rs.next()) {
                dat = new Cls_tblGrados();
                dat.setIdgrado(rs.getInt("intidgrado"));
                dat.setGrado(rs.getString("vchGrado"));
                datosgrado.add(dat);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datosgrado;
    }

    public ResultSet getSelect() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblgrados");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
     public int inserta_grado(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spInsertaGrado(?);");
                stm.setString(1, objeto[0].toString());   
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
            
                stm = cnn.prepareStatement("CALL spUpdategrado(?,?);");
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
            
                stm = cnn.prepareStatement("CALL spEliminargrado("+id+");");

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
