package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.Ingresante;
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

    @Override
    public void sumarIngresantes(Ingresante ingre) {
        List<Provincia>provincias=findAllProvincia();
        for (Provincia prov: provincias){
            if (prov.getNombre().equalsIgnoreCase(ingre.getProvincia())){


                prov.setRegistrosTotales(prov.getRegistrosTotales()+1);
                if (ingre.getGenero().equalsIgnoreCase("Masculino")){
                    prov.setMasculino(prov.getMasculino()+1);
                }else   if (ingre.getGenero().equalsIgnoreCase("Femenino")){
                    prov.setFemenino(prov.getFemenino()+1);

                }else{
                    prov.setNoBinario(prov.getNoBinario()+1);
                }
                saveProvincia(prov);
            }
        }
    }
 @Override
    public void restarIngresantes(Ingresante ingre) {
        List<Provincia>provincias=findAllProvincia();
        for (Provincia prov: provincias){
            if (prov.getNombre().equalsIgnoreCase(ingre.getProvincia())){


                prov.setRegistrosTotales(prov.getRegistrosTotales()-1);
                if (ingre.getGenero().equalsIgnoreCase("Masculino")){
                    prov.setMasculino(prov.getMasculino()-1);
                }else   if (ingre.getGenero().equalsIgnoreCase("Femenino")){
                    prov.setFemenino(prov.getFemenino()-1);

                }else{
                    prov.setNoBinario(prov.getNoBinario()-1);
                }
                saveProvincia(prov);
            }
        }
    }

    @Override
    public void sumarIngresantesFormulario(Ingresante ingre) {
        List<Provincia>provincias=findAllProvincia();
        for (Provincia prov: provincias){
            if (prov.getNombre().equalsIgnoreCase(ingre.getProvincia())){


                prov.setFormularioTerminado(prov.getFormularioTerminado()+1);
                saveProvincia(prov);
            }
        }
    }

    @Override
    public void sumarIngresantesTest(Ingresante ingre) {
        List<Provincia>provincias=findAllProvincia();
        for (Provincia prov: provincias){
            if (prov.getNombre().equalsIgnoreCase(ingre.getProvincia())){


                prov.setTestTerminado(prov.getTestTerminado()+1);
                saveProvincia(prov);
            }
        }
    }


}
