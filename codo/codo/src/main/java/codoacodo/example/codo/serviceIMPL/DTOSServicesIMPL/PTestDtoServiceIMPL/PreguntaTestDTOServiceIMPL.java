package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PTestDtoServiceIMPL;



import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository.PreguntaTestDTORepository;

import codoacodo.example.codo.service.DTOSServices.PTestDtoService.PreguntaTestDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntaTestDTOServiceIMPL implements PreguntaTestDTOService {
@Autowired
    private PreguntaTestDTORepository ptr;


    @Override
    public PreguntaTestDTO savePreguntaTest(PreguntaTestDTO preguntaTest)  {
        return ptr.save(preguntaTest);
    }

    @Override
    public void deletePreguntaTest(Long id)  {
        ptr.deleteById(id);
    }

    @Override
    public List<PreguntaTestDTO> findAllPreguntaTest()  {
        return ptr.findAll();
    }

    @Override
    public List<PreguntaTestDTO> findAllPreguntaTestXmateria(Long id){
        List<PreguntaTestDTO>nueva=new ArrayList<>();
        List<PreguntaTestDTO>original=findAllPreguntaTest();

        if (original.size()!=0){
            for (PreguntaTestDTO pt:original){
                if(pt.getMateria().getId()==id){
                    nueva.add(pt);
                    System.out.println(pt.getTitulo());
                }
            }
        }

        return nueva;
    }

    @Override
    public List<PreguntaTestDTO> findAllPreguntaTestXmateriaID2(Long id) {
        return ptr.findByMateriaID(id);
    }

    @Override
    public PreguntaTestDTO findPreguntaTestById(Long id)  {
        return ptr.findById(id).orElse(null);
    }
}
