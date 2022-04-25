package uog.edu.student;

import uog.edu.person.Person;

public class Student extends Person{
	
	public static String csvFile = "E:\\STS\\Excel Files\\Student.csv";
	
	private int STUDENT_ID;
	
	private String ROLL_NO;
	
	private String STUDY_PROGRAM;
	
	private String STUDY_YEAR;

	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}

	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}

	public String getROLL_NO() {
		return ROLL_NO;
	}

	public void setROLL_NO(String rOLL_NO) {
		ROLL_NO = rOLL_NO;
	}

	public String getSTUDY_PROGRAM() {
		return STUDY_PROGRAM;
	}

	public void setSTUDY_PROGRAM(String sTUDY_PROGRAM) {
		STUDY_PROGRAM = sTUDY_PROGRAM;
	}

	public String getSTUDY_YEAR() {
		return STUDY_YEAR;
	}

	public void setSTUDY_YEAR(String sTUDY_YEAR) {
		STUDY_YEAR = sTUDY_YEAR;
	}

	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) {
		Student.csvFile = csvFile;
	}

	public String toString() {
		
		String str = null;
	
	str = this.STUDENT_ID
			+ "," + this.getTITLE()
			+ "," + this.getFORE_NAME()
			+ "," + this.getSUR_NAME()
			+ "," + this.getAGE()
			+ "," + this.getGENDER()
			+ "," + this.getADDRESS()
			+ "," + this.ROLL_NO
			+ "," + this.STUDY_PROGRAM
			+ "," + this.STUDY_YEAR;
	
		return str;
   }
}
