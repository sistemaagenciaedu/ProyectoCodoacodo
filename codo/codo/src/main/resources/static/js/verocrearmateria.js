function mostrarFormulario(){
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")
}
function noverFomulario(){
    var formulario=document.getElementById("form-creador")
    formulario.removeAttribute("style","display:flex !important")
}

function cargarDatos(index){
var idtabla=document.getElementById("id"+index).innerText
var nombretabla=document.getElementById("nombre"+index).innerText
var cantPreg=document.getElementById("nPreguntas"+index).innerText
console.log(cantPreg)
var idform=document.getElementById("id")
var nombreform=document.getElementById("nombre")
var cantPregform=document.getElementById("nPreguntas")
idform.value=idtabla
nombreform.value=nombretabla
cantPregform.value=cantPreg
    console.log(idtabla)
    console.log(nombretabla)
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")

}
function ventanaSecundaria (URL){ 
    window.open(URL,"ventana1","width=120,height=300,scrollbars=NO") 
 } 
