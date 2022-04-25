package uog.edu.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uog.edu.person.Person;

public class teacherData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Teacher.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	public static List<Teacher> FindAll () {
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Teacher.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Teacher teacher = new Teacher();
				String[] teacherRow = line.split(",");
				
				teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
				
				teachers.add(teacher);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachers;
	}
	
	
	
	
	
	
	
	public static Teacher FindOne (int teacher_ID) {
		
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Teacher.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Teacher teacher = new Teacher();
				String[] teacherRow = line.split(",");
				
				if (Integer.parseInt(teacherRow[0]) == teacher_ID) {
				
					teacher.setPERSON_ID(Integer.parseInt(teacherRow[0]));
					
					return teacher;
				}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	public static List<Teacher> Search (int search)  {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				if (Integer.parseInt(teacherRow[0]) == search) {
					
					teacher.setPERSON_ID(Integer.parseInt(teacherRow[0]));
					
					teachers.add(teacher);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachers;
	}
	
	
	
	
	
	
	public static Teacher deleteOne(int teacher_ID)  {
		FileWriter filewriter;

		List<Teacher> teachers = FindAll();
		Teacher teacher = FindOne(teacher_ID);

		try {
			filewriter = new FileWriter(Teacher.csvFile);

			for (int i=0; i<teachers.size(); i++) {
				if (teachers.get(i).getTEACHER_ID() != teacher_ID) {
					filewriter.append(teachers.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacher;
	}

}
