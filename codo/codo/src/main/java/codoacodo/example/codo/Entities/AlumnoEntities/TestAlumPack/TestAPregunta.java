package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import codoacodo.example.codo.Entities.editabilidad.Imagen;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "testapregunta")
public class TestAPregunta implements Comparable<TestAPregunta>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @Lob
    private String pregunta;
    private String tipoPortada;
    private String tipoOpcion;
    private String portadaVideo;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen portadaImagen;
    private Long portadaImaId;
    private Boolean estado=false;
    private Long respuesta;
    private Integer punto=0;
    @OneToMany(mappedBy = "preguntastestalumno",cascade = CascadeType.ALL)
    private List<TestAOpcion> opcionestestalumno=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "materiaalumno")
    private TestAMateria materiaalumno;

    public TestAPregunta() {
    }

    public TestAPregunta(Long id, String titulo, String pregunta, String tipoPortada, String tipoOpcion, String portadaVideo, Imagen portadaImagen, Long portadaImaId, Boolean estado, Long respuesta, Integer punto, List<TestAOpcion> opcionestestalumno, TestAMateria materiaalumno) {
        this.id = id;
        this.titulo = titulo;
        this.pregunta = pregunta;
        this.tipoPortada = tipoPortada;
        this.tipoOpcion = tipoOpcion;
        this.portadaVideo = portadaVideo;
        this.portadaImagen = portadaImagen;
        this.portadaImaId = portadaImaId;
        this.estado = estado;
        this.respuesta = respuesta;
        this.punto = punto;
        this.opcionestestalumno = opcionestestalumno;
        this.materiaalumno = materiaalumno;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Long respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getPunto() {
        return punto;
    }

    public void setPunto(Integer punto) {
        this.punto = punto;
    }

    public List<TestAOpcion> getOpcionestestalumno() {
        return opcionestestalumno;
    }

    public void setOpcionestestalumno(List<TestAOpcion> opcionestestalumno) {
        this.opcionestestalumno = opcionestestalumno;
    }

    public TestAMateria getMateriaalumno() {
        return materiaalumno;
    }

    public void setMateriaalumno(TestAMateria materiaalumno) {
        this.materiaalumno = materiaalumno;
    }

    @Override
    public int compareTo(TestAPregunta o) {
        return (int) (id- o.id);
    }
}
