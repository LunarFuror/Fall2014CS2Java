/**
 * 
 * @author Grayson Lorenz and Justin Kilzer
 *
 */
public class Candidate {
	private String firstName;
	private String lastName;
	private int total;
	
	public Candidate(){
		
	}
	
	/**
	 * Creates each Candidate with arguments
	 * @param f the first name to be set.
	 * @param l the last name to be set.
	 * @param t the number of votes to be set.
	 */
	public Candidate(String f, String l, int t){
		setFirstName(f);
		setLastName(l);
		setTotal(t);
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Adds the number of votes from one candidate to this one, if the first and last name are the same.
	 * @param c the other candidate to be added to this one.
	 */
	public void add(Candidate c){
		if(c.getLastName().compareTo(getLastName()) == 0 && c.getFirstName().compareTo(getFirstName()) == 0){
				setTotal(c.getTotal() + getTotal());
		}
	}
	
	/**
	 * Creates an object array to give to populate tables.
	 * @return the object array of last name, first name, and total votes
	 */
	public Object[] getObjectArray(){
		Object[] output = {getLastName(), getFirstName(), getTotal()};
		return output;
	}
}
