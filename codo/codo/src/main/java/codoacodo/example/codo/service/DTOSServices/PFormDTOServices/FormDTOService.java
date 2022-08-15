package codoacodo.example.codo.service.DTOSServices.PFormDTOServices;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;

import java.util.List;

public interface FormDTOService{
    public FormDTO saveForm(FormDTO form);
    public void deleteFormDTO(Long id);
    public  List<FormDTO> findAllForms();
    public FormDTO findFormById(Long Id);
}
