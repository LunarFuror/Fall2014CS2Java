/**
 * Simple custom Exception w/o methods
 * @author Grayson Lorenz
 *
 */
public class NameSpelledWrongException extends Exception {
	public NameSpelledWrongException(){
		super();
	}
	
	/**
	 * Basic toString returns base class toString()
	 * @return Exception class toString()
	 */
	public String toString(){
		return super.toString();
	}
}
