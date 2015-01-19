import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Grayson Lorenz
 *
 */
public class Formatting extends JFrame{
	public static void main(String[] args) throws FileNotFoundException{	
		File file = new File("info.txt");		
		Scanner scan = new Scanner(file);
		String s = "";
		int i = 0;
		double d = 0.0;
	
		System.out.printf("%-10s  %-21s  %3s  %5s  %11s  %-15s\n", "First Name", "Last Name", "Age", "GPA", "GPA-sn", "Favorite Movie");	
		
		while(scan.hasNext()){
			s = scan.next();
			System.out.printf("\n%-10s  ", s);
			s = scan.next();
			System.out.printf("%-21s  ", s);
			i = scan.nextInt();
			System.out.printf("%3d  ", i);
			d = scan.nextDouble();
			System.out.printf("%1.3f  ", d);
			System.out.printf("%1.5e ", d);
			s = scan.nextLine();
			System.out.printf("%-15s",s);
		}
	}
}
