package codoacodo.example.codo.Entities;

public class IngresanteFilterDto {
    private String nombre;
    private String numDoc;
    private String apellido;
    private String nacionalidad;
    private String genero;
    private String mail;
    private String pais;
    private String provincia;
    private String desde;
    private String hasta;
    private String encuesta;
    private String test;
    private String tIngles;
    private String tProgramacion;
    private String tLogica;
    private String order;

    public IngresanteFilterDto() {
    }

    public IngresanteFilterDto(String nombre, String numDoc, String apellido, String nacionalidad, String genero, String mail, String pais, String provincia, String desde, String hasta, String encuesta, String test, String tIngles, String tProgramacion, String tLogica, String order) {
        this.nombre = nombre;
        this.numDoc = numDoc;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.mail = mail;
        this.pais = pais;
        this.provincia = provincia;
        this.desde = desde;
        this.hasta = hasta;
        this.encuesta = encuesta;
        this.test = test;
        this.tIngles = tIngles;
        this.tProgramacion = tProgramacion;
        this.tLogica = tLogica;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC")==0;
    }
    public boolean isDESC(){
        return this.order.compareToIgnoreCase("DESC")==0;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(String encuesta) {
        this.encuesta = encuesta;
    }

    public String gettIngles() {
        return tIngles;
    }

    public void settIngles(String tIngles) {
        this.tIngles = tIngles;
    }

    public String gettProgramacion() {
        return tProgramacion;
    }

    public void settProgramacion(String tProgramacion) {
        this.tProgramacion = tProgramacion;
    }

    public String gettLogica() {
        return tLogica;
    }

    public void settLogica(String tLogica) {
        this.tLogica = tLogica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }



    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
