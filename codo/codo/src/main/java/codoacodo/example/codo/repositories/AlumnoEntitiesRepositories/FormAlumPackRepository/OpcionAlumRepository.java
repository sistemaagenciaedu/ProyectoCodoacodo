package codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.OpcionAlum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionAlumRepository extends JpaRepository<OpcionAlum,Long> {

}
