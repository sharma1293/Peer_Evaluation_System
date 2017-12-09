package peerGradingSystem;

import java.util.ArrayList;
import java.util.List;

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
	public void setStudentsList(ArrayList<student> students) {
		this.students = students;
	}
	
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
