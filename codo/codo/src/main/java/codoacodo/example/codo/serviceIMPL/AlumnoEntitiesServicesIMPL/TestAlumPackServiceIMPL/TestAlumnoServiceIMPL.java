package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.TestAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository.TestAlumnoRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TestAlumnoServiceIMPL implements TestAlumnoService {

@Autowired
private TestAlumnoRepository tr;
    @Override
    public TestAlumno saveTestAlumno(TestAlumno testAlumno)  {
        return tr.save(testAlumno);
    }

    @Override
    public void deleteTestAlumno(Long id) {
        tr.deleteById(id);
    }

    @Override
    public List<TestAlumno> findAllTestAlumno()  {
        return tr.findAll();
    }

    @Override
    public TestAlumno findTestAlumnoById(Long id)  {
        return tr.findById(id).orElse(null);
    }
}
