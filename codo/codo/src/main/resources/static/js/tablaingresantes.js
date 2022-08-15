var filtro=document.getElementById("acciones-exportar")
function verFiltro(){
    filtro.setAttribute("Style","display:block !important")
}
function noVerFiltro(){
    filtro.removeAttribute("Style","display:block !important")
}

function descargarFiltro(){
    document.getElementById("formExcelFiltrado").submit();

}