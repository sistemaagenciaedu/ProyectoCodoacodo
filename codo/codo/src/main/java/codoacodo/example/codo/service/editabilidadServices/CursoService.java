package codoacodo.example.codo.service.editabilidadServices;


import codoacodo.example.codo.Entities.editabilidad.Curso;

import java.util.List;

public interface CursoService {
    public Curso saveCurso(Curso curso);
    public void deleteCurso(Long id);
    public List<Curso> findAllCurso();

    public Curso findCursoById(Long id);
}
