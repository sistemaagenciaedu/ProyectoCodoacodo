var resolucioncontainer=document.getElementById("cargar-resolucion-container")
resolucioncontainer.setAttribute("Style","display:none !important")
function VerCargarResolucion(){
    resolucioncontainer.removeAttribute("Style","display:none !important")
}
function NoVerCargarResolucion(){
    resolucioncontainer.setAttribute("Style","display:none !important")
}
var importarResoluciones=document.getElementById("importar-resolucion-container")
importarResoluciones.setAttribute("Style","display:none !important")
var formimportar=document.getElementById("form-importar")
function VerCargarImportarResolucion(){
    importarResoluciones.removeAttribute("Style","display:none !important")
}
function NoCargarImportarResolucion(){
    importarResoluciones.setAttribute("Style","display:none !important")
    formimportar.reset();
}
/********funciones de user**/
var cargaruser=document.getElementById("cargar-user-container")

function verCargarUser(){
    cargaruser.removeAttribute("Style","display:none !important")
}

function NoverCargarUser(){
    cargaruser.setAttribute("Style","display:none !important")
    document.getElementById("cargarUSer").reset();
}
NoverCargarUser()
/********fin funciones de user**/
var buscadorDiv=document.getElementById("buscador-resoluciones-container")
var buscadorForm=document.getElementById("form-buscador")
function verBuscador(){
    buscadorDiv.removeAttribute("Style","display:none !important")
}
function NoverBuscador(){
    buscadorDiv.setAttribute("Style","display:none !important")
    buscadorForm.reset()
}
NoverBuscador()