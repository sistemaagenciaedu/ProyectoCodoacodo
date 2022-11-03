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


 var input1=document.getElementById("")
 var input1=document.getElementById("")
 input1.setAttribute("Style","border-radius: 10px !important")
 input2.setAttribute("Style","border-radius: 10px !important")
 input1.setAttribute("Style","border: 1px solid red !important")
 input2.setAttribute("Style","border: 1px solid red !important")

 var expre=new RegExp('/"/g')

 function verificarComillasdoblestitulo(){
    var titulo=document.getElementById("titulo22")
    var texto="";
    var cantidad=0
    for (let index = 0; index < titulo.value.length; index++) {
        var element = titulo.value.charAt(index)
        if(expre.search(element)!=(0)){
            texto=texto+element;
        }else{
            texto=texto+"&";
            // for (let index2 = 0; index2 < texto.length; index2++) {
            //     var element2 = texto.charAt(index2)
            //     if(cantidad===0){
            //         texto=texto+"“+";
            //         cantidad++;
            //     }else{
            //         texto=texto+"+”";
            //     }
            // }
            
        }
        
    }
    
    titulo.value=texto;
 }


function verificarComillasdoblespregunta(){
    var pregunta=document.getElementById("pregunta22")
    var texto="";
    var cantidad=0
    for (let index = 0; index < pregunta.value.length; index++) {
        var element = pregunta.value.charAt(index)
        if(expre.search(element)!=(0)){
            texto=texto+element;
        }else{
            // for (let index2 = 0; index2 < texto.length; index2++) {
            //     var element2 = texto.charAt(index2)
            //     if(cantidad===0){
            //         texto=texto+"“+";
            //         cantidad++;
            //     }else{
            //         texto=texto+"+”";
            //     }
            // }
            texto=texto+"&";
        }
        
    }
   
    pregunta.value=texto;
 }