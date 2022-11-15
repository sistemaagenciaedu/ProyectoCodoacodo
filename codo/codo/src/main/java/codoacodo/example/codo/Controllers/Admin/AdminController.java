package codoacodo.example.codo.Controllers.Admin;


import codoacodo.example.codo.CodoaApplication;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.OpcionDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.Usuario;
import codoacodo.example.codo.Entities.editabilidad.*;
import codoacodo.example.codo.repositories.UsuarioRepository;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.FormDTOService;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.OpcionDTOService;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.PreguntaDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.MateriaTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.OpcionTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.PreguntaTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.TestDTOService;
import codoacodo.example.codo.service.IngresanteService;
import codoacodo.example.codo.service.editabilidadServices.*;
import codoacodo.example.codo.serviceIMPL.RutaExcelServiceIMPLE;
import codoacodo.example.codo.utiles.ExcelFileExporter;
import codoacodo.example.codo.utiles.GenerarListaConTexto;
import codoacodo.example.codo.utiles.Listas;
import codoacodo.example.codo.web.EncriptarPassword;
import com.graphbuilder.math.func.EFunction;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Controller

@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private Listas lis;
    @Autowired
    private FormDTOService fs;
    @Autowired
    private ImagenService ims;
    @Autowired
    private CursoService cs;
    @Autowired
    private TestimonioService ts;
    @Autowired
    private ImagenService is;
    @Autowired
    private ProvinciaService prs;
    @Autowired
    private EstadisticaService es;
    @Autowired
    private PreguntaDTOService pdtos;
    @Autowired
    private OpcionDTOService opdtos;
    @Autowired
    private GenerarListaConTexto gl;
    @Autowired
    private TestDTOService tdtos;
    @Autowired
    private MateriaTestDTOService mtdtos;
    @Autowired
    private PreguntaTestDTOService ptests;
    @Autowired
    private OpcionTestDTOService optestdtos;
    @Autowired
    private IngresanteService ingres;
    @Autowired
    private UsuarioRepository ur;
@Autowired
private RutaExcelServiceIMPLE resi;

//controlador panel de administracion
    @GetMapping("")
    public String panelAdmin(Model model, Ingresante ingresante){
        ArrayList<Provincia> provinciax= (ArrayList<Provincia>) prs.findAllProvincia();
        if (provinciax.isEmpty()){
            return "redirect:/admin/inicializarelproyecto" ;
        }else{
            model.addAttribute("listaNacionalidades", lis.devolverNacionalidades());
            model.addAttribute("provincias",provinciax);
            model.addAttribute("estadistica",es.findEstadisticaById(1L));
            model.addAttribute("ingresante",ingresante);
            return "paneladministrador";
        }

    }


    @GetMapping("/listasExcels")
    public String listarExcels(Model model, Ingresante ingresante){
        ArrayList<RutasExcel> rutas= (ArrayList<RutasExcel>) resi.listallRutas();


            model.addAttribute("rutas",rutas);
            return "excels";


    }

    //Controldores de formulario dto
    @GetMapping("/formulario/list")
    public String listarFormulario(Model model){
        model.addAttribute("formularios",fs.findAllForms());
        model.addAttribute("formu",new FormDTO());
        return "crear-formulario";
    }

    @PostMapping("/formulario/save")
    public String saveForm(FormDTO form){
        fs.saveForm(form);

        return "redirect:/admin/formulario/list";
    }

    @GetMapping("/formulario/delete")
    public String saveForm(Long id){
        fs.deleteFormDTO(id);

        return "redirect:/admin/formulario/list";
    }


    //controlador de preguntas FormDTO
    @GetMapping("/pregunta/list")
    public String listarpregunta(Long id,Model model){
        model.addAttribute("preguntas",pdtos.findAllPregByForm(id));
        model.addAttribute("preg",new PreguntaDTO());
        model.addAttribute("idFormu",id);
        return "crear-pregunta";
    }

    @GetMapping("/verpreguntastodas")
    public String verpreguntastodas(Model model){
        model.addAttribute("preguntas",ptests.findAllPreguntaTest());


        return "preguntastodas";
    }

    @PostMapping("/pregunta/save")
    public String savepregunta(PreguntaDTO preg,Long idForm,String opcionesDePreguntas, Model model){
        FormDTO formu=fs.findFormById(idForm);
        preg.setFormulario(formu);
        PreguntaDTO pregunta=pdtos.savePreg(preg);
        for (String p: gl.generarLista(opcionesDePreguntas)) {
            OpcionDTO op=new OpcionDTO();
            op.setDescripcion(p);
            op.setPregunta(pregunta);
            opdtos.saveOpcionDTO(op);
        }
        System.out.println(opcionesDePreguntas);

        return "redirect:/admin/pregunta/list?id="+idForm;
    }

    @GetMapping("/pregunta/delete")
    public String deletepregunta(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idForm") Long idForm, Model model){

        pdtos.deletePreg(id);

        return "redirect:/admin/pregunta/list?id="+idForm;
    }

//Controladores de Opciones FormularioDTO
@GetMapping("/opcion/list")
public String listaropcion(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idFormu") Long idFormu, Model model){

    model.addAttribute("opciones",opdtos.findAllOpcionDTOByPreg(id));
    model.addAttribute("idPre",id);
    model.addAttribute("idFormu",idFormu);

    return "listaropcionesform";
}



    @GetMapping("/opcion/delete")
    public String deleteopcion(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idPre") Long idPre,@RequestParam(required = false, name = "idFormu") Long idFormu, Model model){

        opdtos.deleteOpcionDTO(id);


        return "redirect:/admin/opcion/list?id="+idPre+"&idFormu="+idFormu;
    }

//Controlladores de Testimonio
@GetMapping("/testimonio/list")
public String listarTesti(Model model){
    model.addAttribute("testimonios",ts.findAllTesti());
    model.addAttribute("testi",new Testimonio());

    return "crear-testimonio";
}

    @PostMapping("/testimonio/save")
    public String saveTesti(Testimonio test,  MultipartFile imagenx){

        test.setImagen(is.crear(imagenx));
        ts.saveTesti(test);


        return "redirect:/admin/testimonio/list";
    }

    @GetMapping("/testimonio/delete")
    public String deleteTesti(Long id){
        ts.deleteTesti(id);


        return "redirect:/admin/testimonio/list";
    }

//Controlladores de curso

    @GetMapping("/curso/list")
    public String listarCurso(Model model){
        model.addAttribute("cursos",cs.findAllCurso());
        model.addAttribute("curse",new Curso());

        return "crear-curso";
    }

    @PostMapping("/curso/save")
    public String saveCurso(Curso curse,  Model model,  MultipartFile imagenx){
        curse.setImagen(ims.crear(imagenx));
        cs.saveCurso(curse);



        return "redirect:/admin/curso/list";
    }
    @GetMapping("/curso/delete")
    public String deleteCurso(Long id, Model model){
        cs.deleteCurso(id);


        return "redirect:/admin/curso/list";
    }

//Controladores del testDTO

    @GetMapping("/test/list")
    public String listartestDTO(Model model){
        model.addAttribute("tests",tdtos.findAllTest());
        model.addAttribute("test",new TestDTO());
        return "crear-test";
    }

    @PostMapping("/test/save")
    public String savetestDTO(TestDTO test, Model model){
        test.setFechaM(new Date().toString());
        tdtos.saveTest(test);

        return "redirect:/admin/test/list";
    }

    @GetMapping("/test/delete")
    public String deletetestDTO(Long id, Model model){
        tdtos.deleteTest(id);

        return "redirect:/admin/test/list";
    }
//Controladores del Materia testDTO

    @GetMapping("/materia/list")
    public String listarMateriaDto(Long idTest, Model model){
        model.addAttribute("materias",mtdtos.findAllMateriaTestxTest(idTest));
        model.addAttribute("materia",new MateriaTestDTO());
        model.addAttribute("idTest",idTest);
        return "crear-materia";
    }

    @PostMapping("/materia/save")
    public String saveMateria(MateriaTestDTO materia,Long idTest, Model model){
        TestDTO test=tdtos.findTestById(idTest);
        test.setFechaM(new Date().toString());
        test=tdtos.saveTest(test);
        materia.setTest(test);
        materia.setFechaM(new Date().toString());
        mtdtos.saveMateriaTest(materia);


        return "redirect:/admin/materia/list?idTest="+idTest;
    }

    @GetMapping("/materia/delete")
    public String deleteMateria(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idTest") Long idTest, Model model){
        TestDTO test=tdtos.findTestById(idTest);
        test.setFechaM(new Date().toString());
        test=tdtos.saveTest(test);
        mtdtos.deleteMateriaTest(id);

        return "redirect:/admin/materia/list?idTest="+idTest;
    }


    //controladores pregunta test dto

    @GetMapping("/preguntatest/list")
    public String listar(Long idMat,Long idTest, Model model){
        model.addAttribute("preguntas",ptests.findAllPreguntaTestXmateria(idMat));
        model.addAttribute("pregunta",new PreguntaTestDTO());
        model.addAttribute("idMat",idMat);
        model.addAttribute("idTest",idTest);
        return "crear-preguntatest";
    }

    @PostMapping("/preguntatest/save")
    public String saveMat(PreguntaTestDTO pregunta, Long idMat, Long idTest, Model model, MultipartFile imagenx){
        MateriaTestDTO mat=mtdtos.findMateriaTestById(idMat);
        mat.setFechaM(new Date().toString());
        mat=mtdtos.saveMateriaTest(mat);
        TestDTO test=tdtos.findTestById(mat.getTest().getId());
        test.setFechaM(new Date().toString());
        tdtos.saveTest(test);
        pregunta.setMateria(mat);
        if (imagenx.getSize()!=0){
            pregunta.setPortadaImagen(is.crear(imagenx));
            pregunta.setPortadaImaId(pregunta.getPortadaImagen().getId());
        }

        pregunta.setFechaM(new Date().toString());
        ptests.savePreguntaTest(pregunta);


        return "redirect:/admin/preguntatest/list?idMat="+idMat+"&idTest="+idTest;
    }

    @GetMapping("/preguntatest/delete")
    public String delete(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idMat") Long idMat,@RequestParam(required = false, name = "idTest") Long idTest, Model model){
        MateriaTestDTO mat=mtdtos.findMateriaTestById(idMat);
        mat.setFechaM(new Date().toString());
        mat=mtdtos.saveMateriaTest(mat);
        TestDTO test=tdtos.findTestById(mat.getTest().getId());
        test.setFechaM(new Date().toString());
        tdtos.saveTest(test);
        ptests.deletePreguntaTest(id);

        return "redirect:/admin/preguntatest/list?idMat="+idMat+"&idTest="+idTest;
    }

    @GetMapping("/preguntatest/previsualizar")
    public String preview(Long id,Long idTest,Long idMat,Model model){

        model.addAttribute("pregunta",ptests.findPreguntaTestById(id));
        model.addAttribute("idTest",idTest);
        model.addAttribute("idMat",idMat);

        return "visualizador-preguntatest";
    }

//Controlador Opciones de test
@GetMapping("/opciontest/list")
public String listar(Long idMat,Long idTest,Long idPreg, Model model,String tOpcion){
    model.addAttribute("opciones",optestdtos.findAllOpcionTestXPregunta(idPreg));
    for (OpcionTestDTO option: optestdtos.findAllOpcionTestXPregunta(idPreg) ) {
        System.out.println(option.getOpcionText());
        System.out.println(option.getEsCorrecta());
        System.out.println(option.getPreguntastest());
        System.out.println(option.getId());

    }
    model.addAttribute("opcion",new OpcionTestDTO());
    model.addAttribute("idMat",idMat);
    model.addAttribute("idTest",idTest);
    model.addAttribute("idPreg",idPreg);
    model.addAttribute("tOpcion",tOpcion);
    return "crear-opciontest";
}

    @PostMapping("/opciontest/save")
    public String saveMat(OpcionTestDTO opcion, Long idMat,Long idPreg,Long idTest,String tOpcion, Model model, MultipartFile imagenx){
        MateriaTestDTO mat=mtdtos.findMateriaTestById(idMat);
        mat.setFechaM(new Date().toString());
        mat=mtdtos.saveMateriaTest(mat);
        TestDTO test=tdtos.findTestById(mat.getTest().getId());
        test.setFechaM(new Date().toString());
        tdtos.saveTest(test);
        PreguntaTestDTO pregunta=ptests.findPreguntaTestById(idPreg);
        pregunta.setFechaM(new Date().toString());
        pregunta=ptests.savePreguntaTest(pregunta);
        opcion.setPreguntastest(pregunta);
        if (imagenx.getSize()!=0){
            opcion.setOpcionImg(is.crear(imagenx));
            opcion.setOpcionImgid(opcion.getOpcionImg().getId());
        }
        opcion.setPreguntastest(pregunta);
        opcion.setTipoOpcion(tOpcion);
        optestdtos.saveOpcionTest(opcion);




        return "redirect:/admin/opciontest/list?idMat="+idMat+"&idTest="+idTest+"&idPreg="+idPreg+"&tOpcion="+tOpcion;
    }

    @GetMapping("/opciontest/delete")
    public String delete(@RequestParam(required = false, name = "id") Long id, @RequestParam(required = false, name = "idMat") Long idMat, @RequestParam(required = false, name = "idTest") Long idTest, @RequestParam(required = false, name = "idPreg") Long idPreg, @RequestParam(required = false, name = "tOpcion") String tOpcion, Model model){
        MateriaTestDTO mat=mtdtos.findMateriaTestById(idMat);
        mat.setFechaM(new Date().toString());
        mat=mtdtos.saveMateriaTest(mat);
        TestDTO test=tdtos.findTestById(mat.getTest().getId());
        test.setFechaM(new Date().toString());
        tdtos.saveTest(test);
        PreguntaTestDTO pregunta=ptests.findPreguntaTestById(idPreg);
        pregunta.setFechaM(new Date().toString());
        optestdtos.deleteOpcionTest(id);

        return "redirect:/admin/opciontest/list?idMat="+idMat+"&idTest="+idTest+"&idPreg="+idPreg+"&tOpcion="+tOpcion;
    }

//controlador de filtrado de ingresantes
@GetMapping("/filtrar")
public String exportar(Model model,
                       @RequestParam(required = false, name = "desde") String desde,
                       @RequestParam(required = false, name = "query") String query,
                       @RequestParam(required = false, name = "hasta") String hasta,
                       @RequestParam(required = false, name = "genero") String genero,
                       @RequestParam(required = false, name = "encuesta") String encuesta,
                       @RequestParam(required = false, name = "tIngles") String tIngles,
                       @RequestParam(required = false, name = "test") String test,
                       @RequestParam(required = false, name = "tProgramacion") String tProgramacion,
                       @RequestParam(required = false, name = "tLogica") String tLogica,
                       @RequestParam(required = false, defaultValue = "ASC") String order,
                       @RequestParam(required = false,  defaultValue = "no") String no

) {
    List<Ingresante> lista = new ArrayList<>();
    if(no.equalsIgnoreCase("no")){

    }else{
        if (query.equalsIgnoreCase("") && desde.equalsIgnoreCase("") && hasta.equalsIgnoreCase("") && genero.equalsIgnoreCase("") && encuesta.equalsIgnoreCase("") && tIngles.equalsIgnoreCase("")  && tLogica.equalsIgnoreCase("")   && tProgramacion.equalsIgnoreCase("")   ) {
            lista = ingres.findAllIngresante();
        } else {

            if (encuesta.equalsIgnoreCase("")||encuesta.isEmpty()||encuesta.length()==0) {
                encuesta = null;
            }
            if (test.equalsIgnoreCase("")) {
                test = null;
            }
            if (tIngles.equalsIgnoreCase("")) {
                tIngles = null;
            }
            if (tProgramacion.equalsIgnoreCase("")) {
                tProgramacion = null;
            }

            if (tLogica.equalsIgnoreCase("")) {
                tLogica = null;
            }
            if (genero.equalsIgnoreCase(" ")) {
                genero = null;
            }
            System.out.println(desde);
            System.out.println(hasta);
            lista = ingres.getByFilter(query, desde,  hasta,  genero,  encuesta,test,tIngles, tProgramacion,tLogica , order);
        }
    }

    model.addAttribute("ingre", lista);
    model.addAttribute("quer", query);
    model.addAttribute("des", desde);
    model.addAttribute("has", hasta);
    model.addAttribute("gen", genero);
    model.addAttribute("enc", encuesta);
    model.addAttribute("tes", test);
    model.addAttribute("tIng", tIngles);
    model.addAttribute("tPro", tProgramacion);
    model.addAttribute("tLog", tLogica);
    model.addAttribute("ord", order);

    return "tablaingresantes";
}
//Controlador de exportacion a excel con filtrado
@GetMapping("/filtrar/ing.xlsx")
    public void downloadCsvFiltrado(
        HttpServletResponse response, @RequestParam(required = false, name = "num")Long num,
        @RequestParam(required = false, name = "desde") String desde,
        @RequestParam(required = false, name = "query") String query,
        @RequestParam(required = false, name = "hasta") String hasta,
        @RequestParam(required = false, name = "genero") String genero,
        @RequestParam(required = false, name = "encuesta") String encuesta,
        @RequestParam(required = false, name = "test") String test,
        @RequestParam(required = false, name = "tIngles") String tIngles,
        @RequestParam(required = false, name = "tProgramacion") String tProgramacion,
        @RequestParam(required = false, name = "tLogica") String tLogica,
        @RequestParam(required = false, defaultValue = "ASC") String order,
        @RequestParam(required = false,  defaultValue = "no") String no

    ) throws IOException {
    Estadistica estadistica=es.findEstadisticaById(1L);
    String estaba=estadistica.getFormuHabilitado();
    if (estaba.equalsIgnoreCase("si")){
        estadistica.setFormuHabilitado("no");
        es.saveEstadistica(estadistica);
    }
        List<Ingresante> lista = new ArrayList<>();
        if(no.equalsIgnoreCase("no")){

        }else{
            if (query.equalsIgnoreCase("") && desde.equalsIgnoreCase("") && hasta.equalsIgnoreCase("") && genero.equalsIgnoreCase("") && encuesta.equalsIgnoreCase("") && tIngles.equalsIgnoreCase("")  && tLogica.equalsIgnoreCase("")   && tProgramacion.equalsIgnoreCase("")   ) {
                lista = ingres.findAllIngresante();
            } else {

                if (encuesta.equalsIgnoreCase("")) {
                    encuesta = null;
                }
                if (test.equalsIgnoreCase("")) {
                    test = null;
                }
                if (tIngles.equalsIgnoreCase("")) {
                    tIngles = null;
                }
                if (tProgramacion.equalsIgnoreCase("")) {
                    tProgramacion = null;
                }

                if (tLogica.equalsIgnoreCase("")) {
                    tLogica = null;
                }
                if (genero.equalsIgnoreCase(" ")) {
                    genero = null;
                }
                if(desde.equalsIgnoreCase("")){
                    desde=null;
                }
                if(hasta.equalsIgnoreCase("")){
                    hasta=null;
                }
                System.out.println(desde);
                System.out.println(hasta);
                lista = ingres.getByFilter(query, desde,  hasta,  genero,  encuesta,test,tIngles, tProgramacion,tLogica , order);
            }
        }

//            model.addAttribute("preguntas",preguntas);
        List<Ingresante> ingresantex=new ArrayList<>();
        for (Ingresante in: lista) {
            if (in.getFormAlum()!=null){
                Ingresante ingre=new Ingresante();
                ingre=in;

                ingresantex.add(in);
            }
        }
////            model.addAttribute("ingre",ingresantex);
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition", "attachment; filename=ing.xlsx");

//            ByteArrayInputStream stream = ExcelFileExporter.ingresantesExcelExpoter(preguntas,ingresantex);
    ExcelFileExporter esx=new ExcelFileExporter();
    String ruta=esx.ingresantesExcelExpoter (tdtos.findTestById(1L),fs.findFormById(1L),ingresantex);
    RutasExcel nueva=new RutasExcel();
    nueva.setNombre(ruta);
    resi.save(nueva);
    estadistica.setFormuHabilitado(estaba);
    es.saveEstadistica(estadistica);
//            System.out.println("llego");
//            workbook.write(response.getOutputStream());
//        ServletOutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        workbook.close();
//        outputStream.close();
    }
    //controlador de exportacion sin filtado

    @GetMapping("/descargarTodo")

    public void downloadCsv( Model model) throws IOException {
Estadistica estadistica=es.findEstadisticaById(1L);
String estaba=estadistica.getFormuHabilitado();
if (estaba.equalsIgnoreCase("si")){
    estadistica.setFormuHabilitado("no");
    es.saveEstadistica(estadistica);
}
        List<Ingresante> lista = new ArrayList<>();
       lista=ingres.findAllIngresante();


//            model.addAttribute("preguntas",preguntas);
        List<Ingresante> ingresantex=new ArrayList<>();
        for (Ingresante in: lista) {
            if (in.getFormAlum()!=null && in.getTest()!=null){
                Ingresante ingre=new Ingresante();
                ingre=in;

                ingresantex.add(in);
            }
        }
//            model.addAttribute("ingre",ingresantex);
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition", "attachment; filename=ing.xlsx");
//
        //XSSFWorkbook workbook= ExcelFileExporter.ingresantesExcelExpoter(tdtos.findTestById(1L),fs.findFormById(1L),lista);
        ExcelFileExporter esx=new ExcelFileExporter();
        String ruta=esx.ingresantesExcelExpoter(tdtos.findTestById(1L),fs.findFormById(1L),ingresantex);

        RutasExcel nueva=new RutasExcel();
        nueva.setNombre(ruta);
        resi.save(nueva);
        estadistica.setFormuHabilitado(estaba);
        es.saveEstadistica(estadistica);

////
//        ServletOutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        workbook.close();
//        outputStream.close();
//        return "redirect:/admin/";
    }

    //controladores que inicializa las provincias
    @GetMapping("/inicializarelproyecto")
    public String inicializarelproyecto(){
        Provincia p1=new Provincia("Ciudad Autonoma de Buenos Aires","caba.webp");
        Provincia p2=new Provincia("Buenos Aires","buenosaires.webp");
        Provincia p3=new Provincia("Catamarca","catamarca.webp");
        Provincia p4=new Provincia("Chaco","chaco.webp");
        Provincia p5=new Provincia("Chubut","chubut.webp");
        Provincia p6=new Provincia("Cordoba","cordoba.webp");
        Provincia p7=new Provincia("Corrientes","corrientes.webp");
        Provincia p8=new Provincia("Entre Rios","entrerios.webp");
        Provincia p9=new Provincia("Formosa","formosa.webp");
        Provincia p10=new Provincia("Jujuy","jujuy.webp");
        Provincia p11=new Provincia("La Pampa","lapampa.webp");
        Provincia p12=new Provincia("La Rioja","larioja.webp");
        Provincia p13=new Provincia("Mendoza","mendoza.webp");
        Provincia p14=new Provincia("Misiones","misiones.webp");
        Provincia p15=new Provincia("Neuquen","neuquen.webp");
        Provincia p16=new Provincia("Rio Negro","rionegro.webp");
        Provincia p17=new Provincia("Salta","salta.webp");
        Provincia p18=new Provincia("San Juan","sanjuan.webp");
        Provincia p19=new Provincia("San Luis","sanluis.webp");
        Provincia p20=new Provincia("Santa Cruz","santacruz.webp");
        Provincia p21=new Provincia("Santa Fe","santafe.webp");
        Provincia p22=new Provincia("Santiago del Estero","santiagodelestero.webp");
        Provincia p23=new Provincia("Tierra del Fuego","tierradelfuego.webp");
        Provincia p24=new Provincia("Tucuman","tucuman.webp");
        prs.saveProvincia(p1);
        prs.saveProvincia(p2);
        prs.saveProvincia(p3);
        prs.saveProvincia(p4);
        prs.saveProvincia(p5);
        prs.saveProvincia(p6);
        prs.saveProvincia(p7);
        prs.saveProvincia(p8);
        prs.saveProvincia(p9);
        prs.saveProvincia(p10);
        prs.saveProvincia(p11);
        prs.saveProvincia(p12);
        prs.saveProvincia(p13);
        prs.saveProvincia(p14);
        prs.saveProvincia(p15);
        prs.saveProvincia(p16);
        prs.saveProvincia(p17);
        prs.saveProvincia(p18);
        prs.saveProvincia(p19);
        prs.saveProvincia(p20);
        prs.saveProvincia(p21);
        prs.saveProvincia(p22);
        prs.saveProvincia(p23);
        prs.saveProvincia(p24);
        Estadistica esta=new Estadistica();
        es.saveEstadistica(esta);
        FormDTO formDTO=new FormDTO();
        formDTO.setFechaM(new Date().toString());
        formDTO.setNombre("Formulario de Preguntas Personales");
        fs.saveForm(formDTO);
        TestDTO test=new TestDTO();
        test.setFechaM(new Date().toString());
        test.setNombre("test inizializado");
        test.setTiempo(60);
        tdtos.saveTest(test);
        return "redirect:/admin";
    }
    //controlador que elimina usuario
    @GetMapping("/ingresante/delete")
    public String delete(@RequestParam(required = false, name = "id") Long id){
        ingres.deleteIngresante(id);

        return "redirect:/admin/filtrar";
    }
    //controlador que elimina todos los usuarios
    @GetMapping("/resetingresantes")
    public String deleteAllingresantes(Model model){
          ArrayList<Long>ids=new ArrayList<>();
          for (Ingresante ingre: ingres.findAllIngresante()){
              ids.add(ingre.getId());
          }
          for (Long id:ids){
              ingres.deleteIngresante(id);
          }


for (Provincia pro:prs.findAllProvincia()){
    pro.setTestTerminado(0);
    pro.setNoBinario(0);
    pro.setFormularioTerminado(0);
    pro.setFemenino(0);
    pro.setMasculino(0);
    pro.setRegistrados(0);
    pro.setRegistrosTotales(0);
    prs.saveProvincia(pro);
}
for (Estadistica pro:es.findAllEstadistica()){
    pro.setTestTerminado(0);
    pro.setNoBinario(0);
    pro.setFormularioTerminado(0);
    pro.setFemenino(0);
    pro.setMasculino(0);
    pro.setRegistrados(0);
    pro.setRegistrosTotales(0);
  es.saveEstadistica(pro);
}

        return "redirect:/admin/";

    }

    @PostMapping("/guardar-user")
    public String superUser(Usuario usuario) {


        Usuario usu = new Usuario();
        usu.setAlta(new Date());
        usu.setApellido(usuario.getApellido());
        usu.setNombre(usuario.getNombre());
        usu.setEmail(usuario.getEmail());
        usu.setUsername(usu.getEmail());
        usu.setClave(EncriptarPassword.encriptarPassword(usuario.getClave()));
        usu.setPermisos(usuario.getPermisos());
        ur.save(usu);
        return "redirect:/admin/listausuarios";


    }
    @GetMapping("/listausuarios")
    private String listaUser(Model model){

        model.addAttribute("usuario",new Usuario());
        model.addAttribute("lisusuarios",ur.findAll());

        return "usuarios";
    }

    @GetMapping("/eliminar-user")
    public String deleteUser(@RequestParam(required = false, name = "id") Long id) {
        Usuario eliminado = ur.findById(id).orElse(null);

        if (eliminado != null) {

            ur.delete(eliminado);


            return "redirect:/admin/listausuarios";

        } else {
            return "redirect:/admin/listausuarios";

        }


    }
  @GetMapping("/eliminarDuplicados")
    public String eliminarDuplicados(){
        List<Ingresante>listaoriginal=ingres.findAllIngresante();
        Set<Ingresante>listaverificada=new TreeSet<>();
       for (Ingresante ingre:listaoriginal){
           listaverificada.add(ingre);
       };

      System.out.println("tamaño lista original"+listaoriginal.size());
      System.out.println("tamaño lista verificada"+listaverificada.size());
      System.out.println("diferencia"+(listaoriginal.size()-listaverificada.size()));
List<Ingresante>aEliminar=new ArrayList<>();
   Iterator<Ingresante>iteradorIngre=listaoriginal.iterator();
   while (iteradorIngre.hasNext()){
       Ingresante comparador=iteradorIngre.next();
       for (Ingresante ingre:listaverificada){
           if(comparador.getId()==ingre.getId()){
              iteradorIngre.remove();
           }
       }
   }

      System.out.println("tamaño final de la lista original es"+listaoriginal.size());
for (Ingresante ingre:listaoriginal){

         prs.restarIngresantes(ingre);
         es.restarIngresantes(ingre);
         ingres.deleteIngresante(ingre.getId());
}

        return "redirect:/admin/";
  }


//    @GetMapping("/verificarpreguntas")
//    public void verificarPreguntas() throws IOException{
//      List<Ingresante>listaIngre=ingres.findAllIngresante();
//      Set<Ingresante> listaIngre2=new TreeSet<>();
//      List<String>nombre=new ArrayList<>();
//      for (Ingresante in:listaIngre){
//         listaIngre2.add(in);
//
//      }
// String ruta="C:/Users/jorge/Documents/ingresantes/listaingresantes.txt";
//      FileWriter listaingresantes=new FileWriter(ruta);
//      int contador=1;
//       for (Ingresante ingre:listaIngre2){
//        listaingresantes.write("********************"+contador+"***********************"+"\n");
//        listaingresantes.write(ingre.getNombre()+" "+ingre.getApellido()+" con DNI:"+ingre.getNumDoc()+"\n");
//        for(TestAMateria mat:ingre.getTestAlumno().getMateriasAlumno()){
//            String nombreMateria=mat.getNombre().toUpperCase();
//            int tamanio=mat.getPreguntasAlumno().size();
//            listaingresantes.write(nombreMateria+" tiene "+tamanio+" preguntas"+"\n");
//
//
//        }
//contador ++;
//
//
//       }
//        listaingresantes.close();
//
//    }
   @Async
    @GetMapping("/validarTest")
    public String validar(){
        List<Ingresante>ingresantes=ingres.findAllIngresante();
        for (Ingresante ingre: ingresantes){
           if(ingre.getTest()==null){
               ingre.setTest(ingre.getTestAlumno().getEstado());
               ingres.saveIngresante(ingre);
           }
        }
        return "redirect:/admin/";
    }
    @GetMapping("/habilitar-formulario")
    public String habilitarformulario(){
        Estadistica estadistica=es.findEstadisticaById(1L);
        if(estadistica.getFormuHabilitado()==null){
            estadistica.setFormuHabilitado("no");
        }else if(estadistica.getFormuHabilitado().equalsIgnoreCase("si")){
            estadistica.setFormuHabilitado("no");
        }else if(estadistica.getFormuHabilitado().equalsIgnoreCase("no")){
            estadistica.setFormuHabilitado("si");
        }
        es.saveEstadistica(estadistica);
        return "redirect:/admin/";
    }

}
