import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class test extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnCart = new JMenu("Cart");
		menuBar.add(mnCart);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mnCart.add(mntmClear);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		contentPane.add(spinner, BorderLayout.WEST);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {null, null},	new String[] {"Title", "Price"}) 
		{
			boolean[] columnEditables = new boolean[] {false, false};
			public boolean isCellEditable(int row, int column) {return columnEditables[column];}
			}
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(0).setMaxWidth(90);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		contentPane.add(table, BorderLayout.CENTER);
	}

}
