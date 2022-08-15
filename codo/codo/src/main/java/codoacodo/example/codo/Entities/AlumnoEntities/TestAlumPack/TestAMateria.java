package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;


import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "testamateria")
public class TestAMateria implements Comparable<TestAMateria>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();
    private Integer nPreguntas;
    private Long materiaId;
    private Boolean estado=false;
    private Integer puntos=0;
    @OneToMany(mappedBy = "materiaalumno",cascade = CascadeType.ALL)
    private List<TestAPregunta> preguntasAlumno=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "testalumno")
    private TestAlumno testalumno;

    public TestAMateria() {
    }

    public TestAMateria(Long id, String nombre, String fechaM, Integer nPreguntas, Long materiaId, Boolean estado, Integer puntos, List<TestAPregunta> preguntasAlumno, TestAlumno testalumno) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.nPreguntas = nPreguntas;
        this.materiaId = materiaId;
        this.estado = estado;
        this.puntos = puntos;
        this.preguntasAlumno = preguntasAlumno;
        this.testalumno = testalumno;
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

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public List<TestAPregunta> getPreguntasAlumno() {
        return preguntasAlumno;
    }

    public void setPreguntasAlumno(List<TestAPregunta> preguntasAlumno) {
        this.preguntasAlumno = preguntasAlumno;
    }

    public TestAlumno getTestalumno() {
        return testalumno;
    }

    public void setTestalumno(TestAlumno testalumno) {
        this.testalumno = testalumno;
    }

    public int compareTo(TestAMateria o) {
        return (int) (materiaId - o.materiaId);
    }
}
