package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cls_tblPeriodo {

    Connection cnn;

    public Cls_tblPeriodo() {
        cnn = Cnn.getConection();
    }

    public ResultSet getSelect() {
        ResultSet rs = null;
        try {
            Statement stm = cnn.createStatement();
            rs = stm.executeQuery("SELECT *FROM tblperiodo");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    
    public int inserta_periodo(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spinsertaperiodo(?);");
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
    
    public int edita_periodo(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spUpdateperiodo(?,?);");
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
    public int elimina_periodo(int id){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spEliminarperiodo("+id+");");

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
