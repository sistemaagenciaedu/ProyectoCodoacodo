package codoacodo.example.codo.service;


import codoacodo.example.codo.Entities.Ingresante;

import java.util.List;

public interface IngresanteService {

    public Ingresante saveIngresante(Ingresante ingre);
    public void deleteIngresante(Long id);
    public List<Ingresante> findAllIngresante();

    public Ingresante findIngresanteById(Long id);
    public void eliminarRespuestasIngresante(Ingresante ingre);
    public List<Ingresante>getByFilter(String query, String desde, String hasta, String genero, String encuesta,String test,String tIngles,String tProgramacion,String tLogica ,String order);
    public Ingresante findIngresanteByDoc(String numDoc);
    public List<Ingresante>buscarTodosLosDNIQueMacheen(String numDoc);

}