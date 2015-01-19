/**
 * 
 */

/**
 * @author Grayson Lorenz
 *
 */
public class Rectangle {
	private int length;
	private int width;
	
	Rectangle(){
		setLength(0);
		setWidth(0);
	}
	
	Rectangle(int l, int w){
		setLength(l);
		setWidth(w);
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		if(length < 0){
			length = 0;
		}
		
		this.length = length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		if(width < 0){
			width = 0;
		}
		
		this.width = width;
	}
	
	public void setLenWid(int l, int w){
		setLength(l);
		setWidth(w);
	}
	
	public int calcArea(){
		int area = 0;
		area = getLength() * getWidth();
		return area;
	}
	
	public void printLenWid(){
		System.out.println("Length: " + getLength() + " Width: " + getWidth());
	}
	
	public String toString(){
		String output = "";
		output = "Length:" + getLength() + " Width:" + getWidth() + " Area:" + calcArea();
		return output;
	}
}
