import java.util.Objects;

public class SinglyLinkedList {

    class SingleNode {
        private String iD;
        private String studentsName;
        private String address;
        private String email;
        private SingleNode next;

        public SingleNode(String iD, String studentsName, String address, String email ){
            this.iD = iD;
            this.studentsName = studentsName;
            this.address = address;
            this.email = email;
            next = null;
        }
    }

    // Pointer to first node in doubly linked list
    private DoublyLinkedList.Node tail;
    private SingleNode head;
    private int totalStudents;
    public void setData(String studentNames, String iD, String email, String address) {
        SingleNode newNode = new SingleNode(studentNames, iD, email, address);


        // Increase students total sum
        totalStudents++;
    }
    // Getting total number of students in list
    public int getStudentsTotal() {
        return totalStudents;
    }
    // Delete from list based on ID
    public void deleteId(String iD) {

        SingleNode current = head;
        while (!Objects.equals(current.iD, iD)){
            current=current.next;
        }
        current.iD=null;

        // Decreasing sum of students;
        totalStudents--;
    }
    // Insert into list based on name
    public void insertName(String newStudentsName) {

        // Adding new student to total sum
        totalStudents++;
    }
    // Insert into list based on ID
    public void insertId(String newId) {
    }
    // Insert into list based on address
    public void insertAddress(String newAddress) {
    }
    // Get a student's name that is already in the list
    public void getStudentName(String enrolledStudentName) {
    }
    //  Outputting summary of everything in format required
    public void printCourseSummary(String display) {
    }
}
