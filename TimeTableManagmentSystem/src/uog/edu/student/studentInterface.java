package uog.edu.student;

import java.util.List;
import java.util.Scanner;

public class studentInterface {
	
	public static void StudentMenu () {
		
		Student student = new Student();
		
		List<Student> students = studentData.FindAll();
		Scanner choInput = new Scanner(System.in);
		
		int userinput = -1;
		
		while (userinput != 7) {
			
			System.out.println("\n1.Find Specific Record By Giving Student-ID\n2.Find All records of Students\n3.Find records of Students by giving incomplete but consective few words of Roll No.\n4.Save New Records\n5.ShowAll Records\n6.Return To MainMenu :-");
			
			userinput = choInput.nextInt();
			
			switch (userinput) {
			
			case 1:
				Scanner RIDinput = new Scanner(System.in);
				System.out.println("Enter Student ID to find:-");
				
				int input = RIDinput.nextInt();
				System.out.println("\n___Found one matching record in rows of students___\n");
				student = studentData.FindOne(input);
				System.out.println(student.toString());
				
				break;
				
				
			case 2:
				
				System.out.println("\n___Found all rows of students___\n");

				students = studentData.FindAll();
				for(int j=0; j<students.size(); j++) 
				System.out.println(students.get(j).toString());

				   break;
				   
				   
			case 3:
				
				Scanner SRinput = new Scanner(System.in);
				System.out.println("Enter few consective valid Roll No. to find:-");
				
				String input2 = SRinput.nextLine();
				System.out.println("\n___Found these matching records containg Roll No. anywhere in rows of students___\n");
				students = studentData.Search(input2);
				for(int i=0; i<students.size(); i++)
				System.out.println(students.get(i).toString());
				
				break;
				
				
			case 4:
				
				Scanner SaveName1 = new Scanner(System.in);
				System.out.println("Enter Title to save:-");
				
				Scanner SaveName2 = new Scanner(System.in);
				System.out.println("Enter Fore_Name of student:-");
				
				Scanner SaveName3 = new Scanner(System.in);
				System.out.println("Enter Sur_Name of student:-");
				
				Scanner SaveName4 = new Scanner(System.in);
				System.out.println("Enter Age of student:-");
				
				Scanner SaveName5 = new Scanner(System.in);
				System.out.println("Enter Gender of student:-");
				
				Scanner SaveName6 = new Scanner(System.in);
				System.out.println("Enter Address of student:-");
				
				Scanner SaveName7 = new Scanner(System.in);
				System.out.println("Enter Roll_No. of student:-");
				
				Scanner SaveName8 = new Scanner(System.in);
				System.out.println("Enter Study_Program of student:-");
				
				Scanner SaveName9 = new Scanner(System.in);
				System.out.println("Enter Study_Year of student:-");
				
				String Name1 = SaveName1.nextLine();
				String Name2 = SaveName2.nextLine();
				String Name3 = SaveName3.nextLine();
				int Name4 = SaveName4.nextInt();
				String Name5 = SaveName5.nextLine();
				String Name6 = SaveName6.nextLine();
				String Name7 = SaveName7.nextLine();
				String Name8 = SaveName8.nextLine();
				String Name9 = SaveName9.nextLine();
				
				System.out.println("\n________Save of student record__________\n");
				
				student.setTITLE(Name1);
				student.setFORE_NAME(Name2);
				student.setSUR_NAME(Name3);
				student.setAGE(Name4);
				student.setGENDER(Name5);
				student.setADDRESS(Name6);
				student.setROLL_NO(Name7);
				student.setSTUDY_PROGRAM(Name8);
				student.setSTUDY_YEAR(Name9);
				
				student = studentData.Save(student);
				System.out.println(student.toString());

				break;
				
				
			case 5:
				
				Scanner inputID = new Scanner(System.in);
				System.out.println("\nEnter a Student ID you want to delete");
				int rID = inputID.nextInt();
				student = studentData.deleteOne(rID);
				 System.out.println(student.toString());
					System.out.println("____Your given ID data has been successfully Deleted____");
					
					
			case 6:
				
				System.out.println("Return To MainMenu");
				
			}
		}
	}

}
