package codoacodo.example.codo.Entities.editabilidad;

import javax.persistence.*;

@Entity

@Table(name = "estadistica")
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer registrosTotales=0;
    private Integer masculino=0;
    private Integer femenino=0;
    private Integer noBinario=0;
    private Integer registrados=0;
    private Integer formularioTerminado=0;
    private Integer testTerminado=0;
    private  String formuHabilitado="no";

    public Estadistica() {
    }

    public Estadistica(Long id, Integer registrosTotales, Integer masculino, Integer femenino, Integer noBinario, Integer registrados, Integer formularioTerminado, Integer testTerminado, String formuHabilitado) {
        this.id = id;
        this.registrosTotales = registrosTotales;
        this.masculino = masculino;
        this.femenino = femenino;
        this.noBinario = noBinario;
        this.registrados = registrados;
        this.formularioTerminado = formularioTerminado;
        this.testTerminado = testTerminado;
        this.formuHabilitado = formuHabilitado;
    }

    public Long getId() {
        return id;
    }

    public String getFormuHabilitado() {
        return formuHabilitado;
    }

    public void setFormuHabilitado(String formuHabilitado) {
        this.formuHabilitado = formuHabilitado;
    }

    public void setId(Long id) {
        this.id = id;
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
