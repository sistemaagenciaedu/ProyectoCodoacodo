package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "testalumno")
public class TestAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();;
    private Integer tiempo;
    private Boolean estado=false;
    private Integer puntos=0;
    @OneToMany(mappedBy = "testalumno",cascade = CascadeType.ALL)
    private List<TestAMateria> materiasAlumno=new ArrayList<>();

    public TestAlumno() {
    }

    public TestAlumno(Long id, String nombre, String fechaM, Integer tiempo, Boolean estado, Integer puntos, List<TestAMateria> materiasAlumno) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.tiempo = tiempo;
        this.estado = estado;
        this.puntos = puntos;
        this.materiasAlumno = materiasAlumno;
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

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
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

    public List<TestAMateria> getMateriasAlumno() {
        return materiasAlumno;
    }

    public void setMateriasAlumno(List<TestAMateria> materiasAlumno) {
        this.materiasAlumno = materiasAlumno;
    }
}
