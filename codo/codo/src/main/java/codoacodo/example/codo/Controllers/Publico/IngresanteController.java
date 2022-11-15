package codoacodo.example.codo.Controllers.Publico;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAOpcion;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAPregunta;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.Estadistica;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.FormAlumService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.PreguntaAlumService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAMateriaService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAPreguntaService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.TestAlumPackService.TestAlumnoService;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.FormDTOService;
import codoacodo.example.codo.service.DTOSServices.PTestDtoService.TestDTOService;
import codoacodo.example.codo.service.IngresanteService;
import codoacodo.example.codo.service.editabilidadServices.EstadisticaService;
import codoacodo.example.codo.service.editabilidadServices.ProvinciaService;
import codoacodo.example.codo.service.editabilidadServices.TestimonioService;
import codoacodo.example.codo.utiles.Listas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller

@RequestMapping("/ingresante")
public class IngresanteController {
    @Autowired
    private Listas lis;
    @Autowired
    private TestimonioService testimonioService;
    @Autowired
    private IngresanteService inser;
    @Autowired
    private FormAlumService fars;
    @Autowired
    private FormDTOService fdtos;
    @Autowired
    private ProvinciaService provs;
    @Autowired
    private TestAlumnoService tas;
    @Autowired
    private TestDTOService tdtos;
    @Autowired
    private EstadisticaService estas;
    @Autowired
    private PreguntaAlumService pas;
    @Autowired
    private TestAPreguntaService taps;
    @Autowired
    private ProvinciaService prs;
    @Autowired
    private EstadisticaService es;
    @Autowired
    private TestAMateriaService tams;

    @GetMapping("/reg")
    public String verRegistro(Model model) {
        Ingresante ingresante = new Ingresante();
        Estadistica estadistica=es.findEstadisticaById(1L);
        model.addAttribute("ingresante", ingresante);
        model.addAttribute("formulario", estadistica.getFormuHabilitado());
        model.addAttribute("listaNacionalidades", lis.devolverNacionalidades());
        model.addAttribute("testimonios", testimonioService.findAllTesti());
        return "registro";
    }

    @PostMapping("/save")
    public String saveIngre(Ingresante ingresante, Model model) {
        Estadistica estadistica=es.findEstadisticaById(1L);
if (estadistica.getFormuHabilitado().equalsIgnoreCase("si")){

    Ingresante busqueda = inser.findIngresanteByDoc(ingresante.getNumDoc());
    if (busqueda == null) {
        FormAlum formAlum = fars.FormDtoTOFormAlum(fdtos.findFormById(1L));
        ingresante.setFormAlum(formAlum);
        ingresante = inser.saveIngresante(ingresante);
        provs.sumarIngresantes(ingresante);
        estas.sumarIngresantes(ingresante);
        TestDTO testDTO = tdtos.findTestById(1L);
        if (testDTO.getMaterias().size() != 0) {
            ingresante.setTestAlumno(tas.TestDtoTotestAlumno(testDTO));
            inser.saveIngresante(ingresante);
        }

        return "redirect:/ingresante/ingreso";
    } else {
        model.addAttribute("advertenvia", "el registro ya existe por favor ingrese");
        return "ingreso-alumno";
    }
}else{
    return "redirect:/ingresante/reg";
}
    }

    @GetMapping("/ingreso")
    public String vistaIngreso(Ingresante ingresante, Model model) {
        model.addAttribute("testimonios", testimonioService.findAllTesti());

        return "ingreso-alumno";
    }

    @PostMapping("/login")
    public String login(String email, String doc, Model model) {
        Estadistica estadistica=es.findEstadisticaById(1L);
        if (estadistica.getFormuHabilitado().equalsIgnoreCase("si")){
            List<Ingresante>verificacionDeDuplicados=inser.buscarTodosLosDNIQueMacheen(doc);
            List<Long>dnisDuplicados=new ArrayList<>();
            if (verificacionDeDuplicados.size()>1){
                for (int i = 0; i <verificacionDeDuplicados.size() ; i++) {
                    if(i>0){
                        dnisDuplicados.add(verificacionDeDuplicados.get(i).getId());
                        prs.restarIngresantes(verificacionDeDuplicados.get(i));
                        es.restarIngresantes(verificacionDeDuplicados.get(i));
                    }
                }
                for (Long dni:dnisDuplicados){
                    inser.deleteIngresante(dni);
                }
            }
            Ingresante busqueda = inser.findIngresanteByDoc(doc);
            if (busqueda != null && busqueda.getMail().equalsIgnoreCase(email)) {
                model.addAttribute("ingresante", busqueda);
                return "panel-ingresante";
            } else {
                model.addAttribute("testimonios", testimonioService.findAllTesti());
                return "ingreso-alumno";
            }
        }else{
            return "redirect:/ingresante/reg";
        }


    }


    @GetMapping("/cuestionario")
    public String cuestionario(@RequestParam(required = false, name = "idIngresante") Long idIngresante, Model model) {
        Ingresante pd = inser.findIngresanteById(idIngresante);
        Estadistica estadistica=es.findEstadisticaById(1L);
        if (estadistica.getFormuHabilitado().equalsIgnoreCase("si")) {
            if (pd.getFormAlum().getEstado() == false) {
                for (PreguntaAlum r : pd.getFormAlum().getPreguntas()) {
                    System.out.println(r.toString());
                }
                TreeSet<PreguntaAlum> preguntas = new TreeSet<>();
                for (PreguntaAlum d : pd.getFormAlum().getPreguntas()) {
                    preguntas.add(d);
                }
                for (PreguntaAlum res : preguntas) {
                    System.out.println(res.toString());
                    if (res.getRespuesta() == null) {
                        model.addAttribute("idIngresante", idIngresante);
                        model.addAttribute("respuesta", res);
                        break;
                    }

                }
                return "cuestionario";
            } else {
                model.addAttribute("ingresante", pd);
                return "panel-ingresante";
            }
        }else{
            return "redirect:/ingresante/reg";
        }

    }

    @PostMapping("/cuestionario/save")
    public String cuestionarioSave(@RequestParam(required = false, name = "idIngresante") Long idIngresante, PreguntaAlum respuesta, @RequestParam(required = false, name = "rx") List<String> rx, Model model) {
        PreguntaAlum r = pas.findPregById(respuesta.getId());
        Estadistica estadistica=es.findEstadisticaById(1L);
        if (estadistica.getFormuHabilitado().equalsIgnoreCase("si")) {
            boolean falta = false;
            if (rx.isEmpty()) {

                r.setRespuesta(respuesta.getRespuesta());
            } else {
                String respu = "";
                for (String p : rx) {
                    respu = p;
                }

                r.setRespuesta(respu);
            }
            pas.savePreg(r);
            Ingresante contador = inser.findIngresanteById(idIngresante);
            for (PreguntaAlum rt : contador.getFormAlum().getPreguntas()) {
                if (rt.getRespuesta() == null) {
                    falta = true;
                    break;
                }
            }
            if (falta) {

                return "redirect:/ingresante/cuestionario?idIngresante=" + idIngresante;
            } else {

                FormAlum formAlum = fars.findFormById(contador.getFormAlum().getId());

                formAlum.setEstado(true);
                fars.saveForm(formAlum);
                formAlum = fars.findFormById(contador.getFormAlum().getId());
                contador = inser.findIngresanteById(idIngresante);
                contador.setEncuesta(true);
                contador = inser.saveIngresante(contador);
                prs.sumarIngresantesFormulario(contador);
                es.sumarIngresantesFormulario(contador);
                model.addAttribute("ingresante", contador);
                return "panel-ingresante";
            }
        }else{
            return "redirect:/ingresante/reg";
        }

    }

    @GetMapping("/test")
    public String test(@RequestParam(required = false, name = "idIngresante") Long idIngresante, Model model) {
        Estadistica estadistica=es.findEstadisticaById(1L);
        if (estadistica.getFormuHabilitado().equalsIgnoreCase("si")) {
            Ingresante pd = inser.findIngresanteById(idIngresante);
            long hoy =new Date().getTime();
            if(pd.getTestAlumno().getFechaFin()==null || hoy<pd.getTestAlumno().getFechaFin()){
                TestAMateria materiaalumno = new TestAMateria();
                TestAPregunta pregunta = new TestAPregunta();
                if (pd.getTestAlumno().getEstado() == false) {
                    if(pd.getTestAlumno().getFechaFin()==null){
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.MINUTE, pd.getTestAlumno().getTiempo());

                        pd.getTestAlumno().setFechaFin(calendar.getTime().getTime());
                        pd=inser.saveIngresante(pd);
                    }
                    TreeSet<TestAMateria> materias = new TreeSet<>();
                    for (TestAMateria mate : pd.getTestAlumno().getMateriasAlumno()) {
                        materias.add(mate);
                    }
                    for (TestAMateria mate : materias) {
                        if (mate.getEstado() == false) {
                            materiaalumno = mate;
                        } else {
                            continue;
                        }

                    }
                    TreeSet<TestAPregunta> preguntas = new TreeSet<>();
                    for (TestAPregunta p : materiaalumno.getPreguntasAlumno()) {
                        preguntas.add(p);
                    }
                    for (TestAPregunta pregun : preguntas) {
                        if (pregun.getEstado() == false) {
                            pregunta = pregun;
                        }
                    }
                    System.out.println(pregunta.getPregunta());
                    System.out.println(pregunta.getId());
                    System.out.println(pregunta.getPortadaImagen());
                    System.out.println(pregunta.getTipoOpcion());
                    System.out.println(pregunta.getTipoPortada());
                    model.addAttribute("idIngresante", idIngresante);
                    model.addAttribute("pregunta", pregunta);
//            Long fin=new Date(pd.getTestAlumno().getFechaFin()).getTime();
                    model.addAttribute("ahora",new Date().getTime());
                    model.addAttribute("fin", pd.getTestAlumno().getFechaFin());

                    return "pregunta-test";
                }else{
                    model.addAttribute("ingresante", pd);
                    return "panel-ingresante";
                }
            }else{
                pd.getTestAlumno().setEstado(true);
                pd.setTest(true);
                inser.saveIngresante(pd);
                model.addAttribute("ingresante", pd);
                return "panel-ingresante";
            }
        }else{
            return "redirect:/ingresante/reg";
        }



    }


    @PostMapping("/test/save")
    public String testSave(@RequestParam(required = false, name = "idIngresante") Long idIngresante, PreguntaAlum pregunta, @RequestParam(required = false, name = "rx") List<String> rx, Model model) {
        try {
            TestAPregunta r = taps.findPreguntaTestById(pregunta.getId());

            boolean falta = false;
            if (rx.isEmpty()) {

                r.setRespuesta(null);
            } else {
                String respu = "";
                for (String p : rx) {
                    respu = p;
                }

                r.setRespuesta(Long.parseLong(respu));
                r.setEstado(true);
                int res=r.getRespuesta().intValue();
                for (TestAOpcion op: r.getOpcionestestalumno()){
                    if(op.getEsCorrecta().equalsIgnoreCase("si")){
                        int id=op.getId().intValue();
                        if (res==id){
                            r.setPunto(1);
                        }else{
                            r.setPunto(0);
                        }
                    }
                }
            }

            taps.savePreguntaTest(r);
            Ingresante ingresante= inser.findIngresanteById(idIngresante);
            for (TestAMateria mate:ingresante.getTestAlumno().getMateriasAlumno()){
                if(mate.getEstado()==false){
                    int tamanio=mate.getPreguntasAlumno().size();
                    int contador=0;
                    int puntos=0;
                    for (TestAPregunta pre:mate.getPreguntasAlumno()){
                        if(pre.getEstado()==true){
                            contador++;
                            puntos=puntos+pre.getPunto();
                        }
                        if(contador==tamanio){
                            mate.setEstado(true);
                            mate.setPuntos(puntos);
                            tams.saveMateriaTest(mate);
                        }
                    }

                }
            }
            boolean verificador=false;
            ingresante= inser.findIngresanteById(idIngresante);
            for (TestAMateria materias: ingresante.getTestAlumno().getMateriasAlumno()){
                int contadorMate=0;
                int tamanioMate=ingresante.getTestAlumno().getMateriasAlumno().size();
                int puntosMate=0;
                if(materias.getEstado()==true){
                    contadorMate++;
                    puntosMate=puntosMate+materias.getPuntos();
                }
                System.out.println("materias finalizadas van:"+contadorMate);
                System.out.println("el tamaño de las terias es"+tamanioMate);
                if (contadorMate==tamanioMate){
                    ingresante.getTestAlumno().setEstado(true);
                    ingresante.setTest(true);
                    ingresante.getTestAlumno().setPuntos(puntosMate);
                    tas.saveTestAlumno(ingresante.getTestAlumno());

                }
            }
            ingresante= inser.findIngresanteById(idIngresante);
            boolean finalizado=false;
            int contadorFin=0;
            int puntaje=0;
            for (TestAMateria tam: ingresante.getTestAlumno().getMateriasAlumno()){
                if (tam.getEstado()==true){
                    contadorFin++;
                    puntaje=puntaje+tam.getPuntos();
                }
            }
            if (contadorFin==ingresante.getTestAlumno().getMateriasAlumno().size() ){
                ingresante.getTestAlumno().setEstado(true);
                ingresante.setTest(true);
                ingresante.getTestAlumno().setPuntos(puntaje);
                tas.saveTestAlumno(ingresante.getTestAlumno());
                finalizado=true;
            }
            if (finalizado){
                ingresante= inser.findIngresanteById(idIngresante);
                es.sumarIngresantesTest(ingresante);
                provs.sumarIngresantesTest(ingresante);
                model.addAttribute("ingresante", ingresante);
                return "panel-ingresante";
            }else{
                return "redirect:/ingresante/test?idIngresante="+idIngresante;
            }
        }catch (Exception e){
            return "redirect:/ingresante/test?idIngresante="+idIngresante;
        }

    }


}







