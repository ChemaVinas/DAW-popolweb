package com.daw.popol.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
    private int id;
    
    @NotEmpty
    @Size(max=50, message="El 'usuario' no puede superar los 50 caracteres")
    private String usuario; //Nick o nombre de usuario único en el sistema
    
    @NotEmpty
    @Size(max=50, message="La 'clave' no puede superar los 50 caracteres")
    private String clave;
    
    @Size(max=30, message="El 'nombre' no puede superar los 30 caracteres")
    private String nombre;
    
    @Size(max=40, message="Los 'apellidos' no puede superar los 40 caracteres")
    private String apellidos;
    
    @Size(max=40, message="El 'mail' no puede superar los 40 caracteres")
    private String mail;
    
    private int telefono;
    
    private String pais;
    
    @Size(max=20, message="La 'ciudad' no puede superar los 20 caracteres")
    private String ciudad;
    
    @Size(max=40, message="La 'web' no puede superar los 40 caracteres")
    private String web;
    
    @Size(max=255, message="Los 'hobbies' no pueden superar los 255 caracteres")
    private String hobbies;
    
    private String fecha_crea;  //Utilizamos String para la fecha en el bean para
                                //facilitar la conversion con los atributos de la
                                //BBDD (fecha + hora) y mostrarlo adecuadamente

    public Usuario () {
        id=0;
        usuario="";
        clave="";
        nombre="";
        apellidos="";
        mail="";
        telefono=666666666;
        pais="";
        ciudad="";
        web="";
        hobbies="";
        fecha_crea="";
    }
    
    public Usuario(int id, String usuario, String clave, String nombre, String apellidos, String mail, int telefono, String pais, String ciudad, String web, String hobbies, String fecha_crea) {
        this.id=id;
        this.usuario=usuario;
        this.apellidos=apellidos;
        this.ciudad=ciudad;
        this.clave=clave;
        this.fecha_crea=fecha_crea;
        this.hobbies=hobbies;
        this.mail=mail;
        this.pais=pais;
        this.web=web;
        this.telefono=telefono;
        this.nombre=nombre;
    }

    /**Copy constructor*/
    public Usuario(Usuario u) {
        this.id=u.id;
        this.usuario=u.usuario;
        this.apellidos=u.apellidos;
        this.ciudad=u.ciudad;
        this.clave=u.clave;
        this.fecha_crea=u.fecha_crea;
        this.hobbies=u.hobbies;
        this.mail=u.mail;
        this.pais=u.pais;
        this.web=u.web;
        this.telefono=u.telefono;
        this.nombre=u.nombre;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return the hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the fecha_crea
     */
    public String getFecha_crea() {
        return fecha_crea;
    }

    /**
     * @param fecha_crea the fecha_crea to set
     */
    public void setFecha_crea(String fecha_crea) {
        this.fecha_crea = fecha_crea;
    }
 
    
    
}