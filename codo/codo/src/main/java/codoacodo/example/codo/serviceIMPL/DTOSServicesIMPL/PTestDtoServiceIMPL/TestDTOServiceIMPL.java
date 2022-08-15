package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PTestDtoServiceIMPL;


import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository.TestDTORepository;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.TestDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TestDTOServiceIMPL implements TestDTOService {
@Autowired
private TestDTORepository tr;
    @Override
    public TestDTO saveTest(TestDTO test)  {
        return tr.save(test);
    }
    @Override
    public void deleteTest(Long id)  {
        tr.deleteById(id);
    }

    @Override
    public List<TestDTO> findAllTest()  {
        return tr.findAll();
    }

    @Override
    public TestDTO findTestById(Long id)  {
        return tr.findById(id).orElse(null);
    }
}
