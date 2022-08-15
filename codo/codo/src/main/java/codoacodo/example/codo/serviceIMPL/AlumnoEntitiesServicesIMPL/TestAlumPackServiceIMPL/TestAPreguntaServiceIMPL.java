package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.TestAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository.TestAPreguntaRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class TestAPreguntaServiceIMPL implements TestAPreguntaService {
    @Autowired
    private TestAPreguntaRepository ptr;
    @Override
    public TestAPregunta savePreguntaTest(TestAPregunta preguntaTest) {
        return ptr.save(preguntaTest);
    }

    @Override
    public void deletePreguntaTest(Long id) {
        ptr.deleteById(id);
    }

    @Override
    public List<TestAPregunta> findAllPreguntaTest() {
        return ptr.findAll();
    }

    @Override
    public List<TestAPregunta> findAllPreguntaTestXmateria(Long id) {
        List<TestAPregunta>nueva=new ArrayList<>();
        List<TestAPregunta>original=findAllPreguntaTest();

        if (original.size()!=0){
            for (TestAPregunta pt:original){
                if(pt.getMateriaalumno().getId()==id){
                    nueva.add(pt);
                    System.out.println(pt.getTitulo());
                }
            }
        }

        return nueva;
    }

    @Override
    public TestAPregunta findPreguntaTestById(Long id) {
        return ptr.findById(id).orElse(null);
    }
}

