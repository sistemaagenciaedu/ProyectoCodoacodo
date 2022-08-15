package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.FormAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository.FormAlumRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.FormAlumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormAlumServiceIMPL  implements FormAlumService {
@Autowired
private FormAlumRepository far;
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
}
