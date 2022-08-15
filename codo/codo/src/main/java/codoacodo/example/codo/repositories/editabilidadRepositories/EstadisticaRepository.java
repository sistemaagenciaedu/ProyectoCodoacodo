package codoacodo.example.codo.repositories.editabilidadRepositories;

import codoacodo.example.codo.Entities.editabilidad.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica,Long> {

}
