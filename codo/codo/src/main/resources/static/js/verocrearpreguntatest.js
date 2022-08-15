function mostrarFormulario(){
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")

var portadaVideo=document.getElementById("portadaVideo")
var labelportadaVideo=document.getElementById("labelportadaVideo")
var imagenx=document.getElementById("imagenx")
var labelimagenx=document.getElementById("labelimagenx")
portadaVideo.setAttribute("Style","display:none")
labelportadaVideo.setAttribute("Style","display:none")
imagenx.setAttribute("Style","display:none")
labelimagenx.setAttribute("Style","display:none")

}
function verPortada(){
    var tportada=document.getElementById("tipoPortada").value
    var portadaVideo=document.getElementById("portadaVideo")
    var labelportadaVideo=document.getElementById("labelportadaVideo")
   var imagenx=document.getElementById("imagenx")
    var labelimagenx=document.getElementById("labelimagenx")
    if(tportada==="Imagen"){
        imagenx.removeAttribute("Style","display:none")
       labelimagenx.removeAttribute("Style","display:none")
       portadaVideo.setAttribute("Style","display:none")
       labelportadaVideo.setAttribute("Style","display:none")
    }else if(tportada==="Video Youtube"){
        imagenx.setAttribute("Style","display:none")
        labelimagenx.setAttribute("Style","display:none")
       portadaVideo.removeAttribute("Style","display:none")
       labelportadaVideo.removeAttribute("Style","display:none")
    }else{
        portadaVideo.setAttribute("Style","display:none")
        labelportadaVideo.setAttribute("Style","display:none")
        imagenx.setAttribute("Style","display:none")
        labelimagenx.setAttribute("Style","display:none")  
    }
    
}
function noverFomulario(){
    var formulario=document.getElementById("form-creador")
    formulario.removeAttribute("style","display:flex !important")
}


function ventanaSecundaria (URL){ 
    window.open(URL,"ventana1","width=120,height=300,scrollbars=NO") 
 } 
