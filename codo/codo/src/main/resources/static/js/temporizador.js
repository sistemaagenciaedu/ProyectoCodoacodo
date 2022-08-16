let fin=document.getElementById("fin").innerHTML
let ahora=document.getElementById("ahora").innerHTML

// let minadd= parseFloat(minutosrestantes);
// let countDownDate = new Date().getTime()+minadd*60000;
// let countDownDate = new Date().getTime()+minadd*60000;
let countDownDate = new Date().setTime(parseFloat(fin))
console.log(countDownDate);


setInterval(() => {
  // Get Date Now
  let dateNow = new Date();

  // Find The Date Difference Between Now And Countdown Date
  let dateDiff = countDownDate - dateNow;

  // Get Time Units
  
  let days = Math.floor(dateDiff / (1000 * 60 * 60 * 24));
  let hours = Math.floor((dateDiff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  let minutes = Math.floor((dateDiff % (1000 * 60 * 60)) / (1000 * 60));
  let seconds = Math.floor((dateDiff % (1000 * 60)) / 1000);

  document.querySelector(".days").innerHTML = days < 10 ? `0${days}` : days;
  document.querySelector(".hours").innerHTML = hours < 10 ? `0${hours}` : hours;
  document.querySelector(".minutes").innerHTML = minutes < 10 ? `0${minutes}` : minutes;
  document.querySelector(".seconds").innerHTML = seconds < 10 ? `0${seconds}` : seconds;

  if (dateDiff < 0) {
    document.getElementById("myForm").submit();
  }
  
}, 1000);
