import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Student> studentLinkedList = new LinkedList<>();
    public void enqueueStudent(Student student) {
        studentLinkedList.addLast(student);

    }
    public void sortStudentByDob() {
        studentLinkedList.sort((d1, d2) -> d2.getDobDate().compareTo(d1.getDobDate()));
    }
    public Student dequeueStudent() {
        return  studentLinkedList.remove(0);
    }

    public LinkedList<Student> getStudentLinkedList() {
        return studentLinkedList;
    }


}
