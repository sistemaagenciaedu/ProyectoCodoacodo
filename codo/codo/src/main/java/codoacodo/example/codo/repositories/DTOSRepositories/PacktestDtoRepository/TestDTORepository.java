package codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDTORepository extends JpaRepository<TestDTO,Long> {

}
