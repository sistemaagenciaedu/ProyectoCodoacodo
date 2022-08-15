package codoacodo.example.codo.Entities.editabilidad;

import javax.persistence.*;

@Entity

@Table(name = "provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagenNombre;
    private String nombre;
    private Integer registrosTotales=0;
    private Integer masculino=0;
    private Integer femenino=0;
    private Integer noBinario=0;
    private Integer registrados=0;
    private Integer formularioTerminado=0;
    private Integer testTerminado=0;

    public Provincia() {
    }

    public Provincia(String nombre,String imagenNombre) {
        this.imagenNombre = imagenNombre;
        this.nombre = nombre;
    }

    public Provincia(Long id, String imagenNombre, String nombre, Integer registrosTotales, Integer masculino, Integer femenino, Integer noBinario, Integer registrados, Integer formularioTerminado, Integer testTerminado) {
        this.id = id;
        this.imagenNombre = imagenNombre;
        this.nombre = nombre;
        this.registrosTotales = registrosTotales;
        this.masculino = masculino;
        this.femenino = femenino;
        this.noBinario = noBinario;
        this.registrados = registrados;
        this.formularioTerminado = formularioTerminado;
        this.testTerminado = testTerminado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagenNombre() {
        return imagenNombre;
    }

    public void setImagenNombre(String imagenNombre) {
        this.imagenNombre = imagenNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRegistrosTotales() {
        return registrosTotales;
    }

    public void setRegistrosTotales(Integer registrosTotales) {
        this.registrosTotales = registrosTotales;
    }

    public Integer getMasculino() {
        return masculino;
    }

    public void setMasculino(Integer masculino) {
        this.masculino = masculino;
    }

    public Integer getFemenino() {
        return femenino;
    }

    public void setFemenino(Integer femenino) {
        this.femenino = femenino;
    }

    public Integer getNoBinario() {
        return noBinario;
    }

    public void setNoBinario(Integer noBinario) {
        this.noBinario = noBinario;
    }

    public Integer getRegistrados() {
        return registrados;
    }

    public void setRegistrados(Integer registrados) {
        this.registrados = registrados;
    }

    public Integer getFormularioTerminado() {
        return formularioTerminado;
    }

    public void setFormularioTerminado(Integer formularioTerminado) {
        this.formularioTerminado = formularioTerminado;
    }

    public Integer getTestTerminado() {
        return testTerminado;
    }

    public void setTestTerminado(Integer testTerminado) {
        this.testTerminado = testTerminado;
    }
}
