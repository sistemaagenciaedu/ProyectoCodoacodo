

function cambiarColor(i,longitud){
    console.log(i)
    console.log(longitud)
    for (let index = 0; index < longitud+1; index++) {
       
               console.log(index)
        if(i===index){
            console.log("entro")
            var etiqueta = document.getElementsByClassName("etiqueta")[index];
            
            etiqueta.setAttribute("style","background-color: #88bf48;font-weight: bold ")
        
        }else{
            var etiqueta = document.getElementsByClassName("etiqueta")[index];
            var chech = document.getElementsByClassName("chequeado")[index];
            etiqueta.removeAttribute("style","background-color: #88bf48;font-weight: bold ")
            chech.checked=false
            
        }
        
        
    }
}