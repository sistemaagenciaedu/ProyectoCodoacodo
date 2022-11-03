package codoacodo.example.codo.service.DTOSServices.PTestDtoService;


import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;

import java.util.List;

public interface PreguntaTestDTOService {
    public PreguntaTestDTO savePreguntaTest(PreguntaTestDTO preguntaTest);
    public void deletePreguntaTest(Long id);
    public List<PreguntaTestDTO> findAllPreguntaTest();
    public List<PreguntaTestDTO> findAllPreguntaTestXmateria(Long id);
    public List<PreguntaTestDTO> findAllPreguntaTestXmateriaID2(Long id);
    public PreguntaTestDTO findPreguntaTestById(Long id);


}
