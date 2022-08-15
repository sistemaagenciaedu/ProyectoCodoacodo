package codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository;

import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAOpcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAOpcionRepository extends JpaRepository<TestAOpcion,Long> {

}
