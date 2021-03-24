package com.daw.popol.model.dao;

import com.daw.popol.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario,Integer>{
    public Usuario buscaUsuario(String usuario);
}
