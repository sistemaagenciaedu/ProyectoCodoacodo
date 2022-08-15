package codoacodo.example.codo.repositories;


import codoacodo.example.codo.Entities.Ingresante;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngresanteRepository extends JpaRepository<Ingresante,Long>, JpaSpecificationExecutor<Ingresante> {
    @Override
    List<Ingresante> findAll(Specification<Ingresante> spec);

}