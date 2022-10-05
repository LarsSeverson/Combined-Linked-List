import java.util.Objects;

public class Students {
    private Student head = null;

    Students(String studentNames, String iD, String email, String address){
        setData(studentNames, iD, email, address);
    }

    public void setData(String studentNames, String iD, String email, String address) {
        Student newNode = new Student(studentNames, iD, email, address);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        // Increase students total sum
    }

    // Delete from list based on ID
    public void deleteId(String iD) {
        Student current = head;
        while (!Objects.equals(current.iD, iD)){
            current=current.next;
        }
        current.iD = null;

        // Decreasing sum of students
        DoublyLinkedList.minusStudentCount();
    }
    public void deleteStudent(String name){
        Student current = head;
        Student prev = head;
        while(current.studentsName != name){
            prev = current;
            current = current.next;
        }
        prev.next = prev.next.next;
    }
    // Get a student's name that is already in the list return true
    public boolean getStudentsName(String enrolledStudentName) {
        Student current = head;
        while (current != null) {
            if (current.studentsName.equals(enrolledStudentName)) {
                return true;
            }
            current = current.next;
        }
        System.out.println("Not found");
        return false;
    }

    public void addNewStudentToCourse(String newStudentsName, String studentID, String studentAddress) {
        Student newStudent = new Student(newStudentsName, studentID, "", studentAddress);
        newStudent.next = head;
        head = newStudent;
    }

    public class Student {
        private String iD;
        private String studentsName;
        private String address;
        private String email;
        private Student next;

        public Student(String studentsName, String iD, String email, String address){
            this.iD = iD;
            this.studentsName = studentsName;
            this.address = address;
            this.email = email;
            this.next = null;
        }
    }
}
