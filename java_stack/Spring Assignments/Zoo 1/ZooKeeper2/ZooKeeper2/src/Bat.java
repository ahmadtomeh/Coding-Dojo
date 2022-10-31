
public class Bat extends Mammal {
	public void fly() {
		System.out.println("flyyyy!!");
		
		
		int Energy = this.displayEnergy() ;
		Energy -=50;
		this.setEnergyLevel(Energy);
		System.out.println("Bat new Energy : " + Energy);
	}
	public  Bat() {
		this.setEnergyLevel(300);
	}
	public void eatHumans() {
		System.out.println("yam yam!!!");
		int Energy = this.displayEnergy() ;
		Energy +=25;
		this.setEnergyLevel(Energy);
		System.out.println("Bat new Energy : " + Energy);
	}
	public void attackTown() {
		System.out.println("BOOM !!!");
		int Energy = this.displayEnergy() ;
		Energy -=100;
		this.setEnergyLevel(Energy);
		System.out.println("Bat new Energy : " + Energy);
	}
}
