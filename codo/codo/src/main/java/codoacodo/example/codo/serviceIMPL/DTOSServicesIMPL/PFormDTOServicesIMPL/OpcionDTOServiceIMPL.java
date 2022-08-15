package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PFormDTOServicesIMPL;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.OpcionDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PackFormDTORepository.OpcionDTORepository;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.OpcionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpcionDTOServiceIMPL implements OpcionDTOService {
@Autowired
private OpcionDTORepository opr;

    @Override
    public OpcionDTO saveOpcionDTO(OpcionDTO opcion)  {
        return opr.save(opcion);
    }

    @Override
    public void deleteOpcionDTO(Long id) {
        opr.deleteById(id);
    }

    @Override
    public List<OpcionDTO> findAllOpcionDTO() {
        return opr.findAll();
    }

    @Override
    public List<OpcionDTO> findAllOpcionDTOByPreg(Long id)  {
        List<OpcionDTO> lista=new ArrayList<>();
        for (OpcionDTO p: findAllOpcionDTO()) {
            if (p.getPregunta()!=null){
                if(p.getPregunta().getId()==id){
                    lista.add(p);
                }
            }
        }
        return lista;
    }

    @Override
    public OpcionDTO findOpcionDTOById(Long id) {
        return opr.findById(id).orElse(null);
    }
}
