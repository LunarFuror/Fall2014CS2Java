
public class Periodical {
	private String edition;
	private int publishRate;
	
	public Periodical(){
		setEdition("Initial");
		setPublishRate(1);
	}

	public Periodical(String e, int p){
		setEdition(e);
		setPublishRate(p);
	}
	
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getPublishRate() {
		return publishRate;
	}

	public void setPublishRate(int publishRate) {
		this.publishRate = publishRate;
	}
	
	public void printAll(){
		System.out.println("Published " + getPublishRate() + " time(s) a year!");
		System.out.println("Volume: " + getEdition());
	}
	
	public String toString(){
		return getEdition() + "\n" + getPublishRate();
	}
}
