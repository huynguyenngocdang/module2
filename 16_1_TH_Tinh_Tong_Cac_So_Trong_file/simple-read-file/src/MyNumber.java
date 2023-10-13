import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyNumber {
    public static void main(String[] args) {
        int[] numbers = {5,3,6,1,8};

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("numbers.json");
            gson.toJson(numbers, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileReader reader = null;
        try {
            reader = new FileReader("numbers.json");
            int[] numbersRead = gson.fromJson(reader, int[].class);
            for (int number: numbersRead
                 ) {
                System.out.println(number);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
