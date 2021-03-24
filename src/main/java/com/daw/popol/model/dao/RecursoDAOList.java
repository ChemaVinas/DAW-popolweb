package com.daw.popol.model.dao;

import com.daw.popol.model.Recurso;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/*Sample DAO implementation using an ArrayList of Objects in memory*/
public class RecursoDAOList implements RecursoDAO{

    private static ArrayList<Recurso> recursos=null;
    private static int idRecurso = 1;

    public RecursoDAOList() {
        if (recursos == null) {
            recursos = new ArrayList<>();

            recursos.add(new Recurso(   idRecurso++, 
                                        "Textura árbol", 
                                        "Texturas", 
                                        "Textura en 2D para el modelado de un árbol.",
                                        false,
                                        "Jose7pc"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Sonido ambiente bosque", 
                                        "Efectos de sonido", 
                                        "Fichero .mp3 que contiene sonidos relacionados con el ambiente del bosque: viento, movimientos de hojas, cantos de pájaros y agua de un río.",
                                        false,
                                        "jmvm0014"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Modelado árbol en 3D", 
                                        "Modelados 3D", 
                                        "Modelo en 3D (.obj) para construir un árbol. Contiene 500.000 de vértices.",
                                        true,
                                        "Jose7pc"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Leñador", 
                                        "Modelados 3D", 
                                        "Modelo en 3D (.obj) de un leñador.",
                                        false,
                                        "Fulanito"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Hacha", 
                                        "Modelados 3D", 
                                        "Hacha de leñador. Un poco desgastada.",
                                        false,
                                        "Fulanito"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Sonido del hacha", 
                                        "Efectos de sonido", 
                                        "Sonido de un hacha al cortar la madera.",
                                        false,
                                        "jmvm0014"));
            
            recursos.add(new Recurso(   idRecurso++, 
                                        "Bosque", 
                                        "Escenario", 
                                        "Escenario que simula un bosque.",
                                        false,
                                        "Jose7pc"));
            
            recursos.get(0).setUlt_modific(new Date().toString());
            recursos.get(1).setUlt_modific(new Date().toString());
            recursos.get(2).setUlt_modific(new Date().toString());
            recursos.get(3).setUlt_modific(new Date().toString());
            recursos.get(4).setUlt_modific(new Date().toString());
            recursos.get(5).setUlt_modific(new Date().toString());
            recursos.get(6).setUlt_modific(new Date().toString());
        }
    }
    
    @Override
    public Recurso buscaId(Integer id) {
        Recurso encontrado=null;
        for (Recurso r: recursos) {
               if (r.getId()==id) encontrado=r;
        }
        return encontrado;
    }
    
    @Override
    public List<Recurso> buscaTodos() {
        return recursos;
    }
    
    @Override
    public List<Recurso> buscaRecursosUsu(String usuario){
        ArrayList<Recurso> recursosUsu=new ArrayList<>();
        for(Recurso r: recursos){
            if(r.getUsuario().equals(usuario)) recursosUsu.add(r);
        }
        return recursosUsu;
    }
    
    @Override
    public List<Recurso> buscaRecursosNoUsu(String usuario){
        ArrayList<Recurso> recursosPubl=new ArrayList<>();
        for(Recurso r: recursos){
            if(!r.getUsuario().equals(usuario) && !r.isPrivacidad()) recursosPubl.add(r);
        }
        return recursosPubl;
    }

    @Override
    public boolean crea(Recurso r) {
        Recurso nr=new Recurso(r);
        nr.setId(idRecurso);
        recursos.add(0, nr);
        r.setId(idRecurso);
        idRecurso++;
        return true;
    }
        
    @Override
    public boolean guarda(Recurso r) {
        boolean result=false;
        Recurso nr=new Recurso(r);
        for (int i=0; i<recursos.size();i++) {
            if (recursos.get(i).getId()==nr.getId()) {
                recursos.remove(i);
                recursos.add(0, nr);
                result=true;
            }
        }       
        return result;
    }
    
    @Override
    public boolean borra(Integer id) {
        boolean result=false;
        for (int i=0; i<recursos.size();i++) {
            if (recursos.get(i).getId()==id) {
                recursos.remove(i);
                result=true;
            }
        }       
        return result;
    }
    
    @Override
    public boolean descargar(Recurso r){
        if(r==null) return false;
        int descargas = r.getDescargas();
        for (int i=0; i<recursos.size();i++) {
            if (recursos.get(i).getId()==r.getId()) {
                recursos.get(i).setDescargas(descargas+1);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean darLike(Recurso r){
        if(r==null) return false;
        int likes = r.getLikes();
        for (int i=0; i<recursos.size();i++) {
            if (recursos.get(i).getId()==r.getId()) {
                recursos.get(i).setLikes(likes+1);
                return true;
            }
        }
        return false;
    }

}
