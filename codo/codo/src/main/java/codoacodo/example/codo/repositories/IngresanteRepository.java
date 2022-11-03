package codoacodo.example.codo.repositories;


import codoacodo.example.codo.Entities.Ingresante;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngresanteRepository extends JpaRepository<Ingresante,Long>, JpaSpecificationExecutor<Ingresante> {
    @Override
    List<Ingresante> findAll(Specification<Ingresante> spec);
    @Query("SELECT a FROM Ingresante a WHERE a.numDoc=:doc")
    Ingresante findByNumDoc(@Param("doc") String doc);
    @Query("SELECT a FROM Ingresante a WHERE a.numDoc=:doc")
    List<Ingresante>buscarTodosLosQueTenganEseDni(@Param("doc") String doc);
}
