package codoacodo.example.codo.repositories;

import codoacodo.example.codo.Entities.editabilidad.RutasExcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasExcelRepository extends JpaRepository<RutasExcel,Long> {
}
