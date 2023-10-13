import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var student1 = new Student("Huy", 30, "C08");
        var student2 = new Student("Son", 25, "C08");
        var student3 = new Student("Man", 18, "C09");
        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        //create my GSON object;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //convert Json
//        String myJson = gson.toJson(student1);
//        System.out.println(myJson);
        //Write file
        try {
            FileWriter writer = new FileWriter("student.json");
            gson.toJson(students, writer);

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Read from file

        try {

            FileReader reader = new FileReader("student.json");
            Type studentType = new TypeToken<LinkedList<Student>>(){}.getType();
            LinkedList<Student> simpleStudentLinkedList = gson.fromJson(reader, studentType);
            for (Student student: simpleStudentLinkedList) {
                System.out.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}