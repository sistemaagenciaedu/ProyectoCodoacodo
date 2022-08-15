package codoacodo.example.codo.Controllers.Publico;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.FormAlumService;
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
    @GetMapping("/reg")
    public String verRegistro(Model model){
        Ingresante ingresante=new Ingresante();
        model.addAttribute("ingresante",ingresante);
        model.addAttribute("listaNacionalidades", lis.devolverNacionalidades());
        model.addAttribute("testimonios", testimonioService.findAllTesti());
        return "registro";
    }
        @PostMapping("/save")
       public String saveIngre(Ingresante ingresante, Model model) {
            FormAlum formAlum=fars.FormDtoTOFormAlum(fdtos.findFormById(1L));
            ingresante.setFormAlum(formAlum);
            ingresante=inser.saveIngresante(ingresante);
            provs.sumarIngresantes(ingresante);
            estas.sumarIngresantes(ingresante);
            TestDTO testDTO=tdtos.findTestById(1L);
            if (testDTO.getMaterias().size()!=0){
                ingresante.setTestAlumno(tas.TestDtoTotestAlumno(testDTO));
                inser.saveIngresante(ingresante);
            }
        return "redirect:/";
       }



}