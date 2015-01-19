
public class RectangleTest {
	public static void main(String[]args){
		Rectangle sandbox = new Rectangle();
		Rectangle bBallCourt = new Rectangle(15,20);
		
		System.out.println("Sandbox default info");
		sandbox.printLenWid();
		
		System.out.println("\nBasketball Court Info:");
		bBallCourt.printLenWid();
		System.out.println("Area: " + bBallCourt.calcArea());
		sandbox.setLenWid(10, 4);
		
		System.out.println("\nSandbox new info:");
		sandbox.printLenWid();
		System.out.println("Area: " + sandbox.calcArea());
		
		System.out.println("\nSandbox:\n" + sandbox.toString());
		System.out.println("Basketball Courth:\n"+bBallCourt.toString());
	}
}
