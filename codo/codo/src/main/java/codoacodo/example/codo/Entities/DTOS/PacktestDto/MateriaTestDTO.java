package codoacodo.example.codo.Entities.DTOS.PacktestDto;

import javax.persistence.*;
import java.util.*;

@Entity

@Table(name = "materiatestdto")
public class MateriaTestDTO implements Comparable<MateriaTestDTO>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();
    private Integer nPreguntas;

    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL)
    private List<PreguntaTestDTO> preguntasTest=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "test")
    private TestDTO test;

    public MateriaTestDTO() {
    }

    public MateriaTestDTO(Long id, String nombre, String fechaM, Integer nPreguntas, List<PreguntaTestDTO> preguntasTest, TestDTO test) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.nPreguntas = nPreguntas;
        this.preguntasTest = preguntasTest;
        this.test = test;
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

    public Integer getnPreguntas() {
        return nPreguntas;
    }

    public void setnPreguntas(Integer nPreguntas) {
        this.nPreguntas = nPreguntas;
    }

    public List<PreguntaTestDTO> getPreguntasTest() {
        return preguntasTest;
    }

    public void setPreguntasTest(List<PreguntaTestDTO> preguntasTest) {
        this.preguntasTest = preguntasTest;
    }

    public TestDTO getTest() {
        return test;
    }

    public void setTest(TestDTO test) {
        this.test = test;
    }
    public int compareTo(MateriaTestDTO o) {
        return (int) (id - o.id);
    }
}
