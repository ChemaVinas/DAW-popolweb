package com.daw.popol.controller;

import com.daw.popol.model.Recurso;
import com.daw.popol.Util;
import com.daw.popol.model.dao.RecursoDAOList;
import java.util.Date;


import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daw.popol.model.dao.RecursoDAO;
import com.daw.popol.model.dao.RecursoDAOJDBC;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

@WebServlet("/recursos/*")
@ServletSecurity(@HttpConstraint(rolesAllowed={"USUARIOS","ADMINISTRADORES"}))
public class RecursosController extends HttpServlet {
    
    /**View files path*/
    private final String srvViewPath="/WEB-INF/recursos";
    private RecursoDAO recursoDAO;
    private String srvUrl;
    private String imgUrl;
    private static final Logger Log= Logger.getLogger(RecursosController.class.getName());

    
    @Override
    public void init(ServletConfig servletConfig ) throws ServletException {
        
        super.init(servletConfig);
        
        Log.info("Inicializando RecursosController");
        
        //Servlet and image dir URLs for views' use
        srvUrl=servletConfig.getServletContext().getContextPath()+"/recursos";
        imgUrl=servletConfig.getServletContext().getContextPath()+"/images";
        
        //Select DAO Implementation
        //recursoDAO=new RecursoDAOList();
        recursoDAO=new RecursoDAOJDBC();

    }
    
/**Common Request processing*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	if(request.authenticate(response)!=true)return; //Forzar autentificación		
        
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
                
        String usuario = request.getRemoteUser();
        
        switch (action) {
            case "/visualizar": {    //VISUALIZA UN RECURSO
                int id=Integer.parseInt(request.getParameter("id"));
                Recurso r = recursoDAO.buscaId(id);
                request.setAttribute("recurso", r);
                rd=request.getRequestDispatcher(srvViewPath+"/visualizar.jsp");
                break;
            }
            case "/eliminar":  {       //BORRAR RECURSO
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                if (id>0) recursoDAO.borra(id);
                response.sendRedirect(srvUrl+"/misrecursos");
                return;
            }
            case "/crear":  {        //FORMULARIO CREACIÓN DE RECURSO
                Recurso r=new Recurso();
                request.setAttribute("recurso", r);
                rd=request.getRequestDispatcher(srvViewPath+"/crear.jsp");
                break;
            }
            case "/misrecursos": {  //LISTAR TODOS MIS RECURSOS
                List<Recurso> recursos = recursoDAO.buscaRecursosUsu(usuario);
                request.setAttribute("recursos", recursos);
                rd=request.getRequestDispatcher(srvViewPath+"/misrecursos.jsp");
                break;
            }
            case "/editar": {        //FORMULARIO EDICION DE RECURSO
                Recurso r;
                //Cargar Recurso seleccionado
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                r=recursoDAO.buscaId(id);
                //Formulario de edición
                request.setAttribute("recurso", r);
                rd=request.getRequestDispatcher(srvViewPath+"/editar.jsp");
                break;
            }
            case "/descargar": {
                Recurso r;
                //Cargar Recurso seleccionado
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                r=recursoDAO.buscaId(id);
                recursoDAO.descargar(r);
                request.setAttribute("recurso", r);
                rd=request.getRequestDispatcher(srvViewPath+"/visualizar.jsp");
                break;
            }
            case "/descargar_ini": {
                Recurso r;
                //Cargar Recurso seleccionado
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                r=recursoDAO.buscaId(id);
                recursoDAO.descargar(r);
                response.sendRedirect(srvUrl);
                return;
            }
            case "/like": {
                Recurso r;
                //Cargar Recurso seleccionado
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                r=recursoDAO.buscaId(id);
                recursoDAO.darLike(r);
                request.setAttribute("recurso", r);
                rd=request.getRequestDispatcher(srvViewPath+"/visualizar.jsp");
                break;
            }
            case "/like_ini": {
                Recurso r;
                //Cargar Recurso seleccionado
                int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
                r=recursoDAO.buscaId(id);
                recursoDAO.darLike(r);
                response.sendRedirect(srvUrl);
                return;
            }
            default: {          //MOSTRAR INICIO CON TODOS LOS RECURSOS
                List<Recurso> recursos = recursoDAO.buscaRecursosNoUsu(usuario);
                request.setAttribute("recursos", recursos);
                rd=request.getRequestDispatcher(srvViewPath+"/inicio.jsp");
                break;
            }

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
            case "/crear": {     //ACREAR UN RECURSO
                Recurso r=new Recurso();
                if (validarRecurso(request,r)) {
                    recursoDAO.crea(r); //Create new recurso
                    //Post-sent-redirect
                    response.sendRedirect(srvUrl+"/visualizar?id="+r.getId());
                } else { //Show form with validation errores
                    request.setAttribute("recurso", r);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath+"/crear.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            case "/editar": {    //EDITAR UN RECURSO
                Recurso r=new Recurso();
                if (validarRecurso(request,r)) {
                    //Aactualizar datos Recurso
                    recursoDAO.guarda(r);
                    response.sendRedirect(srvUrl+"/visualizar?id="+r.getId());
                } else { //Show form with validation errores
                    request.setAttribute("recurso", r);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath+"/editar.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            default:{ // Default POST
                response.sendRedirect(srvUrl);        
                break;
            }
        }
    }


/**Recopilar datos del formulario de creacion del recurso*/
    private boolean validarRecurso(HttpServletRequest request, Recurso r) {
        boolean valido=true;
        //Capturamos y convertimos datos
        int id=Integer.parseInt(Util.getParam(request.getParameter("id"),"0"));
        String nombre=Util.getParam(request.getParameter("nombre"),"");
        String tipo=Util.getParam(request.getParameter("tipo"),"");
        boolean privacidad=Util.getParamBool(request.getParameter("privacidad"));
        String descripcion=Util.getParam(request.getParameter("descripcion"),"");
        String usuario=request.getRemoteUser();
        
        /*Recurso r1 = recursoDAO.buscaId(id);
        if(r1 != null){
            r.setDescargas(r1.getDescargas());
            r.setLikes(r1.getLikes());
        }*/
        
        //Asignamos datos al bean
        r.setId(id);
        r.setNombre(nombre);
        r.setTipo(tipo);
        r.setPrivacidad(privacidad);
        r.setDescripcion(descripcion);
        r.setUsuario(usuario);
        r.setUlt_modific(new Date().toString());
        
        
        //Validamos Datos
        if (nombre.isEmpty()) {
            request.setAttribute("errNombre", "El 'nombre' no puede estar vacío");
            Log.log(Level.INFO, "Enviado Nombre de recurso no válido");        
            valido=false;
        }
        if (nombre.length() > 35) {
            request.setAttribute("errNombre", "El 'nombre' no puede superar los 35 caracteres");
            Log.log(Level.INFO, "Enviado Nombre de recurso no válido");        
            valido=false;
        }
        if (tipo.isEmpty()) {
            request.setAttribute("errTipo", "El 'tipo' no puede estar vacío");
            Log.log(Level.INFO, "Enviado Tipo de recurso no válido");        
            valido=false;
        }
        if (tipo.length() > 25) {
            request.setAttribute("errTipo", "El 'tipo' no puede superar los 25 caracteres");
            Log.log(Level.INFO, "Enviado Tipo de recurso no válido");        
            valido=false;
        }
        if (descripcion.isEmpty()) {
            request.setAttribute("errDescripcion", "La 'descripción' no puede estar vacía");
            Log.log(Level.INFO, "Enviado Descripción de recurso no válido");        
            valido=false;
        }
        if (descripcion.length() > 300) {
            request.setAttribute("errDescripcion", "La 'descripción' no puede superar los 300 caracteres");
            Log.log(Level.INFO, "Enviado Descripción de recurso no válido");        
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
        return "Controlador del recurso";
    }// </editor-fold>

}
