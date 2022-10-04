import java.util.Objects;

public class SinglyLinkedList {
    private Node head;
    private int totalStudents;

    SinglyLinkedList(){
        head = null;
        totalStudents = 0;
    }

    public void setData(String studentNames, String iD, String email, String address) {
        Node newNode = new Node(studentNames, iD, email, address);
        newNode.next = head;
        head = newNode;
        // Increase students total sum
        totalStudents++;
    }

    // Delete from list based on ID
    public void deleteId(String iD) {
        Node current = head;
        while (!Objects.equals(current.iD, iD)){
            current=current.next;
        }
        current.iD = null;

        // Decreasing sum of students;
        totalStudents--;
    }

    // Get a student's name that is already in the list return true
    public boolean getStudentsName(String enrolledStudentName) {
        Node current=head;
        while (current != null) {
            if (current.studentsName.equals(enrolledStudentName)) {
                return true;
            } else {
                current=current.next;
            }
        }
        return false;
    }
    public void printStudentsTotal() {
        System.out.println(totalStudents);
        System.out.println();
    }
   /* public void printStudentsNames() {
        SingleNode studentNames = head;
        while(studentNames != null){
            System.out.println("Course Number: " + studentNames.studentsName);
            studentNames = studentNames.next;
        }
    }

    */
    //  Outputting summary of everything in format required
    public void printCourseSummary(String display) {
    }

    // Getting total number of students in list
    public int getStudentsTotal() {
        return totalStudents;
    }

    public void insertId(String newId) {
    }

    public void insertAddress(String newAddress) {
    }

    public void setName(String newStudentsName) {

        // Adding new student to total sum
        totalStudents++;
    }

    public class Node {
        private String iD;
        private String studentsName;
        private String address;
        private String email;
        private Node next;

        public Node(String studentsName, String iD, String email, String address){
            this.iD = iD;
            this.studentsName = studentsName;
            this.address = address;
            this.email = email;
            this.next = null;
        }
        public Node getHead() {
            return head;
        }
    }
}
