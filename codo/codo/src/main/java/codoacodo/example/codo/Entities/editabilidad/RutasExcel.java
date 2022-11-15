package codoacodo.example.codo.Entities.editabilidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rutaexcel")
public class RutasExcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fecha=new Date().toString();

    public RutasExcel() {
    }

    public RutasExcel(Long id, String nombre, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
