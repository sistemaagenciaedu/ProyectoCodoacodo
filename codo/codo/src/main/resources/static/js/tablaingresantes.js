var filtro=document.getElementById("acciones-exportar")
function verFiltro(){
    filtro.setAttribute("Style","display:block !important")
}
function noVerFiltro(){
    filtro.removeAttribute("Style","display:block !important")
}

function descargarFiltro(){
    var mensaje;
    var opcion = confirm("Desea Generar el reporte filtrado haga clic en aceptar de lo contrario haga clic en cancelar el proceso puede demorar");
    if (opcion == true) {
        var validacion = confirm("Por favor cierre el la pestaña de administracion en 30 minutos se generará el reporte podra descargarlo en la seccion Lista de Reportes");
      if(validacion==true){
        let formu=document.getElementById("formExcelFiltrado").submit();
       formu.submit();
      }
    } 


 

}