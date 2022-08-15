package codoacodo.example.codo.service.DTOSServices.PTestDtoService;


import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;

import java.util.List;

public interface OpcionTestDTOService {
    public OpcionTestDTO saveOpcionTest(OpcionTestDTO opcionTest);
    public void deleteOpcionTest(Long id);
    public List<OpcionTestDTO> findAllOpcionTest();

    public List<OpcionTestDTO> findAllOpcionTestXPregunta(Long id);
    public OpcionTestDTO findOpcionTestById(Long id);
}
