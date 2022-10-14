class nominaClass {
    constructor(nombre, nominas) {
        this.nombre = nombre;
        this.nominas = nominas;
    }

}
var profecionales = new nominaClass()
var sociohumanistica = new nominaClass()
var artistica = new nominaClass()
var capacitacionlaboral = new nominaClass()


var profecionales = {
    nombre: "ETP - TS y FP  (Inicial y continua)",
    nominas: [
        "ACTIVIDADES ARTÍSTICAS TÉCNICAS",
        "ADMINISTRACIÓN, GESTIÓN Y SERVICIOS EMPRESARIALES",
        "AERONÁUTICA",
        "AGROPECUARIO",
        "AUTOMOTRIZ",
        "CONSTRUCCIONES",
        "CUERO Y CALZADO",
        "ELECTROMECÁNICA",
        "ELECTRÓNICA",
        "ENERGÍA",
        "ESTÉTICA PROFESIONAL",
        "FERROVIARIO",
        "HOTELERÍA Y GASTRONOMÍA",
        "INDUSTRIA ALIMENTARIA",
        "INDUSTRIAS DE PROCESOS",
        "INDUSTRIAS, GRÁFICA, PUBLICITARIA Y MULTIMEDIAL",
        "INFORMÁTICA",
        "MADERA Y MUEBLE",
        "MECÁNICA, METALMECÁNICA Y METALURGIA",
        "MINERÍA E HIDROCARBUROS",
        "NAVAL",
        "SALUD",
        "SEGURIDAD, AMBIENTE E HIGIENE",
        "TEXTIL E INDUMENTARIA",
        "TURISMO"
    ]
}

var sociohumanistica = {
    nombre: "FPC Socio Humanística",
    nominas: [
        "COMUNICACIÓN Y MEDIOS",
        "INTERVENCIÓN SOCIAL",
        "DEPORTE, JUEGO Y TIEMPO LIBRE",
        "BIENESTAR PERSONAL Y COMUNITARIO",
        "RELACIONES INSTITUCIONALES Y HUMANAS",
        "POLÍTICA, DERECHO Y SOCIOLOGÍA",
        "ECONOMÍA, BANCOS Y FINANZAS",
        "HUMANÍSTICAS",
        "FILOSOFÍA, ÉTICA Y RELIGIÓN",
        "LITERATURA, REDACCIÓN LITERARIA Y EDICIÓN.",
        "TAQUIGRAFÍA / ESTENOTIPIA, TRADUCTORADOS E",
        "INTERPRETARIADOS.",
        "DISCIPLINAS COMBINADAS",
        "CIENCIAS DE LA VIDA",
        "CIENCIAS DE LA CONDUCTA PERSONAL Y SOCIAL",
        "HISTORIA, GEOGRAFÍA Y ARQUEOLOGÍA",
        "HISTORIA, GEOGRAFÍA Y AMBIENTE"
    ]
}
var artistica = {
    nombre: "FPC Artística Específica",
    nominas: [
        "ARTES VISUALES Y PLÁSTICAS",
        "ARTES DE LA ALFARERÍA Y LA CERÁMICA",
        "ARTES DE LA ESCULTURA",
        "ARTES DE LA ESCENOGRAFÍA Y LA DECORACIÓN",
        "ARTES MUSICALES Y SONORAS",
        "ARTES DRAMÁTICAS",
        "ARTES DEL MOVIMIENTO",
        "ARTES AUDIOVISUALES",
        "ARTES MULTIMEDIALES",
        "ARTE Y DISEÑO",
        "ARTE Y COMUNICACIÓN",
        "ARTE Y GESTIÓN CULTURAL"

    ]
}
var capacitacionlaboral = {
    nombre: "Capacitación Laboral",
    nominas: [
        "NO APLICA"
    ]
}

var nominasObject = [
    profecionales,
    sociohumanistica,
    artistica,
    capacitacionlaboral
];

function cargarNominas() {
    var tipoDeAgrupamiento = document.getElementById("tipoDeAgrupamiento");

    nominasObject = nominasObject.sort()
    for (let index = 0; index < nominasObject.length; index++) {

        var element = nominasObject[index].nombre;

        tipoDeAgrupamiento.options[index + 1] = new Option(element, element);

    }
}


function cargarNominaValores() {
    var tipoDeAgrupamiento = document.getElementById("tipoDeAgrupamiento").value
    var nomina = document.getElementById("nomina")
    var div_nomina=document.getElementById("div-nomina")
    
    while (nomina.firstChild) {
        nomina.removeChild(nomina.firstChild);
      }
    
   
   
   
    nomina.options[0] = new Option("Seleccione", "")

    for (let index = 0; index < nominasObject.length; index++) {
        const element = nominasObject[index];
        if(element.nombre===tipoDeAgrupamiento){
         for (let i = 0; i < element.nominas.length; i++) {
            const element2 = element.nominas[i];
            nomina.options[i+1] = new Option(element2, element2)
            
         }

        }
        
    }
   


}
cargarNominas();
