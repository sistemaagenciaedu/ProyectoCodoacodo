function mostrarFormulario(){
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")

var tipo=document.getElementById("tOpcion").value

var opcionText=document.getElementById("opcionText")
var labelopcionText=document.getElementById("labelopcionText")
var labelimagenx=document.getElementById("labelimagenx")
var imagenx=document.getElementById("imagenx")


if(tipo==="Texto Plano"){
    labelimagenx.setAttribute("Style","display:none !important")
    imagenx.setAttribute("Style","display:none !important")
    opcionText.setAttribute("required","true")
}else if(tipo==="Imagen"){
    opcionText.setAttribute("Style","display:none !important")
    labelopcionText.setAttribute("Style","display:none !important")
    imagenx.setAttribute("required","true")
}else{
    opcionText.setAttribute("Style","display:none !important")
    labelopcionText.setAttribute("Style","display:none !important")
    labelimagenx.setAttribute("Style","display:none !important")
    imagenx.setAttribute("Style","display:none !important")
}

}



function noverFomulario(){
    var formulario=document.getElementById("form-creador")
    formulario.removeAttribute("style","display:flex !important")
}


function ventanaSecundaria (URL){ 
    window.open(URL,"ventana1","width=120,height=300,scrollbars=NO") 
 } 
