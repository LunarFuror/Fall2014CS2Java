
/**
 * 
 * @author Grayson Lorenz
 *
 */
public class CustomStack {
	LinkedNode start;
	
	public CustomStack(){
		setStart(new LinkedNode());
	}

	/**
	 * @return the start
	 */
	public LinkedNode getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(LinkedNode start) {
		this.start = start;
	}
	
	public void push(String d){
		LinkedNode temp = new LinkedNode(d);
		if(start.getNext() == null){
			start.setNext(temp);
		}
		else{
			temp.setNext(start.getNext());
			start.setNext(temp);
		}
	}
	
	public String pop(){
		String data = "Stack Empty";
		LinkedNode next = start.getNext();
		
		if(next != null){
			data = next.getData();
			start.setNext(next.getNext());
		}
		
		return data;
	}
}
