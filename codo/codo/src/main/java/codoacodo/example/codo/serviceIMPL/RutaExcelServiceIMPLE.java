package codoacodo.example.codo.serviceIMPL;

import codoacodo.example.codo.Entities.editabilidad.RutasExcel;
import codoacodo.example.codo.repositories.RutasExcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaExcelServiceIMPLE {
    @Autowired
    private RutasExcelRepository res;

    public RutasExcel save(RutasExcel rutaExcel){
        return res.save(rutaExcel);
    }
    public void delete(Long id){
        res.deleteById(id);
    }
    public List<RutasExcel> listallRutas(){
        return res.findAll();
    }

}
