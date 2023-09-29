import java.util.ArrayList;
import java.util.List;

public class StudentList {
    static Student student1 = new Student("John", "CO7");
    static Student student2 = new Student("Marry", "C07");
    List<Student> studentLists = new ArrayList<>();
    public StudentList() {
        this.studentLists = studentLists;
        this.studentLists.add(student1);
        this.studentLists.add(student2);
    }

    public Student getStudentLists(int index) {
        return studentLists.get(index);
    }
//    public void setStudentListsName(int index, String newName) {
//        getStudentLists(index).setName(newName);
//    }
//
//    public void setStudentListsClasses(int index, String newClasses) {
//        studentLists.get(index).setClasses(newClasses);
//    }

    public void add(String newName, String newClasses) {
        studentLists.add(new Student(newName,newClasses));
    }
}
