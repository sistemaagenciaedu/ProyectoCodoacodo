package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.TestAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAOpcion;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository.TestAOpcionRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAOpcionService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TestAOpcionServiceIMPL implements TestAOpcionService {
@Autowired
private TestAOpcionRepository optr;


    @Override
    public TestAOpcion saveOpcionTest(TestAOpcion opcionTest)  {
        return optr.save(opcionTest);
    }

    @Override
    public void deleteOpcionTest(Long id)  {
        optr.deleteById(id);
    }

    @Override
    public List<TestAOpcion> findAllOpcionTest()  {
        return optr.findAll();
    }

    @Override
    public List<TestAOpcion> findAllOpcionTestXPregunta(Long id) {
        List<TestAOpcion>nueva=new ArrayList<>();
        List<TestAOpcion>original=findAllOpcionTest();
        System.out.println("el Identificador de la pregunta es "+ id);
        System.out.println("el tamaño de la lista de opciones es "+ original.size());
        if (original.size()!=0){
            for (TestAOpcion opt:original){
                if(opt.getPreguntastestalumno().getId()==id){
                    nueva.add(opt);
                    System.out.println(opt.getId());
                }
            }
        }
        return nueva;
    }

    @Override
    public TestAOpcion findOpcionTestById(Long id)  {
        return optr.findById(id).orElse(null);
    }
}
