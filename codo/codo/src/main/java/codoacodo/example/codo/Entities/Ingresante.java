package codoacodo.example.codo.Entities;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.FormAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAlumno;


import javax.persistence.*;

import java.util.*;

@Entity

@Table(name = "ingresante")
public class Ingresante implements Comparable<Ingresante>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private Long celu;
    private String tDoc;
    private String numDoc;
    private String apellido;
    private String nombre;
    private String fNacimiento;
    private String genero;
    private String nacionalidad;
    private String pais;
    private String provincia;
    private String localidadResi;
    private String domicilio;

    private String rol;

    private Boolean encuesta = false;
    private Boolean test = false;
    private Boolean tIngles = false;
    private Boolean tProgramacion = false;
    private Boolean tLogica = false;

    private int ingles;
    private int programacion;
    private int logica;
    private int totalpuntos;
    @Temporal(TemporalType.DATE)
    private Date fechaEncuenta = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    private FormAlum formAlum;
@OneToOne(cascade = CascadeType.ALL)
private TestAlumno testAlumno;
    public Ingresante() {
    }

    public Ingresante(Long id, String mail, Long celu, String tDoc, String numDoc, String apellido, String nombre, String fNacimiento, String genero, String nacionalidad, String pais, String provincia, String localidadResi, String domicilio, String rol, Boolean encuesta, Boolean test, Boolean tIngles, Boolean tProgramacion, Boolean tLogica, int ingles, int programacion, int logica, int totalpuntos, Date fechaEncuenta, FormAlum formAlum, TestAlumno testAlumno) {
        this.id = id;
        this.mail = mail;
        this.celu = celu;
        this.tDoc = tDoc;
        this.numDoc = numDoc;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.pais = pais;
        this.provincia = provincia;
        this.localidadResi = localidadResi;
        this.domicilio = domicilio;
        this.rol = rol;
        this.encuesta = encuesta;
        this.test = test;
        this.tIngles = tIngles;
        this.tProgramacion = tProgramacion;
        this.tLogica = tLogica;
        this.ingles = ingles;
        this.programacion = programacion;
        this.logica = logica;
        this.totalpuntos = totalpuntos;
        this.fechaEncuenta = fechaEncuenta;
        this.formAlum = formAlum;

        this.testAlumno = testAlumno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getCelu() {
        return celu;
    }

    public void setCelu(Long celu) {
        this.celu = celu;
    }

    public String gettDoc() {
        return tDoc;
    }

    public void settDoc(String tDoc) {
        this.tDoc = tDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidadResi() {
        return localidadResi;
    }

    public void setLocalidadResi(String localidadResi) {
        this.localidadResi = localidadResi;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Boolean encuesta) {
        this.encuesta = encuesta;
    }

    public Boolean gettIngles() {
        return tIngles;
    }

    public void settIngles(Boolean tIngles) {
        this.tIngles = tIngles;
    }

    public Boolean gettProgramacion() {
        return tProgramacion;
    }

    public void settProgramacion(Boolean tProgramacion) {
        this.tProgramacion = tProgramacion;
    }

    public Boolean gettLogica() {
        return tLogica;
    }

    public void settLogica(Boolean tLogica) {
        this.tLogica = tLogica;
    }

    public int getIngles() {
        return ingles;
    }

    public void setIngles(int ingles) {
        this.ingles = ingles;
    }

    public int getProgramacion() {
        return programacion;
    }

    public void setProgramacion(int programacion) {
        this.programacion = programacion;
    }

    public int getLogica() {
        return logica;
    }

    public void setLogica(int logica) {
        this.logica = logica;
    }

    public int getTotalpuntos() {
        return totalpuntos;
    }

    public void setTotalpuntos(int totalpuntos) {
        this.totalpuntos = totalpuntos;
    }

    public Date getFechaEncuenta() {
        return fechaEncuenta;
    }

    public void setFechaEncuenta(Date fechaEncuenta) {
        this.fechaEncuenta = fechaEncuenta;
    }

    public FormAlum getFormAlum() {
        return formAlum;
    }

    public void setFormAlum(FormAlum formAlum) {
        this.formAlum = formAlum;
    }

    public TestAlumno getTestAlumno() {
        return testAlumno;
    }

    public void setTestAlumno(TestAlumno testAlumno) {
        this.testAlumno = testAlumno;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingresante that = (Ingresante) o;
        return numDoc.equals(that.numDoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDoc);
    }

    @Override
    public String toString() {
        return "Ingresante{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", celu=" + celu +
                ", tDoc='" + tDoc + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fNacimiento='" + fNacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", localidadResi='" + localidadResi + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", rol='" + rol + '\'' +
                ", encuesta=" + encuesta +
                ", tIngles=" + tIngles +
                ", tProgramacion=" + tProgramacion +
                ", tLogica=" + tLogica +
                ", ingles=" + ingles +
                ", programacion=" + programacion +
                ", logica=" + logica +
                ", totalpuntos=" + totalpuntos +
                ", fechaEncuenta=" + fechaEncuenta +
                ", formAlum=" + formAlum +
                ", testAlumno=" + testAlumno +
                '}';
    }

    @Override
    public int compareTo(Ingresante o) {
        return this.numDoc.compareTo(o.getNumDoc());
    }
}