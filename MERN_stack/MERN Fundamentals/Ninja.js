class Ninja {
    constructor(name, health = 0) {
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;
    }

    sayName() {
        console.log("-----------------")
        console.log(`My name is ${this.name}`);
        return this;
    }

    showStats() {
        console.log("-----------------")
        console.log(`Name:    ${this.name}`);
        console.log(`Health:  ${this.health}`);
        console.log(`Speed:   ${this.speed}`);
        console.log(`Stength: ${this.strength}`);
        return this;
    }
    drinkSake() {
        console.log("-----------------")
        console.log(`${this.name} drank sake.`);
        this.health += 10;
        return this;

    }
}

const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();
ninja1.showStats();



class Sensei extends Ninja{
    constructor(name){
        super(name, 200);
        this.speed = 10;
        this.strength = 10;
        this.wisdom = 10;
    }

    speakWisdom(){
        const message = super.drinkSake();
        console.log("What one programmer can do in one month, two programmers can do in two months.");
        console.log(message);
    }
}

// example output
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"
