import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

public class StudentFileService {
    public static LinkedList<Student> readStudentFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("student.json");
            Type typeStudent = new TypeToken<LinkedList<Student>>() {
            }.getType();
            LinkedList<Student> studentsRead = gson.fromJson(reader, typeStudent);
            return  studentsRead;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeStudentFile(LinkedList<Student> studentsWrite) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("student.json");
            gson.toJson(studentsWrite, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
    public static void copyFileStudent(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
