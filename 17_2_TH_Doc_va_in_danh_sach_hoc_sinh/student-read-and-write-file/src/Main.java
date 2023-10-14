
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Student> studentsWrite = getStudentExample();
        StudentFileService.writeStudentFile(studentsWrite);

        LinkedList<Student> studentsRead = StudentFileService.readStudentFile();
        studentsRead.forEach(student -> System.out.println(student.toString()));
        System.out.println("Input source file");
        String source = scanner.nextLine();
        System.out.println("Input destination file");
        String dest = scanner.nextLine();
        File sourceFile = new File(source);
        File destinationFile = new File(dest);

        try {
           StudentFileService.copyFileStudent(sourceFile, destinationFile);
            System.out.println("Copy file complete");

        } catch (IOException ioe) {
            System.out.println("Can't copy file");
        }
    }

    private static LinkedList<Student> getStudentExample() {
        LinkedList<Student> studentsWrite = new LinkedList<>();
        studentsWrite.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        studentsWrite.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        studentsWrite.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        studentsWrite.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        studentsWrite.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        return studentsWrite;
    }
}