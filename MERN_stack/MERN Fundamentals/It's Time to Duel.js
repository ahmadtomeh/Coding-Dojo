class Card {
    constructor(name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card{
    constructor(name, cost, power, res) {
    super(name,cost);
    this.power = power;
    this.res  = res;
    }

    attack(target){
        target.res-=this.power
    }
    showStats() {
        console.log("-----------------")
        console.log(`Name:    ${this.name}`);
        console.log(`cost:  ${this.cost}`);
        console.log(`power:   ${this.power}`);
        console.log(`res: ${this.res}`);
        return this;
    }
}

class Effect extends Card{
    constructor(name, cost, text, stat, magnitude) {
    super(name,cost);
    this.text  = text;
    this.stat = stat;
    this.magnitude  = magnitude;

    }

    play( target ) {
        if( target instanceof Unit ) {
            if(this.stat=="resilience"){
                target.res+=this.magnitude
            }
            else{
                target.power+=this.magnitude
            }
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

const unitCard1 = new Unit("Red Belt Ninja", 3, 3, 4);
const unitCard2 = new Unit("Black Belt Ninja", 4, 5, 4);

const effectCard1 = new Effect("Hard Algorithm", 2, "	increase target's resilience by 3","resilience", 3);
const effectCard2 = new Effect("Unhandled Promise Rejection", 1, "reduce target's resilience by 2", "resilience", -2);
const effectCard3  = new Effect("Pair Programming", 3, "increase target's power by 2", "power", 2);

effectCard1.play(unitCard1)
unitCard1.showStats()
effectCard2.play(unitCard1)
unitCard1.showStats()
effectCard3.play(unitCard1)
unitCard1.showStats()
unitCard1.attack(unitCard2)
unitCard2.showStats()
