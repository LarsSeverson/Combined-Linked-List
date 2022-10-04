import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	  public static void main(String[] args) {

		  Scanner input = new Scanner(System.in);
		  Scanner secondInput = new Scanner(System.in);

		  DoublyLinkedList doubly = new DoublyLinkedList();
		  SinglyLinkedList singly = new SinglyLinkedList();

		  try {
			  // Inputting text file and separating it by commas
			  BufferedReader textInput = new BufferedReader(
					  new FileReader("inputFile.txt"));

			  String str;
			  int i = 1;
			  while ((str = textInput.readLine()) != null) {
				  if (i > 1) {
					  String[] values = str.split(",");

					// Setting course number and course names for doubly linked list
					  doubly.setData(values[0], values[1]);

					  // Getting student names, ID, email, address for singly linked list
					  singly.setData((values[3]).replaceAll("\\s", "") + " " + (values[2]), values[4], values[5], values[6]);

					  //studentNames();
					  // Getting emails
					  //emails(values[5]);
					  // Getting addresses
					  //addresses(values[6]);
				  }
				  i++;
			  }
				  System.out.print("1. Read the input data\n" +
						  "2. Delete a course\n" +
						  "3. Insert a new course\n" +
						  "4. Delete a student\n" +
						  "5. Insert a new student\n" +
						  "6. Transfer a student from one course to another\n" +
						  "7. Display the course list\n" +
						  "8. Display the student list\n" +
						  "9. Exit\n");
				  	int firstOptions = input.nextInt();
				  switch (firstOptions) {
					  case 1:
						  System.out.println("Input file is read successfully...");
						  System.out.println("Summary of the record:");
						  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
						  System.out.println("Number of total students: " + singly.getStudentsTotal());
						  while (true) {
							/*
								System.out.print(
									  "2. Delete a course\n" +
									  "3. Insert a new course\n" +
									  "4. Delete a student\n" +
									  "5. Insert a new student\n" +
									  "6. Transfer a student from one course to another\n" +
									  "7. Display the course list\n" +
									  "8. Display the student list\n" +
									  "9. Exit\n");
							 */
							  int secondOptions = secondInput.nextInt();
							  switch (secondOptions) {
								  case 2:
									  System.out.print("Enter the course number to delete: ");
									  // Getting course number to delete
									  Scanner delete = new Scanner(System.in);
									  String courseToDelete = delete.nextLine();

									  // doubly linked list delete method
									  doubly.deleteCourse(courseToDelete);

									  System.out.println("Summary of the record:");
									  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
									  System.out.println("Number of total students: " + singly.getStudentsTotal());
									  break;
								  case 3:
									  Scanner inputOne = new Scanner(System.in);
									  Scanner inputTwo = new Scanner(System.in);
									  System.out.print("Enter the new course number to add: ");
									  String courseNumber = inputOne.nextLine();
									  System.out.print("Enter the new course name: ");
									  String courseName = inputTwo.nextLine();

									  //doubly linked list to add method
									  doubly.insertCourse(courseNumber, courseName);

									  System.out.println("Summary of the record: ");
									  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
									  System.out.println("Number of total students: " + singly.getStudentsTotal());
									  break;
								  case 4:
									  Scanner inputId= new Scanner(System.in);
									  Scanner inputCourseNumber = new Scanner(System.in);
									  System.out.print("Enter the student ID number to delete: ");
									  String iD = inputId.nextLine();
									  singly.deleteId(iD);
									  System.out.print("Enter the course number from which the student is to be dropped from: ");
									  String courseNumberInput = inputCourseNumber.nextLine();
									  doubly.deleteCourse(courseNumberInput);
									  System.out.println("Summary of the record: ");
									  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
									  System.out.println("Number of total students: " + singly.getStudentsTotal());
									  break;
								  case 5:
									  Scanner newCourseNumber = new Scanner(System.in);
									  Scanner newStudentName = new Scanner(System.in);
									  Scanner newStudentAddress = new Scanner(System.in);
									  Scanner newStudentId = new Scanner(System.in);
									  System.out.print("Enter the course number the student wants to enroll to: ");
									  String newCourseNumberInsert = newCourseNumber.nextLine();
									  if (doubly.getCourseNumber(newCourseNumberInsert)){
										  System.out.print("Enter the student's name: ");
										  String newStudentsName = newStudentName.nextLine();
										  singly.insertName(newStudentsName);
										  System.out.print("Enter the student's ID: ");
										  String newId = newStudentId.nextLine();
										  singly.insertId(newId);
										  System.out.print("Enter the student's emergency contact address: ");
										  String newAddress = newStudentAddress.nextLine();
										  singly.insertAddress(newAddress);
								  		} else {
										  System.out.println("Course does not exist...");
									  }
									  System.out.println("Summary of the record: ");
									  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
									  System.out.println("Number of total students: " + singly.getStudentsTotal());
									  break;
								  case 6:
									  Scanner enrolledStudent = new Scanner(System.in);
									  Scanner enrolledCourseNumber = new Scanner(System.in);
									  Scanner newCourseNumberToEnroll = new Scanner(System.in);
									  System.out.print("Enter student's name: ");
									  String enrolledStudentName = enrolledStudent.nextLine();
									  if (singly.getStudentsName(enrolledStudentName)){
										  System.out.print("Enter the course number the student wants to dropped from: ");
										  String enrolledCourseToDrop = enrolledCourseNumber.nextLine();
										  doubly.deleteCourse(enrolledCourseToDrop);
										  System.out.print("Enter the course number the student wants to enrolled to: ");
										  String newCourseToEnroll = newCourseNumberToEnroll.nextLine();
										  doubly.insertCourseByNumber(newCourseToEnroll);
									  } else {
										  System.out.println("Student does not exist...");
									  }
									  System.out.println("Summary of the record: ");
									  System.out.println("Number of courses registered: " + doubly.getCoursesTotal());
									  System.out.println("Number of total students: " + singly.getStudentsTotal());
									  break;
								  case 7:
									  System.out.println("The list of courses registered are as follows: ");
									  doubly.printCoursesSummary();
									  break;
								  case 8:
									  Scanner displayStudents = new Scanner(System.in);
									  System.out.print("Enter the course number: ");
									  String display = displayStudents.nextLine();
									  System.out.println("The list of students enrolled in the course " + display + "are as follows: ");
									  singly.printCourseSummary(display);
									  break;
								  case 9:
									  System.out.println("Exiting program...");
									  System.exit(1);
							  }
						  }
					  case 9:
						  System.out.println("Exiting program...");
						  System.exit(1);
				  }

			  } catch(IOException e){
				  // TODO Auto-generated catch block
				  System.out.println(e);
			  }
		  }
	  }


