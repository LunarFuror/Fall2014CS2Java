import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Grayson Lorenz and Justin Kilzer
 *
 */
@SuppressWarnings("serial")
public class ElectionTally extends JFrame {
	private Vector<Candidate> candidates1, candidates2, candidates3, candidates4, candidatesTotal;
	private JButton load1B, load2B, load3B, load4B;
	private JTable totalT, region1T, region2T, region3T, region4T;
	private DefaultTableModel model1, model2, model3, model4, modelTotal;
	private ButtonHandler bHandle;
	private JPanel mainP, eastP, southP, westP, region4P, region3P, region2P, region1P;
	private JScrollPane totalSP, region1SP, region2SP, region3SP, region4SP;
	private static final int WIDTH=850,HEIGHT=600;
	
	public ElectionTally(){
		load1B = new JButton("Load Region 1");
		load2B = new JButton("Load Region 2");
		load3B = new JButton("Load Region 3");
		load4B = new JButton("Load Region 4");
		candidates1 = new Vector<Candidate>();
		candidates2 = new Vector<Candidate>();
		candidates3 = new Vector<Candidate>();
		candidates4 = new Vector<Candidate>();
		candidatesTotal = new Vector<Candidate>();
		
		totalT = new JTable();
		region1T = new JTable();
		region2T = new JTable();
		region3T = new JTable();
		region4T = new JTable();
		
		bHandle = new ButtonHandler();
		
		load1B.addActionListener(bHandle);
		load2B.addActionListener(bHandle);
		load3B.addActionListener(bHandle);
		load4B.addActionListener(bHandle);
		
		//initialize all panels and scrollpanes last just in case
		mainP = new JPanel();
		eastP = new JPanel();
		westP = new JPanel();
		southP = new JPanel();
		region4P = new JPanel();
		region3P = new JPanel();
		region2P = new JPanel();
		region1P = new JPanel();
		
		region1SP = new JScrollPane(region1T);
		region1SP.setPreferredSize(new Dimension(400, 160));
		region2SP = new JScrollPane(region2T);
		region2SP.setPreferredSize(new Dimension(400, 160));
		region3SP = new JScrollPane(region3T);
		region3SP.setPreferredSize(new Dimension(400, 160));
		region4SP = new JScrollPane(region4T);
		region4SP.setPreferredSize(new Dimension(400, 160));
		totalSP = new JScrollPane(totalT);
		totalSP.setPreferredSize(new Dimension(800, 160));
		
		mainP.setLayout(new BorderLayout());
		eastP.setLayout(new BorderLayout());
		westP.setLayout(new BorderLayout());
		southP.setLayout(new BorderLayout());
		southP.setBorder(BorderFactory.createTitledBorder("Totals"));
		region4P.setLayout(new BorderLayout());
		region4P.setBorder(BorderFactory.createTitledBorder("Region 4"));
		region3P.setLayout(new BorderLayout());
		region3P.setBorder(BorderFactory.createTitledBorder("Region 3"));
		region2P.setLayout(new BorderLayout());
		region2P.setBorder(BorderFactory.createTitledBorder("Region 2"));
		region1P.setLayout(new BorderLayout());
		region1P.setBorder(BorderFactory.createTitledBorder("Region 1"));
		
		String columns[] =  {"Last Name", "First Name", "Votes"};
		
		model1 = new DefaultTableModel(0,3); 
		model1.setColumnIdentifiers(columns);
		region1T.setModel(model1);
		
		model2 = new DefaultTableModel(0,3); 
		model2.setColumnIdentifiers(columns);
		region2T.setModel(model2);
		
		model3 = new DefaultTableModel(0,3); 
		model3.setColumnIdentifiers(columns);
		region3T.setModel(model3);
		
		model4 = new DefaultTableModel(0,3); 
		model4.setColumnIdentifiers(columns);
		region4T.setModel(model4);
		
		modelTotal = new DefaultTableModel(0,3); 
		modelTotal.setColumnIdentifiers(columns);
		totalT.setModel(modelTotal);
		/*
		 * add panels to stuff here
		 */
		region1P.add(region1SP, BorderLayout.NORTH);
		region1P.add(load1B, BorderLayout.SOUTH);
		region2P.add(region2SP, BorderLayout.NORTH);
		region2P.add(load2B, BorderLayout.SOUTH);
		region3P.add(region3SP, BorderLayout.NORTH);
		region3P.add(load3B, BorderLayout.SOUTH);
		region4P.add(region4SP, BorderLayout.NORTH);
		region4P.add(load4B, BorderLayout.SOUTH);
		mainP.add(southP, BorderLayout.SOUTH);
		mainP.add(westP, BorderLayout.WEST);
		mainP.add(eastP, BorderLayout.EAST);
		
		westP.add(region1P, BorderLayout.NORTH);
		westP.add(region3P, BorderLayout.SOUTH);
		eastP.add(region2P, BorderLayout.NORTH);
		eastP.add(region4P, BorderLayout.SOUTH);
		southP.add(totalSP);
		
		
		//set up and display
		setTitle("Call Helper");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
  		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container grid = getContentPane();
		
		//add items here
		grid.add(mainP, BorderLayout.NORTH);
	}
	
	
	public class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			//Loads region 1
			if(source == load1B){
				File file = null;
				JFileChooser chooser = new JFileChooser();
				BufferedReader reader;
				String line;
				//prompt to choose file
				JOptionPane.showMessageDialog(null, "Choose your election file.");
				
				//clears Vector
				candidates1.clear();
				
				//if a file is chosen then load the file
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   file = chooser.getSelectedFile();
				}		
				//Read the file and load the Vector with the candidates
				try{       
		      reader = new BufferedReader(new FileReader(file));
		      while((line = reader.readLine()) != null) 
		      {
		         String[] temp = line.split(", ");
		         candidates1.add(new Candidate(temp[0], temp[1], Integer.parseInt(temp[2])));
		      }
		      reader.close();
				}
				catch(IOException ex){
					JOptionPane.showMessageDialog(null, "Error");
					ex.printStackTrace();
				}
				
				//sort the vector
				candidates1 = sortVector(candidates1);
				
				//clear table
				while(model1.getRowCount() > 0){
					model1.removeRow(0);
				}
				
				//using the vector of objects, populate the tables
				for(Candidate temp: candidates1){
					model1.addRow(temp.getObjectArray());
				}
				
				//either set empty array to this, or add this to the populated array
				if(candidatesTotal.size() < candidates1.size()){
					candidatesTotal = candidates1;
					for(Candidate temp: candidatesTotal){
						totalT.setModel(modelTotal);
						modelTotal.addRow(temp.getObjectArray());
					}
				}
				else if(candidatesTotal.size() == candidates1.size()){
					calculateTotalArray(candidates1);
				}
			}
			
			//Loads region 2
			if(source == load2B){
				File file = null;
				JFileChooser chooser = new JFileChooser();
				BufferedReader reader;
				String line;
				//prompt to choose file
				JOptionPane.showMessageDialog(null, "Choose your election file.");
				
				//clears Vector
				candidates2.clear();
				
				//if a file is chosen then load the file
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   file = chooser.getSelectedFile();
				}		
				//Read the file and load the Vector with the candidates
				try{       
		      reader = new BufferedReader(new FileReader(file));
		      while((line = reader.readLine()) != null) 
		      {
		         String[] temp = line.split(", ");
		         candidates2.add(new Candidate(temp[0], temp[1], Integer.parseInt(temp[2])));
		      }
		      reader.close();
				}
				catch(IOException ex){
					JOptionPane.showMessageDialog(null, "Error");
					ex.printStackTrace();
				}
				
				//sort the vector
				candidates2 = sortVector(candidates2);
				
				//clear table
				while(model2.getRowCount() > 0){
					model2.removeRow(0);
				}
				
				//using the vector of objects, populate the tables
				for(Candidate temp: candidates2){
					model2.addRow(temp.getObjectArray());
				}
				
				//either set empty array to this, or add this to the populated array
				if(candidatesTotal.size() < candidates2.size()){
					candidatesTotal = candidates2;
					for(Candidate temp: candidatesTotal){
						modelTotal.addRow(temp.getObjectArray());
					}
				}
				else if(candidatesTotal.size() == candidates2.size()){
					calculateTotalArray(candidates2);
				}
			}
			
			//loads region 3
			if(source == load3B){
				File file = null;
				JFileChooser chooser = new JFileChooser();
				BufferedReader reader;
				String line;
				//prompt to choose file
				JOptionPane.showMessageDialog(null, "Choose your election file.");
				
				//clears Vector
				candidates3.clear();
				
				//if a file is chosen then load the file
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   file = chooser.getSelectedFile();
				}		
				//Read the file and load the Vector with the candidates
				try{       
		      reader = new BufferedReader(new FileReader(file));
		      while((line = reader.readLine()) != null) 
		      {
		         String[] temp = line.split(", ");
		         candidates3.add(new Candidate(temp[0], temp[1], Integer.parseInt(temp[2])));
		      }
		      reader.close();
				}
				catch(IOException ex){
					JOptionPane.showMessageDialog(null, "Error");
					ex.printStackTrace();
				}
				
				//sort the vector
				candidates3 = sortVector(candidates3);
				
				//clear table
				while(model3.getRowCount() > 0){
					model3.removeRow(0);
				}
				
				//using the vector of objects, populate the tables
				for(Candidate temp: candidates3){
					model3.addRow(temp.getObjectArray());
				}
				
				//either set empty array to this, or add this to the populated array
				if(candidatesTotal.size() < candidates3.size()){
					candidatesTotal = candidates3;
					for(Candidate temp: candidatesTotal){
						modelTotal.addRow(temp.getObjectArray());
					}
				}
				else if(candidatesTotal.size() == candidates3.size()){
					calculateTotalArray(candidates3);
				}
			}
			
			//loads region 4
			if(source == load4B){
				File file = null;
				JFileChooser chooser = new JFileChooser();
				BufferedReader reader;
				String line;
				//prompt to choose file
				JOptionPane.showMessageDialog(null, "Choose your election file.");
				
				//clears Vector
				candidates4.clear();
				
				//if a file is chosen then load the file
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   file = chooser.getSelectedFile();
				}		
				//Read the file and load the Vector with the candidates
				try{       
		      reader = new BufferedReader(new FileReader(file));
		      while((line = reader.readLine()) != null) 
		      {
		         String[] temp = line.split(", ");
		         candidates4.add(new Candidate(temp[0], temp[1], Integer.parseInt(temp[2])));
		      }
		      reader.close();
				}
				catch(IOException ex){
					JOptionPane.showMessageDialog(null, "Error");
					ex.printStackTrace();
				}
				
				//sort the vector
				candidates4 = sortVector(candidates4);
				
				//clear table
				while(model4.getRowCount() > 0){
					model4.removeRow(0);
				}
				
				//using the vector of objects, populate the tables
				for(Candidate temp: candidates4){
					model4.addRow(temp.getObjectArray());
				}
				
				//either set empty array to this, or add this to the populated array
				if(candidatesTotal.size() < candidates4.size()){
					candidatesTotal = candidates4;
					for(Candidate temp: candidatesTotal){
						modelTotal.addRow(temp.getObjectArray());
					}
				}
				else if(candidatesTotal.size() == candidates4.size()){
					calculateTotalArray(candidates4);
				}
			}
			
		}
	}
	
	/**
	 * Sorts candidate arrays
	 * @param c the candidate vector to be sorted
	 * @return returns the array sorted
	 */
	public Vector<Candidate> sortVector(Vector<Candidate> c){
		boolean sorted = false;
		int i = 0;
		Candidate temp = new Candidate();
		
		//Compares last names, of objects. If the first one is larger: Store in temp, remove it, add temp to the end, repeat till sorted.
		while(i < c.size() - 1){
			//if the first word is more than the second word, pull the first word and put it at the end, then test again
			if(c.get(i).getLastName().compareToIgnoreCase(c.get(i+1).getLastName()) > 0){
				temp = c.get(i);
				c.remove(i);
				c.add(temp);
				i = 0;
			}
			else{
				//if the two are finally sorted, iterate 1
				i++;
			}
		}
		return c;
	}
	
	/**
	 * Adds the sent in vector's votes, to the total votes. Then it clears the total table, and repopulates it.
	 * @param c the vector to be added to the total.
	 */
	public void calculateTotalArray(Vector<Candidate> c){
		for(int i = 0; i < c.size(); i ++){
			candidatesTotal.get(i).add(c.get(i));
		}
		while(modelTotal.getRowCount() > 0){
			modelTotal.removeRow(0);
		}
		for(Candidate temp: candidatesTotal){
			modelTotal.addRow(temp.getObjectArray());
		}
	}
	
	public static void main(String [] args){
		@SuppressWarnings("unused")
		ElectionTally ele = new ElectionTally();
	}
}
