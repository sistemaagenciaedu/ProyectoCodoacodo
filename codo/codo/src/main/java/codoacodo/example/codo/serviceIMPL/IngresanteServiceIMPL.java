package codoacodo.example.codo.serviceIMPL;


import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.IngresanteFilterDto;

import codoacodo.example.codo.repositories.IngresanteRepository;
import codoacodo.example.codo.service.IngresanteService;
import codoacodo.example.codo.specification.IngresanteSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngresanteServiceIMPL implements IngresanteService {
    @Autowired
    private IngresanteRepository ir;
    //@Autowired
//private RespuestaService rs;
    @Autowired
    private IngresanteSpecification ingresanteSpecification;
    @Override
    public Ingresante saveIngresante(Ingresante ingre) {
        return ir.save(ingre);
    }

    @Override
    public void deleteIngresante(Long id) {
        ir.deleteById(id);
    }

    @Override
    public List<Ingresante> findAllIngresante() {
        return ir.findAll();
    }

    @Override
    public Ingresante findIngresanteById(Long id) {
        return ir.findById(id).orElse(null);
    }

    @Override
    public void eliminarRespuestasIngresante(Ingresante ingre){
//        ArrayList <Long> ids=new ArrayList<>();
//        ingre=findIngresanteById(ingre.getId());
//        for (Respuesta res: ingre.getRespuestas()) {
//            ids.add(res.getId());
//        }
//       if (!ids.isEmpty()){
//           for (Long id: ids) {
//               rs.deleteRespuesta(id);
//           }
//       }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Ingresante> getByFilter(String query, String desde, String hasta, String genero, String encuesta,String test,String tIngles,String tProgramacion,String tLogica ,String order) {
        System.out.println(desde);
        System.out.println(hasta);
        IngresanteFilterDto ifd= new IngresanteFilterDto();
        ifd.setDesde(desde);
        ifd.setHasta(hasta);
        ifd.setNombre(query);
        ifd.setApellido(query);
        ifd.setGenero(genero);
        ifd.setNacionalidad(query);
        ifd.setProvincia(query);
        ifd.setNumDoc(query);
        ifd.setMail(query);
        ifd.setOrder(order);
        ifd.setPais(query);
        ifd.setEncuesta(encuesta);
        ifd.setTest(test);
        ifd.settIngles(tIngles);
        ifd.settLogica(tLogica);
        ifd.settProgramacion(tProgramacion);

        System.out.println("nombre "+ ifd.getNombre());
        System.out.println("apellido "+ ifd.getApellido());
        System.out.println("genero "+ifd.getGenero());
        System.out.println("nacionalidad "+ifd.getNacionalidad());
        System.out.println("mail "+ ifd.getMail());
        System.out.println("numdocumento "+ifd.getNumDoc());
        System.out.println("provincia "+ifd.getProvincia());
        System.out.println("pais "+ifd.getPais());
        System.out.println("desde "+ifd.getDesde());
        System.out.println("hasta "+ifd.getHasta());

        List <Ingresante>lista=ir.findAll(ingresanteSpecification.getByFilters(ifd));
        return lista;
    }

    @Transactional(readOnly = true)
    @Override
    public Ingresante findIngresanteByDoc(String numDoc) {
        return ir.findByNumDoc(numDoc);
    }

    @Override
    public List<Ingresante> buscarTodosLosDNIQueMacheen(String numDoc) {
        return ir.buscarTodosLosQueTenganEseDni(numDoc);
    }
}
