package codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;

import java.util.List;

public interface FormAlumService {
    public FormAlum saveForm(FormAlum form);
    public void deleteForm(Long id);
    public List<FormAlum> findAllForms();
    public  FormAlum findFormById(Long id);

    public FormAlum FormDtoTOFormAlum(FormDTO formDTO);
}
