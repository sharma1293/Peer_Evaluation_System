package peerGradingSystem;

import java.util.ArrayList;
import java.util.List;

public class studentList{
	private ArrayList<student> students;
	String studentNames[] = {"A","B","C","D","E","F","G"};

	public studentList() {
		students = new ArrayList<student>();
	}
	public void add(student currentStudent) {
		students.add(currentStudent);
	}
	public ArrayList<student> getStudentsList() {
		return students;
	}
	
	public void initStudentList(int numTeamates, boolean previousValues){
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
	
//The function will calculate the normalised scores of the students by summing up first their marks in all categories and dividing it by total marks awarded to students.
public void calculateNormalisedMarks(){//studentList currentList
	//ArrayList<student> currentArrayList = currentList.getStudentsList();
	int totalMarks = 0;
	List<Integer> currentMarks = new ArrayList<Integer>(); 
	for(int i= 0; i<students.size(); i++){
		
		currentMarks.add(students.get(i).getProfessionalismMarks()+students.get(i).getParticipationMarks()+students.get(i).getWorkEvaluationMarks());
		totalMarks = totalMarks+(int)currentMarks.get(i);
		//totalMarks = totalMarks+students.get(i).getProfessionalismMarks()+students.get(i).getParticipationMarks()+students.get(i).getWorkEvaluationMarks();
		
	}
	for(int i= 0; i<students.size(); i++){
		
		//totalMarks = totalMarks+currentArrayList.get(i).getMarks();
//		students.get(i).setNormalisedMarks((((float)(students.get(i).getProfessionalismMarks()+students.get(i).getParticipationMarks()+students.get(i).getWorkEvaluationMarks()))/totalMarks));
		students.get(i).setNormalisedMarks(((float)currentMarks.get(i))/totalMarks);
		System.out.println("The value has been changed to:"+ students.get(i).getNormalisedMarks());
		
	}
	}
	
	

}
