package codoacodo.example.codo.service.editabilidadServices;


import codoacodo.example.codo.Entities.editabilidad.Testimonio;

import java.util.List;

public interface TestimonioService {
    public Testimonio saveTesti(Testimonio test);
    public void deleteTesti(Long id);
    public List<Testimonio> findAllTesti();

    public Testimonio findTestiById(Long id);
}
