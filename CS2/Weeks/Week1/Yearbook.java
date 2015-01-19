
public class Yearbook extends Periodical {
	private String schoolName;
	private String schoolYear;
	
	public Yearbook(){
		super();
		setSchoolName("Bates High School");
		setSchoolYear("1976");
	}
	
	public Yearbook(String n, String y){
		super();
		setSchoolName(n);
		setSchoolYear(y);
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public void printAll(){
		super.printAll();
		System.out.println("School Name: " + getSchoolName());
		System.out.println("For the " + getSchoolYear() + " school year.");
	}
	
	public String toString(){
		return super.toString() + "\n" + getSchoolName() + "\n" + getSchoolYear();
	}
}
