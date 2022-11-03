package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.TestAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAOpcion;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.TestAlumPackRepository.TestAlumnoRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAMateriaService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAOpcionService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAPreguntaService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAlumnoService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.PreguntaTestDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class TestAlumnoServiceIMPL implements TestAlumnoService {

@Autowired
private TestAlumnoRepository tr;
@Autowired
private TestAMateriaService ts;

@Autowired
private TestAPreguntaService ps;
@Autowired
private TestAOpcionService ops;
@Autowired
private PreguntaTestDTOService ptdtos;
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

    @Override
    public TestAlumno TestDtoTotestAlumno(TestDTO testDTO) {
        TestAlumno testAlumno=new TestAlumno();
        testAlumno.setNombre(testDTO.getNombre());
        testAlumno.setFechaM(new Date().toString());
        testAlumno.setTiempo(testDTO.getTiempo());
        testAlumno=saveTestAlumno(testAlumno);
       for (MateriaTestDTO materiaTestDTO:testDTO.getMaterias()){
           TestAMateria testAMateria=new TestAMateria();
           testAMateria.setNombre(materiaTestDTO.getNombre());
           testAMateria.setMateriaId(materiaTestDTO.getId());
           testAMateria.setFechaM(new Date().toString());
           testAMateria.setnPreguntas(materiaTestDTO.getnPreguntas());
           testAMateria.setTestalumno(testAlumno);
           testAMateria=ts.saveMateriaTest(testAMateria);
           ArrayList<Long>ids=new ArrayList<>();
           int contador=0;
//           ArrayList<Integer>aleatorios=new ArrayList<>();
           Set<PreguntaTestDTO>setPreguntas=new TreeSet<>();
           do {
               int tamanio=materiaTestDTO.getPreguntasTest().size()-1;
               int aleatorio=(int)(Math.random()*tamanio);
               PreguntaTestDTO preguntaTestDTO=materiaTestDTO.getPreguntasTest().get(aleatorio);
               setPreguntas.add(preguntaTestDTO);
           }while (setPreguntas.size()!=materiaTestDTO.getnPreguntas());




               for (PreguntaTestDTO preguntaTestDTO: setPreguntas){

                   TestAPregunta testAPregunta=new TestAPregunta();
                   testAPregunta.setTitulo(preguntaTestDTO.getTitulo());
                   testAPregunta.setPregunta(preguntaTestDTO.getPregunta());
                   testAPregunta.setTipoPortada(preguntaTestDTO.getTipoPortada());
                   testAPregunta.setTipoOpcion(preguntaTestDTO.getTipoOpcion());
                   testAPregunta.setPortadaVideo(preguntaTestDTO.getPortadaVideo());
                   testAPregunta.setPortadaImaId(preguntaTestDTO.getPortadaImaId());
                   testAPregunta.setMateriaalumno(testAMateria);
                   testAPregunta=ps.savePreguntaTest(testAPregunta);

                   for (OpcionTestDTO opcionTestDTO :preguntaTestDTO.getOpcionestest()){
                       TestAOpcion testAOpcion=new TestAOpcion();

                       testAOpcion.setEsCorrecta(opcionTestDTO.getEsCorrecta());
                       testAOpcion.setOpcionText(opcionTestDTO.getOpcionText());
                       testAOpcion.setTipoOpcion(opcionTestDTO.getTipoOpcion());
                       testAOpcion.setOpcionImgid(opcionTestDTO.getOpcionImgid());
                       testAOpcion.setPreguntastestalumno(testAPregunta);
                       ops.saveOpcionTest(testAOpcion);
                   }

           }
       }
       return testAlumno;
    }
//    @Override
//    public TestAlumno TestDtoTotestAlumno(TestDTO testDTO) {
//        TestAlumno testAlumno=new TestAlumno();
//        testAlumno.setNombre(testDTO.getNombre());
//        testAlumno.setFechaM(new Date().toString());
//        testAlumno.setTiempo(testDTO.getTiempo());
//        testAlumno.setMateriasAlumno(new TreeSet<>());
//
//
//        for (MateriaTestDTO materiaTestDTO:testDTO.getMaterias()) {
//            TestAMateria testAMateria = new TestAMateria();
//            testAMateria.setNombre(materiaTestDTO.getNombre());
//            testAMateria.setMateriaId(materiaTestDTO.getId());
//            testAMateria.setFechaM(new Date().toString());
//            testAMateria.setnPreguntas(materiaTestDTO.getnPreguntas());
//            testAMateria.setTestalumno(testAlumno);
//            //testAMateria=ts.saveMateriaTest(testAMateria);
//            testAlumno.getMateriasAlumno().add(testAMateria);
//        }
//        List<PreguntaTestDTO>listaDePreguntas=new ArrayList<>();
//
//        for(TestAMateria materia:testAlumno.getMateriasAlumno()){
//            List<PreguntaTestDTO>preguntasTodasOriginales=ptdtos.findAllPreguntaTestXmateriaID2(materia.getMateriaId());
//            Collections.shuffle(preguntasTodasOriginales);
//            for (int i = 0; i < materia.getnPreguntas(); i++) {
//                PreguntaTestDTO preguntaTestDTO=preguntasTodasOriginales.get(i);
//                TestAPregunta testAPregunta=new TestAPregunta();
//                testAPregunta.setTitulo(preguntaTestDTO.getTitulo());
//                testAPregunta.setPregunta(preguntaTestDTO.getPregunta());
//                testAPregunta.setTipoPortada(preguntaTestDTO.getTipoPortada());
//                testAPregunta.setTipoOpcion(preguntaTestDTO.getTipoOpcion());
//                testAPregunta.setPortadaVideo(preguntaTestDTO.getPortadaVideo());
//                testAPregunta.setPortadaImaId(preguntaTestDTO.getPortadaImaId());
//                testAPregunta.setMateriaalumno(materia);
//                for (OpcionTestDTO opcionTestDTO :preguntaTestDTO.getOpcionestest()){
//                    TestAOpcion testAOpcion=new TestAOpcion();
//                    testAOpcion.setEsCorrecta(opcionTestDTO.getEsCorrecta());
//                    testAOpcion.setOpcionText(opcionTestDTO.getOpcionText());
//                    testAOpcion.setTipoOpcion(opcionTestDTO.getTipoOpcion());
//                    testAOpcion.setOpcionImgid(opcionTestDTO.getOpcionImgid());
//                    testAOpcion.setPreguntastestalumno(testAPregunta);
//                    testAPregunta.getOpcionestestalumno().add(testAOpcion);
//                    testAOpcion.setPreguntastestalumno(testAPregunta);
//                }
//                Collections.shuffle(testAPregunta.getOpcionestestalumno());
//                materia.getPreguntasAlumno().add(testAPregunta);
//            }
//
//        }
//        testAlumno=saveTestAlumno(testAlumno);
//
//        return testAlumno;
//    }
}
