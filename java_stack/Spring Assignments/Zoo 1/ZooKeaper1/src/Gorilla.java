
public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Boooooooom");
		int Energy = this.displayEnergy() ;
		Energy -=5;
		this.setEnergyLevel(Energy);
		System.out.println("Gorilla new Energy : " + Energy);
	}
	public void eatBananas() {
		System.out.println("yam yam!!!");
		int Energy = this.displayEnergy() ;
		Energy +=10;
		this.setEnergyLevel(Energy);
		System.out.println("Gorilla new Energy : " + Energy);
	}
	public void climb() {
		System.out.println("weeeeeeee!!!");
		int Energy = this.displayEnergy() ;
		Energy -=10;
		this.setEnergyLevel(Energy);
		System.out.println("Gorilla new Energy : " + Energy);
	}
}
