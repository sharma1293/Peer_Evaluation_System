package peerGradingSystem;

import java.util.ArrayList;

public class studentList{
	private ArrayList<student> students;
//	private ArrayList<String> studentNames = new ArrayList<String>
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
			int currentMarks = 0;
			if(previousValues){
				currentMarks = (int) Math.floor(Math.random() * 5);
			}
			student currentStudent = new student(studentNames[i],currentMarks);
			students.add(currentStudent);
		}
	}
	

public void calculateNormalisedMarks(){//studentList currentList
	//ArrayList<student> currentArrayList = currentList.getStudentsList();
	int totalMarks = 0;
	for(int i= 0; i<students.size(); i++){
		
		totalMarks = totalMarks+students.get(i).getMarks();
		
	}
	for(int i= 0; i<students.size(); i++){
		
		//totalMarks = totalMarks+currentArrayList.get(i).getMarks();
		students.get(i).setNormalisedMarks((((float)(students.get(i).getMarks()))/totalMarks));
		System.out.println("The value has been changed to:"+ students.get(i).getNormalisedMarks());
		
	}
	}
	
	

}
