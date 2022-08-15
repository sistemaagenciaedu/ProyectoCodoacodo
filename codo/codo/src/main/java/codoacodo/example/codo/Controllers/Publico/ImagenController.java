package codoacodo.example.codo.Controllers.Publico;

import codoacodo.example.codo.Entities.editabilidad.Curso;
import codoacodo.example.codo.Entities.editabilidad.Testimonio;
import codoacodo.example.codo.service.editabilidadServices.CursoService;
import codoacodo.example.codo.service.editabilidadServices.ImagenService;
import codoacodo.example.codo.service.editabilidadServices.TestimonioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/imagen")
public class ImagenController {
@Autowired
    private TestimonioService ts;
@Autowired
private CursoService cs;
@Autowired
private ImagenService ims;
    @GetMapping("/testimonio")
    private ResponseEntity<byte[]> Foto(@RequestParam Long id) {
        Testimonio testi = ts.findTestiById(id);

        if (testi.getImagen().getContenido() != null) {
            byte[] imagen = testi.getImagen().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        } else {
            return null;
        }
    }
    @GetMapping("/curso")
    private ResponseEntity<byte[]> FotoCurso(@RequestParam Long id) {

        Curso curso=cs.findCursoById(id);
        if (curso.getImagen().getContenido() != null) {
            byte[] imagen = curso.getImagen().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        } else {
            return null;
        }
    }

    @GetMapping("/img")
    private ResponseEntity<byte[]> Fotoxid(@RequestParam Long id) {


        if (id != null) {
            byte[] imagen = ims.listar(id).orElse(null).getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        } else {
            return null;
        }
    }

}