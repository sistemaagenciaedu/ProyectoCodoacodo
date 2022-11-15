package codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack;



import javax.persistence.*;
import java.util.*;

@Entity

@Table(name = "testalumno")
public class TestAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaM=new Date().toGMTString();
    private Long fechaFin;
    private Integer tiempo;
    private Boolean estado=false;
    private Integer puntos=0;

    @OneToMany(mappedBy = "testalumno",cascade = CascadeType.ALL)
    private Set<TestAMateria> materiasAlumno=new TreeSet<>();

    public TestAlumno() {
    }

    public TestAlumno(Long id, String nombre, String fechaM, Long fechaFin, Integer tiempo, Boolean estado, Integer puntos, Set<TestAMateria> materiasAlumno) {
        this.id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.fechaFin = fechaFin;
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

    public Long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Long fechaFin) {
        this.fechaFin = fechaFin;
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

    public Set<TestAMateria> getMateriasAlumno() {
        return materiasAlumno;
    }

    public void setMateriasAlumno(Set<TestAMateria> materiasAlumno) {
        this.materiasAlumno = materiasAlumno;
    }
}
