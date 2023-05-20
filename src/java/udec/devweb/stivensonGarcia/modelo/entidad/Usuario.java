package udec.devweb.stivensonGarcia.modelo.entidad;
/*
autor: Stivenson Garcia Romero
*/
public class Usuario {
    private int cc;
    private String pass;
    private String nombre;
    private String apellido;
    private String genero;
    private String email;

    public Usuario(int id, String nombre1) {
    }

    public Usuario(int cc, String pass, String nombre, String apellido, String genero, String email) {
        this.cc = cc;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
