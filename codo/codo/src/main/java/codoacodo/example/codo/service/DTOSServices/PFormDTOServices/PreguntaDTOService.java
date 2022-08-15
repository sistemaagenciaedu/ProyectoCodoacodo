package codoacodo.example.codo.service.DTOSServices.PFormDTOServices;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;

import java.util.TreeSet;

public interface PreguntaDTOService{
    public PreguntaDTO savePreg(PreguntaDTO preg);
    public void deletePreg(Long id);
    public TreeSet<PreguntaDTO> findAllPreg();
    public TreeSet<PreguntaDTO> findAllPregByForm(Long id);
    public PreguntaDTO findPregById(Long id);
}
