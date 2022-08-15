package codoacodo.example.codo.repositories.editabilidadRepositories;


import codoacodo.example.codo.Entities.editabilidad.Testimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonioRepository extends JpaRepository<Testimonio,Long> {

}
