/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udec.devweb.stivensonGarcia.modelo.entidad;

/*
autor: Stivenson Garcia Romero
*/
public class Cancion {
    private int id;
    private String nombre;
    private String ritmo;
    private String duracion;
    private String album;
    private String posicionEnAlbum;
    private String banda;
    private String interprete;
    private String autor;
    private String fechaLanzamiento;
    private int usuariocc;

   

    public Cancion(int id, String nombre, String ritmo, String duracion, String album, String posicionEnAlbum, String banda, String interprete, String autor, String fechaLanzamiento, int usuarioCc) {
        this.id = id;
        this.nombre = nombre;
        this.ritmo = ritmo;
        this.duracion = duracion;
        this.album = album;
        this.posicionEnAlbum = posicionEnAlbum;
        this.banda = banda;
        this.interprete = interprete;
        this.autor = autor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.usuariocc = usuarioCc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPosicionEnAlbum() {
        return posicionEnAlbum;
    }

    public void setPosicionEnAlbum(String posicionEnAlbum) {
        this.posicionEnAlbum = posicionEnAlbum;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    
    public int getUsuariocc() {
        return usuariocc;
    }

    public void setUsuariocc(int usuariocc) {
        this.usuariocc = usuariocc;
    }
   
}

