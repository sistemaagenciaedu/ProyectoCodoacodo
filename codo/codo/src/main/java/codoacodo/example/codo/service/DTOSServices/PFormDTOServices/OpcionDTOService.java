package codoacodo.example.codo.service.DTOSServices.PFormDTOServices;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.OpcionDTO;

import java.util.List;

public interface OpcionDTOService {
    OpcionDTO saveOpcionDTO(OpcionDTO opcion);
    void deleteOpcionDTO(Long id);
    List<OpcionDTO> findAllOpcionDTO();
    List<OpcionDTO> findAllOpcionDTOByPreg(Long id);

    OpcionDTO findOpcionDTOById(Long id);


}
