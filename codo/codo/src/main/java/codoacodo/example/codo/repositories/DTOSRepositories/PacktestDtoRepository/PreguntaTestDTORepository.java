package codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaTestDTORepository extends JpaRepository<PreguntaTestDTO,Long> {
//    @Query("SELECT a FROM PreguntaTestDTO a WHERE a.materia=:id")
//    List<PreguntaTestDTO> findByMateriaID(@Param("id") Long id);
@Query(
        value = "SELECT * FROM PreguntaTestDTO u WHERE u.materia = ?1",
        nativeQuery = true)
List<PreguntaTestDTO> findByMateriaID(Long id);

}
