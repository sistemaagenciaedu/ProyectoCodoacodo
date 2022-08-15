package codoacodo.example.codo.Entities.DTOS.PackFormDTO;


import javax.persistence.*;
import java.util.*;

@Entity

@Table(name = "formdto")
public class FormDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String fechaM=new Date().toGMTString();;
    @OneToMany(mappedBy = "formulario",cascade = CascadeType.ALL)
    private Set<PreguntaDTO> preguntas=new TreeSet<>();


    public FormDTO() {
    }

    public FormDTO(Long id, String nombre, String fechaM, Set<PreguntaDTO> preguntas) {
        Id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.preguntas = preguntas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Set<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }
}
