package codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository;

import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestAPreguntaRepository extends JpaRepository<TestAPregunta,Long> {

}
