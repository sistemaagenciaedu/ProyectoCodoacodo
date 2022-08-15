package codoacodo.example.codo.service.editabilidadServices;


import codoacodo.example.codo.Entities.editabilidad.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ImagenService {

    public Imagen crear(MultipartFile archivo);

    public Optional<Imagen> listar(Long Id);


    public Imagen actualizar(Long Id, MultipartFile archivo);
    public void borrar(Long Id);

}
