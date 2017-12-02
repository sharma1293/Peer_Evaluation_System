package peerGradingSystem;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import peerGradingSystem.userInputSelectionWindow;



public class peerGradingWindow extends JPanel {
	//    private boolean DEBUG = false;


	public peerGradingWindow() {
		super(new GridLayout(1,0));

		//Here change the student list value
		JTable table = new JTable(new MyTableModel(new studentList()));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Fiddle with the Sport column's cell editors/renderers.
		setUpMarksColumn(table, table.getColumnModel().getColumn(1));

		//Add the scroll pane to this panel.
		add(scrollPane);
	}


	public class student{
		private String fullName;
		private Integer marks;

		public student(String fullName, Integer marks){
			this.fullName = fullName;
			this.marks = marks;
		}
		public Integer getMarks() {
			return marks;
		}
		public String getFullName() {
			return fullName;
		}

	}

	public class studentList{
		private ArrayList<student> students;

		public studentList() {
			students = new ArrayList<student>();
		}
		public void add(student currentStudent) {
			students.add(currentStudent);
		}
		public ArrayList<student> getStudentsList() {
			return students;
		}

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
		"Marks"};

		private List<student> data;// = new ArrayList();

		public MyTableModel(studentList currentList){
			this.data = currentList.getStudentsList();
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
			//            return data[row][col];
			Object temp = null; 
			if (col == 0) { 
				temp = data.get(row).getFullName(); 
			} 
			else if (col == 1) { 
				temp = data.get(row).getMarks(); 
			} 
			//            else if (col == 2) { 
			//               temp = new Double(data.get(row).getPrice()); 
			//            } 
			return temp; 
		} 
		//        }

		//        /*
		//         * JTable uses this method to determine the default renderer/
		//         * editor for each cell.  If we didn't implement this method,
		//         * then the last column would contain text ("true"/"false"),
		//         * rather than a check box.
		//         */
		//        public Class getColumnClass(int c) {
		//            return getValueAt(0, c).getClass();
		//        }

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col  == 0) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			//            if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col
					+ " to " + value
					+ " (an instance of "
					+ value.getClass() + ")");
			//            }

			//            data[row][col] = value;
			fireTableCellUpdated(row, col);

			//            if (DEBUG) {
			//                System.out.println("New value of data:");
			//                printDebugData();
			//            }
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i=0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j=0; j < numCols; j++) {
					//                    System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}


	



	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		
		
		JFrame frame = new JFrame("TableRenderDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userInputSelectionWindow currentUserSelectionWindow = new userInputSelectionWindow();
		currentUserSelectionWindow.getBoolPreviousScores();
		currentUserSelectionWindow.getNumTeammatesSelected();

		//Create and set up the content pane.
		
		peerGradingWindow newContentPane = new peerGradingWindow();
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

