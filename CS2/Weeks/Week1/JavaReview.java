import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Grayson Lorenz
 *
 */
public class JavaReview {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numPets = "";
		
		numPets = JOptionPane.showInputDialog("How many pets (3-5)?");
		int pets = Integer.parseInt(numPets);
		
		if(pets > 5){
			pets = 5;
		}
		if(pets < 3){
			pets = 3;
		}
		
		String names[] = new String[pets];
		
		Scanner scan = new Scanner(System.in);
		
		for(int x = 0; x < pets; x++){
			System.out.println("Enter pet #" + (x + 1) + "'s name.");
			names[x] = scan.nextLine();
		}
		
		System.out.println("My pets:");
		
		String buffer = null;
		for(String output: names){
			buffer = output.toLowerCase();
			System.out.println(buffer);
		}
		
		System.out.println("My pets in reverse order:");
		
		int x = names.length -1;
		while(x >= 0){
			buffer = names[x].toUpperCase();
			System.out.println(buffer);
			x --;
		}
		
	}
}
