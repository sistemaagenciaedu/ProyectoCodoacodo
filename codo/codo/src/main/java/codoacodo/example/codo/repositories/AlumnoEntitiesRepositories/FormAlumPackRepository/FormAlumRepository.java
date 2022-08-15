package codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository;



import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormAlumRepository extends JpaRepository<FormAlum,Long> {

}
