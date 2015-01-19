
public class Test {
	public static void main(String[] args){
		Periodical p = new Periodical();
		Magazine m = new Magazine();
		Yearbook y = new Yearbook();
		
		System.out.println("Calling print method for Magazine");
		m.printAll();
		
		System.out.println("Using toString");
		System.out.println(m.toString());
		
		System.out.println("Changing magazine");
		m.setDate("Jan/11/1990");
		m.setFeatureStory("Someone was born today");
		
		System.out.println("Calling gets");
		System.out.println(m.getDate() + ", " + m.getFeatureStory());
		
		System.out.println("Printing Yearbook what up?");
		y.printAll();
		
		System.out.println("Changing stuff again");
		y.setSchoolYear("1968");
		y.setSchoolName("America High School");
		
		System.out.println("toString time!");
		System.out.println(y.toString());
		p = m;
		System.out.println("Dat periodical printing press!");
		p.printAll();
		
		System.out.println("Altering data");
		p.setEdition("This edition");
		
		p.setPublishRate(9001);
		
		System.out.println("Periodical toString");
		System.out.println(p.toString());
	}
}
