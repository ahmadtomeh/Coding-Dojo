function hide() {
    document.querySelector(".ul4").remove();
}

var red1_ = document.querySelector(".red1");
var red2_ = document.querySelector(".red2");
var red3_ = document.querySelector(".red3");
var red4_ = document.querySelector(".red4");
var blue1_ = document.querySelector(".blue1");
var blue2_ = document.querySelector(".blue2");
var blue3_ = document.querySelector(".blue3");
var blue4_ = document.querySelector(".blue4");

function changeTemp(elm) {
    if (elm.value == "f") {
        red1_.innerText = 75 + "°";
        red2_.innerText = 80 + "°";
        red3_.innerText = 69 + "°";
        red4_.innerText = 78 + "°";
        blue1_.innerText = 65 + "°";
        blue2_.innerText = 66 + "°";
        blue3_.innerText = 61 + "°";
        blue4_.innerText = 70 + "°";
    }
    else {
        red1_.innerText = 24 + "°";
        red2_.innerText = 27 + "°";
        red3_.innerText = 21 + "°";
        red4_.innerText = 26 + "°";
        blue1_.innerText = 18 + "°";
        blue2_.innerText = 19 + "°";
        blue3_.innerText = 16 + "°";
        blue4_.innerText = 21 + "°";
    }
}

