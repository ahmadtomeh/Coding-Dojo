var name_ = document.querySelector(".card-body h1");
function changeName(){
    name_.innerText = "Ahmad Tomeh";
}

var conCount = 500;
var reqCount = 2;
var reqNumber = document.querySelector(".first-span");
var conNumber = document.querySelector(".second-span");
var req1 = document.querySelector("li.req1")
var req2 = document.querySelector("li.req2")

function tick1(){
    reqCount --;
    conCount ++;
    reqNumber.innerText = reqCount;
    conNumber.innerText = conCount + "+";
    req1.remove()
}

function cross1(){
    reqCount --;
    reqNumber.innerText = reqCount;
    req1.remove()
}

function tick2(){
    reqCount --;
    conCount ++;
    reqNumber.innerText = reqCount;
    conNumber.innerText = conCount + "+";
    req2.remove()
}

function cross2(){
    reqCount --;
    reqNumber.innerText = reqCount;
    req2.remove()
}