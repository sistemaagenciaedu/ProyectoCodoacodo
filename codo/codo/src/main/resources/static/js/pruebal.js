
function auto(marca, modelo, year) {
    this.marca = marca;
    this.modelo = modelo;
    this.year = year;
}

function crearAuto(){
    let marca=document.getElementById("marca").value
    let modelo=document.getElementById("modelo").value
    let year=document.getElementById("year").value
    let nuevo=new auto()
    nuevo.marca=marca
    nuevo.modelo=modelo
    nuevo.year=year
    console.log(nuevo)
    let emarca=document.getElementById("emarca").value=nuevo.marca
    let emodelo=document.getElementById("emodelo").value=nuevo.modelo
    let eyear=document.getElementById("eyear").value=nuevo.year
    
return false
}

