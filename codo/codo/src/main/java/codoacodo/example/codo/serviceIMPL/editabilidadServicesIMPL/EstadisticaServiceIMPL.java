package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.editabilidad.Estadistica;
import codoacodo.example.codo.repositories.editabilidadRepositories.EstadisticaRepository;
import codoacodo.example.codo.service.editabilidadServices.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadisticaServiceIMPL implements EstadisticaService {
   @Autowired
    private EstadisticaRepository er;
    @Override
    public Estadistica saveEstadistica(Estadistica estadistica) {
        return er.save(estadistica);
    }

    @Override
    public void deleteEstadistica(Long id) {
        er.deleteById(id);
    }

    @Override
    public List<Estadistica> findAllEstadistica() {
        return er.findAll();
    }

    @Override
    public Estadistica findEstadisticaById(Long id) {
        return er.findById(id).orElse(null);
    }
}
