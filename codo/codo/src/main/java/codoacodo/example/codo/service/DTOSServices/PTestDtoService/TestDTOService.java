package codoacodo.example.codo.service.DTOSServices.PTestDtoService;


import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;

import java.util.List;

public interface TestDTOService {
    public TestDTO saveTest(TestDTO test);
    public void deleteTest(Long id);
    public List<TestDTO> findAllTest();
    public TestDTO findTestById(Long id);
}
