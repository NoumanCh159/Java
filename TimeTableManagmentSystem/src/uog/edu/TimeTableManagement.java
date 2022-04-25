package uog.edu;

import java.util.List;

import uog.edu.student.Student;
import uog.edu.student.studentData;

public class TimeTableManagement {

	public static void main(String[] args) {
		
//		courseData coursedata = new courseData();
		
		System.out.println("Find One");
		
		Student student = studentData.FindOne(2);
		System.out.println(student.toString());
		System.out.println("------------------------------------------\n------------------------------------------\n");
		
		
		System.out.println("Find All");
		
		List<Student> students = studentData.FindAll();
		for (int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).toString());
		}
		System.out.println("------------------------------------------\n------------------------------------------\n");
		
		
		System.out.println("Search");
		
		students = studentData.Search("19011519-120");
		for (int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).toString());
		}
		System.out.println("------------------------------------------\n------------------------------------------\n");
		
		
		System.out.println("Save");
		
		student.setTITLE("Student");
		student.setFORE_NAME("Muhammad");
		student.setSUR_NAME("Nouman");
		student.setAGE(20);
		student.setGENDER("Male");
		student.setADDRESS("Islamabad Pakistan");
		student.setROLL_NO("19011519-159");
		student.setSTUDY_PROGRAM("BS Computer Science");
		student.setSTUDY_YEAR("2019-2023");
		student = studentData.Save(student);
		System.out.println(student.toString());
		System.out.println("------------------------------------------\n------------------------------------------\n");
		
		
		System.out.println("Find All after Save");
		
		students = studentData.FindAll();
		for (int i=0; i<students.size(); i++) 
			System.out.println(students.get(i).toString());
		System.out.println("------------------------------------------\n------------------------------------------\n");
		
	}
}
