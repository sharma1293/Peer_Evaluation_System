package peerGradingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


public class peerGradingWindow extends JPanel {
	//    private boolean DEBUG = false;


	public peerGradingWindow(studentList currentList) {
		super(new GridLayout(2,0));

		//Here change the student list value
		MyTableModel currentModel = new MyTableModel(currentList);
		JTable table = new JTable(currentModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Fiddle with the Sport column's cell editors/renderers.
		setUpMarksColumn(table, table.getColumnModel().getColumn(1));
		setUpMarksColumn(table, table.getColumnModel().getColumn(2));
		setUpMarksColumn(table, table.getColumnModel().getColumn(3));
		//Add the scroll pane to this panel.
//		add(scrollPane);
		JButton submitButton = new JButton("Submit");
		submitButton.setSize(new Dimension(10, 10));
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				currentList.calculateNormalisedMarks();
				currentModel.fireTableDataChanged();
				
			}
		});
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		add(submitButton, BorderLayout.SOUTH);
	}

	public void setUpMarksColumn(JTable table,
			TableColumn marksColumn) {
		//Set up the editor for the sport cells.
		Integer marksOptions[] = {0,1,2,3,4,5};

		JComboBox<Integer> comboBoxMarks = new JComboBox<Integer>(marksOptions);
		marksColumn.setCellEditor(new DefaultCellEditor(comboBoxMarks));

		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		marksColumn.setCellRenderer(renderer);
	}



	public class MyTableModel extends AbstractTableModel {
		private String[] columnNames = {"Name",
		"Professionalism","Meeting Participation","Work Evaluation","Normalised Marks"};

		private List<student> data;// = new ArrayList();

		public MyTableModel(studentList currentList){
			data = currentList.getStudentsList();
		}
		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			int size; 
			if (data == null) { 
				size = 0; 
			} 
			else { 
				size = data.size(); 
			} 
			return size;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			Object temp = null; 
			if (col == 0) { 
				temp = data.get(row).getFullName(); 
			} 
			else if (col == 1) { 
				temp = data.get(row).getProfessionalismMarks(); 
			}
			else if (col == 2) { 
				temp = data.get(row).getParticipationMarks(); 
			}
			else if (col == 3) { 
				temp = data.get(row).getWorkEvaluationMarks(); 
			}
			else if (col == 4) { 
				temp = data.get(row).getNormalisedMarks(); 
			}
			return temp; 
		} 

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col  == 1||col  == 2||col  == 3) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			System.out.println("Setting value at " + row + "," + col
					+ " to " + value
					+ " (an instance of "
					+ value.getClass() + ")");
			if (col == 0) { 
				data.get(row).setFullName((String)value); 
			} 
			else if (col == 1) { 
				data.get(row).setProfessionalismMarks((int)value); 
			}
			else if (col == 1) { 
				data.get(row).setProfessionalismMarks((int)value); 
			}
			else if (col == 2) { 
				data.get(row).setParticipationMarks((int)value); 
			}
			else if (col == 3) { 
				data.get(row).setWorkEvaluationMarks((int)value); 
			}
			else if (col == 4) { 
				data.get(row).setNormalisedMarks((int)value); 
			}
			
			
			fireTableCellUpdated(row, col);

		}
	}


	



	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		
		
		JFrame frame = new JFrame("Peer Evaluation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userInputSelectionWindow currentUserSelectionWindow = new userInputSelectionWindow();
		boolean previousValues = currentUserSelectionWindow.getBoolPreviousScores();
		int numTeamates = currentUserSelectionWindow.getNumTeammatesSelected();
		studentList currentList = new studentList();
		//Initialize the data
//		initializeGrades()
		currentList.initStudentList(numTeamates, previousValues);
		
		
		//Create and set up the content pane.
		
		peerGradingWindow newContentPane = new peerGradingWindow(currentList);
		
		//Write code to pass the parameters to pane
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

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

