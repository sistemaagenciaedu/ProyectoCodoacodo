package codoacodo.example.codo.repositories.editabilidadRepositories;

import codoacodo.example.codo.Entities.editabilidad.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,Long> {

}
