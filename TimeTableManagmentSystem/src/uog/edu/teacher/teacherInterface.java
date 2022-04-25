package uog.edu.teacher;

import java.util.List;
import java.util.Scanner;

import uog.edu.person.Person;
import uog.edu.person.personData;

public class teacherInterface {
	
	@SuppressWarnings( "resource" )
	public static void TeacherMenu(){
		
		
		Teacher teacher = new Teacher();
		
		List<Teacher> teachers = teacherData.FindAll();
		Scanner Teinput=new Scanner(System.in);
		
		int Userinput=-1;
		while(Userinput!=7) {
			
		System.out.println("\n1.Find Specific Record By Giving Teacher_ID\n2.Find All records of Teachers\n3.Find records of your specific Teacher_ID\n4.Find records of Teachers by giving incomplete but consective few words of Person_Name\n5.Save New Records\n6.ShowAll Records\n7.Return To MainMenu :-");
	  
	    Userinput=Teinput.nextInt();
		switch(Userinput) {
		
		case 1:
			Scanner Tinput=new Scanner(System.in);
			System.out.println("Enter Teacher to find:-");
			int input=Tinput.nextInt();
		System.out.println("\n___found one matching record in rows of Teachers___\n");

		teacher = teacherData.FindOne(input);
		System.out.println(teacher.toString());
		
		break;
		
		
		case 2:

			System.out.println("\n___found all rows of Teachers___\n");

			teachers = teacherData.FindAll();
			for(int j=0;j<teachers.size();j++) 
				System.out.println(teachers.get(j).toString());

	   break;
	   

	case 3:
		
		Scanner SaveName1 = new Scanner(System.in);
		System.out.println("Enter Person Title to save:-");
		Scanner SaveName2=new Scanner(System.in);
		System.out.println("Enter Teacher Fore_Name:-");
		Scanner SaveName3=new Scanner(System.in);
		System.out.println("Enter Teacher Sur_Name:-");
		Scanner SaveName4=new Scanner(System.in);
		System.out.println("Enter Teacher Age:-");
		Scanner SaveName5=new Scanner(System.in);
		System.out.println("Enter Teacher Gender:-");
		Scanner SaveName6=new Scanner(System.in);
		System.out.println("Enter Teacher Address:-");
		
		String Name1=SaveName1.nextLine();
		String Name2=SaveName2.nextLine();
		String Name3=SaveName3.nextLine();
		int Name4=SaveName4.nextInt();
		String Name5= SaveName5.nextLine();
		String Name6= SaveName6.nextLine();
		
		System.out.println("\n________Save of Teachers__________\n");
		
		teacher.setTITLE(Name1);
		teacher.setFORE_NAME(Name2);
		teacher.setSUR_NAME(Name3);
		teacher.setAGE(Name4);	
		teacher.setGENDER(Name5);
		teacher.setADDRESS(Name6);
		
		System.out.println(teacher.toString());
		break;
		
	case 4:
		System.out.println("\n_______________________________\n");
		System.out.println("\n____Found all records after saving user records of Teachers_____\n");
		teachers = teacherData.FindAll();
		for(int i=0;i<teachers.size();i++) 
		System.out.println(teachers.get(i).toString());

		break;
		
	case 5:
		Scanner inputID = new Scanner(System.in);
		System.out.println("\nEnter a Teacher_ID you want to delete");
		int rID = inputID.nextInt();
		teacher = teacherData.deleteOne(rID);
		 System.out.println(teacher.toString());
			System.out.println("____Your given ID data has been successfully Deleted____");
			
	case 6:
		System.out.println("Return To MainMenu");
		}
	}
	}

}
