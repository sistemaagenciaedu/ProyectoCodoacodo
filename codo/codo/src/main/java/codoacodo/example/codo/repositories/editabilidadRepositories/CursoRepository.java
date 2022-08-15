package codoacodo.example.codo.repositories.editabilidadRepositories;


import codoacodo.example.codo.Entities.editabilidad.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {

}
