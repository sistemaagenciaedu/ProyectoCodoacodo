package codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;

import java.util.List;

public interface TestAlumnoService {
    public TestAlumno saveTestAlumno(TestAlumno testAlumno);
    public void deleteTestAlumno(Long id);
    public List<TestAlumno> findAllTestAlumno();
    public TestAlumno findTestAlumnoById(Long id);


}
