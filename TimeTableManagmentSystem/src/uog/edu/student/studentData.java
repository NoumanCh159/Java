package uog.edu.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uog.edu.person.Person;

public class studentData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Student.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	public static List<Student> FindAll () {
		
		List<Student> students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Student.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Student student = new Student();
				String[] studentRow = line.split(",");
				
				student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
				student.setTITLE(studentRow[1]);
				student.setFORE_NAME(studentRow[2]);
				student.setSUR_NAME(studentRow[3]);
				student.setAGE(Integer.parseInt(studentRow[4]));
				student.setGENDER(studentRow[5]);
				student.setADDRESS(studentRow[6]);
				student.setROLL_NO(studentRow[7]);
				student.setSTUDY_PROGRAM(studentRow[8]);
				student.setSTUDY_YEAR(studentRow[9]);
				
				students.add(student);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return students;
	}
	
	
	
	
	
	
	
	public static Student FindOne (int student_ID) {
		
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Student.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Student student = new Student();
				String[] studentRow = line.split(",");
				
				if (Integer.parseInt(studentRow[0]) == student_ID) {
				
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setTITLE(studentRow[1]);
					student.setFORE_NAME(studentRow[2]);
					student.setSUR_NAME(studentRow[3]);
					student.setAGE(Integer.parseInt(studentRow[4]));
					student.setGENDER(studentRow[5]);
					student.setADDRESS(studentRow[6]);
					student.setROLL_NO(studentRow[7]);
					student.setSTUDY_PROGRAM(studentRow[8]);
					student.setSTUDY_YEAR(studentRow[9]);
					
					return student;
				}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	public static List<Student> Search (String search)  {
		List<Student> students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();
				
				String[] studentRow = line.split(",");
				
				if (studentRow[7].contains(search) == true) {
					
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setTITLE(studentRow[1]);
					student.setFORE_NAME(studentRow[2]);
					student.setSUR_NAME(studentRow[3]);
					student.setAGE(Integer.parseInt(studentRow[4]));
					student.setGENDER(studentRow[5]);
					student.setADDRESS(studentRow[6]);
					student.setROLL_NO(studentRow[7]);
					student.setSTUDY_PROGRAM(studentRow[8]);
					student.setSTUDY_YEAR(studentRow[9]);
					
					students.add(student);
					
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return students;
	}
	
	
	
	
	
	
	
	
	public static Student Save (Student student) {
		
		FileWriter filewriter; 
		List<Student> students = FindAll();

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<students.size(); i++) {
				filewriter.append(students.get(i).toString());
				filewriter.append("\n");
			}
			
			if (students.size()>0)
				student.setSTUDENT_ID(students.get(students.size()-1).getSTUDENT_ID()+1);
			else
				student.setSTUDENT_ID(1);
			
			filewriter.append(student.toString());
			filewriter.append("\n");
			
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return student;
	}
	
	
	
	
	
	
	
	public static Student deleteOne(int student_ID)  {
		FileWriter filewriter;

		List<Student> students = FindAll();
		Student student = FindOne(student_ID);

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<students.size(); i++) {
				if (students.get(i).getSTUDENT_ID() != student_ID) {
					filewriter.append(students.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

}
