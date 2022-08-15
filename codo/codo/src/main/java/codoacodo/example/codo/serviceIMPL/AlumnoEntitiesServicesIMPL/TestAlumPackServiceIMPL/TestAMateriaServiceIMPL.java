package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.TestAlumPackServiceIMPL;

import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository.TestAMateriaRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TestAMateriaServiceIMPL implements TestAMateriaService {
@Autowired
private TestAMateriaRepository mtr;
    @Override
    public TestAMateria saveMateriaTest(TestAMateria materiaTest) {
        return mtr.save(materiaTest);
    }

    @Override
    public void deleteMateriaTest(Long id) {
        mtr.deleteById(id);
    }

    @Override
    public List<TestAMateria> findAllMateriaTest() {
        return mtr.findAll();
    }

    @Override
    public List<TestAMateria> findAllMateriaTestxTest(Long id) {
        List<TestAMateria>nueva=new ArrayList<>();
        List<TestAMateria>original=findAllMateriaTest();

        if (original.size()!=0){
            for (TestAMateria mat:original){
                if(mat.getTestalumno().getId()==id){
                    nueva.add(mat);
                    System.out.println(mat.getNombre());
                }
            }
        }

        return nueva;
    }

    @Override
    public TestAMateria findMateriaTestById(Long id) {
        return mtr.findById(id).orElse(null);
    }
}
