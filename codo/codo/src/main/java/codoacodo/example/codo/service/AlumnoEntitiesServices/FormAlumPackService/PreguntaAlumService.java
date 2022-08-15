package codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;

import java.util.TreeSet;

public interface PreguntaAlumService {
    public PreguntaAlum savePreg(PreguntaAlum preg);
    public void deletePreg(Long id);
    public TreeSet<PreguntaAlum> findAllPreg();
    public TreeSet<PreguntaAlum> findAllPregByForm(Long id);
    public PreguntaAlum findPregById(Long id);
}
