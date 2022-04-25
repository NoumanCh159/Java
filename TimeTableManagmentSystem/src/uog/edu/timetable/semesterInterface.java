package uog.edu.timetable;

import java.util.List;
import java.util.Scanner;

import uog.edu.course.courseData;
import uog.edu.teacher.TeacherCourse;
import uog.edu.teacher.teacherCourseData;
import uog.edu.teacher.teacherData;

public class semesterInterface {
	
public static void SemesterMenu () {
		
		Semester semester = new Semester();
		
		List<Semester> semesters = semesterData.FindAll();
		Scanner choInput = new Scanner(System.in);
		
		int userinput = -1;
		
		while (userinput != 7) {
			
			System.out.println("\n1.Find Specific Record By Giving Semester_ID\n2.Find All records of Semesters\n3.Find records of Semesters by giving incomplete but consective few words of Semester_ID\n4.Save New Records\n5.ShowAll Records\n6.Return To MainMenu :-");
			
			userinput = choInput.nextInt();
			
			switch (userinput) {
			
			case 1:
				
				Scanner SIDinput = new Scanner(System.in);
				System.out.println("Enter Semester ID to find:-");
				
				int input = SIDinput.nextInt();
				System.out.println("\n___Found one matching record in rows of semesters___\n");
				semester = semesterData.FindOne(input);
				System.out.println(semester.toString());
				
				break;
				
				
			case 2:
				
				System.out.println("\n___Found all rows of semesters___\n");

				semesters = semesterData.FindAll();
				for(int j=0; j<semesters.size(); j++) 
				System.out.println(semesters.get(j).toString());

				   break;
				   
				   
			case 3:
				
				Scanner SRinput = new Scanner(System.in);
				System.out.println("Enter Semester ID to find:-");
				
				String input2 = SRinput.nextLine();
				System.out.println("\n___Found these matching records containing Season anywhere in rows of semesters___\n");
				semesters = semesterData.Search(input2);
				for(int i=0; i<semesters.size(); i++)
				System.out.println(semesters.get(i).toString());
				
				break;
				
				
			case 4:
				
				Scanner SaveName1 = new Scanner(System.in);
				System.out.println("Enter Semester ID:-");
				
				System.out.println("Enter Semester Code:-");
				
				System.out.println("Enter Semester Name:-");
				
				System.out.println("Enter Semester Start Date:-");
				
				System.out.println("Enter Semester End Date:-");
				
				int Name1 = SaveName1.nextInt();
				String Name2 = SaveName1.nextLine();
				String Name3 = SaveName1.nextLine();
				String Name4 = SaveName1.nextLine();
				String Name5 = SaveName1.nextLine();
				
				System.out.println("\n________Save of semester record__________\n");
				
				semester.setSEMESTER_ID(Name1);
				semester.setSEMESTER_CODE(Name2);
				semester.setSEMESTER_NAME(Name3);
				semester.setSEMESTER_STARTDATE(Name4);
				semester.setSEMESTER_ENDDATE(Name5);
				
				semester = semesterData.Save(semester);
				System.out.println(semester.toString());

				break;
				
				
			case 5:
				
				Scanner inputID = new Scanner(System.in);
				System.out.println("\nEnter a Semester ID you want to delete");
				int sID = inputID.nextInt();
				semester = semesterData.deleteOne(sID);
				 System.out.println(semester.toString());
					System.out.println("____Your given ID data has been successfully Deleted____");
					
					
			case 6:
				
				System.out.println("Return To MainMenu");
				
			}
		}
	}

}
