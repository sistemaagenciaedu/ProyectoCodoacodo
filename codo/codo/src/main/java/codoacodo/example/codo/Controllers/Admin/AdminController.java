package codoacodo.example.codo.Controllers.Admin;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.OpcionDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.OpcionTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.PreguntaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.Curso;
import codoacodo.example.codo.Entities.editabilidad.Estadistica;
import codoacodo.example.codo.Entities.editabilidad.Provincia;
import codoacodo.example.codo.Entities.editabilidad.Testimonio;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.FormDTOService;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.OpcionDTOService;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.PreguntaDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.MateriaTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.OpcionTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.PreguntaTestDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.TestDTOService;
import codoacodo.example.codo.service.IngresanteService;
import codoacodo.example.codo.service.editabilidadServices.*;
import codoacodo.example.codo.utiles.ExcelFileExporter;
import codoacodo.example.codo.utiles.GenerarListaConTexto;
import codoacodo.example.codo.utiles.Listas;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

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
//controlador panel de administracion
    @GetMapping("")
    public String panelAdmin(Model model, Ingresante ingresante){
        ArrayList<Provincia> provinciax= (ArrayList<Provincia>) prs.findAllProvincia();
        if (provinciax.isEmpty()){
            return "redirect:/admin/inicializarelproyecto" ;
        }else{
            model.addAttribute("listaNacionalidades", lis.devolverNacionalidades());
            model.addAttribute("provincias",provinciax);
            model.addAttribute("ingresante",ingresante);
            return "paneladministrador";
        }

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
public String listar(Long idMat,Long idTest,Long idPreg , Model model,String tOpcion){
    model.addAttribute("opciones",optestdtos.findAllOpcionTestXPregunta(idPreg));
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

            if (encuesta.equalsIgnoreCase("")) {
                encuesta = null;
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
            lista = ingres.getByFilter(query, desde,  hasta,  genero,  encuesta,tIngles, tProgramacion,tLogica , order);
        }
    }

    model.addAttribute("ingre", lista);
    model.addAttribute("quer", query);
    model.addAttribute("des", desde);
    model.addAttribute("has", hasta);
    model.addAttribute("gen", genero);
    model.addAttribute("enc", encuesta);
    model.addAttribute("tIng", tIngles);
    model.addAttribute("tPro", tProgramacion);
    model.addAttribute("tLog", tLogica);
    model.addAttribute("ord", order);

    return "tablaingresantes";
}
//Controlador de exportacion a excel
@GetMapping("/filtrar/ing.xlsx")
    public void downloadCsvFiltrado(
        HttpServletResponse response, @RequestParam(required = false, name = "num")Long num,
        @RequestParam(required = false, name = "desde") String desde,
        @RequestParam(required = false, name = "query") String query,
        @RequestParam(required = false, name = "hasta") String hasta,
        @RequestParam(required = false, name = "genero") String genero,
        @RequestParam(required = false, name = "encuesta") String encuesta,
        @RequestParam(required = false, name = "tIngles") String tIngles,
        @RequestParam(required = false, name = "tProgramacion") String tProgramacion,
        @RequestParam(required = false, name = "tLogica") String tLogica,
        @RequestParam(required = false, defaultValue = "ASC") String order,
        @RequestParam(required = false,  defaultValue = "no") String no

    ) throws IOException {
        List<Ingresante> lista = new ArrayList<>();
        if(no.equalsIgnoreCase("no")){

        }else{
            if (query.equalsIgnoreCase("") && desde.equalsIgnoreCase("") && hasta.equalsIgnoreCase("") && genero.equalsIgnoreCase("") && encuesta.equalsIgnoreCase("") && tIngles.equalsIgnoreCase("")  && tLogica.equalsIgnoreCase("")   && tProgramacion.equalsIgnoreCase("")   ) {
                lista = ingres.findAllIngresante();
            } else {

                if (encuesta.equalsIgnoreCase("")) {
                    encuesta = null;
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
                lista = ingres.getByFilter(query, desde,  hasta,  genero,  encuesta,tIngles, tProgramacion,tLogica , order);
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
//            model.addAttribute("ingre",ingresantex);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=ing.xlsx");

//            ByteArrayInputStream stream = ExcelFileExporter.ingresantesExcelExpoter(preguntas,ingresantex);
        XSSFWorkbook workbook= ExcelFileExporter.ingresantesExcelExpoter(tdtos.findTestById(1L),fs.findFormById(1L),ingresantex);

//            System.out.println("llego");
//            workbook.write(response.getOutputStream());
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
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
        return "redirect:/admin";
    }
}
