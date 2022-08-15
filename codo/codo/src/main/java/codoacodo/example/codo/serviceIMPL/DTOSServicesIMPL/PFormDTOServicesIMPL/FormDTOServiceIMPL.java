package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PFormDTOServicesIMPL;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PackFormDTORepository.FormDTORepository;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.FormDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormDTOServiceIMPL implements FormDTOService {
    @Autowired
    private FormDTORepository fr;
    @Override
    public FormDTO saveForm(FormDTO form) {

        return fr.save(form);
    }

    @Override
    public void deleteFormDTO(Long id) {
        fr.delete(findFormById(id));
    }

    @Override
    public List<FormDTO> findAllForms() {

        return (List <FormDTO>)fr.findAll();
    }

    @Override
    public FormDTO findFormById(Long id) {
        return fr.findById(id).orElse(null);
    }
}
