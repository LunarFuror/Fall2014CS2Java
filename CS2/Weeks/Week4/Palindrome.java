import java.util.Scanner;

/**
 * 
 */

/**
 * @author Grayson Lorenz
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String testString = "";
		String send = "";
		Scanner scan = new Scanner(System.in);
		
		while(testString.compareTo("exit") != 0){
			send = "";
			System.out.println("Enter your test string or type exit to exit:");
			testString = scan.nextLine().toLowerCase();
			
			for(int i = 0; i < testString.length(); i++){
				if(testString.charAt(i) != ',' && testString.charAt(i) != '.' && testString.charAt(i) != ' '){
					send += testString.charAt(i);
				}
			}
			if(testString.compareTo("exit") != 0){
				if(isPalindrome(send)){
					System.out.println("Test string is a palindrome");
				}
				else{
					System.out.println("Test string is not a palindrome");
				}
			}
		}
	}
	
	/**
	 * If not too small, and the last and first letter in the phrase match, pass in the phrase again, with those two letters removed.
	 * @param test the string to test
	 * @return true if palindrome, fales if not.
	 */
	public static boolean isPalindrome(String test){
		String buffer = "";
		if(test.length() == 1 || (test.length() == 2 && test.charAt(0) == test.charAt(1))){
			return true;
		}
		
		if(test.charAt(0) == test.charAt(test.length() -1)){
			buffer = test.substring(1, test.length() - 1);
			if(isPalindrome(buffer)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}
