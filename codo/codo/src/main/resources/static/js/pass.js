function validarPass(){
    // Expreciones regulares
    let RegMayus=new RegExp("^(?=.*[A-Z])")
    let RegEspecial=new RegExp("^(?=.*[!@#$%&/*_-])")
    let RegNum=new RegExp("^(?=.*[0-9])")
    let RegTamanio=new RegExp("^(?=.{8})")
//    Fin expreciones regulares

    let password=document.getElementById("password").value

   
    let passMin8=document.getElementById("pass-8")
    let passCE=document.getElementById("pass-Cespe")
    let passMayus=document.getElementById("pass-mayus")
    let passNum=document.getElementById("pass-num")
   
    
   
    if(RegTamanio.test(password)){
        passMin8.setAttribute("style","color:green")
    }else{
        passMin8.setAttribute("style","color:red") 
    }
    
    if(RegNum.test(password)){
        passNum.setAttribute("style","color:green")
    }else{
        passNum.setAttribute("style","color:red") 
    }
    if(RegEspecial.test(password)){
        passCE.setAttribute("style","color:green")
    }else{
        passCE.setAttribute("style","color:red") 
    }
    if(RegMayus.test(password)){
        passMayus.setAttribute("style","color:green")
    }else{
        passMayus.setAttribute("style","color:red") 
    }
    
    
   

   

 }


