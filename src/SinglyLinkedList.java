import java.util.Objects;

public class SinglyLinkedList {

    class SingleNode {
        private String iD;
        private String studentsName;
        private String address;
        private String email;
        private SingleNode next;

        public SingleNode(String studentsName, String iD, String email, String address){
            this.iD = iD;
            this.studentsName = studentsName;
            this.address = address;
            this.email = email;
            this.next = null;
        }
    }

    private SingleNode head;
    private int totalStudents;
    public void setData(String studentNames, String iD, String email, String address) {
        SingleNode newNode = new SingleNode(studentNames, iD, email, address);
        if (head == null) {
            head = newNode;
            totalStudents++;
            return;
        }
        newNode.next=head;
        head = newNode;

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
        this.id = newId;
    }
    // Insert into list based on address
    public void insertAddress(String newAddress) {
        this.address = newAddress;
    }
    // Get a student's name that is already in the list return true

    public boolean getStudentsName(String enrolledStudentName) {
        SingleNode current=head;
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
}
