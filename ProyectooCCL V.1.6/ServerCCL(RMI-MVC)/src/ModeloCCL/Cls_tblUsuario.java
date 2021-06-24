

package ModeloCCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Cls_tblUsuario {
    
    Connection cnn;
    
    public Cls_tblUsuario(){
        cnn=Cnn.getConection();
    }
    
     public ResultSet getSelect() {
        ResultSet rs = null;
        try {
            Statement stm = (Statement) cnn.createStatement();
            
            rs = stm.executeQuery("CALL spListausuarios");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
      public int inserta_user(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("call spinsertaUser(?,?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());  
                stm.setString(3, objeto[2].toString());  
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
    
    public int edita_user(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spupdateUser(?,?,?);");
                stm.setString(1, objeto[0].toString());
                stm.setString(2, objeto[1].toString());
                stm.setString(3, objeto[2].toString());
                r = stm.executeUpdate();
       }catch(SQLException e)
       {
           System.out.println(e);
       }
       finally{
           return r;
       }
    }
    public int edita_Password(Object objeto[]){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spupdateUserPaswword(?,?);");
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
    public int elimina_user(int id){
        int r=0;  
        
       try{  
          PreparedStatement stm;
            
                stm = cnn.prepareStatement("CALL spEliminarusuario("+id+");");

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
