package com.daw.popol.controller;

import com.daw.popol.Util;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daw.popol.model.Usuario;
import com.daw.popol.model.dao.UsuarioDAO;
import com.daw.popol.model.dao.UsuarioDAOJDBC;

@WebServlet("/usuarios/*")
public class UsuariosController extends HttpServlet {
    
    /**View files path*/
    private final String srvViewPath="/WEB-INF/usuarios";
    private UsuarioDAO usuarioDAO;
    private String srvUrl;
    private String imgUrl;
    private static final Logger Log= Logger.getLogger(UsuariosController.class.getName());

    
    @Override
    public void init(ServletConfig servletConfig ) throws ServletException {
        
        super.init(servletConfig);
        
        Log.info("Inicializando UsuariosController");
        
        //Servlet and image dir URLs for views' use
        srvUrl=servletConfig.getServletContext().getContextPath()+"/usuarios";
        imgUrl=servletConfig.getServletContext().getContextPath()+"/images";
        
        usuarioDAO=new UsuarioDAOJDBC();

    }
    
/**Common Request processing*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {		
        
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Expires","0"); //Avoid browser caching response

        request.setAttribute("imgUrl",imgUrl);
        request.setAttribute("srvUrl", srvUrl);
                
        
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method. Select Controller Views
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
        RequestDispatcher rd;

        //Detect current servlet action
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        
        Log.log(Level.INFO, "Petición GET {0}", action);
        
        Usuario u;
                
        switch (action) {
            
            //Registro de un nuevo usuario
            case "/register":
                u=new Usuario();
                request.setAttribute("usuario", u);
                rd=request.getRequestDispatcher(srvViewPath+"/register.jsp");
                break;
               
            //Mostrar perfil del usuario
            default: 
               
                String usuario = request.getRemoteUser();

                u = usuarioDAO.buscaUsuario(usuario);
                request.setAttribute("usuario", u);
                rd=request.getRequestDispatcher(srvViewPath+"/perfil.jsp");
        }
        rd.forward(request, response);
                
    }
    
    /**
     * Handles the HTTP
     * <code>POST</code> method for Creating and Saving Resources
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        //Detect current servlet action
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");

        Log.log(Level.INFO, "Petición POST {0}", action);        

        switch (action) {
            
            //Registrar un nuevo usuario
            case "/register":
                Usuario usu=new Usuario();
                if (validarUsuario(request,usu)) {
                    usuarioDAO.crea(usu); //Create new usuario
                    //Post-sent-redirect
                    //Mostrar su perfil
                    response.sendRedirect(srvUrl);
                } else { //Show form with validation errores
                    request.setAttribute("usuario", usu);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath+"/register.jsp");
                    rd.forward(request, response);
                }
                break;
                
            //Modificar el perfil del usuario
            default:
                String usuario = request.getRemoteUser();

                Usuario u = usuarioDAO.buscaUsuario(usuario);

                if (validarUsuario(request,u)) {
                    //Aactualizar datos Usuario
                    usuarioDAO.guarda(u);
                    
                    //Si hemos modificado el parámetro "usuario", volveremos a logearnos
                    if(!u.getUsuario().equals(usuario))response.sendRedirect("logout");
                    else response.sendRedirect(srvUrl);
                } else { //Show form with validation errores
                    request.setAttribute("usuario", u);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath+"/perfil.jsp");
                    rd.forward(request, response);
                }
        }
    }


/**Recopilar datos del formulario de creacion del usuario*/
    private boolean validarUsuario(HttpServletRequest request, Usuario u) {
        boolean valido=true;
        //Capturamos y convertimos datos
        String usuario=Util.getParam(request.getParameter("usuario"),"");
        String clave=Util.getParam(request.getParameter("clave"),"");
        String nombre=Util.getParam(request.getParameter("nombre"),"");
        String apellidos=Util.getParam(request.getParameter("apellidos"),"");
        String mail=Util.getParam(request.getParameter("mail"),"");
        int telefono=Integer.parseInt(Util.getParam(request.getParameter("telefono"),"0"));
        String pais=Util.getParam(request.getParameter("pais"),"");
        String ciudad=Util.getParam(request.getParameter("ciudad"),"");
        String web=Util.getParam(request.getParameter("web"),"");
        String hobbies=Util.getParam(request.getParameter("hobbies"),"");
        String fecha_crea=Util.getParam(request.getParameter("fecha_crea"),"");
       
        //Asignamos datos al bean
        u.setUsuario(usuario);
        u.setClave(clave);
        u.setNombre(nombre);
        u.setApellidos(apellidos);
        u.setMail(mail);
        u.setTelefono(telefono);
        u.setPais(pais);
        u.setCiudad(ciudad);
        u.setHobbies(hobbies);
        u.setWeb(web);
        u.setFecha_crea(fecha_crea);
        
        
        //Validamos Datos
        if(usuario.isEmpty()){
            request.setAttribute("errUsuario", "El 'usuario' no puede estar vacío");
            Log.log(Level.INFO, "Enviado Usuario de usuario no válido");        
            valido=false;
        } else if((usuarioDAO.buscaUsuario(usuario)!=null) && (!usuario.equals(request.getRemoteUser()))){
            //Si el usuario no esta repetido en la BBDD (y no somos nosotros)
            request.setAttribute("errUsuario", "El 'usuario' ya está registrado");
            Log.log(Level.INFO, "Enviado Usuario de usuario no válido");        
            valido=false;
        }
        
        if (usuario.length() > 50) {
            request.setAttribute("errUsuario", "El 'usuario' no puede superar los 50 caracteres");
            Log.log(Level.INFO, "Enviado Usuario de usuario no válido");        
            valido=false;
        }
        
        if(clave.isEmpty()){
            request.setAttribute("errClave", "La 'clave' no puede estar vacío");
            Log.log(Level.INFO, "Enviado Clave de usuario no válida");        
            valido=false;
        }
        
        if (clave.length() > 50) {
            request.setAttribute("errClave", "La 'clave' no puede superar los 50 caracteres");
            Log.log(Level.INFO, "Enviado Clave de usuario no válido");        
            valido=false;
        }
        
        if (nombre.length() > 30) {
            request.setAttribute("errNombre", "El 'nombre' no puede superar los 30 caracteres");
            Log.log(Level.INFO, "Enviado Nombre de usuario no válido");        
            valido=false;
        }
        
        if (apellidos.length() > 40) {
            request.setAttribute("errApellidos", "Los 'apellidos' no puede superar los 40 caracteres");
            Log.log(Level.INFO, "Enviado Apellidos de usuario no válido");        
            valido=false;
        }
        
        if (mail.length() > 40) {
            request.setAttribute("errMail", "El 'mail' no puede superar los 40 caracteres");
            Log.log(Level.INFO, "Enviado Mail de usuario no válido");        
            valido=false;
        }
        
        if (ciudad.length() > 20) {
            request.setAttribute("errCiudad", "La 'ciudad' no puede superar los 20 caracteres");
            Log.log(Level.INFO, "Enviado Ciudad de usuario no válido");        
            valido=false;
        }
        
        if (web.length() > 40) {
            request.setAttribute("errWeb", "La 'web' no puede superar los 40 caracteres");
            Log.log(Level.INFO, "Enviado Web de usuario no válido");        
            valido=false;
        }
        
        if (hobbies.length() > 300) {
            request.setAttribute("errHobbies", "Los 'Hobbies' no pueden superar los 300 caracteres");
            Log.log(Level.INFO, "Enviado Hobbies de usuario no válido");        
            valido=false;
        }
        
        return valido;
    }

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
    @Override
    public String getServletInfo() {
        return "Controlador del usuario";
    }// </editor-fold>

}
