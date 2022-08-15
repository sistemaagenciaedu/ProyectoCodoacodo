package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PTestDtoServiceIMPL;

import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PacktestDtoRepository.MateriaTestDTORepository;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.MateriaTestDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MateriaTestDTOServiceIMPL implements MateriaTestDTOService {
@Autowired
private MateriaTestDTORepository mtr;
    @Override
    public MateriaTestDTO saveMateriaTest(MateriaTestDTO materiaTest)  {
        return mtr.save(materiaTest);
    }

    @Override
    public void deleteMateriaTest(Long id) {
        mtr.deleteById(id);
    }


    @Override
    public List<MateriaTestDTO> findAllMateriaTest()  {
        return mtr.findAll();
    }

    @Override
    public List<MateriaTestDTO> findAllMateriaTestxTest(Long id)  {
        List<MateriaTestDTO>nueva=new ArrayList<>();
        List<MateriaTestDTO>original=findAllMateriaTest();

        if (original.size()!=0){
            for (MateriaTestDTO mat:original){
                if(mat.getTest().getId()==id){
                    nueva.add(mat);
                    System.out.println(mat.getNombre());
                }
            }
        }

        return nueva;
    }

    @Override
    public MateriaTestDTO findMateriaTestById(Long id) {
        return mtr.findById(id).orElse(null);
    }
}
