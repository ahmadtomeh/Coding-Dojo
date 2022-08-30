console.log("---------------Print odds 1-20----------------");
for (i=1;i<=20;i+=2){
    console.log(i);
}
console.log("----------Decreasing Multiples of 3-----------");
for (i = 100; i > 0; i--){
    if(i % 3 == 0){
        console.log(i);
    }
}
console.log("------------Print the sequence----------------");
for (i = 4; i >= -3.5; i -= 1.5){
    console.log(i)
}
console.log("-------------------Sigma----------------------");
var sum = 0;
for (i = 1; i <= 100; i++){
    sum = sum + i;
}
console.log(sum);
console.log("-----------------Factorial--------------------");
var Factorial = 1;
for(i = 1; i <= 12; i++){
    Factorial = Factorial * i;
}
console.log(Factorial);
