package codoacodo.example.codo.service.DTOSServices.PTestDtoService;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;

import java.util.List;

public interface MateriaTestDTOService {
    public MateriaTestDTO saveMateriaTest(MateriaTestDTO materiaTest);
    public void deleteMateriaTest(Long id);
    public List<MateriaTestDTO> findAllMateriaTest();
    public List<MateriaTestDTO> findAllMateriaTestxTest(Long id);
    public MateriaTestDTO findMateriaTestById(Long id);
}
