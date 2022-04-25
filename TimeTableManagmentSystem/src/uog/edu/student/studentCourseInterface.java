package uog.edu.student;

import java.util.List;
import java.util.Scanner;

import uog.edu.course.courseData;
import uog.edu.timetable.semesterData;

public class studentCourseInterface {
	
	public static void StudentCourseMenu () {
		
		StudentCourse studentcourse = new StudentCourse();
		
		List<StudentCourse> studentcourses = studentCourseData.FindAll();
		Scanner choInput = new Scanner(System.in);
		
		int userinput = -1;
		
		while (userinput != 7) {
			
			System.out.println("\n1.Find Specific Record By Giving Student-Course_ID\n2.Find All records of Student Courses\n3.Find records of Student Courses by giving incomplete but consective few words of Course_ID\n4.Save New Records\n5.ShowAll Records\n6.Return To MainMenu :-");
			
			userinput = choInput.nextInt();
			
			switch (userinput) {
			
			case 1:
				
				Scanner CIDinput = new Scanner(System.in);
				System.out.println("Enter Student Course ID to find:-");
				
				int input = CIDinput.nextInt();
				System.out.println("\n___Found one matching record in rows of student courses___\n");
				studentcourse = studentCourseData.FindOne(input);
				System.out.println(studentcourse.toString());
				
				break;
				
				
			case 2:
				
				System.out.println("\n___Found all rows of student courses___\n");

				studentcourses = studentCourseData.FindAll();
				for(int j=0; j<studentcourses.size(); j++) 
				System.out.println(studentcourses.get(j).toString());

				   break;
				   
				   
			case 3:
				
				Scanner SRinput = new Scanner(System.in);
				System.out.println("Enter Course ID to find:-");
				
				String input2 = SRinput.nextLine();
				System.out.println("\n___Found these matching records containg Roll No. anywhere in rows of student courses___\n");
				studentcourses = studentCourseData.Search(input2);
				for(int i=0; i<studentcourses.size(); i++)
				System.out.println(studentcourses.get(i).toString());
				
				break;
				
				
			case 4:
				
				Scanner SaveName1 = new Scanner(System.in);
				System.out.println("Enter Student Course ID:-");
				
				Scanner SaveName2 = new Scanner(System.in);
				System.out.println("Enter Section:-");
				
				int Name1 = SaveName1.nextInt();
				String Name2 = SaveName2.nextLine();
				
				System.out.println("\n________Save of student course record__________\n");
				
				studentcourse.setSTUDENTCOURSE_ID(Name1);
				studentcourse.setCOURSE_ID(courseData.FindOne(1));
				studentcourse.setSTUDENT_ID(studentData.FindOne(1));
				studentcourse.setSEMESTER_ID(semesterData.FindOne(1));
				studentcourse.setSECTION(Name2);
				
				studentcourse = studentCourseData.Save(studentcourse);
				System.out.println(studentcourse.toString());

				break;
				
				
			case 5:
				
				Scanner inputID = new Scanner(System.in);
				System.out.println("\nEnter a Student Course ID you want to delete");
				int scID = inputID.nextInt();
				studentcourse = studentCourseData.deleteOne(scID);
				 System.out.println(studentcourse.toString());
					System.out.println("____Your given ID data has been successfully Deleted____");
					
					
			case 6:
				
				System.out.println("Return To MainMenu");
				
			}
		}
	}

}
