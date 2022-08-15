package codoacodo.example.codo.repositories.DTOSRepositories.PackFormDTORepository;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormDTORepository extends JpaRepository<FormDTO,Long> {

}
