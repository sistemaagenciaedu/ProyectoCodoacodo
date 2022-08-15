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
var tiempo=document.getElementById("tiempo"+index).innerText
var idform=document.getElementById("id")
var nombreform=document.getElementById("nombre")
var tiempoform=document.getElementById("tiempo")
tiempoform.value=tiempo
idform.value=idtabla
nombreform.value=nombretabla
    console.log(idtabla)
    console.log(nombretabla)
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")

}
function ventanaSecundaria (URL){ 
    window.open(URL,"ventana1","width=120,height=300,scrollbars=NO") 
 } 
