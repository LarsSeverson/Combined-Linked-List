import java.util.Objects;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int totalCourses;
    private static int totalStudentCount;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.totalCourses = 0;
        totalStudentCount = 0;
    }
    // Delete course by course number
    public void deleteCourse(String courseNumber) {
        Node current = head;
        while (!Objects.equals(current.courseNumber, courseNumber)){
            current=current.next;
        }
        current.courseNumber=null;
        current.courseName=null;

        // Decreasing courses total
        totalCourses--;
    }
    // Insert by course and course name
    public void setData(String courseNumber, String courseName, int studentsPerCourse
    ,String studentNames, String iD, String email, String address) {

        Node newNode = new Node(courseNumber, courseName, studentsPerCourse,
                studentNames, iD, email, address);

        if(head == null){
            tail=newNode;
            head=newNode;
            totalCourses++;
            totalStudentCount++;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;

        // Increasing courses total
        totalCourses++;
        totalStudentCount++;
    }

    public int getCoursesTotal() {
        return totalCourses;
    }
    public static int getTotalStudentCount() {
        return totalStudentCount;
    }
    public static void minusStudentCount(){
        totalStudentCount--;
    }
    // Getting a course that is already in the list
   public boolean found(String course) {
        Node current = head;
        while(current != null){
            if (current.courseNumber.equals(course)){
                return true;
            }
            else {
                current = current.next;
            }
        }
        return false;
    }

    // Outputting summary of everything in format required
    public void printCoursesSummary() {
        Node current = head;
        while(current != null){
            System.out.println("Course Number:" + current.courseNumber);
            System.out.println("Course Name:" + current.courseName);
            System.out.println("Number of students enrolled: " + current.studentsPerCourse);
            current = current.next;
        }
    }
    public void addStudentToCourse(String name, String courseNumber, String studentID, String studentAdress) {
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseNumber)){
            current = current.next;
        }
        current.students.addNewStudentToCourse(name, studentID, studentAdress);
        current.studentsPerCourse++;
    }
    public void dropStudentFromCourse(String studentName, String courseToDrop, String studentID){
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseToDrop)){
            current = current.next;
        }
        current.students.deleteStudent(studentName, studentID);
        current.studentsPerCourse--;
    }

    private class Node {
        private String courseNumber;
        private String courseName;

        private int studentsPerCourse;
        private Students students;

        private Node next;
        private Node prev;

        // Default constructor for two inputs
        public Node(String courseNumber, String courseName, int studentsPerCourse,
                    String studentNames, String iD, String email, String address){
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.studentsPerCourse = studentsPerCourse;
            this.next = null;
            this.prev = null;

            students = new Students(studentNames, iD, email, address);
        }
    }
}




