package uog.edu.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uog.edu.course.courseData;

public class teacherCourseData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Teacher Course.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	
public static List<TeacherCourse> FindAll () {
		
		List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(TeacherCourse.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				TeacherCourse teachercourse = new TeacherCourse();
				String[] teachercourseRow = line.split(",");
				
				teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
				teachercourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(teachercourseRow[1])));
				teachercourse.setTEACHER_ID(teacherData.FindOne(Integer.parseInt(teachercourseRow[2])));
				teachercourse.setSECTION(teachercourseRow[3]);
				
				teachercourses.add(teachercourse);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachercourses;
	}








	public static TeacherCourse FindOne (int teacherCourse_ID) {
	
		String line;
	
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(TeacherCourse.csvFile));
		
			while ((line = bufferedreader.readLine()) != null) {
			
				TeacherCourse teachercourse = new TeacherCourse();
				String[] teachercourseRow = line.split(",");
			
				if (Integer.parseInt(teachercourseRow[0]) == teacherCourse_ID) {
			
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.FindOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
				
					return teachercourse;
				}
			
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
		return null;
	}
	
	
	
	
	
	
	
	
	public static List<TeacherCourse> Search (String search)  {
		List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				TeacherCourse teachercourse = new TeacherCourse();
				
				String[] teachercourseRow = line.split(",");
				
				if (teachercourseRow[2].contains(search) == true) {
					
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.FindOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.FindOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
					
					teachercourses.add(teachercourse);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachercourses;
	}
	
	
	
	
	
	
	
	
	public static TeacherCourse Save (TeacherCourse teachercourse) {
		
		FileWriter filewriter; 
		List<TeacherCourse> teachercourses = FindAll();

		try {
			filewriter = new FileWriter(TeacherCourse.csvFile);

			for (int i=0; i<teachercourses.size(); i++) {
				filewriter.append(teachercourses.get(i).toString());
				filewriter.append("\n");
			}
			
			if (teachercourses.size()>0)
				teachercourse.setTEACHERCOURSE_ID(teachercourses.get(teachercourses.size()-1).getTEACHERCOURSE_ID()+1);
			else
				teachercourse.setTEACHERCOURSE_ID(1);
			
			filewriter.append(teachercourse.toString());
			filewriter.append("\n");
			
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return teachercourse;
	}
	
	
	
	
	
	
	
	
	public static TeacherCourse deleteOne(int teachercourse_ID)  {
		FileWriter filewriter;

		List<TeacherCourse> teachercourses = FindAll();
		TeacherCourse teachercourse = FindOne(teachercourse_ID);

		try {
			filewriter = new FileWriter(TeacherCourse.csvFile);

			for (int i=0; i<teachercourses.size(); i++) {
				if (teachercourses.get(i).getTEACHERCOURSE_ID() != teachercourse_ID) {
					filewriter.append(teachercourses.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return teachercourse;
	}

}
