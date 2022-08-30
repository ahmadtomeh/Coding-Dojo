function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings = toppings;
    return pizza;
}
function randomPizza() {
    var crustType = ["hand tossed", "deep dish"];
    var sauceType = ["traditional", "marinara"];
    var cheeses = ["mozzarella", "feta"];
    var toppings = ["pepperoni", "sausage", "mushrooms","olives", "onions"];
    var toppings_r1 = toppings[Math.floor(Math.random() * toppings.length)];
    var toppings_r2 = toppings[Math.floor(Math.random() * toppings.length)];
    while(toppings_r1 === toppings_r2){
        toppings_r2 = toppings[Math.floor(Math.random() * toppings.length)];
    }
    var random = pizzaOven(crustType[Math.floor(Math.random() * crustType.length)],
        sauceType[Math.floor(Math.random() * sauceType.length)],
        cheeses[Math.floor(Math.random() * cheeses.length)],[toppings_r1,toppings_r2]);
    return random;
}

var pizza1 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions", ])
console.log(pizza1);

var pizza2 = pizzaOven("deep dish", "traditional", ["mozzarella"],["pepperoni", "sausage", "sausage"])
console.log(pizza2);

var pizza3 = pizzaOven("aaa", "bbb", ["ccc"],["ddd", "eee"])
console.log(pizza3);

var pizza4 = pizzaOven("ZZZ", "YYY", ["XXX"],["WWW", "VVV"])
console.log(pizza4);

var pizza5 = randomPizza()
console.log(pizza5);
