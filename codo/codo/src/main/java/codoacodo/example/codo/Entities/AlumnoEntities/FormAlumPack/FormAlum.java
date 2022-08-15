package codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity

@Table(name = "formalum")
public class FormAlum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String fechaM=new Date().toGMTString();
    private Boolean estado=false;
    @OneToMany(mappedBy = "formulario",cascade = CascadeType.ALL)
    private Set<PreguntaAlum> preguntas=new TreeSet<>();

    public FormAlum() {
    }

    public FormAlum(Long id, String nombre, String fechaM, Boolean estado, Set<PreguntaAlum> preguntas) {
        Id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.estado = estado;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<PreguntaAlum> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaAlum> preguntas) {
        this.preguntas = preguntas;
    }
}
