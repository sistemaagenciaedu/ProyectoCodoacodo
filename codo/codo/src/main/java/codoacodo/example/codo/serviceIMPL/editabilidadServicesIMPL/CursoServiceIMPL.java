package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.editabilidad.Curso;
import codoacodo.example.codo.repositories.editabilidadRepositories.CursoRepository;
import codoacodo.example.codo.service.editabilidadServices.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServiceIMPL implements CursoService {
    @Autowired
    private CursoRepository cr;
    @Override
    public Curso saveCurso(Curso curso) {
        return cr.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cr.deleteById(id);
    }

    @Override
    public List<Curso> findAllCurso() {
        return cr.findAll();
    }

    @Override
    public Curso findCursoById(Long id) {
        return cr.findById(id).orElse(null);
    }
}
