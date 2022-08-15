package codoacodo.example.codo.Entities.DTOS.PacktestDto;

import codoacodo.example.codo.Entities.editabilidad.Imagen;

import javax.persistence.*;

@Entity
@Table(name="opciontestdto")
public class OpcionTestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String esCorrecta;
    private String opcionText;
    private String tipoOpcion;
    private String fechaMod;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen opcionImg;
    private Long opcionImgid;
    @ManyToOne
    @JoinColumn(name = "preguntastest")
    private PreguntaTestDTO preguntastest;

    public OpcionTestDTO() {
    }

    public OpcionTestDTO(Long id, String esCorrecta, String opcionText, String tipoOpcion, String fechaMod, Imagen opcionImg, Long opcionImgid, PreguntaTestDTO preguntastest) {
        this.id = id;
        this.esCorrecta = esCorrecta;
        this.opcionText = opcionText;
        this.tipoOpcion = tipoOpcion;
        this.fechaMod = fechaMod;
        this.opcionImg = opcionImg;
        this.opcionImgid = opcionImgid;
        this.preguntastest = preguntastest;
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

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
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

    public PreguntaTestDTO getPreguntastest() {
        return preguntastest;
    }

    public void setPreguntastest(PreguntaTestDTO preguntastest) {
        this.preguntastest = preguntastest;
    }
}
