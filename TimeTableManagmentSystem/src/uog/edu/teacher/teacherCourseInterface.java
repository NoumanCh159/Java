package uog.edu.teacher;

import java.util.List;
import java.util.Scanner;

import uog.edu.course.courseData;


public class teacherCourseInterface {
	
public static void TeacherCourseMenu () {
		
		TeacherCourse teachercourse = new TeacherCourse();
		
		List<TeacherCourse> teachercourses = teacherCourseData.FindAll();
		Scanner choInput = new Scanner(System.in);
		
		int userinput = -1;
		
		while (userinput != 7) {
			
			System.out.println("\n1.Find Specific Record By Giving Teacher-Course_ID\n2.Find All records of Teacher Courses\n3.Find records of Teacher Courses by giving incomplete but consective few words of Course_ID\n4.Save New Records\n5.ShowAll Records\n6.Return To MainMenu :-");
			
			userinput = choInput.nextInt();
			
			switch (userinput) {
			
			case 1:
				
				Scanner CIDinput = new Scanner(System.in);
				System.out.println("Enter Teacher Course ID to find:-");
				
				int input = CIDinput.nextInt();
				System.out.println("\n___Found one matching record in rows of teacher courses___\n");
				teachercourse = teacherCourseData.FindOne(input);
				System.out.println(teachercourse.toString());
				
				break;
				
				
			case 2:
				
				System.out.println("\n___Found all rows of teacher courses___\n");

				teachercourses = teacherCourseData.FindAll();
				for(int j=0; j<teachercourses.size(); j++) 
				System.out.println(teachercourses.get(j).toString());

				   break;
				   
				   
			case 3:
				
				Scanner SRinput = new Scanner(System.in);
				System.out.println("Enter Course ID to find:-");
				
				String input2 = SRinput.nextLine();
				System.out.println("\n___Found these matching records containg Roll No. anywhere in rows of teacher courses___\n");
				teachercourses = teacherCourseData.Search(input2);
				for(int i=0; i<teachercourses.size(); i++)
				System.out.println(teachercourses.get(i).toString());
				
				break;
				
				
			case 4:
				
				Scanner SaveName1 = new Scanner(System.in);
				System.out.println("Enter Student Course ID:-");
				
				Scanner SaveName2 = new Scanner(System.in);
				System.out.println("Enter Section:-");
				
				int Name1 = SaveName1.nextInt();
				String Name2 = SaveName2.nextLine();
				
				System.out.println("\n________Save of student course record__________\n");
				
				teachercourse.setTEACHERCOURSE_ID(Name1);
				teachercourse.setCOURSE_ID(courseData.FindOne(1));
				teachercourse.setTEACHER_ID(teacherData.FindOne(1));
				teachercourse.setSECTION(Name2);
				
				teachercourse = teacherCourseData.Save(teachercourse);
				System.out.println(teachercourse.toString());

				break;
				
				
			case 5:
				
				Scanner inputID = new Scanner(System.in);
				System.out.println("\nEnter a T Course ID you want to delete");
				int scID = inputID.nextInt();
				teachercourse = teacherCourseData.deleteOne(scID);
				 System.out.println(teachercourse.toString());
					System.out.println("____Your given ID data has been successfully Deleted____");
					
					
			case 6:
				
				System.out.println("Return To MainMenu");
				
			}
		}
	}

}
