package codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;

import java.util.List;

public interface TestAPreguntaService {
    public TestAPregunta savePreguntaTest(TestAPregunta preguntaTest);
    public void deletePreguntaTest(Long id);
    public List<TestAPregunta> findAllPreguntaTest();
    public List<TestAPregunta> findAllPreguntaTestXmateria(Long id);
    public TestAPregunta findPreguntaTestById(Long id);
}
