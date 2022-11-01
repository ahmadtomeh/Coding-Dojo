
public class Sculpture extends Art {
	String material;
	public void viewArt() {
		System.out.println("ART made by "+this.author+", Title "+this.title);
		System.out.println("made by "+this.material);
		System.out.println(this.description);
	}
}
