import java.util.Scanner;

public class Console {

    public static void displaySelectedStudentList(int index) {
        System.out.println("Selecting " + (index +1) + " " + Main.studentList.getStudentLists(index).getName());
    }
    public void studentMenu() {
        System.out.println("""
                    1. Select student
                    2. Create new student
                    0. Exit            
                    """);
    }

    public void changeStudentData() {
        System.out.println("""
                1. Change Name
                2. Change Classes
                0. Exit""");
    }
    public void setNewNameConsole(){
        System.out.println("Set new name");
    }
    public void setNewClassesConsole(){
        System.out.println("Set new classes");
    }
    public void displayStudentList(StudentList studentList) {
        for (int i = 0; i < studentList.studentLists.size(); i++) {
            System.out.println((i+1)+ ". " + studentList.getStudentLists(i).getName() + "\t" + studentList.getStudentLists(i).getClasses());
        }
    }
}
