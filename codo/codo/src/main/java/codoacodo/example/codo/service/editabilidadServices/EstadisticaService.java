package codoacodo.example.codo.service.editabilidadServices;


import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.Estadistica;

import java.util.List;

public interface EstadisticaService {
    public Estadistica saveEstadistica(Estadistica estadistica);
    public void deleteEstadistica(Long id);
    public List<Estadistica> findAllEstadistica();

    public Estadistica findEstadisticaById(Long id);
    public void sumarIngresantes(Ingresante ingre);
    public void restarIngresantes(Ingresante ingre);
    public void sumarIngresantesFormulario(Ingresante ingre);
    public void sumarIngresantesTest(Ingresante ingre);
}
