package peerGradingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class normaliseMarksTest {

//	@SuppressWarnings("deprecation")
	@Test
	public void testNormalisedCalculation() {
//		fail("Not yet implemented");

		student stu1=new student("Mitali",3,2,1);
		student stu2=new student("Sumedh", 4,3,1);
		student stu3=new student("Kaushik", 5,0,1);
		student stu4=new student("manasi",1,5,2);
		studentList studentList = new studentList();
		studentList.add(stu1);
		studentList.add(stu2);
		studentList.add(stu3);
		studentList.add(stu4);
		
		
		//sltest.initStudentList(3, false);
		ArrayList<student> marks= normaliseMarks.calculateNormalisedMarks(studentList.getStudentsList());
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
		//Sum should be equal to 1
		assertEquals(1, (int)(marks.get(0).getNormalisedMarks()+marks.get(1).getNormalisedMarks()+marks.get(2).getNormalisedMarks()+marks.get(3).getNormalisedMarks()));
		
	}

}
