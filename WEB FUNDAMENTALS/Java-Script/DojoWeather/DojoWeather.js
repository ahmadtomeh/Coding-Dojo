//
function hide() {
    document.querySelector(".ul4").remove();
}

// var red1_ = document.querySelector(".red1");
// var red2_ = document.querySelector(".red2");
// var red3_ = document.querySelector(".red3");
// var red4_ = document.querySelector(".red4");
// var blue1_ = document.querySelector(".blue1");
// var blue2_ = document.querySelector(".blue2");
// var blue3_ = document.querySelector(".blue3");
// var blue4_ = document.querySelector(".blue4");
// var sw  = document.querySelector(".swap");
// var num = sw.innerText;
// function changeTemp(elm) {
//     if(elm.value == "f"){
//         sw.innerText = Math.floor(( num * 1.8 ) + 32);
//     }
//     else{
//         sw.innerText = Math.round(( Math.round(( num * 1.8 ) + 32) - 32) / 1.8);
//     }
    // if (elm.value == "f") {
    //     red1_.innerText = 75 + "°";
    //     red2_.innerText = 80 + "°";
    //     red3_.innerText = 69 + "°";
    //     red4_.innerText = 78 + "°";
    //     blue1_.innerText = 65 + "°";
    //     blue2_.innerText = 66 + "°";
    //     blue3_.innerText = 61 + "°";
    //     blue4_.innerText = 70 + "°";
    // }
    // else {
    //     red1_.innerText = 24 + "°";
    //     red2_.innerText = 27 + "°";
    //     red3_.innerText = 21 + "°";
    //     red4_.innerText = 26 + "°";
    //     blue1_.innerText = 18 + "°";
    //     blue2_.innerText = 19 + "°";
    //     blue3_.innerText = 16 + "°";
    //     blue4_.innerText = 21 + "°";
    // }
// }
// }

function c2f(temp) {
    return Math.round(9 / 5 * temp + 32);
}

function f2c(temp) {
    return Math.round(5 / 9 * (temp - 32));
}
function changeTemp(element) {
    for(var i=1; i<9; i++) {
        var tempSpan = document.querySelector(".swap" + i);
        var tempVal = parseInt(tempSpan.innerText);
        if(element.value == "c") {
            tempSpan.innerText = f2c(tempVal);
        } else {
            tempSpan.innerText = c2f(tempVal);
        }
    }
}

