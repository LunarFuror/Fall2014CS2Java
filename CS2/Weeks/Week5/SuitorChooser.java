import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Grayson Lorenz
 */
@SuppressWarnings("serial")
public class SuitorChooser extends JFrame{
	
	private static JButton keepB, removeB;
	private static JLabel nameL;
	private static ButtonHandler bHandle;
	private static LinkedNode start, current, previous;
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static int EXPMIN = 0;
	
	/**
	 * instantiates objects and generates the list.
	 */
	private static void instantiate(){
		keepB = new JButton("Keep");
		removeB = new JButton("Remove");

		bHandle = new ButtonHandler();
		start = new LinkedNode();
		generateList();
		
		nameL = new JLabel(current.getName(), JLabel.CENTER);
	
		keepB.addActionListener(bHandle);
		removeB.addActionListener(bHandle);
	}
	
	/**
	 * Puts everything in the window pane.
	 * @param pane the main window pane
	 */
	private static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    if (shouldFill) {
		    //natural height, maximum width
		    c.fill = GridBagConstraints.HORIZONTAL;
	    }
	    
	    if (shouldWeightX) {
	    	c.weightx = 0.5;
	    }
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.ipady = 30;
	    c.gridheight = 1;
	    c.gridwidth = 2;
	    pane.add(nameL, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 1;
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    pane.add(keepB, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 1;
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    pane.add(removeB, c);
	}
	
	/**
	 * Creates the main window object
	 * Runs instantiation
	 * Runs window set up
	 * Makes everything visible
	 */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Instantiate objects
        instantiate();
        
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Get the first name from user
     * If current doesn't exist yet, instantiate it with the first name.
     * If it does exist, make a new node (with the entered name) after this one.
     * Set the current node, to the node we just made.
     * Do this until they type "done"
     * Close the loop by making the last node refer to the first node (the one that start refers to).
     * Make our current node the node start refers to.
     */
    private static void generateList(){
    	String buffer = JOptionPane.showInputDialog("Enter suitor name or enter DONE to continue.");
    	
    	while(buffer.compareToIgnoreCase("Done") != 0){
        	if(current == null){
        		current = new LinkedNode(buffer);
        		start.setNext(current);
        	}
        	else{
        		current.setNext(new LinkedNode(buffer));
        		current = current.getNext();
        	}
        	
    		buffer = JOptionPane.showInputDialog("Enter suitor name or enter DONE to continue.");
    	}
    	previous = current;
    	current.setNext(start.getNext());
    	current = start.getNext();
    }
        
    /**
     *	Simply moves to the next node in the list 
     */
    public static void nextNode(){
    	previous = current;
    	current = current.getNext();
    	nameL.setText(current.getName());
    }
    
    /**
     * 
     */
    public static void removeNode(){
    	previous.setNext(current.getNext());
    	current = previous.getNext();
    	nameL.setText(current.getName());
    	if(current.getNext() == current){
    		JOptionPane.showMessageDialog(null, current.getName() + " is your suitor.");
    		System.exit(0);
    	}
    }
    
    /**
     * Simply chooses what method to run based on the button pushed.
     */
    public static class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			if(source == keepB){
				nextNode();
			}
			
			if(source == removeB){
				removeNode();
			}
			
		}
    }
	
    /**
     * Start your engines!
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
