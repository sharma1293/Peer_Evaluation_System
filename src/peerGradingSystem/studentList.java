package peerGradingSystem;

import java.util.ArrayList;
import java.util.List;
/**
 * The class will make array list of type student.
 * @author Group 1
 *
 */
public class studentList{
	private ArrayList<student> students;

	/**
	 * This is a constructor to the studentList class
	 * @param
	 */
	public studentList() {
		students = new ArrayList<student>();
	}
	/**
	 * This method adds a new object to the list
	 * @param currentStudent
	 */
	public void add(student currentStudent) {
		students.add(currentStudent);
	}
	/**
	 * This method is a getter method to return the "students" array list
	 * @return students
	 */
	public ArrayList<student> getStudentsList() {
		return students;
	}
	/**
	 * This method is a setter method to set the "students" array list
	 * @param students An array list containing details about all the students
	 */
	public void setStudentsList(ArrayList<student> students) {
		this.students = students;
	}
	/**
	 * This method is used to initialize the student array list
	 * @param numTeamates The number of team mates entered by the user
	 * @param previousValues Whether or not the students had marks entered previously or not
	 * @param studentNames These are the names of the students
	 */
	public void initStudentList(int numTeamates, boolean previousValues, String studentNames[]){
		for(int i= 0; i<numTeamates; i++)
		{
			int currentProfessionalismMarks = 0, currentParticipationMarks = 0,currentWorkEvaluationMarks = 0 ;
			if(previousValues){
				currentProfessionalismMarks = (int) Math.floor(Math.random() * 5);
				currentParticipationMarks =  (int) Math.floor(Math.random() * 5);
				currentWorkEvaluationMarks =  (int) Math.floor(Math.random() * 5);
			}
			student currentStudent = new student(studentNames[i],currentProfessionalismMarks,currentParticipationMarks,currentWorkEvaluationMarks);
			students.add(currentStudent);
		}
	}
}
