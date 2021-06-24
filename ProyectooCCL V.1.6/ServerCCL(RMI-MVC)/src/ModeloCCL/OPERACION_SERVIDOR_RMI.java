package ModeloCCL;

import InterfaceCCL.Operacion_InterfaceCCL;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JOptionPane;

public class OPERACION_SERVIDOR_RMI extends UnicastRemoteObject implements Operacion_InterfaceCCL {

    private static final long serialversionUID = 9061868373895430621L;
    private final int PUERTO = 3232;

    ClsComparaAccion clase;
    FrmAcciones Accion;

    public OPERACION_SERVIDOR_RMI() throws RemoteException {
        clase = new ClsComparaAccion();
        Accion = new FrmAcciones();
    }

    public static void main(String[] args) throws Exception {
        (new OPERACION_SERVIDOR_RMI()).iniciarservidor();
    }

    public void iniciarservidor() {
        try {
            Accion = new FrmAcciones();
            Accion.setVisible(true);
            String dirip = (InetAddress.getLocalHost()).toString();
            Accion.Escucha.setText("Conectado..Escuchando en.... " + dirip + ":" + PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.bind("operacionServidor", (Operacion_InterfaceCCL) this);
        } catch (UnknownHostException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Object[]> getSelect(String opc) throws RemoteException {
        List<Object[]> lista = null;

        Accion.txtArea.setText(clase.acum);

        return lista = clase.consultas(opc);

    }

    @Override
    public List<Object[]> getSelectBusca(String name, String opc) throws RemoteException {
        List<Object[]> lista = null;
        Accion.txtArea.setText(clase.acum);
        return lista = clase.buscar(name, opc);
    }

    @Override
    public int Insertar(Object[] obj, String opc) throws RemoteException {
        Accion.txtArea.setText(clase.acum);

        return clase.Insertar(obj, opc);
    }

    @Override
    public int Editar(Object[] obj, String opc) throws RemoteException {
        Accion.txtArea.setText(clase.acum);
        return clase.Editar(obj, opc);
    }

    @Override
    public int Eliminar(int id, String opc) throws RemoteException {
        Accion.txtArea.setText(clase.acum);
        return clase.Eliminar(id, opc);
    }

}
