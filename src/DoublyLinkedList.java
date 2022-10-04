import java.util.Objects;

public class DoublyLinkedList {

    private Node head;
    private Node tail;


    private int totalCourses;
    private int studentsPerCourse;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.totalCourses = 0;
        this.studentsPerCourse = 0;
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
    public void insertCourse(String courseNumber, String courseName, int studentsPerCourse) {
        Node newNode = new Node(courseNumber, courseName, studentsPerCourse);
        if(head == null){
            tail=newNode;
            head=newNode;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;

        // Increasing courses total
        totalCourses++;
    }
    // Insert only by course number
    public void insertCourseByNumber(String newCourseNumberInsert) {
        Node newNode = new Node(newCourseNumberInsert);
        if(head==null){
            tail=newNode;
            head=newNode;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;

        // Increasing courses total
        totalCourses++;
    }
    public int getCoursesTotal() {
        return totalCourses;
    }

   // Getting a course that is already in the list
   public boolean getCourseNumber(String newCourseNumberInsert) {
        Node current = head;
        while (current != null) {
            if (current.courseNumber.equals(newCourseNumberInsert)) {
                return true;
            }
            else {
               current=current.next;
            }
       }
       return false;
    }

    // Outputting summary of everything in format required
    public void printCoursesSummary() {
        Node courses = head;
        Node coursesName = head;

        while(courses !=null && coursesName !=null) {
            System.out.println("Course Number: " + courses.courseNumber);
            courses = courses.next;
            System.out.println("Course Name: " + coursesName.courseName);
            coursesName=coursesName.next;
            System.out.println("Number of students enrolled: ");
            // show students per each course
        }
    }

    public Node getTail() {
        return tail;
    }

    public Node getCourse(String courseNumber){
        Node current = head;
        while(!Objects.equals(current.courseNumber, courseNumber)){
            current = current.next;
        }
        return current;
    }

    // No other option but to make Node public, since it needs to be accessed throughout
    // multiple data structures. You fucking suck professor
    public class Node {
        private String courseNumber;
        private String courseName;

        private int studentsPerCourse;

        private Node next;
        private Node prev;
        private SinglyLinkedList.Node theStudent;

        // Default constructor for two inputs
        public Node(String courseNumber, String courseName, int studentsPerCourse){
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.studentsPerCourse = studentsPerCourse;
            this.next = null;
            this.prev = null;
            theStudent = null;
        }
        // Default constructor for one input to check if it exists in list
        public Node(String courseNumber){
            this.courseNumber = courseNumber;
        }
        public SinglyLinkedList.Node getTheStudent() {
            theStudent = theStudent.getHead();
            return theStudent;
        }
    }
}




