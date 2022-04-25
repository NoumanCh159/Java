package uog.edu.timetable;

public class WeekDay {
	
	private int WEEKDAY_ID;
	
	private String WEEKDAY_NAME;

	public int getWEEKDAY_ID() {
		return WEEKDAY_ID;
	}

	public void setWEEKDAY_ID(int wEEKDAY_ID) {
		WEEKDAY_ID = wEEKDAY_ID;
	}

	public String getWEEKDAY_NAME() {
		return WEEKDAY_NAME;
	}

	public void setWEEKDAY_NAME(String wEEKDAY_NAME) {
		WEEKDAY_NAME = wEEKDAY_NAME;
	}

	public String toString() {
		
		String str = null;
	
	str = "WeekDay ID : " + this.WEEKDAY_ID
			+ "\nWeekDay Name : " + this.WEEKDAY_NAME;
	
		return str;
   }
}
