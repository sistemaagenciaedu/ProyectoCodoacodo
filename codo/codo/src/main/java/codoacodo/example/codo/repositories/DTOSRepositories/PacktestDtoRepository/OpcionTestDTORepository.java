package codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionTestDTORepository extends JpaRepository<OpcionTestDTO,Long> {

}
