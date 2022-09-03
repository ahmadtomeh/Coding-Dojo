function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() +
        new Date().getMinutes() * 60 +
        new Date().getHours() * 3600;
}
var hour1 = document.getElementById("hour");
var minutes1 = document.getElementById("minutes")
var seconds1 = document.getElementById("seconds")
setInterval(function () {
    var time = getSecondsSinceStartOfDay();
    hour = Math.floor(time / 3600);
    minutes = Math.floor((time - hour * 3600) / 60);
    seconds = (time - hour * 3600) - (minutes * 60);
    if(hour > 12){
        hour -= 12;
    }
    if(hour < 6){
        x=180+hour*30
        hour1.style.transform = " rotate("+x+"deg)"
    }
    if(hour > 6){
        hour1.style.transform = " rotate("+(hour-6)*30+"deg)"
    }
    if(minutes < 30){
        x=180+minutes*6
        minutes1.style.transform = " rotate("+x+"deg)"
    }
    if(minutes > 30){
        minutes1.style.transform = " rotate("+(minutes-30)*6+"deg)"
    }
    if(seconds < 30){
        x=180+seconds*6
        seconds1.style.transform = " rotate("+x+"deg)"
    }
    if(seconds > 30){
        seconds1.style.transform = " rotate("+(seconds-30)*6+"deg)"
    }
    
}, 1000);
function c(){
    console.log(hour,':',minutes,':', seconds)
}
