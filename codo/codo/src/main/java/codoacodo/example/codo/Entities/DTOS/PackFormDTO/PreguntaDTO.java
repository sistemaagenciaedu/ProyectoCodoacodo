package codoacodo.example.codo.Entities.DTOS.PackFormDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="preguntadto")
public class PreguntaDTO implements Comparable<PreguntaDTO>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String enunciado;
    private String tipo;

    private String fechaM = new Date().toGMTString();
    ;
    private Long asociacionId;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<OpcionDTO> opciones=new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "fomulario")
    private FormDTO formulario;

    public PreguntaDTO() {
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

    public List<OpcionDTO> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionDTO> opciones) {
        this.opciones = opciones;
    }

    public FormDTO getFormulario() {
        return formulario;
    }

    public void setFormulario(FormDTO formulario) {
        this.formulario = formulario;
    }

    public PreguntaDTO(Long id, String descripcion, String enunciado, String tipo, String fechaM, Long asociacionId, List<OpcionDTO> opciones, FormDTO formulario) {
        this.id = id;
        this.descripcion = descripcion;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.fechaM = fechaM;
        this.asociacionId = asociacionId;
        this.opciones = opciones;
        this.formulario = formulario;
    }

    @Override
    public int compareTo(PreguntaDTO o) {
        return (int) (id - o.id);
    }
}
