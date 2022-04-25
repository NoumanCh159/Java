package uog.edu.course;

import java.util.List;
import java.util.Scanner;


public class courseInterface {
	
	@SuppressWarnings( "resource" )
	public static void CourseMenu(){
		courseData coursedata=new courseData();
		Course course = new Course();
		List<Course> courses=coursedata.FindAll();
		Scanner Rawinput=new Scanner(System.in);
		int Userinput=-1;
		while(Userinput!=7) {
		System.out.println("\n1.Find Specific Record By Giving Course_ID\n2.Find All records of Courses\n3.Find records of your specific Course_Name\n4.Find records of Courses by giving incomplete but consective few words of Course_Code\n5.Save New Records\n6.ShowAll Records\n7.Return To MainMenu :-");
	  
	    Userinput=Rawinput.nextInt();
		switch(Userinput) {
		case 1:
			Scanner Rinput=new Scanner(System.in);
			System.out.println("Enter Course_ID to find:-");
			int input=Rinput.nextInt();
		System.out.println("\n_________found one matching record in rows of Courses___________\n");
	    coursedata=new courseData();
	    course = coursedata.FindOne(input);
		System.out.println(course.toString());
		
		break;
		case 2:

	System.out.println("\n_________found all rows of Courses___________\n");

	courses = coursedata.FindAll();
	for(int j=0;j<courses.size();j++) 
	System.out.println(courses.get(j).toString());

	   break;

		case 3:

	Scanner ASRrinput=new Scanner(System.in);
	System.out.println("Enter few consective valid Course_Code text record to find:-");
	String input2=ASRrinput.nextLine();
	System.out.println("\n_________ found these matching records containg words anywhere in rows of Courses___________\n");
	courses = coursedata.Search(input2);
	for(int i=0;i<courses.size();i++)             
	System.out.println(courses.get(i).toString());

	break;
	case 4:
		Scanner SaveName1=new Scanner(System.in);
		System.out.println("Enter Course_Code to save:-");
		Scanner SaveName2=new Scanner(System.in);
		System.out.println("Enter title of course:-");
		Scanner SaveName3=new Scanner(System.in);
		System.out.println("Enter Course Descrption:-");
		Scanner SaveName4=new Scanner(System.in);
		System.out.println("Enter course credithours:-");
		
		String Name1=SaveName1.nextLine();
		String Name2=SaveName2.nextLine();
		String Name3=SaveName3.nextLine();
		int Name4=SaveName4.nextInt();
		System.out.println("\n________Save of courses__________\n");
		course.setCOURSE_CODE(Name1);
		course.setCOURSE_TITLE(Name2);
		course.setCOURSE_DESC(Name3);
		course.setCOURSE_CREDITHOUR(Name4);	
		System.out.println(course.toString());

		break;
	case 5:
		System.out.println("\n_______________________________\n");
		System.out.println("\n____Found all records after saving user records of courses_____\n");
		courses=coursedata.FindAll();
		for(int i=0;i<courses.size();i++) 
		System.out.println(courses.get(i).toString());

		break;
	case 6:
		Scanner inputID = new Scanner(System.in);
		System.out.println("\nEnter a course_ID you want to delete");
		int rID = inputID.nextInt();
		course = coursedata.deleteOne(rID);
		 System.out.println(course.toString());
			System.out.println("____Your given ID data has been successfully Deleted____");
			
	case 7:
		System.out.println("Return To MainMenu");
		}
	}
	}

}
