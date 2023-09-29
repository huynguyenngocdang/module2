import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Student student1 = new Student("John", "CO7");
    static Student student2 = new Student("Marry", "C07");
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        studentList.add(student1);
        studentList.add(student2);
        DisplayMenu.displayMenu();

    }

}