
public class Painting extends Art {
	String paintType;
	
	public void viewArt() {
		System.out.println("ART made by "+this.author+", Title "+this.title);
		System.out.println("made by "+this.paintType);
		System.out.println(this.description);

	}
}
