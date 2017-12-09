package peerGradingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
/**
 * The class will test the functionality of the normalisation method
 * @author Group 1
 *
 */
public class normaliseMarksTest {
	@Test
	public void testNormalisedCalculation() {
		
		studentList currentStudentList = null;
		ArrayList<student> marks = null;
		currentStudentList = initStudentObject();
		marks = normaliseMarks.calculateNormalisedMarks(currentStudentList.getStudentsList());
		assertNotNull("Object shouldbe not null", marks);
		//Checking the size of the list, should be equal to number of students
		assertEquals(4, marks.size());
		//Checking the normalised marks for the first student
		assertEquals("Normalisation correct for first person ",(float) 0.21, (float)marks.get(0).getNormalisedMarks(),(float) 0.05);
		//Checking the normalised marks for the second student
		assertEquals("Normalisation correct for second person ",(float) 0.29, (float)marks.get(1).getNormalisedMarks(),(float) 0.05);
		//Checking the normalised marks for the third student
		assertEquals("Normalisation correct for third person ",(float) 0.21, (float)marks.get(2).getNormalisedMarks(),(float) 0.05);
		//Checking the normalised marks for the fourth student
		assertEquals("Normalisation correct for fourth person ",(float) 0.29, (float)marks.get(3).getNormalisedMarks(),(float) 0.05);
		
	}
	@Test
	public void testSumOfNormalisedScore(){
		studentList currentStudentList = null;
		ArrayList<student> marks = null;
		currentStudentList = initStudentObject();
		marks = normaliseMarks.calculateNormalisedMarks(currentStudentList.getStudentsList());
		//The marks object should not be null 
		assertNotNull("Object shouldbe not null", marks);
		//Sum should be equal to 1
		System.out.println(marks.get(0).getNormalisedMarks());
		assertEquals(1, (int)(marks.get(0).getNormalisedMarks()+marks.get(1).getNormalisedMarks()+marks.get(2).getNormalisedMarks()+marks.get(3).getNormalisedMarks()));
		
	}
	
	/**
	 * Initialize a object of type of studentList with 4 students 
	 * @return studentList
	 */
	public studentList initStudentObject(){
		studentList currentStudentList = new studentList();
		student stu1=new student("Mitali",3,2,1);
		student stu2=new student("Sumedh", 4,3,1);
		student stu3=new student("Kaushik", 5,0,1);
		student stu4=new student("manasi",1,5,2);
		currentStudentList.add(stu1);
		currentStudentList.add(stu2);
		currentStudentList.add(stu3);
		currentStudentList.add(stu4);
		return currentStudentList;
	}
	

}
