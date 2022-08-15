package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;

import codoacodo.example.codo.Entities.editabilidad.Imagen;

import javax.persistence.*;

@Entity
@Table(name="testaopcion")
public class TestAOpcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String esCorrecta;
    private String opcionText;
    private String tipoOpcion;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen opcionImg;
    private Long opcionImgid;
    @ManyToOne
    @JoinColumn(name = "preguntastestalumno")
    private TestAPregunta preguntastestalumno;

    public TestAOpcion() {
    }

    public TestAOpcion(Long id, String esCorrecta, String opcionText, String tipoOpcion, Imagen opcionImg, Long opcionImgid, TestAPregunta preguntastestalumno) {
        this.id = id;
        this.esCorrecta = esCorrecta;
        this.opcionText = opcionText;
        this.tipoOpcion = tipoOpcion;
        this.opcionImg = opcionImg;
        this.opcionImgid = opcionImgid;
        this.preguntastestalumno = preguntastestalumno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(String esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public String getOpcionText() {
        return opcionText;
    }

    public void setOpcionText(String opcionText) {
        this.opcionText = opcionText;
    }

    public String getTipoOpcion() {
        return tipoOpcion;
    }

    public void setTipoOpcion(String tipoOpcion) {
        this.tipoOpcion = tipoOpcion;
    }

    public Imagen getOpcionImg() {
        return opcionImg;
    }

    public void setOpcionImg(Imagen opcionImg) {
        this.opcionImg = opcionImg;
    }

    public Long getOpcionImgid() {
        return opcionImgid;
    }

    public void setOpcionImgid(Long opcionImgid) {
        this.opcionImgid = opcionImgid;
    }

    public TestAPregunta getPreguntastestalumno() {
        return preguntastestalumno;
    }

    public void setPreguntastestalumno(TestAPregunta preguntastestalumno) {
        this.preguntastestalumno = preguntastestalumno;
    }
}
