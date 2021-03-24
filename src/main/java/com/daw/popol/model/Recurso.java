package com.daw.popol.model;
import java.util.Date;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Recurso {
    private int id;
    
    @NotEmpty
    @Size(max=35, message="El 'nombre' no puede superar los 35 caracteres")
    private String nombre;
    
    @NotEmpty
    @Size(max=25, message="El 'tipo' no puede superar los 25 caracteres")
    private String tipo;
    
    @NotEmpty
    @Size(max=255, message="La 'descripcion' no puede superar los 255 caracteres")
    private String descripcion;
    
    private int descargas;
    private int likes;
    private boolean privacidad; //true = privado | false = publico
    private String usuario; //Más adelante -> private Usuario usuario;
    private String ult_modific; //Utilizamos String para la fecha en el bean para
                                //facilitar la conversion con los atributos de la
                                //BBDD (fecha + hora) y mostrarlo adecuadamente

    public Recurso () {
        id=0;
        nombre="";
        tipo="";
        descripcion="";
        descargas=0;
        likes=0;
        privacidad=false;
        usuario="Desconocido";
        ult_modific=null;
    }
    
    public Recurso(int id, String nombre, String tipo, String descripcion, boolean privacidad, String usuario) {
        this.id=id;
        this.nombre=nombre;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.descargas=0;
        this.likes=0;
        this.privacidad=privacidad;
        this.usuario=usuario;
        this.ult_modific=null;
    }
    
    public Recurso(int id, String nombre, String tipo, String descripcion, int descargas, int likes, boolean privacidad, String usuario, String ult_modific) {
        this.id=id;
        this.nombre=nombre;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.descargas=descargas;
        this.likes=likes;
        this.privacidad=privacidad;
        this.usuario=usuario;
        this.ult_modific=ult_modific;
    }

    /**Copy constructor*/
    public Recurso(Recurso r) {
        this.id=r.id;
        this.nombre=r.nombre;
        this.tipo=r.tipo;
        this.descripcion=r.descripcion;
        this.descargas=r.descargas;
        this.likes=r.likes;
        this.privacidad=r.privacidad;
        this.usuario=r.usuario;
        this.ult_modific=r.ult_modific;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the dni to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the privacidad
     */
    public boolean isPrivacidad() {
        return privacidad;
    }

    /**
     * @param privacidad the socio to set
     */
    public void setPrivacidad(boolean privacidad) {
        this.privacidad = privacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUlt_modific(){
        return ult_modific;
    }
    
    public void setUlt_modific(String fecha){
        this.ult_modific = fecha;
    }
    
    public int getDescargas(){
        return descargas;
    }
    
    public void setDescargas(int descargas){
        this.descargas = descargas;
    }
    
    public int getLikes(){
        return likes;
    }
    
    public void setLikes(int likes){
        this.likes = likes;
    }
    
}
