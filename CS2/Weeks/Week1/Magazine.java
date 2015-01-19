
public class Magazine extends Periodical {
	private int issueNumber;
	private String date;
	private String featureStory;
	
	public Magazine(){
		super();
		setIssueNumber(1);
		setDate("Oct/15/1999");
		setFeatureStory("Headline: You are not your wallet.");
	}
	
	public Magazine(int i, String d, String f){
		super();
		setIssueNumber(i);
		setDate(d);
		setFeatureStory(f);
	}
	
	public int getIssueNumber() {
		return issueNumber;
	}
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFeatureStory() {
		return featureStory;
	}
	public void setFeatureStory(String featureStory) {
		this.featureStory = featureStory;
	}
	
	public void printAll(){
		super.printAll();
		System.out.println("Issue: " + getIssueNumber());
		System.out.println("Printed: " + getDate());
		System.out.println("Cover Story: " + getFeatureStory());
	}
	
	public String toString(){
		return super.toString() + "\n" + getIssueNumber() + "\n" + getDate() + "\n" + getFeatureStory();
	}
}
