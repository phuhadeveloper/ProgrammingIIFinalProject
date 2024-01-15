package student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
	
	// method to check GPA
	public static boolean checkGPA(double GPA) {
		return GPA <= 5.0 && GPA >= 0.0;
	}
	
	// method to write students' information to a file
	public static void writeStudentsInfoToFile(List<Student> studentsList) throws IOException {
		// creating the file path
		String fileSeparator = System.getProperty("file.separator");
		String filePath = fileSeparator + "Users" + fileSeparator + "phuth" + fileSeparator + "OneDrive" + fileSeparator + "Desktop" + fileSeparator + "studentsInfo.txt";
		
		//create the file
		File file = new File(filePath);
		file.createNewFile();
		
		// writing students' info to file
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		PrintWriter outFS = new PrintWriter(filePath);
		
		for (Student student: studentsList) {
			outFS.println(student.toString());
		}
		
		outFS.close();
	}
	
	public static void main(String[] args) {
		LinkedList<Student> studentsList = new LinkedList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		while (!userInput.equals("q")) {
			try {
				System.out.println("Please enter the student's name: ");
				String name = scanner.nextLine();
				
				System.out.println("Please enter the student's address: ");
				String address = scanner.nextLine();
				
				System.out.println("Please enter the student's GPA: ");
				
				// check if user enter a double value
				if (!scanner.hasNextDouble()) {
					throw new InvalidGPAException("Invalid GPA. Please try again.");
				}
				
				double GPA = scanner.nextDouble();
				
				//check GPA for validity
				if (!checkGPA(GPA)) {
					throw new InvalidGPAException("Invalid GPA. Please try again.");
				}
				
				studentsList.add(new Student(name, address, GPA));
				
			} catch (InvalidGPAException error){
				System.out.println(error.getMessage());
			} finally {
				System.out.println("Eter 'c' to continue, or 'q' to quit.");
				//apparently after using nextDouble() or nextInt(),
				// there is still line end character we need to 
				// get rid of, so call next() to clear it
				userInput = scanner.next() + scanner.nextLine();
			}
			
		}
		
		scanner.close();
		
		// sort sudentsList
		Collections.sort(studentsList, new NameComparator());
		
		//write students' info to file
		try {
			writeStudentsInfoToFile(studentsList);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
