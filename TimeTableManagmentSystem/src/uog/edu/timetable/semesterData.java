package uog.edu.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class semesterData {
	
	private String csvFile = "E:\\STS\\Excel Files\\Semester.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	
	
	
	
	
	public static List<Semester> FindAll () {
		
		List<Semester> semesters = new ArrayList<Semester>();
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Semester.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Semester semester = new Semester();
				String[] semesterRow = line.split(",");
				
				semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
				semester.setSEMESTER_CODE(semesterRow[1]);
				semester.setSEMESTER_NAME(semesterRow[2]);
				semester.setSEMESTER_STARTDATE(semesterRow[3]);
				semester.setSEMESTER_ENDDATE(semesterRow[4]);
				
				semesters.add(semester);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return semesters;
	}
	
	
	
	
	
	
	
	public static Semester FindOne (int semester_ID) {
		
		String line;
		
		try {
			BufferedReader bufferedreader = new BufferedReader (new FileReader(Semester.csvFile));
			
			while ((line = bufferedreader.readLine()) != null) {
				
				Semester semester = new Semester();
				String[] semesterRow = line.split(",");
				
				if (Integer.parseInt(semesterRow[0]) == semester_ID) {
				
					semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
					semester.setSEMESTER_CODE(semesterRow[1]);
					semester.setSEMESTER_NAME(semesterRow[2]);
					semester.setSEMESTER_STARTDATE(semesterRow[3]);
					semester.setSEMESTER_ENDDATE(semesterRow[4]);
					
					return semester;
				}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	public static List<Semester> Search (String search)  {
		List<Semester> semesters = new ArrayList<Semester>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semester.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Semester semester = new Semester();
				
				String[] semesterRow = line.split(",");
				
				if (semesterRow[1].contains(search) == true) {
					
					semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
					semester.setSEMESTER_CODE(semesterRow[1]);
					semester.setSEMESTER_NAME(semesterRow[2]);
					semester.setSEMESTER_STARTDATE(semesterRow[3]);
					semester.setSEMESTER_ENDDATE(semesterRow[4]);
					
					semesters.add(semester);
					
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return semesters;
	}
	
	
	
	
	
	
	
	public static Semester Save (Semester semester) {
		
		FileWriter filewriter; 
		List<Semester> semesters = FindAll();

		try {
			filewriter = new FileWriter(Semester.csvFile);

			for (int i=0; i<semesters.size(); i++) {
				filewriter.append(semesters.get(i).toString());
				filewriter.append("\n");
			}
			
			if (semesters.size()>0)
				semester.setSEMESTER_ID(semesters.get(semesters.size()-1).getSEMESTER_ID()+1);
			else
				semester.setSEMESTER_ID(1);
			
			filewriter.append(semester.toString());
			filewriter.append("\n");
			
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return semester;
	}
	
	
	
	
	
	
	
	public static Semester deleteOne(int semester_ID)  {
		FileWriter filewriter;

		List<Semester> semesters = FindAll();
		Semester semester = FindOne(semester_ID);

		try {
			filewriter = new FileWriter(Semester.csvFile);

			for (int i=0; i<semesters.size(); i++) {
				if (semesters.get(i).getSEMESTER_ID() != semester_ID) {
					filewriter.append(semesters.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return semester;
	}

}
