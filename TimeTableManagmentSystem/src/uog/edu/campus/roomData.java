package uog.edu.campus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class roomData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Room.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	public static List<Room> FindAll () {
		
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Room.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Room room = new Room();
				String[] roomRow = line.split(",");
				
				room.setROOM_ID(Integer.parseInt(roomRow[0]));
				room.setROOM_NAME(roomRow[1]);
				room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
				room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
				room.setROOM_TYPE(roomRow[4]);
				
				
				rooms.add(room);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return rooms;
	}
	
	
	
	
	
	
	
	public static Room FindOne (int room_ID) {
		
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Room.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Room room = new Room();
				String[] roomRow = line.split(",");
				
				if (Integer.parseInt(roomRow[0]) == room_ID) {
				
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					
					return room;
				}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	public static List<Room> Search (String search)  {
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				if (roomRow[1].contains(search) == true) {
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					
					rooms.add(room);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return rooms;
	}
	
	
	
	
	
	
	
	
	public static Room Save (Room room) {
		
		FileWriter filewriter; 
		List<Room> rooms = FindAll();

		try {
			filewriter = new FileWriter(Room.csvFile);

			for (int i=0; i<rooms.size(); i++) {
				filewriter.append(rooms.get(i).toString());
				filewriter.append("\n");
			}
			
			if (rooms.size()>0)
				room.setROOM_ID(rooms.get(rooms.size()-1).getROOM_ID()+1);
			else
				room.setROOM_ID(1);
			
			filewriter.append(room.toString());
			filewriter.append("\n");
			
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return room;
	}
	
	
	
	
	
	
	
	public static Room deleteOne(int room_ID)  {
		FileWriter filewriter;

		List<Room> rooms = FindAll();
		Room room = FindOne(room_ID);

		try {
			filewriter = new FileWriter(Room.csvFile);

			for (int i=0; i<rooms.size(); i++) {
				if (rooms.get(i).getROOM_ID() != room_ID) {
					filewriter.append(rooms.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return room;
	}
	
}
