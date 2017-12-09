package peerGradingSystem;

import java.util.ArrayList;
import java.util.List;

public class normaliseMarks {

	/**The function will calculate the normalised scores of the students by summing up first their marks in all categories and dividing it by total marks awarded to students.
	 * @param
	 */
	public static ArrayList<student> calculateNormalisedMarks(ArrayList<student> currentStudents){
		//ArrayList<student> currentArrayList = currentList.getStudentsList();
		int totalMarks = 0;
//		currentStudents
		List<Integer> currentMarks = new ArrayList<Integer>(); 
		for(int i= 0; i<currentStudents.size(); i++){
			currentMarks.add(currentStudents.get(i).getProfessionalismMarks()+currentStudents.get(i).getParticipationMarks()+currentStudents.get(i).getWorkEvaluationMarks());
			totalMarks = totalMarks+(int)currentMarks.get(i);
		}
		for(int i= 0; i<currentStudents.size(); i++){
			currentStudents.get(i).setNormalisedMarks(((float)currentMarks.get(i))/totalMarks);
			System.out.println("The value has been changed to:"+ currentStudents.get(i).getNormalisedMarks());
		}
		return currentStudents;
		}

}
