package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.editabilidad.Provincia;
import codoacodo.example.codo.repositories.editabilidadRepositories.ProvinciaRepository;
import codoacodo.example.codo.service.editabilidadServices.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceIMPL implements ProvinciaService {
    @Autowired
    ProvinciaRepository pr;

    @Override
    public Provincia saveProvincia(Provincia provincia) {
        return pr.save(provincia);
    }

    @Override
    public void deleteProvincia(Long id) {
        pr.deleteById(id);
    }

    @Override
    public List<Provincia> findAllProvincia() {
        return pr.findAll();
    }

    @Override
    public Provincia findProvinciaById(Long id) {
        return pr.findById(id).orElse(null);
    }
}
