package codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="preguntaalum")
public class PreguntaAlum implements Comparable<PreguntaAlum>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPregunta;
    private String respuesta;
    private String descripcion;
    private String enunciado;
    private String tipo;

    private String fechaM = new Date().toGMTString();
    ;
    private Long asociacionId;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<OpcionAlum> opciones=new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "fomulario")
    private FormAlum formulario;

    public PreguntaAlum() {
    }

    public PreguntaAlum(Long id, Long idPregunta, String respuesta, String descripcion, String enunciado, String tipo, String fechaM, Long asociacionId, List<OpcionAlum> opciones, FormAlum formulario) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
        this.descripcion = descripcion;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.fechaM = fechaM;
        this.asociacionId = asociacionId;
        this.opciones = opciones;
        this.formulario = formulario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public Long getAsociacionId() {
        return asociacionId;
    }

    public void setAsociacionId(Long asociacionId) {
        this.asociacionId = asociacionId;
    }

    public List<OpcionAlum> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionAlum> opciones) {
        this.opciones = opciones;
    }

    public FormAlum getFormulario() {
        return formulario;
    }

    public void setFormulario(FormAlum formulario) {
        this.formulario = formulario;
    }
    @Override
    public int compareTo(PreguntaAlum o) {
        return (int) (idPregunta - o.idPregunta);
    }
}
