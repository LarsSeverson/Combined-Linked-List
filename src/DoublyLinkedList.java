import java.util.Objects;

public class DoublyLinkedList {
    class Node {
        private String courseNumber;
        private String courseName;
        public Node studentList;
        private Node next;
        private Node prev;

        // Pointer to first node in singly linked list
        private SinglyLinkedList.SingleNode firstNode;

        public Node(String courseNumber, String courseName ){
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            next = null;
            prev = null;
            firstNode = null;
        }
    }

    // DoublyLinked List
    private Node head;
    private Node tail;
    // private SinglyLinkedList.SingleNode tail;
    private int totalCourses;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.totalCourses = 0;
    }
    // Delete course by course number
    public void deleteCourse(String courseNumber) {
        Node current = head;
        while (!Objects.equals(current.courseNumber, courseNumber)){
            current=current.next;
        }
        current.courseNumber=null;

        // Decreasing courses total
        totalCourses--;
    }
    // Insert by course and course name
    public void insertCourse(String courseNumber, String courseName) {
        Node current = head;


        // Increasing courses total
        totalCourses++;
    }
    // Insert only by course number
    public void insertCourseByNumber(String newCourseNumberInsert) {
    }
    public void setData(String courseNumber, String courseName) {
        Node newNode = new Node(courseNumber, courseName);
        if (head==null){
            head=newNode;
            head.prev=null;
            totalCourses++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;

        // Increase courses and students total
        totalCourses++;
    }
    public void printCourses(){
        Node current = head;
        while(current!=null){

            System.out.println("Course Number: " + current.courseNumber);
            current=current.next;
        }
    }
    public int getCoursesTotal() {
        return totalCourses;
    }

   // Getting a course that is already in the list
    public void getCourseNumber(String newCourseNumberInsert) {
    }
    // Outputting summary of everything in format required
    public void printCoursesSummary() {
    }
}



