package peerGradingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The class contains the normalized calculation method
 * @author Group 1
 *
 */
public class normaliseMarks {

	/**The function will calculate the normalised scores of the students by summing up first their marks in all categories and dividing it by total marks awarded to students.
	 * @param ArrayList<student> currentStudents
	 * @return ArrayList<student> currentStudents
	 */
	public static ArrayList<student> calculateNormalisedMarks(ArrayList<student> currentStudents){
		int totalMarks = 0;
		List<Integer> currentMarks = new ArrayList<Integer>(); 
		for(int i= 0; i<currentStudents.size(); i++){
			currentMarks.add(currentStudents.get(i).getProfessionalismMarks()+currentStudents.get(i).getParticipationMarks()+currentStudents.get(i).getWorkEvaluationMarks());
			totalMarks = totalMarks+(int)currentMarks.get(i);
		}
		for(int i= 0; i<currentStudents.size(); i++){ 
			if(totalMarks == 0){
				currentStudents.get(i).setNormalisedMarks(0);
			}
			else{
				currentStudents.get(i).setNormalisedMarks(((float)currentMarks.get(i))/totalMarks);		
			}
			System.out.println("The value has been changed to:"+ currentStudents.get(i).getNormalisedMarks());
		}
		return currentStudents;
		}

}
