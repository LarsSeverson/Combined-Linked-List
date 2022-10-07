import java.util.Objects;

public class Students {
    private Student head = null;

    Students(){

    }
    public void setData(String studentNames, String iD, String email, String address) {
        Student newNode = new Student(studentNames, iD, email, address);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void deleteStudent(String name, String ID){
        Student current = head;
        Student prev = head;
        if (Objects.equals(head.studentsName, name) || Objects.equals(head.iD, ID)){
            head = head.next;
            return;
        }
        while(current != null){
            if (Objects.equals(current.studentsName, name) || Objects.equals(current.iD, ID)){
                break;
            }
            prev = current;
            current = current.next;
        }
        prev.next = prev.next.next;
    }
    public void displayInfo(){
        Student current = head;
        while(current != null){
            System.out.print(current.iD + "\t" + current.studentsName
            + "\t" + current.email + "\t" + current.address);
            current = current.next;
            System.out.println();
        }
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
