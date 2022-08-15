package codoacodo.example.codo.Entities.DTOS.PacktestDto;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="testdto")
public class TestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();;
private Integer tiempo;

    @OneToMany(mappedBy = "test",cascade = CascadeType.ALL)
    private List<MateriaTestDTO> materias=new ArrayList<>();

    public TestDTO() {
    }

    public TestDTO(Long id, String nombre, String fechaM, Integer tiempo, List<MateriaTestDTO> materias) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.tiempo = tiempo;
        this.materias = materias;
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

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public List<MateriaTestDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaTestDTO> materias) {
        this.materias = materias;
    }
}
