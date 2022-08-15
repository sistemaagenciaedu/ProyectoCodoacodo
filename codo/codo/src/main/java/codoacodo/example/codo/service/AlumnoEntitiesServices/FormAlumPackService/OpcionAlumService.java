package codoacodo.example.codo.service.AlumnoEntitiesServices.FormAlumPackService;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.OpcionAlum;

import java.util.List;

public interface OpcionAlumService {
    OpcionAlum saveOpcion(OpcionAlum opcion);
    void deleteOpcion(Long id);
    List<OpcionAlum> findAllOpcion();
    List<OpcionAlum> findAllOpcionByPreg(Long id);

    OpcionAlum findOpcionById(Long id);
}
