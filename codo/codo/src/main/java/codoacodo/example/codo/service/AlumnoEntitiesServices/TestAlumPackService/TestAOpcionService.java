package codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAOpcion;

import java.util.List;

public interface TestAOpcionService {
    public TestAOpcion saveOpcionTest(TestAOpcion opcionTest);
    public void deleteOpcionTest(Long id);
    public List<TestAOpcion> findAllOpcionTest();

    public List<TestAOpcion> findAllOpcionTestXPregunta(Long id);
    public TestAOpcion findOpcionTestById(Long id);
}
