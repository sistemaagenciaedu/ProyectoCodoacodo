package codoacodo.example.codo.Entities.editabilidad;

import javax.persistence.*;

@Entity
@Table(name="imagen")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String mime;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;

    public Imagen() {
    }

    public Imagen(Long id, String nombre, String mime, byte[] contenido) {
        this.id = id;
        this.nombre = nombre;
        this.mime = mime;
        this.contenido = contenido;
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

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
