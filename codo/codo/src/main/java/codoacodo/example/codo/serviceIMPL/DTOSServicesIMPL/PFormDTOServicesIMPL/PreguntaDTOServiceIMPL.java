package codoacodo.example.codo.serviceIMPL.DTOSServicesIMPL.PFormDTOServicesIMPL;


import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;
import codoacodo.example.codo.repositories.DTOSRepositories.PackFormDTORepository.PreguntaDTORepository;
import codoacodo.example.codo.service.DTOSServices.PFormDTOServices.PreguntaDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

@Service

public class PreguntaDTOServiceIMPL implements PreguntaDTOService {
@Autowired
private PreguntaDTORepository pr;
    @Override
    public PreguntaDTO savePreg(PreguntaDTO preg) {
        return pr.save(preg);
    }

    @Override
    public void deletePreg(Long id)  {
        pr.deleteById(id);
    }

    @Override
    public TreeSet<PreguntaDTO> findAllPreg() {
        List<PreguntaDTO> pre=pr.findAll();
        TreeSet<PreguntaDTO> preguntas= new TreeSet<>();
        for (PreguntaDTO p: pre) {
            preguntas.add(p);
        }
        return preguntas;
    }

    @Override
    public TreeSet<PreguntaDTO> findAllPregByForm(Long id) {
        TreeSet<PreguntaDTO> listaVerificada=new TreeSet<>();
        TreeSet<PreguntaDTO> listaOriginal=findAllPreg();
        if (!listaOriginal.isEmpty()){
            for (PreguntaDTO p: listaOriginal ) {
                if(p.getFormulario().getId()==id){
                    listaVerificada.add(p);
                }
            }}
        return listaVerificada;
    }

    @Override
    public PreguntaDTO findPregById(Long id)  {
        return pr.findById(id).orElse(null);
    }
}
