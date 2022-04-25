package uog.edu.person;

import java.util.List;
import java.util.Scanner;


public class personInterface {
	
	@SuppressWarnings( "resource" )
	public static void PersonMenu(){
		personData persondata=new personData();
		Person person = new Person();
		List<Person> persons=persondata.FindAll();
		Scanner Rawinput=new Scanner(System.in);
		int Userinput=-1;
		while(Userinput!=7) {
		System.out.println("\n1.Find Specific Record By Giving Person_ID\n2.Find All records of Persons\n3.Find records of your specific Person_Name\n4.Find records of Courses by giving incomplete but consective few words of Person_Name\n5.Save New Records\n6.ShowAll Records\n7.Return To MainMenu :-");
	  
	    Userinput=Rawinput.nextInt();
		switch(Userinput) {
		case 1:
			Scanner Rinput=new Scanner(System.in);
			System.out.println("Enter Person_ID to find:-");
			int input=Rinput.nextInt();
		System.out.println("\n_________found one matching record in rows of Persons___________\n");
		persondata=new personData();
		person = persondata.FindOne(input);
		System.out.println(person.toString());
		
		break;
		case 2:

	System.out.println("\n_________found all rows of Persons___________\n");

	persons = persondata.FindAll();
	for(int j=0;j<persons.size();j++) 
	System.out.println(persons.get(j).toString());

	   break;

		case 3:

	Scanner ASRrinput=new Scanner(System.in);
	System.out.println("Enter few consective valid Person_Name text record to find:-");
	String input2=ASRrinput.nextLine();
	System.out.println("\n_________ found these matching records containg words anywhere in rows of Persons___________\n");
	persons = persondata.Search(input2);
	for(int i=0;i<persons.size();i++)             
	System.out.println(persons.get(i).toString());

	break;
	case 4:
		Scanner SaveName1=new Scanner(System.in);
		System.out.println("Enter Person Title to save:-");
		Scanner SaveName2=new Scanner(System.in);
		System.out.println("Enter Person Fore_Name:-");
		Scanner SaveName3=new Scanner(System.in);
		System.out.println("Enter Person Sur_Name:-");
		Scanner SaveName4=new Scanner(System.in);
		System.out.println("Enter Person Age:-");
		Scanner SaveName5=new Scanner(System.in);
		System.out.println("Enter Person Gender:-");
		Scanner SaveName6=new Scanner(System.in);
		System.out.println("Enter Person Address:-");
		
		String Name1=SaveName1.nextLine();
		String Name2=SaveName2.nextLine();
		String Name3=SaveName3.nextLine();
		int Name4=SaveName4.nextInt();
		String Name5= SaveName5.nextLine();
		String Name6= SaveName6.nextLine();
		
		System.out.println("\n________Save of persons__________\n");
		person.setTITLE(Name1);
		person.setFORE_NAME(Name2);
		person.setSUR_NAME(Name3);
		person.setAGE(Name4);	
		person.setGENDER(Name5);
		person.setADDRESS(Name6);
		
		System.out.println(person.toString());
		break;
		
	case 5:
		System.out.println("\n_______________________________\n");
		System.out.println("\n____Found all records after saving user records of persons_____\n");
		persons=persondata.FindAll();
		for(int i=0;i<persons.size();i++) 
		System.out.println(persons.get(i).toString());

		break;
		
	case 6:
		Scanner inputID = new Scanner(System.in);
		System.out.println("\nEnter a Person_ID you want to delete");
		int rID = inputID.nextInt();
		person = persondata.deleteOne(rID);
		 System.out.println(person.toString());
			System.out.println("____Your given ID data has been successfully Deleted____");
			
	case 7:
		System.out.println("Return To MainMenu");
		}
	}
	}

}
