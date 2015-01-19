/**
 * @author Grayson Lorenz
 * Bookstore program for CS2
 * Reads a txt file, populates a table
 * handles adding from one table to another
 * then calculates prices and displays it and where
 * the order should be sent.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Bookstore extends JFrame{
	//Fields
	private JPanel invP, cartP, donateP, addressP;
	private JScrollPane invSP, addressSP, cartSP;
	private JButton addB, removeB, finishB;
	private JSpinner addS, removeS;
	private JTextArea addressTA;
	private JTable invT, cartT;
	private JSlider donationSl;
	private JMenuBar menuBar;
	private JMenu fileM, cartM, helpM;
	private JMenuItem exitI, clearI, howI, aboutI;
	private JLabel amountL, amountL2;
	private DefaultTableModel cartTableModel;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer rightRenderer;
	
	
	private ButtonHandler bHandle;
	private MenuHandler mHandle;

	//window size
	private static final int WIDTH=800,HEIGHT=400;
	
	/**
	 * Constructor that instantiates all fields,
	 * sets up the objects, and displays the program
	 */
	public Bookstore(){
		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		//instantiation
		bHandle = new ButtonHandler();
		mHandle = new MenuHandler();
		
		invP = new JPanel();
		cartP = new JPanel();
		donateP = new JPanel();
		addressP = new JPanel();
		
		addB = new JButton("Add to cart");
		addB.addActionListener(bHandle);
		removeB = new JButton("Remove from cart");
		removeB.addActionListener(bHandle);
		finishB = new JButton("Check Out");
		finishB.addActionListener(bHandle);
		
		addS = new JSpinner();
		removeS = new JSpinner();
		
		addressTA = new JTextArea("Enter your address here.",10,10);
		
		invT = new JTable();
		cartT = new JTable();

		donationSl = new JSlider(JSlider.HORIZONTAL,0,100,10);
		
		menuBar = new JMenuBar();
		
		fileM = new JMenu("File");
		cartM = new JMenu("Cart");
		helpM = new JMenu("Help");
		
		exitI = new JMenuItem("Exit");
		exitI.addActionListener(mHandle);
		clearI = new JMenuItem("Clear Cart");
		clearI.addActionListener(mHandle);
		howI = new JMenuItem("How do I do the do?");
		howI.addActionListener(mHandle);
		aboutI = new JMenuItem("About");
		aboutI.addActionListener(mHandle);
		
		amountL = new JLabel("Amount:");
		amountL2 = new JLabel("Amount:");
		
		/*Oh boy...
		 * Shows box prompting user.
		 * loads file.
		 * creates table model.
		 * buffer reads file, then sets it in the table via table model.
		 */
		File file = null;
		JFileChooser chooser = new JFileChooser();
		BufferedReader reader;
		String line;

		JOptionPane.showMessageDialog(null, "Choose your inventory file.");
		
		int returnVal = chooser.showOpenDialog(getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		   file = chooser.getSelectedFile();
		}		

		String columns[] =  {"Title", "Price"};
		
		// specify number of columns
		tableModel = new DefaultTableModel(0,2); 
		tableModel.setColumnIdentifiers(columns);
		
		invT.setModel(tableModel);
		
		try{       
      reader = new BufferedReader(new FileReader(file));
      while((line = reader.readLine()) != null) 
      {
         tableModel.addRow(line.split(", "));
      }
      reader.close();
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
		
		String cartColumns[] =  {"Amt", "Title", "Price"};
		
		// specify number of columns
		cartTableModel = new DefaultTableModel(0,3); 
		cartTableModel.setColumnIdentifiers(cartColumns);
		
		cartT.setModel(cartTableModel);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		//Set up objects
		//Panels
		invP.setLayout(new BorderLayout());
		invP.setBorder(BorderFactory.createTitledBorder("Inventory"));
		cartP.setLayout(new BorderLayout());
		cartP.setBorder(BorderFactory.createTitledBorder("Cart"));
		donateP.setLayout(new BorderLayout());
		donateP.setBorder(BorderFactory.createTitledBorder("Donation in $"));
		addressP.setLayout(new BorderLayout());
		addressP.setBorder(BorderFactory.createTitledBorder("Address"));
		
		//Spinners
		addS.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		removeS.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));

		//Slider
		donationSl.setMajorTickSpacing(25);
		donationSl.setMinorTickSpacing(1);
		donationSl.setPaintTicks(true);
		donationSl.setPaintLabels(true);
		donationSl.setSnapToTicks(true);
		
		//Tables
		invT.getColumnModel().getColumn(0).setResizable(true);
		invT.getColumnModel().getColumn(0).setPreferredWidth(110);
		invT.getColumnModel().getColumn(0).setMinWidth(110);
		invT.getColumnModel().getColumn(1).setResizable(true);
		invT.getColumnModel().getColumn(1).setPreferredWidth(60);
		invT.getColumnModel().getColumn(1).setMinWidth(60);
		invT.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		
		cartT.getColumnModel().getColumn(0).setResizable(true);
		cartT.getColumnModel().getColumn(0).setPreferredWidth(20);
		cartT.getColumnModel().getColumn(0).setMinWidth(20);
		cartT.getColumnModel().getColumn(1).setResizable(true);
		cartT.getColumnModel().getColumn(1).setPreferredWidth(90);
		cartT.getColumnModel().getColumn(1).setMinWidth(90);
		cartT.getColumnModel().getColumn(2).setResizable(true);
		cartT.getColumnModel().getColumn(2).setPreferredWidth(60);
		cartT.getColumnModel().getColumn(2).setMinWidth(60);
		cartT.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		//ScrollPanes done last to make sure tables are set as clients
		invSP = new JScrollPane(invT);
		addressSP = new JScrollPane(addressTA);
		cartSP = new JScrollPane(cartT);
		
		invSP.setPreferredSize(new Dimension(200, 160));
		invSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		invSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		cartSP.setPreferredSize(new Dimension(160, 160));
		cartSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		cartSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//HOPEFULLY we have everything loaded and not broken. So we put all the boxes together.
		
		menuBar.add(fileM);
		menuBar.add(cartM);
		menuBar.add(helpM);
		
		fileM.add(exitI);
		cartM.add(clearI);
		helpM.add(howI);
		helpM.add(aboutI);
		
		invP.add(invSP, BorderLayout.NORTH);
		invP.add(amountL2, BorderLayout.WEST);
		invP.add(addS, BorderLayout.CENTER);
		invP.add(addB, BorderLayout.EAST);
				
		cartP.add(cartSP, BorderLayout.NORTH);
		cartP.add(amountL, BorderLayout.WEST);
		cartP.add(removeS, BorderLayout.CENTER);
		cartP.add(removeB, BorderLayout.EAST);
		
		donateP.add(donationSl, BorderLayout.CENTER);
		donateP.add(finishB, BorderLayout.SOUTH);
		
		addressP.add(addressSP);
		
		//create and display
		setTitle("Call Helper");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
  		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container grid = getContentPane();
		
		//add items here
		grid.add(menuBar, BorderLayout.NORTH);
		grid.add(invP, BorderLayout.WEST);
		grid.add(cartP, BorderLayout.EAST);
		grid.add(addressP, BorderLayout.CENTER);
		grid.add(donateP, BorderLayout.SOUTH);
	}
	
	//add methods and all that funky jazz here
	/**
	 * This class handles all the button logic
	 * it checks which button was pushed then reacts
	 * accordingly.
	 */
	public class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			DecimalFormat df = new DecimalFormat("#.##");
			
			JButton source = (JButton) e.getSource();
			
			if(source == addB){
				String title = "";
				int amount = 0;
				double price = 0.0;
				boolean found = false;
				int index = 0;
				
				title = (String) tableModel.getValueAt(invT.getSelectedRow(), 0);
				amount = (int) addS.getValue();
				price = Double.parseDouble((String) tableModel.getValueAt(invT.getSelectedRow(), 1));
				//Add Button
				for(int i = 0; i < cartTableModel.getRowCount(); i ++){
					if(title.compareTo((String) cartTableModel.getValueAt(i, 1)) == 0){
						found = true;
						index = i;
					}
				}
				
				if(found){
					int oldAmount = (int) cartTableModel.getValueAt(index, 0);
					int newAmount = oldAmount + amount;
					cartTableModel.setValueAt(newAmount, index, 0);
					cartTableModel.setValueAt(df.format(price*newAmount), index, 2);
				}
				else{
					cartTableModel.addRow(new Object[] {amount, title, df.format(price*amount)});
				}
			}
			
			//Remove Button
			if(source == removeB){
				
				int amount = (int) cartTableModel.getValueAt(cartT.getSelectedRow(), 0);
				double price = Double.parseDouble((String) cartTableModel.getValueAt(cartT.getSelectedRow(), 2)) / amount;
				int newAmount = (amount - (int) removeS.getValue());
				
				if(newAmount <= 0){
					cartTableModel.removeRow(cartT.getSelectedRow());
				}
				else{
					cartTableModel.setValueAt(newAmount, cartT.getSelectedRow(), 0);
					cartTableModel.setValueAt(df.format(price*newAmount), cartT.getSelectedRow(), 2);
				}
			}
			
			//Check out button
			if(source == finishB){
				int amount = 0;
				String title = "";
				double price = 0.0;
				double pricePer = 0.0;
				double total = 0.0;
				String output = "";
				
				for(int i = 0; i < cartTableModel.getRowCount(); i++ ){
					amount = (int) cartTableModel.getValueAt(i, 0);
					title = (String) cartTableModel.getValueAt(i, 1);
					price = Double.parseDouble((String)cartTableModel.getValueAt(i, 2));
					pricePer = price/amount;
					total += price;
					output += "\n" + title + " $" + df.format(price) + " (" + amount + " x $" + df.format(pricePer) + ")";
				}
				
				output += "\nSub Total $" + df.format(total);
				output += "\n6% Tax $" + df.format(total*.06);
				output += "\nDonation $" + donationSl.getValue();
				total += total*.06;
			  total += (double) donationSl.getValue();
				output += "\n=====================================\nTotal Cost: $" + df.format(total);
				
				output += "\n\nWill be shipped to:\n"+addressTA.getText();

				JOptionPane.showMessageDialog(null, output);
			}
		}
	}
	
	/**
	 * This class handles all the menu logic
	 * it checks which item was pushed then reacts
	 * accordingly.
	 */
	public class MenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem) e.getSource();
			if(source == exitI){
				System.exit(0);
			}
			if(source == aboutI){
				JOptionPane.showMessageDialog(null, "Created by Grayson Lorenz.\nMay he finally find peace.");
			}
			if(source == howI){
				JOptionPane.showMessageDialog(null, "Step 1: Choose a book from the inventory on the left.\n"
						+ "Step 2: Enter the number of that book you want to add into the box labeled Amount.\n"
						+ "Step 3: Press Add to cart.\n"
						+ "Step 4: Type your address into the center box.\n"
						+ "Step 5: Confirm your order, you can remove items from the cart by entering an amount and clicking Remove from cart.\n"
						+ "Step 6: Consider donating and click Check Out\n\n"
						+ "You can also click Cart > Clear to completely clear your cart if needed.");
			}
			if(source == clearI){
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your cart?") == 0){
					while(cartTableModel.getRowCount() > 0){
						cartTableModel.removeRow(0);
					}
					JOptionPane.showMessageDialog(null, "Cleared");
				}
			}
		}
	}
	
	/**
	 * simply launches the program.
	 */
	public static void main(String[]args){
		@SuppressWarnings("unused")
		Bookstore run = new Bookstore();
	}

}
