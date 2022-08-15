package codoacodo.example.codo.Controllers.Publico;

import codoacodo.example.codo.service.editabilidadServices.CursoService;
import codoacodo.example.codo.service.editabilidadServices.ProvinciaService;
import codoacodo.example.codo.service.editabilidadServices.TestimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class HomeController {
    @Autowired
    private TestimonioService testimonioService;
    @Autowired
    private ProvinciaService prs;
    @Autowired
    private CursoService cs;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("testimonios", testimonioService.findAllTesti());

        return "index";
    }

    @GetMapping("/cursos")
    public String cursos(){
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listarTesti(Model model){
        model.addAttribute("cursos",cs.findAllCurso());
        return "listarcursos";
    }
    @GetMapping("/cursosejemplos")
    public String cursosejemplo(){
        return "cursos";
    }



}