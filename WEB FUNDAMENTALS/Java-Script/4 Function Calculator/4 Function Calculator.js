var val = document.querySelector("#display")
var num1 = "";
var num2 = "";
var op = "";
var result = 0;
function press(num) {
    num1 += num;
    val.innerText = num1;
    console.log(typeof (num1))
}
function clr() {
    num1 = "";
    num2 = "";
    op = "";
    val.innerText = 0;
}

function setOP(opr) {
    op = opr;
    num2 = num1;
    num1 = "";
}

function calculate() {
    if (op == "+") {
        result = Number(num2) + Number(num1);
    }   
    else if (op == "-") {
        result = Number(num2) - Number(num1);
    }
    else if (op == "*") {
        result = Number(num2) * Number(num1);
    }
    else {
        result = Number(num2) / Number(num1);
    }
    num1 = result;
    op = "";
    val.innerHTML = result;
}