package codoacodo.example.codo.Controllers.Publico;

import codoacodo.example.codo.Entities.Usuario;
import codoacodo.example.codo.repositories.UsuarioRepository;
import codoacodo.example.codo.service.editabilidadServices.CursoService;
import codoacodo.example.codo.service.editabilidadServices.ProvinciaService;
import codoacodo.example.codo.service.editabilidadServices.TestimonioService;
import codoacodo.example.codo.web.EncriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

@RequestMapping("/")
public class HomeController {
    @Autowired
    private TestimonioService testimonioService;
    @Autowired
    private ProvinciaService prs;
    @Autowired
    private CursoService cs;
    @Autowired
    private UsuarioRepository ur;
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

    @GetMapping("/administrador/crear-super-user")
    public String superUser() {

        List<Usuario> userLis = new ArrayList<>();
        userLis = ur.findAll();
        if (userLis.size() == 0) {
            Usuario usu = new Usuario();
            usu.setAlta(new Date());
            usu.setApellido("SuperAdmin");
            usu.setNombre("Admin");
            usu.setEmail("superadmin@bue.edu.ar");
            usu.setUsername(usu.getEmail());
            usu.setClave(EncriptarPassword.encriptarPassword("sistemas"));
            ur.save(usu);

        }
        return "index";
    }


}