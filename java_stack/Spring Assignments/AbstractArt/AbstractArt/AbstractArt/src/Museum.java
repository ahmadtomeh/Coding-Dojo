
public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting paint1 =new Painting();
		
		Painting paint2 =new Painting();
		
		Painting paint3 =new Painting();
		
		Sculpture scp1=new Sculpture();
		Sculpture scp2=new Sculpture();
		
		paint1.paintType = "Oil";
		paint1.title = "t";
		paint1.author = "ahmad";
		paint1.description = "aaaaaaaaaaa";
		
		paint2.paintType = "Watercolor";
		paint2.title = "t";
		paint2.author = "ahmad";
		paint2.description = "aaaaaaaaaaa";
		
		paint3.paintType = "Acrylic";
		paint3.title = "t";
		paint3.author = "ahmad";
		paint3.description = "aaaaaaaaaaa";
		
		scp1.material="Bronze";
		scp1.title = "t";
		scp1.author = "ahmad";
		scp1.description = "aaaaaaaaaaa";
		
		scp2.material = "Marble";
		scp2.title = "t";
		scp2.author = "ahmad";
		scp2.description = "aaaaaaaaaaa";
		
		System.out.println(scp1.material);
		scp1.viewArt();
		paint1.viewArt();
	}

}
