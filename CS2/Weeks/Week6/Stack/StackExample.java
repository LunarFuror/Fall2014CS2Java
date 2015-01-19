import java.util.Stack;

/**
 * 
 * @author Grayson Lorenz
 *
 */
public class StackExample {
	public static void main(String []args){
		Stack<Object> stack1 = new Stack<Object>();
		Stack<Object> stack2 = new Stack<Object>();
		
		printEmpty(stack1);
		
		stack1.push("Grayson");
		stack1.push(24);
		stack1.push("purple");
		stack1.push(25.10);
		
		printEmpty(stack1);
		
		System.out.println(stack1.peek());
		
		if(!stack1.contains("magenta")){
			System.out.println("Magenta does not exist in stack1");
		}
		if(stack1.contains("purple")){
			System.out.println("Purple does exist in stack1");
		}
		
		System.out.println("\nMoving from stack one to stack 2");
		
		while(!stack1.empty()){
			stack2.push(stack1.pop());
			System.out.println(stack2.peek());
		}
		
		System.out.println("\nChecking stack2 then 1 for emptiness");
		
		printEmpty(stack2);
		printEmpty(stack1);
		
		System.out.println("\nPrinting stack2 contents, then emptying");
		
		while(!stack2.empty()){
			System.out.println(stack2.pop());
		}
		
		printEmpty(stack2);
	}
	
	public static void printEmpty(Stack stack){
		if(stack.empty()){
			System.out.println("The stack is empty.");
		}
		else{
			System.out.println("The stack is not empty.");
		}
	}
}
