package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.FormAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.OpcionAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.OpcionDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository.FormAlumRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.FormAlumService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.OpcionAlumService;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.PreguntaAlumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormAlumServiceIMPL  implements FormAlumService {
@Autowired
private FormAlumRepository far;
@Autowired
private PreguntaAlumService pars;
@Autowired
private OpcionAlumService ops;
    @Override
    public FormAlum saveForm(FormAlum form)  {
        return far.save(form);
    }

    @Override
    public void deleteForm(Long id) {
        far.deleteById(id);
    }

    @Override
    public List<FormAlum> findAllForms()  {
        return far.findAll();
    }

    @Override
    public FormAlum findFormById(Long id)  {
        return far.findById(id).orElse(null);
    }

    @Override
    public FormAlum FormDtoTOFormAlum(FormDTO formDTO) {
        FormAlum formAlum=new FormAlum();
        formAlum.setEstado(false);
        formAlum.setFechaM(new Date().toString());
        formAlum.setNombre(formDTO.getNombre());
        formAlum=saveForm(formAlum);
        for(PreguntaDTO preg:formDTO.getPreguntas()){
            PreguntaAlum preguntaAlum=new PreguntaAlum();
            preguntaAlum.setIdPregunta(preg.getId());
            preguntaAlum.setDescripcion(preg.getDescripcion());
            preguntaAlum.setEnunciado(preg.getEnunciado());
            preguntaAlum.setTipo(preg.getTipo());
            preguntaAlum.setFechaM(new Date().toString());
            preguntaAlum.setAsociacionId(preg.getAsociacionId());
            preguntaAlum.setFormulario(formAlum);
            preguntaAlum=pars.savePreg(preguntaAlum);
            for (OpcionDTO opcion:preg.getOpciones()){
                OpcionAlum opcionAlum=new OpcionAlum();
                opcionAlum.setDescripcion(opcion.getDescripcion());
                opcionAlum.setFechaM(new Date().toString());
                opcionAlum.setPregunta(preguntaAlum);
                ops.saveOpcion(opcionAlum);
            }
        }

        return formAlum;
    }

}
