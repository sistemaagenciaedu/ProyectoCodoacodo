var registrouser=document.getElementById("crear-user-container")
var todo=document.getElementById("bodyextra")
registrouser.setAttribute("style","display:none !important")
function verRegistro(){
    registrouser.removeAttribute("style","display:none !important")
    //todo.setAttribute("style","display:none !important")
}

var advertencia=document.getElementById("advertencia-eliminar")
advertencia.setAttribute("style","display:none !important")
function veradvertencia(){
    advertencia.removeAttribute("style","display:none !important") 
}
function noveradvertencia(){
    advertencia.setAttribute("style","display:none !important")
}


function noVerRegistro(){
    //todo.removeAttribute("style","display:none !important")
    registrouser.setAttribute("style","display:none !important")
    
}