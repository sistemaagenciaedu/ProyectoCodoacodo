package codoacodo.example.codo.serviceIMPL.AlumnoEntitiesServicesIMPL.FormAlumPackServiceIMPL;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.OpcionAlum;
import codoacodo.example.codo.repositories.AlumnoEntitiesRepositories.FormAlumPackRepository.OpcionAlumRepository;
import codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService.OpcionAlumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpcionAlumServiceIMPL implements OpcionAlumService {
@Autowired
private OpcionAlumRepository opr;
    @Override
    public OpcionAlum saveOpcion(OpcionAlum opcion)  {
        return opr.save(opcion);
    }

    @Override
    public void deleteOpcion(Long id)  {
        opr.deleteById(id);
    }

    @Override
    public List<OpcionAlum> findAllOpcion()  {
        return opr.findAll();
    }

    @Override
    public List<OpcionAlum> findAllOpcionByPreg(Long id){
        List<OpcionAlum> lista=new ArrayList<>();
        for (OpcionAlum p: findAllOpcion()) {
            if (p.getPregunta()!=null){
                if(p.getPregunta().getId()==id){
                    lista.add(p);
                }
            }
        }
        return lista;
    }

    @Override
    public OpcionAlum findOpcionById(Long id) {
        return null;
    }
}
