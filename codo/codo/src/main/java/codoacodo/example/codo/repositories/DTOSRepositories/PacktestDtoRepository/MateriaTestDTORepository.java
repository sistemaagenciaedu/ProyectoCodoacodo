package codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaTestDTORepository extends JpaRepository<MateriaTestDTO,Long> {

}
