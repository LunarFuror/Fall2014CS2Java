/**
 * 
 * @author Grayson Lorenz
 *
 */
public class LinkedNode {
	String data;
	LinkedNode next;
	
	/**
	 * No param Constructor
	 */
	public LinkedNode(){
		setData("");
		setNext(null);
	}
	
	/**
	 * Data Constructor
	 * @param n the data to set
	 */
	public LinkedNode(String n){
		setData(n);
		setNext(null);
	}
	
	/**
	 * LinkedNode constructor
	 * @param l the next node after this one
	 */
	public LinkedNode(LinkedNode l){
		setNext(l);
	}
	
	/**
	 * All Data constructor
	 * @param n the data to set
 	 * @param l the next node after this one
	 */
	public LinkedNode(String n, LinkedNode l){
		setData(n);
		setNext(l);
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public LinkedNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedNode next) {
		this.next = next;
	}
}
