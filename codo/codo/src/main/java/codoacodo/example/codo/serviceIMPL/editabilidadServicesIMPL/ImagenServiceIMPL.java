package codoacodo.example.codo.serviceIMPL.editabilidadServicesIMPL;


import codoacodo.example.codo.Entities.editabilidad.Imagen;
import codoacodo.example.codo.repositories.editabilidadRepositories.ImagenRepository;
import codoacodo.example.codo.service.editabilidadServices.ImagenService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
@Service
public class ImagenServiceIMPL implements ImagenService {
    @Autowired
    private ImagenRepository ir;

    @Override
    public Imagen crear(MultipartFile archivo) throws ServiceException {
        if (archivo != null) {
            try {
                Imagen foto = new Imagen();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getOriginalFilename());
                foto.setContenido(archivo.getBytes());
                return ir.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Optional<Imagen> listar(Long Id)  {return ir.findById(Id);}

    @Override
    public Imagen actualizar(Long Id, MultipartFile archivo)  throws ServiceException {
        if (archivo != null) {
            try {
                Imagen foto = new Imagen();
                if (Id != null) {
                    Optional<Imagen> respuesta = ir.findById(Id);
                    if (respuesta.isPresent()) {
                        foto = respuesta.get();
                    }
                }
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                return ir.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    @Override
    public void borrar(Long Id)  {
        if (Id != null) {
            try {
                Optional<Imagen> respuesta = ir.findById(Id);
                if (respuesta.isPresent()) {
                    ir.deleteById(Id);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
