import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class MyNumber {
    public static void main(String[] args) {
        int[] numbers = {9,5,4,2,15,3,6};
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("number.json");
            gson.toJson(numbers, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileReader reader = null;
        try {
            reader = new FileReader("number.json");
            Integer[] numbersRead = gson.fromJson(reader, Integer[].class);
            Arrays.sort(numbersRead, Collections.reverseOrder());

//            for (int number: numbersRead
//                 ) {
//                System.out.println(number);
//            }
            System.out.println(numbersRead[0]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
