package controlador;

public class Cls_reporte {
String matricula,nombre,curp,grupo,grado,periodo;

    public Cls_reporte(String matricula, String nombre, String curp, String grupo, String grado, String periodo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.curp = curp;
        this.grupo = grupo;
        this.grado = grado;
        this.periodo = periodo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

   

}
