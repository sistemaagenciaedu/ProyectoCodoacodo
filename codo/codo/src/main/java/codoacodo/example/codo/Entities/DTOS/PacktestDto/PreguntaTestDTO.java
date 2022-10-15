package codoacodo.example.codo.Entities.DTOS.PacktestDto;

import codoacodo.example.codo.Entities.editabilidad.Imagen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="preguntatestdto")
public class PreguntaTestDTO implements Comparable<PreguntaTestDTO>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @Lob
    private String pregunta;
    private String tipoPortada;
    private String tipoOpcion;
    private String portadaVideo;
    private String fechaM=new Date().toString();
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen portadaImagen;
    private Long portadaImaId;

    @OneToMany(mappedBy = "preguntastest",cascade = CascadeType.ALL)
    private List<OpcionTestDTO>opcionestest=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "materia")
    private MateriaTestDTO materia;

    public PreguntaTestDTO() {
    }

    public PreguntaTestDTO(Long id, String titulo, String pregunta, String tipoPortada, String tipoOpcion, String portadaVideo, String fechaM, Imagen portadaImagen, Long portadaImaId, List<OpcionTestDTO> opcionestest, MateriaTestDTO materia) {
        this.id = id;
        this.titulo = titulo;
        this.pregunta = pregunta;
        this.tipoPortada = tipoPortada;
        this.tipoOpcion = tipoOpcion;
        this.portadaVideo = portadaVideo;
        this.fechaM = fechaM;
        this.portadaImagen = portadaImagen;
        this.portadaImaId = portadaImaId;
        this.opcionestest = opcionestest;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTipoPortada() {
        return tipoPortada;
    }

    public void setTipoPortada(String tipoPortada) {
        this.tipoPortada = tipoPortada;
    }

    public String getTipoOpcion() {
        return tipoOpcion;
    }

    public void setTipoOpcion(String tipoOpcion) {
        this.tipoOpcion = tipoOpcion;
    }

    public String getPortadaVideo() {
        return portadaVideo;
    }

    public void setPortadaVideo(String portadaVideo) {
        this.portadaVideo = portadaVideo;
    }

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public Imagen getPortadaImagen() {
        return portadaImagen;
    }

    public void setPortadaImagen(Imagen portadaImagen) {
        this.portadaImagen = portadaImagen;
    }

    public Long getPortadaImaId() {
        return portadaImaId;
    }

    public void setPortadaImaId(Long portadaImaId) {
        this.portadaImaId = portadaImaId;
    }

    public List<OpcionTestDTO> getOpcionestest() {
        return opcionestest;
    }

    public void setOpcionestest(List<OpcionTestDTO> opcionestest) {
        this.opcionestest = opcionestest;
    }

    public MateriaTestDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaTestDTO materia) {
        this.materia = materia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaTestDTO that = (PreguntaTestDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(PreguntaTestDTO o) {
        return (int) (id - o.id);
    }
}
