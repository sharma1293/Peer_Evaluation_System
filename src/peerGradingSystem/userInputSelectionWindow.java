package peerGradingSystem;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * This is the class to implement the dialog box for user selection
 * @author Group 1
 *
 */
public class userInputSelectionWindow {

		private int numTeammatesSelected;
		private boolean boolPreviousScores;

		public int getNumTeammatesSelected() {
			return numTeammatesSelected;
		}
		
		public boolean getBoolPreviousScores(){
			return boolPreviousScores;
		}

/**
 * This is the constructor method to invoke the dialog box
 */
	public userInputSelectionWindow(){
		Integer teamMateOptions[] = {2,3,4,5,6,7};
		String yesNoOptions[] = {"Yes","No"};
		JComboBox<Integer> comboBoxNumberOfTeamMates = new JComboBox<Integer>(teamMateOptions);
		JComboBox<String> comboBoxPreviousScores = new JComboBox<String>(yesNoOptions);

		Object[] inputFields = {
				"Number Team Members:", comboBoxNumberOfTeamMates,
				"Score Previously entered", comboBoxPreviousScores
		};

		int option = JOptionPane.showConfirmDialog(null, inputFields, "Info", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			System.out.println("The number Of teammates selected: "+teamMateOptions[comboBoxNumberOfTeamMates.getSelectedIndex()]
					+ "The Score option is: "+yesNoOptions[comboBoxPreviousScores.getSelectedIndex()]);
			this.boolPreviousScores = ((yesNoOptions[comboBoxPreviousScores.getSelectedIndex()].equalsIgnoreCase("Yes"))? true:false);
			this.numTeammatesSelected = (int)teamMateOptions[comboBoxNumberOfTeamMates.getSelectedIndex()];

	
		} else {
			System.out.println("User input selection canceled");
			//Here system should either exit.
					    System.exit(0);
		}
	}

}
