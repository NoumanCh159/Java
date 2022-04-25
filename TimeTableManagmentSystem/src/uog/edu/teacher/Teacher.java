package uog.edu.teacher;

import uog.edu.person.Person;

public class Teacher extends Person{
	
	public static String csvFile = "E:\\STS\\Excel Files\\Teacher.csv";
	
	private int TEACHER_ID;

	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) {
		Teacher.csvFile = csvFile;
	}

	public int getTEACHER_ID() {
		return TEACHER_ID;
	}

	public void setTEACHER_ID(int tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}

	public String toString() {
		
		String str = null;
	
	str = " " + this.TEACHER_ID
			+ "," + this.getTITLE()
			+ "," + this.getFORE_NAME()
			+ "," + this.getSUR_NAME()
			+ "," + this.getAGE()
			+ "," + this.getGENDER()
			+ "," + this.getADDRESS();
	
		return str;
   }
}
