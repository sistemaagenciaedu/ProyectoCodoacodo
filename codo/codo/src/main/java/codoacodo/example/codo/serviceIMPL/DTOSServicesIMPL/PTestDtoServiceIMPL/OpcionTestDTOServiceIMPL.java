package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PTestDtoServiceIMPL;


import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository.OpcionTestDTORepository;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.OpcionTestDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OpcionTestDTOServiceIMPL implements OpcionTestDTOService {
@Autowired
private OpcionTestDTORepository optr;
    @Override
    public OpcionTestDTO saveOpcionTest(OpcionTestDTO opcionTest)  {
        return optr.save(opcionTest);
    }

    @Override
    public void deleteOpcionTest(Long id)  {
        optr.deleteById(id);
    }
    @Override
    public List<OpcionTestDTO> findAllOpcionTest()  {
        return optr.findAll();
    }

    @Override
    public List<OpcionTestDTO> findAllOpcionTestXPregunta(Long id){
        List<OpcionTestDTO>nueva=new ArrayList<>();
        List<OpcionTestDTO>original=findAllOpcionTest();

        System.out.println("el Identificador de la pregunta es "+ id);
        System.out.println("el tamaño de la lista de opciones es "+ original.size());
 Integer idnuevo=id.intValue();
        if (!original.isEmpty()){
            for (OpcionTestDTO opt:original){
                if(opt.getPreguntastest().getId()==idnuevo.longValue()){
                    nueva.add(opt);
                    System.out.println(opt.getId());
                }
            }
        }
        for (OpcionTestDTO opt: nueva) {
            System.out.println(opt.getOpcionText());
            System.out.println(opt.getEsCorrecta());
            System.out.println(opt.getPreguntastest());
            System.out.println(opt.getId());
        }
        return nueva;
    }

    @Override
    public OpcionTestDTO findOpcionTestById(Long id) {
        return optr.findById(id).orElse(null);
    }
}
