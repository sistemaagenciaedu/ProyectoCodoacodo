package codoacodo.example.codo.Entities.editabilidad;


import javax.persistence.*;

@Entity
@Table(name="curso")


public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Lob
    private String descripcion;
    private String duracion;
    private String claSem;
    private String tipo;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen imagen;

    public Curso() {
    }

    public Curso(Long id, String titulo, String descripcion, String duracion, String claSem, String tipo, Imagen imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.claSem = claSem;
        this.tipo = tipo;
        this.imagen = imagen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getClaSem() {
        return claSem;
    }

    public void setClaSem(String claSem) {
        this.claSem = claSem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
