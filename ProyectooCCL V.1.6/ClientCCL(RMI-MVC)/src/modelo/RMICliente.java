package modelo;

import InterfaceCCL.Operacion_InterfaceCCL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List; 

public class RMICliente {
    Operacion_InterfaceCCL objeto; 
    String serverAddres = "localhost";
    int serverPort = 3232;

    public RMICliente() {
        try {
            Registry registry = LocateRegistry.getRegistry(serverAddres, serverPort);
            objeto = (Operacion_InterfaceCCL) (registry.lookup("operacionServidor"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Object[]> Llenado(String opc) throws RemoteException{
        List<Object[]> listaAlumnos = objeto.getSelect(opc);
        return listaAlumnos;
    }
    
    public List<Object[]> Busca(String mat, String opc) throws RemoteException {
        List<Object[]> listaAlumno = objeto.getSelectBusca(mat, opc);
        return listaAlumno;
    }

    public int Insertar(Object[]obj, String opc) {
        int num = 0;
        try {        
            num = objeto.Insertar(obj,opc);
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }

    public int Editar(Object[]obj,String opc) {
        int num = 0;
        try {
            num = objeto.Editar(obj, opc);
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }

    public int Eliminar(int mat,String opc) {
        int num = 0;
        try {
            num = objeto.Eliminar(mat, opc);
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }

}
