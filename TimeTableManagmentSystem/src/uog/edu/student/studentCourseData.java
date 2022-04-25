package uog.edu.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uog.edu.course.courseData;
import uog.edu.timetable.semesterData;

public class studentCourseData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Student Course.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	public static List<StudentCourse> FindAll () {
		
		List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(StudentCourse.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				StudentCourse studentcourse = new StudentCourse();
				String[] studentcourseRow = line.split(",");
				
				studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
				studentcourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(studentcourseRow[1])));
				studentcourse.setSTUDENT_ID(studentData.FindOne(Integer.parseInt(studentcourseRow[2])));
				studentcourse.setSEMESTER_ID(semesterData.FindOne(Integer.parseInt(studentcourseRow[3])));
				studentcourse.setSECTION(studentcourseRow[4]);
				
				studentcourses.add(studentcourse);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return studentcourses;
	}
	
	
	
	
	
	
	
	public static StudentCourse FindOne (int studentcourse_ID) {
		
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(StudentCourse.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				StudentCourse studentcourse = new StudentCourse();
				String[] studentcourseRow = line.split(",");
				
				if (Integer.parseInt(studentcourseRow[0]) == studentcourse_ID) {
					
					studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					studentcourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(studentcourseRow[1])));
					studentcourse.setSTUDENT_ID(studentData.FindOne(Integer.parseInt(studentcourseRow[2])));
					studentcourse.setSEMESTER_ID(semesterData.FindOne(Integer.parseInt(studentcourseRow[3])));
					studentcourse.setSECTION(studentcourseRow[4]);
					
					return studentcourse;
				}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	public static List<StudentCourse> Search (String search)  {
		List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				StudentCourse studentcourse = new StudentCourse();
				
				String[] studentcourseRow = line.split(",");
				
				if (studentcourseRow[1].contains(search) == true) {
					
					studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					studentcourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(studentcourseRow[1])));
					studentcourse.setSTUDENT_ID(studentData.FindOne(Integer.parseInt(studentcourseRow[2])));
					studentcourse.setSEMESTER_ID(semesterData.FindOne(Integer.parseInt(studentcourseRow[3])));
					studentcourse.setSECTION(studentcourseRow[4]);
					
					studentcourses.add(studentcourse);
					
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return studentcourses;
	}
	
	
	
	
	
	
	
	public static StudentCourse Save (StudentCourse studentcourse) {
		
		FileWriter filewriter; 
		List<StudentCourse> studentcourses = FindAll();

		try {
			filewriter = new FileWriter(StudentCourse.csvFile);

			for (int i=0; i<studentcourses.size(); i++) {
				filewriter.append(studentcourses.get(i).toString());
				filewriter.append("\n");
			}
			
			if (studentcourses.size()>0)
				studentcourse.setSTUDENTCOURSE_ID(studentcourses.get(studentcourses.size()-1).getSTUDENTCOURSE_ID()+1);
			else
				studentcourse.setSTUDENTCOURSE_ID(1);
			
			filewriter.append(studentcourse.toString());
			filewriter.append("\n");
			
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return studentcourse;
	}
	
	
	
	
	
	
	
	public static StudentCourse deleteOne(int studentcourse_ID)  {
		FileWriter filewriter;

		List<StudentCourse> studentcourses = FindAll();
		StudentCourse studentcourse = FindOne(studentcourse_ID);

		try {
			filewriter = new FileWriter(StudentCourse.csvFile);

			for (int i=0; i<studentcourses.size(); i++) {
				if (studentcourses.get(i).getSTUDENTCOURSE_ID() != studentcourse_ID) {
					filewriter.append(studentcourses.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentcourse;
	}

}
