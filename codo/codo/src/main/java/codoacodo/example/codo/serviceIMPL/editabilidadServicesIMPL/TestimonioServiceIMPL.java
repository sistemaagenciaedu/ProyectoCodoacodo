package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.editabilidad.Testimonio;
import codoacodo.example.codo.repositories.editabilidadRepositories.TestimonioRepository;
import codoacodo.example.codo.service.editabilidadServices.TestimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonioServiceIMPL implements TestimonioService {
    @Autowired
    TestimonioRepository tr;
    @Override
    public Testimonio saveTesti(Testimonio test) {
        return tr.save(test);
    }

    @Override
    public void deleteTesti(Long id) {
        tr.deleteById(id);
    }

    @Override
    public List<Testimonio> findAllTesti() {
        return tr.findAll();
    }


    @Override
    public Testimonio findTestiById(Long id) {
        return tr.findById(id).orElse(null);
    }
}

