package com.daw.popol.controller;

import com.daw.popol.model.Usuario;
import com.daw.popol.model.dao.UsuarioDAO;
import com.daw.popol.model.dao.PaisesDAO;
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
@RequestMapping("/usuarios")
public class UsuariosSpringController {

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Autowired
    private PaisesDAO paisesDAO;

    //Usuario que actualmente está logueado
    private String usuario_log;

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //Common variables for Views
        model.addAttribute("srvUrl", request.getContextPath() + request.getServletPath() + "/usuarios");
        model.addAttribute("imgUrl", request.getContextPath() + "/images");
        usuario_log = request.getRemoteUser();
    }

    //METODOS GET
    //REGISTRO DE UN NUEVO USUARIO
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/register";
    }

    //MOSTRAR PERFIL DE USUARIO (LOGUEADO)
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(ModelMap model) {
        model.addAttribute("usuario", usuarioDAO.buscaUsuario(usuario_log));
        model.addAttribute("paises", paisesDAO.buscaTodos().toArray());
        return "usuarios/perfil";
    }
    
    //MOSTRAR DATOS DE USUARIO
    @RequestMapping(value = "/visualizar", method = RequestMethod.GET)
    public String visualizar(@RequestParam(value="usuario")String usuario,
                            ModelMap model) {
        model.addAttribute("usuario", usuarioDAO.buscaUsuario(usuario));
        return "usuarios/visualizar";
    }
    
    //ELIMINAR DE LA BBDD O DESUSCRIBIR USUARIO
    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String desuscripcion(@RequestParam(value = "id", required = true) Integer id,
            ModelMap model) {
        usuarioDAO.borra(id);
        model.clear();
        return "redirect:/logout";
    }

    //METODOS POST
    //REGISTRAR UN NUEVO USUARIO
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    String crearUsuario(@ModelAttribute("usuario") @Valid Usuario u,
            BindingResult result,
            ModelMap model) {

        if (!result.hasErrors()) {
            //Comprobamos si el usuario_log ya está en la base de datos
            if((usuarioDAO.buscaUsuario(u.getUsuario())!=null) && (!u.getUsuario().equals(usuario_log))){
                result.rejectValue("usuario", "'usuario' ya en la BBDD", "El 'usuario' ya está registrado");
                return "usuarios/register";
            }else{
                usuarioDAO.crea(u);
                //model.addAttribute("usuario_log", u);
                return "redirect:/main/recursos";
            }
        } else {
            //Show message form with original text and bean validation error message
            return "usuarios/register";
        }
    }

    //MODIFICAR PERFIL DE USUARIO
    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    String editarUsuario(@ModelAttribute("usuario") @Valid Usuario u,
            BindingResult result,
            ModelMap model) {
        
        u.setId(usuarioDAO.buscaUsuario(usuario_log).getId());
        if (!result.hasErrors()) {
            //Comprobamos si el usuario_log ya está en la base de datos
            if((usuarioDAO.buscaUsuario(u.getUsuario())!=null) && (!u.getUsuario().equals(usuario_log))){
                result.rejectValue("usuario", "'usuario' ya en la BBDD", "El 'usuario' ya está registrado");
                model.addAttribute("paises", paisesDAO.buscaTodos().toArray());
                return "usuarios/perfil";
            }else{
                usuarioDAO.guarda(u);
                if(!u.getUsuario().equals(usuario_log)) return "redirect:/logout";
                else return "redirect:perfil";
            }
        } else {
            //Show message form with original text and bean validation error message
            model.addAttribute("paises", paisesDAO.buscaTodos().toArray());
            return "usuarios/perfil";
        }
    }

}
