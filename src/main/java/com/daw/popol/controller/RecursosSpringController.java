package com.daw.popol.controller;

import com.daw.popol.model.Recurso;
import com.daw.popol.model.dao.RecursoDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/recursos")
public class RecursosSpringController {

    @Autowired
    @Qualifier("RecursoDAOJDBC")
    private RecursoDAO recursoDAO;
    
    //Usuario que actualmente está logueado
    private String usuario_log;

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //Common variables for Views
        model.addAttribute("srvUrl", request.getContextPath() + request.getServletPath() + "/recursos");
        model.addAttribute("imgUrl", request.getContextPath() + "/images");
        usuario_log = request.getRemoteUser();
    }

    //METODOS GET
    //VISUALIZA EL INICIO
    @RequestMapping(value = {"", "/inicio"}, method = RequestMethod.GET)
    public String inicio(ModelMap model) {
        model.addAttribute("recursos", recursoDAO.buscaRecursosNoUsu(usuario_log));
        return "recursos/inicio";
    }

    //VISUALIZA UN RECURSO
    @RequestMapping(value = "/visualizar", method = RequestMethod.GET)
    public String visualizar(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        model.addAttribute("recurso", recursoDAO.buscaId(id));
        return "recursos/visualizar";
    }

    //BORRAR RECURSO
    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        
        //Podemos eliminar si somos propietarios del recurso
        if(usuario_log.equals(r.getUsuario())){
            recursoDAO.borra(id);
            model.clear();
            return "redirect:misrecursos";
        }else{
            model.addAttribute("recurso", r);
            return "recursos/visualizar";
        }
    }

    //FORMULARIO CREACIÓN DE RECURSO
    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(ModelMap model) {
        model.addAttribute("recurso", new Recurso());
        return "recursos/crear";
    }

    //LISTAR TODOS MIS RECURSOS
    @RequestMapping(value = "/misrecursos", method = RequestMethod.GET)
    public String misrecursos(ModelMap model) {
        //String usuario = request.getRemoteUser();
        List<Recurso> recursos = recursoDAO.buscaRecursosUsu(usuario_log);
        model.addAttribute("recursos", recursos);
        return "recursos/misrecursos";
    }

    //FORMULARIO EDICION DE RECURSO
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editar(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        model.addAttribute("recurso", r);
        
        //Podemos editar si es uno de nuestros recursos
        if(usuario_log.equals(r.getUsuario())){
            return "recursos/editar";
        }else{
            return "recursos/visualizar";
        }
    }

    @RequestMapping(value = "/descargar", method = RequestMethod.GET)
    public String descargar(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        if(!usuario_log.equals(r.getUsuario())) recursoDAO.descargar(r);
        return "redirect:visualizar?id="+r.getId();
    }

    //Descargar desde pantalla de inicio (desde listado)
    @RequestMapping(value = "/descargar_ini", method = RequestMethod.GET)
    public String descargar_ini(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        if(!usuario_log.equals(r.getUsuario())) recursoDAO.descargar(r);
        return "redirect:inicio";
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public String like(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        if(!usuario_log.equals(r.getUsuario())) recursoDAO.darLike(r);
        return "redirect:visualizar?id="+r.getId();
    }

    //Dar like desde pantalla de inicio (desde listado)
    @RequestMapping(value = "/like_ini", method = RequestMethod.GET)
    public String like_ini(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        Recurso r = recursoDAO.buscaId(id);
        if(!usuario_log.equals(r.getUsuario())) recursoDAO.darLike(r);
        return "redirect:inicio";
    }

    //METODOS POST
    //CREAR UN RECURSO
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    String crearRecurso(@ModelAttribute("recurso") @Valid Recurso r,
            BindingResult result,
            ModelMap model) {

        if (!result.hasErrors()) {
            r.setUsuario(usuario_log);
            recursoDAO.crea(r);
            return "redirect:visualizar?id="+r.getId();
        } else {
            //Show message form with original text and bean validation error message
            return "recursos/crear";
        }
    }

    //EDITAR UN RECURSO
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    String editarRecurso(@ModelAttribute("recurso") @Valid Recurso r,
            BindingResult result,
            ModelMap model) {
        
        if (!result.hasErrors()) {
            r.setUsuario(usuario_log);
            recursoDAO.guarda(r);
            //model.addAttribute("recurso", r);
            return "redirect:visualizar?id="+r.getId();
        } else {
            //Show message form with original text and bean validation error message
            return "recursos/editar";
        }
    }

}
