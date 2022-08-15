package codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;

import java.util.List;

public interface TestAMateriaService {
    public TestAMateria saveMateriaTest(TestAMateria testAMateria);
    public void deleteMateriaTest(Long id);
    public List<TestAMateria> findAllMateriaTest();
    public List<TestAMateria> findAllMateriaTestxTest(Long id);
    public TestAMateria findMateriaTestById(Long id);
}
