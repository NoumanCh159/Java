  package uog.edu.campus;

public class Room {
	
	public static String csvFile = "E:\\STS\\Excel Files\\Room.csv";
	
	private int ROOM_ID;
	
	private String ROOM_NAME;
	
	private int ROOM_FLOOR;
	
	private int ROOM_CAPACITY;
	
	private String ROOM_TYPE;

	public int getROOM_ID() {
		return ROOM_ID;
	}

	public void setROOM_ID(int rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}

	public String getROOM_NAME() {
		return ROOM_NAME;
	}

	public void setROOM_NAME(String rOOM_NAME) {
		ROOM_NAME = rOOM_NAME;
	}

	public int getROOM_FLOOR() {
		return ROOM_FLOOR;
	}

	public void setROOM_FLOOR(int rOOM_FLOOR) {
		ROOM_FLOOR = rOOM_FLOOR;
	}

	public int getROOM_CAPACITY() {
		return ROOM_CAPACITY;
	}

	public void setROOM_CAPACITY(int rOOM_CAPACITY) {
		ROOM_CAPACITY = rOOM_CAPACITY;
	}

	public String getROOM_TYPE() {
		return ROOM_TYPE;
	}

	public void setROOM_TYPE(String rOOM_TYPE) {
		ROOM_TYPE = rOOM_TYPE;
	}

	public String toString() {
		
		String str = null;
		
		str = this.ROOM_ID
				+ "," + this.ROOM_NAME
				+ "," + this.ROOM_FLOOR
				+ "," + this.ROOM_CAPACITY
				+ "," + this.ROOM_TYPE;
		
		return str;
	}

}
