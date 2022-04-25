package uog.edu.campus;

import java.util.List;
import java.util.Scanner;

public class roomInterface {
	
	@SuppressWarnings( "resource" )
	public static void RoomMenu(){
		roomData roomdata=new roomData();
		Room room=new Room();
		List<Room>rooms=roomdata.FindAll();
		Scanner Rawinput=new Scanner(System.in);
		int Userinput=-1;
		while(Userinput!=7) {
		System.out.println("\n1.Find Specific Record By Giving Room-ID\n2.Find All records of Rooms\n3.Find records of Students by giving incomplete but consective few words of Roll No.\n4.Save New Records\n6.ShowAll Records\n7.Return To MainMenu :-");
	  
	    Userinput=Rawinput.nextInt();
		switch(Userinput) {
		case 1:
			Scanner Rinput=new Scanner(System.in);
			System.out.println("Enter Room ID to find:-");
			int input=Rinput.nextInt();
		System.out.println("\n_________found one matching record in rows of rooms___________\n");
	    roomdata=new roomData();
	    room=roomdata.FindOne(input);
		System.out.println(room.toString());
		
		break;
		case 2:

	System.out.println("\n_________found all rows of rooms___________\n");

	rooms=roomdata.FindAll();
	for(int j=0;j<rooms.size();j++) 
	System.out.println(rooms.get(j).toString());

	   break;

		case 3:

	Scanner ASRrinput=new Scanner(System.in);
	System.out.println("Enter few consective valid Room-Name text record to find:-");
	String input2=ASRrinput.nextLine();
	System.out.println("\n_________ found these matching records containg words anywhere in rows of rooms___________\n");
	rooms=roomdata.Search(input2);
	for(int i=0;i<rooms.size();i++)
	System.out.println(rooms.get(i).toString());

	break;
	case 4:
		Scanner SaveName1=new Scanner(System.in);
		System.out.println("Enter room name to save:-");
		Scanner SaveName2=new Scanner(System.in);
		System.out.println("Enter type of room:-");
		Scanner SaveName3=new Scanner(System.in);
		System.out.println("Enter room capacity:-");
		Scanner SaveName4=new Scanner(System.in);
		System.out.println("Enter room floor:-");
		
		String Name1=SaveName1.nextLine();
		String Name2=SaveName2.nextLine();
		int Name3=SaveName3.nextInt();
		int Name4=SaveName4.nextInt();
		System.out.println("\n________Save of rooms__________\n");
		room.setROOM_NAME(Name1);
		room.setROOM_TYPE(Name2);
		room.setROOM_CAPACITY(Name3);
		room.setROOM_FLOOR(Name4);	
		room=roomdata.Save(room);
		System.out.println(room.toString());

		break;
	case 5:
		System.out.println("\n_______________________________\n");
		System.out.println("\n____Found all records after saving user records of rooms_____\n");
		rooms=roomdata.FindAll();
		for(int i=0;i<rooms.size();i++) 
		System.out.println(rooms.get(i).toString());

		break;
	case 6:
		Scanner inputID = new Scanner(System.in);
		System.out.println("\nEnter a room ID you want to delete");
		int rID = inputID.nextInt();
		room = roomdata.deleteOne(rID);
		 System.out.println(room.toString());
			System.out.println("____Your given ID data has been successfully Deleted____");
			
	case 7:
		System.out.println("Return To MainMenu");
		}
	}
	}

}
