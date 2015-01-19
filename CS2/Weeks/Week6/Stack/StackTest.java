import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Grayson Lorenz
 *
 */

@SuppressWarnings("serial")
public class StackTest extends JFrame{
	public static void main(String []args){
		File file = null;
		JFileChooser chooser = new JFileChooser();
		Scanner reader;
		String line = "";
		String output = "";
		CustomStack stack = new CustomStack();

		JOptionPane.showMessageDialog(null, "Choose your test file.");
		
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		   file = chooser.getSelectedFile();
		}		

		try{       
      reader = new Scanner(file);
      while(reader.hasNext()) 
      {
      	line = reader.nextLine();
      	output += line + "\n";
      	
      	for(int i = 0; i < line.length(); i ++){
      		String thisChar = "";
      		thisChar += line.charAt(i);
      		
      		//if open then just add to stack
      		if(thisChar.compareTo("{") == 0 || thisChar.compareTo("[") == 0 || thisChar.compareTo("(") == 0){
      			stack.push(thisChar);
      		}
      		
      		//Check closes
      		if(thisChar.compareTo("}") == 0){
      			if(stack.pop().compareTo("{") != 0){
      				JOptionPane.showMessageDialog(null, "Issue with nesting at final printed line.");
      				System.out.println(output);
      				System.exit(0);
      			}
      		}
      		if(thisChar.compareTo("]") == 0){
      			if(stack.pop().compareTo("[") != 0){
      				JOptionPane.showMessageDialog(null, "Issue with nesting at final printed line.");
      				System.out.println(output);
      				System.exit(0);
      			}
      		}
      		if(thisChar.compareTo(")") == 0){
      			if(stack.pop().compareTo("(") != 0){
      				JOptionPane.showMessageDialog(null, "Issue with nesting at final printed line.");
      				System.out.println(output);
      				System.exit(0);
      			}
      		}	
      	}
      }
      reader.close();
		}	
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Check completed. Output done.");
		System.out.println(output);
		
	}
}
