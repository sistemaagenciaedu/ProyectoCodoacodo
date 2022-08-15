package codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaAlumRepository extends JpaRepository<PreguntaAlum,Long> {

}
