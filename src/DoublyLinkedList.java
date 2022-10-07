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
        if(Objects.equals(head.courseNumber, courseNumber)){
            head = head.next;
            return;
        }

        while (!Objects.equals(current.courseNumber, courseNumber)){
            current=current.next;
        }
        if (current.next == null){
            current.prev = tail;
            totalCourses--;
            return;
        }
        current.next.prev = current.prev;
        current.prev.next = current.next;
        // Decreasing courses total
        totalCourses--;
    }
    public void addCourse(String courseNUmber, String courseName){
        if (found(courseNUmber)){
            return;
        }
        Node newNode = new Node(courseNUmber, courseName);
        if (head == null){
            tail = newNode;
            head = newNode;
            totalCourses++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        totalCourses++;
    }

    public int getCoursesTotal() {
        return totalCourses;
    }
    public static int getTotalStudentCount() {
        return totalStudentCount;
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
    public void addStudentToCourse(String name, String courseNumber, String studentID, String studentAdress, String email) {
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseNumber)){
            current = current.next;
        }
        current.students.setData(name, studentID, email, studentAdress);
        current.studentsPerCourse++;
        totalStudentCount++;
    }
    public void dropStudentFromCourse(String studentName, String courseToDrop, String studentID){
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseToDrop)){
            current = current.next;
        }
        current.students.deleteStudent(studentName, studentID);
        current.studentsPerCourse--;
    }
    public void displayCourseInfo(String courseNumber){
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseNumber)){
            current = current.next;
        }
        System.out.println();
        System.out.println("Students ID      Students Name     Email      Address");
        current.students.displayInfo();
    }

    private class Node {
        private String courseNumber;
        private String courseName;

        private int studentsPerCourse;
        private Students students;

        private Node next;
        private Node prev;

        // Default constructor for two inputs
        public Node (String courseNumber, String courseName){
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            students = new Students();
        }
    }
}




