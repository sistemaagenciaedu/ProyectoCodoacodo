package codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="opcionalum")
public class OpcionAlum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    private String fechaM = new Date().toGMTString();

    @ManyToOne
    @JoinColumn(name = "preguntaid" )
    private PreguntaAlum pregunta;


    public OpcionAlum() {
    }

    public OpcionAlum(Long id, String descripcion, String fechaM, PreguntaAlum pregunta) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaM = fechaM;
        this.pregunta = pregunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public PreguntaAlum getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaAlum pregunta) {
        this.pregunta = pregunta;
    }
}
