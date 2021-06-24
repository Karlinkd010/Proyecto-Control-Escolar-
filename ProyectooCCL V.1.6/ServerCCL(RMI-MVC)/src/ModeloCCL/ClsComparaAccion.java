package ModeloCCL;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClsComparaAccion {

    Cls_ConsultasAlum alumno;
    Cls_ConsultasProf profe;
    Cls_tblAlumnosInscritos inscrito;
    Cls_tblGrados grado;
    Cls_tblPeriodo periodo;
    Cls_tblMateria materia;
    Cls_tblCalificaciones  calif;
    Cls_tblUsuario login;
    FrmAcciones area;
    public static String acum = "";
    public static int contador = 0;

    public ClsComparaAccion() throws RemoteException {
        alumno = new Cls_ConsultasAlum();
        profe = new Cls_ConsultasProf();
        inscrito = new Cls_tblAlumnosInscritos();
        grado = new Cls_tblGrados();
        periodo = new Cls_tblPeriodo();
        materia = new Cls_tblMateria();
        calif =new Cls_tblCalificaciones();
        login =new Cls_tblUsuario();
        
    }

    public int Insertar(Object[] obj, String opc) throws RemoteException {

        int r = 0;
        if (opc.equals("Alumno")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Alumno\n" + acum;
            return alumno.inserta_imagen(obj);
        }
        if (opc.equals("Profesor")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Profesor\n" + acum;
            return profe.InsertarProfesor(obj);
        }
        if (opc.equals("Inscrito")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Alumno tblInscrito\n" + acum;
            return inscrito.InsertarAlumnnoInscrito(obj);
        }
        if (opc.equals("Grado")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Grado\n" + acum;
            return grado.inserta_grado(obj);
        }
        if (opc.equals("Periodo")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Perido\n" + acum;
            return periodo.inserta_periodo(obj);
        }
        if (opc.equals("Materia")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Materia\n" + acum;
            return materia.inserta_materia(obj);
        }
        if (opc.equals("AsingaP")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta Profesor\n" + acum;
            return profe.InsertaAsignaProf(obj);
        }
        if (opc.equals("User")) {
            contador = contador + 1;
            acum = contador + ".-" + "Inserta User\n" + acum;
            return login.inserta_user(obj);
        }
        
        return r;
    }

    public int Editar(Object[] obj, String opc) throws RemoteException {
        int r = 0;
        if (opc.equals("Alumno")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Alumno\n" + acum;
            return alumno.edita_imagen(obj);

        }
        if (opc.equals("AlumnoSinFoto")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Alumno\n" + acum;
            return alumno.EditarAlumnno(obj);
        }
        if (opc.equals("Profesor")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Profesor\n" + acum;
            return profe.EditarProfesor(obj);
        }
        if (opc.equals("Inscrito")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Alumno Inscrito\n" + acum;
            return inscrito.EditarAlumnnoInscrito(obj);
        }
        if (opc.equals("Grado")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Grado\n" + acum;
            return grado.edita_grado(obj);
        }
        if (opc.equals("Periodo")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Periodo\n" + acum;
            return periodo.edita_periodo(obj);
        
        }
        if (opc.equals("Materia")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Materia\n" + acum;
            return periodo .edita_periodo(obj);
        
        }
        if (opc.equals("AsingaP")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita Profesor\n" + acum;
            return profe.EditaAsignaProf(obj);
        }
        if (opc.equals("User")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita User\n" + acum;
            return login.edita_user(obj);
        }
        if (opc.equals("UserPassword")) {
            contador = contador + 1;
            acum = contador + ".-" + "Edita User\n" + acum;
            return login.edita_Password(obj);
        }

        return r;
    }

    public int Eliminar(int id, String opc) throws RemoteException {
        int r = 0;
        if (opc.equals("Alumno")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina Alumno\n" + acum;
            return alumno.EliminarAlumno(id);
        }
        if (opc.equals("Profesor")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina  Profesor\n" + acum;
            return profe.EliminarProfesor(id);
        }
        if (opc.equals("Inscrito")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina Alumno Inscrito\n" + acum;
            return inscrito.EliminarAlumnnoInscrito(id);
        }
        if (opc.equals("Grado")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina Grado\n" + acum;
            return grado.elimina_grado(id);
        }
        if (opc.equals("Periodo")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina Periodo\n" + acum;
            return periodo.elimina_periodo(id);
        }
        if (opc.equals("AsingaP")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina Pr\n" + acum;
            return profe.EliminaAsignaP(id);
        }
        if (opc.equals("User")) {
            contador = contador + 1;
            acum = contador + ".-" + "Elimina User\n" + acum;
            return login.elimina_user(id);
        }

        return r;
    }

    public List<Object[]> consultas(String opc) throws RemoteException {
        List<Object[]> lista = null;
        if (opc.equals("Reporte")) {
            contador = contador + 1;
            acum = contador + ".-" + "Reporte\n" + acum;
        }
        if(opc.equals("Alumno")) {//Cosnulta Alumnos
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Alumno\n" + acum;
            ResultSet rs = alumno.getSelect();
            Object[] x = null;

            int tel;
            String matricula, Nombre, curp, fechanacimiento, cooreo, fechaingrso;

            byte datos[] = new byte[1000000];

            try {
                lista = new ArrayList();
                while (rs.next()) {
                    matricula = rs.getString("vchMatricula");
                    Nombre = rs.getString("vchNombre");
                    curp = rs.getString("vchCurp");
                    fechanacimiento = rs.getString("vchFechaNac");
                    tel = rs.getInt("vchTel");
                    cooreo = rs.getString("vchCorreo");
                    fechaingrso = rs.getString("dtFechaIngreso");
                    datos = rs.getBytes("vchimagen");
                    x = new Object[]{matricula, Nombre, curp, fechanacimiento, tel, cooreo, fechaingrso, datos};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        } else if (opc.equals("Profesor")) {///Consulta Profesores
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Profesor\n" + acum;
            ResultSet rs = profe.getSelectProfesores();
            Object[] x = null;

            int id;
            String nombre, direccion, telefono, mail, rut,grado;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    id = rs.getInt("intidprofesor");
                    nombre = rs.getString("Nombre");
                    direccion = rs.getString("Direccion");
                    telefono = rs.getString("Telefono");
                    mail = rs.getString("email");
                    rut = rs.getString("ruta");
                    grado = rs.getString("vchGrado");
                    x = new Object[]{id, nombre, direccion, telefono, mail, rut,grado};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        } else if (opc.equals("Inscrito")) {///Consulta tblAsigna
            contador = contador + 1;

            acum = contador + ".-" + "Consulta Alumnos Inscritos\n" + acum;
            ResultSet rs = inscrito.getSelectInscritos();
            Object[] x = null;

            int periodo, id;
            Date fecha;
            String matricula, nombre, curp, grupo, grado;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    id = rs.getInt("intidinscritos");
                    matricula = rs.getString("vchMatricula");
                    nombre = rs.getString("vchNombre");
                    curp = rs.getString("vchCurp");
                    grupo = rs.getString("chrgrupo");
                    grado = rs.getString("vchGrado");
                    periodo = rs.getInt("periodo");
                    fecha = rs.getDate("fechainscripcion");
                    x = new Object[]{id, matricula, nombre, curp, grupo, grado, periodo, fecha};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        } else if (opc.equals("Grado")) {///Consulta Grados
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Grados\n" + acum;
            ResultSet rs = grado.getSelect();
            Object[] x = null;

            int idGrupo;
            String Grupo;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    idGrupo = rs.getInt("intidgrado");
                    Grupo = rs.getString("vchGrado");
                    x = new Object[]{idGrupo, Grupo};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        } else if (opc.equals("Periodo")) {///Consulta Periodo
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Periodo\n" + acum;
            ResultSet rs = periodo.getSelect();
            Object[] x = null;

            int idperiodo;
            String periodo;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    idperiodo = rs.getInt("intidperiodo");
                    periodo = rs.getString("periodo");
                    x = new Object[]{idperiodo, periodo};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }else if (opc.equals("Materia")) {///Consulta Periodo
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Materia\n" + acum;
            ResultSet rs = materia.getSelect();
            Object[] x = null;

            int id;
            String materia,grado;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    id=rs.getInt("intidmaterias");
                    materia = rs.getString("Materia");
                    grado = rs.getString("vchGrado");
                    x = new Object[]{id,materia,grado};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }else if (opc.equals("Login")) {///Consulta Periodo
            contador = contador + 1;
            acum =  contador+".-" + "Consulta Usuarios\n"+acum;
            ResultSet rs = login.getSelect();
            Object[] x = null;

            int id;
            String tipo,usuario,contrase;
     
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    usuario = rs.getString("USUARIO");
                    contrase=rs.getString("CONTRASEÑA");
                    tipo =rs.getString("TIPO");     
                    
                    x = new Object[]{id,usuario,contrase,tipo};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }else if (opc.equals("ConsultaCal")) {///Consulta Periodo
            contador = contador + 1;
            acum =  contador+".-" + "Consulta Calificacion\n"+acum;
            ResultSet rs = calif.Consulta();
            Object[] x = null;
            String mat,nombre,gra,per;
            try {
                lista = new ArrayList();
                while (rs.next()) {
                    mat = rs.getString("vchMatricula");
                    nombre = rs.getString("vchNombre");
                    gra=rs.getString("vchGrado");
                    per =rs.getString("periodo");      
                    x = new Object[]{mat,nombre,gra,per};
                    lista.add(x);
                    Object[] y = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }

        return lista;
    }
    
    
    
    
    
    
    
    
    
    

    ////Busca
    public List<Object[]> buscar(String busca, String opc) throws RemoteException {
        List<Object[]> listabusca = null;
        if (opc.equals("Reporte")) {
            contador = contador + 1;
            acum = contador + ".-" + "Reporte\n" + acum;
            profe.getSelectProfesor(opc);
        }if (opc.equals("BuscaAlumnos")) {
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Alumnos Inscritos\n" + acum;
            ResultSet rs = alumno.BuscaAlumno(busca);
            Object[] x = null;
            
            int tel;
            String matricula, Nombre, curp, fechanacimiento, cooreo, fechaingrso;

            byte datos[] = new byte[1000000];

            try {
                listabusca = new ArrayList();
                if(rs.next()) {

                    matricula = rs.getString("vchMatricula");
                    Nombre = rs.getString("vchNombre");
                    curp = rs.getString("vchCurp");
                    fechanacimiento = rs.getString("vchFechaNac");
                    tel = rs.getInt("vchTel");
                    cooreo = rs.getString("vchCorreo");
                    fechaingrso = rs.getString("dtFechaIngreso");
                    datos = rs.getBytes("vchimagen");
                    
                     x = new Object[]{matricula, Nombre, curp, fechanacimiento, tel, cooreo, fechaingrso, datos};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }else{
                        JOptionPane.showMessageDialog(null, "Mátricula No Existe "+busca);
                        }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        }

        if (opc.equals("Alumno")) {
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Alumno\n" + acum;
            ResultSet rs = alumno.ConsultaImagen(busca);
            Object[] x = null;

            byte datos[] = new byte[1000000];

            try {
                listabusca = new ArrayList();
                while (rs.next()) {

                    datos = rs.getBytes("vchimagen");
                    x = new Object[]{datos};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        }if (opc.equals("BuscaMateria")) {
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Grado\n" + acum;
            ResultSet rs = materia.getSelectBusca(busca);
            Object[] x = null;

            try {
                listabusca = new ArrayList();
                while (rs.next()) {

                    String id = rs.getString("intidmaterias");
                   String materia= rs.getString("Materia");
                    String grado = rs.getString("vchGrado");
                    x = new Object[]{id,materia,grado};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        } 
         if (opc.equals("Profesor")) {
            contador = contador + 1;
            acum = acum + contador + ".-" + "Consulta Buscador Profesor\n";
            ResultSet rs = profe.ConsultaImagen(busca);
            Object[] x = null;
            String img;
            try {
                listabusca = new ArrayList();
                while (rs.next()) {
                   
                    img = rs.getString("Imagen");
                    x = new Object[]{img};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }if (opc.equals("BuscaAlumnosGrado")) {
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Alumnos Inscritos\n" + acum;
            ResultSet rs = inscrito.getSelectInscritosBusca(busca);
            Object[] x = null;
            try {
                listabusca = new ArrayList();
                while (rs.next()) {

                    String id = rs.getString("intidinscritos");
                   String matri= rs.getString("vchMatricula");
                    String nom = rs.getString("vchNombre");
                    String curp = rs.getString("vchCurp");
                    String grupo = rs.getString("chrgrupo");
                    String grado = rs.getString("vchGrado");
                    String periodo = rs.getString("periodo");
                    String fecha = rs.getString("fechainscripcion");
                    
                    x = new Object[]{id,matri,nom,curp,grupo,grado,periodo,fecha};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        }if (opc.equals("ConsultaCalificacion")) {
            contador = contador + 1;
            acum = contador + ".-" + "Consulta Calificacion\n" + acum;
            ResultSet rs = inscrito.ConsultaCalificacion(busca);
            Object[] x = null;
            byte datos[] = new byte[1000000];
            try {
                listabusca = new ArrayList();
                while (rs.next()) {  
                   String matri= rs.getString("vchMatricula");
                    String nom = rs.getString("vchNombre");
                    String grupo = rs.getString("chrgrupo");
                    String grado = rs.getString("vchGrado");
                    String periodo = rs.getString("periodo");
                    datos = rs.getBytes("vchimagen");
                    
                    x = new Object[]{matri,nom,grado,grupo,periodo,datos};
                    listabusca.add(x);
                    Object[] y = listabusca.get(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");

        }
        return listabusca;
    }
}
