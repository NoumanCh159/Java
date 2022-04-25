package uog.edu.teacher;

import uog.edu.course.Course;

public class TeacherCourse {
	
	public static String csvFile = "E:\\STS\\Excel Files\\Teacher Course.csv";
	
	private int TEACHERCOURSE_ID;
	
	private Course COURSE_ID;
	
	private Teacher TEACHER_ID;
	
	private String SECTION;

	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) {
		TeacherCourse.csvFile = csvFile;
	}

	public int getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}

	public void setTEACHERCOURSE_ID(int tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}

	public Course getCOURSE_ID() {
		return COURSE_ID;
	}

	public void setCOURSE_ID(Course cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}

	public Teacher getTEACHER_ID() {
		return TEACHER_ID;
	}

	public void setTEACHER_ID(Teacher tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}

	public String getSECTION() {
		return SECTION;
	}

	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}

	public String toString() {
		
		String str = null;
	
	str = this.TEACHERCOURSE_ID
			+ "," + this.COURSE_ID.getCOURSE_ID()
			+ "," + this.TEACHER_ID.getTEACHER_ID()
			+ "," + this.SECTION;
	
		return str;
   }
}
