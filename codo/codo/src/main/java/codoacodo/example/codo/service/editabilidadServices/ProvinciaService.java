package codoacodo.example.codo.service.editabilidadServices;


import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.Provincia;

import java.util.List;

public interface ProvinciaService {
    public Provincia saveProvincia(Provincia provincia);
    public void deleteProvincia(Long id);
    public List<Provincia> findAllProvincia();

    public Provincia findProvinciaById(Long id);
    public void sumarIngresantes(Ingresante ingre);
    public void restarIngresantes(Ingresante ingre);
    public void sumarIngresantesFormulario(Ingresante ingre);
    public void sumarIngresantesTest(Ingresante ingre);
}
