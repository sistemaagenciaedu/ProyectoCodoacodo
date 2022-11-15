package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.Estadistica;
import codoacodo.example.codo.Entities.editabilidad.Provincia;
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

    @Override
    public void sumarIngresantes(Ingresante ingre) {
        Estadistica estadistica=findEstadisticaById(1L);
      estadistica.setRegistrosTotales(estadistica.getRegistrosTotales()+1);
       if (ingre.getGenero().equalsIgnoreCase("Masculino")){
                    estadistica.setMasculino(estadistica.getMasculino()+1);
       }else   if (ingre.getGenero().equalsIgnoreCase("Femenino")){
                    estadistica.setFemenino(estadistica.getFemenino()+1);

        }else{
         estadistica.setNoBinario(estadistica.getNoBinario()+1);
        }
       saveEstadistica(estadistica);

    }
    @Override
    public void restarIngresantes(Ingresante ingre) {
        Estadistica estadistica=findEstadisticaById(1L);
      estadistica.setRegistrosTotales(estadistica.getRegistrosTotales()-1);
       if (ingre.getGenero().equalsIgnoreCase("Masculino")){
                    estadistica.setMasculino(estadistica.getMasculino()-1);
       }else   if (ingre.getGenero().equalsIgnoreCase("Femenino")){
                    estadistica.setFemenino(estadistica.getFemenino()-1);

        }else{
         estadistica.setNoBinario(estadistica.getNoBinario()-1);
        }
       saveEstadistica(estadistica);

    }

    @Override
    public void sumarIngresantesFormulario(Ingresante ingre) {
        Estadistica estadistica=findEstadisticaById(1L);
        estadistica.setFormularioTerminado(estadistica.getFormularioTerminado()+1);
        saveEstadistica(estadistica);
    }

    @Override
    public void sumarIngresantesTest(Ingresante ingre) {
        Estadistica estadistica=findEstadisticaById(1L);
        estadistica.setTestTerminado(estadistica.getTestTerminado()+1);
        saveEstadistica(estadistica);
    }

}
