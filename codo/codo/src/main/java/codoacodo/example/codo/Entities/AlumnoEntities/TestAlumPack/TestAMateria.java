package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "testamateria")
public class TestAMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();

    @OneToMany(mappedBy = "materiaalumno",cascade = CascadeType.ALL)
    private List<TestAPregunta> preguntasAlumno=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "testalumno")
    private TestAlumno testalumno;

    public TestAMateria() {
    }

    public TestAMateria(Long id, String nombre, String fechaM, List<TestAPregunta> preguntasAlumno, TestAlumno testalumno) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
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
}