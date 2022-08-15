function noVerOpciones(){
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.setAttribute("style","display:none !important")
    var formcreador=document.getElementById("form-creador")
    formcreador.setAttribute("style","display:none !important")
}

noVerOpciones()
function tipoPregunta(){
    var tipo=document.getElementById("tipo").value
if(tipo==="OPCION SIMPLE" || tipo==="LISTA"){
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.removeAttribute("style","display:none !important")
}else{
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.setAttribute("style","display:none !important")
}
}
function mostrarcreador(){
    var formcreador=document.getElementById("form-creador")
    formcreador.removeAttribute("style","display:none !important")
}

function cargarDatos(index){
   
    var idpreg=document.getElementById("id"+index).innerText
    var descripcionpreg=document.getElementById("descripcion"+index).innerText
    var enunciadopreg=document.getElementById("enunciado"+index).innerText
    var tipopreg=document.getElementById("tipo"+index).innerText
    var asociacionIdpreg=document.getElementById("asociacionId"+index).innerText
    
    var idform=document.getElementById("id")
    var descripcionform=document.getElementById("descripcion")
    var asociacionIdform=document.getElementById("asociacionId")
    var enunciadoform=document.getElementById("enunciado")
    var tipoform=document.getElementById("tipo")

    idform.value=idpreg
    descripcionform.value=descripcionpreg
    enunciadoform.value=enunciadopreg
    tipoform.value=tipopreg
    asociacionIdform.value=asociacionIdpreg
   

    mostrarcreador()
    
    }
function preguntaAsociada(index){
   
    var idpreg=document.getElementById("id"+index).innerText
       
    var asociacionIdform=document.getElementById("asociacionId")
        
    asociacionIdform.value=idpreg
   

    mostrarcreador()
    
    }