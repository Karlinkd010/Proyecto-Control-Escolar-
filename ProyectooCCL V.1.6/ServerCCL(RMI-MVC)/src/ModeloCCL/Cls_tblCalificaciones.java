
package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Cls_tblCalificaciones {
    Connection cnn;
   public Cls_tblCalificaciones() {
        cnn = Cnn.getConection();
    }

    
    
    public ResultSet Consulta() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM vw_tblcalificaciones");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public int inserta_calificaciones(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spInsertaCalificaciones(?);");
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
    public int edita_Calificaciones(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spUpdateCalificaciones(?,?);");
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
    
    public int elimina_calificaciones(int id){
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
