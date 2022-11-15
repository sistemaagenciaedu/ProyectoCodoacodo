package codoacodo.example.codo.specification;


import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.IngresanteFilterDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class IngresanteSpecification {
    public Specification<Ingresante> getByFilters(IngresanteFilterDto ifd){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (ifd.getApellido()!=null ) {
                if (StringUtils.hasLength(ifd.getApellido())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("apellido")),
                                    "%" + ifd.getApellido().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getMail()!=null) {
                if (StringUtils.hasLength(ifd.getMail())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("mail")),
                                    "%" + ifd.getMail().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getNacionalidad()!=null) {
                if (StringUtils.hasLength(ifd.getNacionalidad())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("nacionalidad")),
                                    "%" + ifd.getNacionalidad().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getNombre()!=null) {
                if (StringUtils.hasLength(ifd.getNombre())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("nombre")),
                                    "%" + ifd.getNombre().toLowerCase() + "%"
                            )
                    );

                }
            }

            if (ifd.getNumDoc()!=null) {
                if (StringUtils.hasLength(ifd.getNumDoc())){
                    System.out.println(ifd.getNumDoc());
                    predicates.add(
                            criteriaBuilder.like(

                                    criteriaBuilder.lower(root.get("numDoc")),
                                    "%" + ifd.getNumDoc().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getGenero()!=null) {
                if (StringUtils.hasLength(ifd.getGenero())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("genero")),
                                    "%" + ifd.getGenero().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getPais()!=null) {
                if (StringUtils.hasLength(ifd.getPais())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("pais")),
                                    "%" + ifd.getPais().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getProvincia()!=null) {
                if (StringUtils.hasLength(ifd.getProvincia())){
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("provincia")),
                                    "%" + ifd.getProvincia().toLowerCase() + "%"
                            )
                    );

                }
            }
            if (ifd.getEncuesta() != null){
                if (ifd.getEncuesta().equalsIgnoreCase("si")) {
                    predicates.add(
                            criteriaBuilder.isTrue(root.get("encuesta").as(Boolean.class)));


                } else {
                    predicates.add(
                            criteriaBuilder.isFalse(root.get("encuesta").as(Boolean.class)));
                }

            }
            if (ifd.getTest() != null){
                if (ifd.getEncuesta().equalsIgnoreCase("si")) {
                    predicates.add(
                            criteriaBuilder.isTrue(root.get("test").as(Boolean.class)));


                } else {
                    predicates.add(
                            criteriaBuilder.isFalse(root.get("test").as(Boolean.class)));
                }

            }
            if (ifd.gettIngles() != null){
                if (ifd.gettIngles().equalsIgnoreCase("si")) {
                    predicates.add(
                            criteriaBuilder.isTrue(root.get("tIngles").as(Boolean.class)));


                } else {
                    predicates.add(
                            criteriaBuilder.isFalse(root.get("tIngles").as(Boolean.class)));
                }

            }
            if (ifd.gettLogica() != null){
                if (ifd.gettIngles().equalsIgnoreCase("si")) {
                    predicates.add(
                            criteriaBuilder.isTrue(root.get("tLogica").as(Boolean.class)));


                } else {
                    predicates.add(
                            criteriaBuilder.isFalse(root.get("tLogica").as(Boolean.class)));
                }

            }
            if (ifd.gettProgramacion() != null){
                if (ifd.gettIngles().equalsIgnoreCase("si")) {
                    predicates.add(
                            criteriaBuilder.isTrue(root.get("tProgramacion").as(Boolean.class)));


                } else {
                    predicates.add(
                            criteriaBuilder.isFalse(root.get("tProgramacion").as(Boolean.class)));
                }

            }
            if (ifd.getDesde()!= null && ifd.getHasta() !=null ){

                try {
                    SimpleDateFormat desde = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat hasta = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(ifd.getDesde());
                    System.out.println(ifd.getHasta());
                    Date desde2 = desde.parse(ifd.getDesde());
                    Date hasta2 = hasta.parse(ifd.getHasta());
                    predicates.add(
                            criteriaBuilder.between(root.<Date>get("fechaEncuenta"), desde2, hasta2)
                    );
                } catch (ParseException ex) {
                    Logger.getLogger(IngresanteSpecification.class.getName()).log(Level.SEVERE, null, ex);
                }


            }








            query.distinct(true);


            String order = "apellido";

            query.orderBy(
                    ifd.isASC()?
                            criteriaBuilder.asc(root.get(order)) :
                            criteriaBuilder.desc(root.get(order))
            );

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));

        };
    }
}