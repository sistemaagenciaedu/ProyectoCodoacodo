package codoacodo.example.codo.repositories.editabilidadRepositories;

import codoacodo.example.codo.Entities.editabilidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen,Long> {

}
