function noVerOpciones(){
   
    var formcreador=document.getElementById("form-creador")
    formcreador.setAttribute("style","display:none !important")
}

noVerOpciones()
function mostrarcreador(){
    var formcreador=document.getElementById("form-creador")
    formcreador.removeAttribute("style","display:none !important")
}
