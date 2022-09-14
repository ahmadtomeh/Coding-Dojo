var sort_ = document.querySelector(".sort");
function changeSort(element) {
    sort_.innerText = element.value;
}

var add_ = document.querySelector(".add_cart");
var counter = 0;
function add1(){
    counter++;
    add_.innerText = counter;
}