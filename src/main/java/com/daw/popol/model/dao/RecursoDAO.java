package com.daw.popol.model.dao;

import com.daw.popol.model.Recurso;
import java.util.List;

public interface RecursoDAO extends GenericDAO<Recurso,Integer>{
    public List<Recurso> buscaRecursosUsu(String usuario);
    public List<Recurso> buscaRecursosNoUsu(String usuario);
    public boolean descargar(Recurso r);
    public boolean darLike(Recurso r);
}
