package InterfaceCCL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Operacion_InterfaceCCL extends Remote { 
    public List<Object[]> getSelect(String opc) throws RemoteException;
    public List<Object[]> getSelectBusca(String name, String opc) throws RemoteException;
    public int Insertar(Object[]Inserta, String opc) throws RemoteException;
    public int Editar(Object[]Editar,String opc) throws RemoteException;
    public int Eliminar(int id,String opc) throws RemoteException;  
}

