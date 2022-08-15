package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.FormAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository.PreguntaAlumRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.PreguntaAlumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;
@Service
public class PreguntaAlumServiceIMPL implements PreguntaAlumService {
@Autowired
private PreguntaAlumRepository pr;
    @Override
    public PreguntaAlum savePreg(PreguntaAlum preg)  {
        return pr.save(preg);
    }


    @Override
    public void deletePreg(Long id)  {
        pr.deleteById(id);
    }

    @Override
    public TreeSet<PreguntaAlum> findAllPreg() {
        List<PreguntaAlum> pre=pr.findAll();
        TreeSet<PreguntaAlum> preguntas= new TreeSet<>();
        for (PreguntaAlum p: pre) {
            preguntas.add(p);
        }
        return preguntas;
    }

    @Override
    public TreeSet<PreguntaAlum> findAllPregByForm(Long id) {
        TreeSet<PreguntaAlum> listaVerificada=new TreeSet<>();
        TreeSet<PreguntaAlum> listaOriginal=findAllPreg();
        if (!listaOriginal.isEmpty()){
            for (PreguntaAlum p: listaOriginal ) {
                if(p.getFormulario().getId()==id){
                    listaVerificada.add(p);
                }
            }}
        return listaVerificada;
    }
    @Override
    public PreguntaAlum findPregById(Long id)  {
        return pr.findById(id).orElse(null);
    }
}
