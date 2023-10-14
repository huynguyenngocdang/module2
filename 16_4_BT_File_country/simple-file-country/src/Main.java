import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        var country1 = new Country(1, "AU", "Australia");
        var country2 = new Country(2, "CN", "China");
        var country3 = new Country(3, "AU", "Australia");
        var country4 = new Country(4, "CN", "China");
        var country5 = new Country(5, "JP", "Japan");
        var country6 = new Country(6, "CN", "China");
        var country7 = new Country(7, "JP", "Japan");
        var country8 = new Country(8, "TH", "Thailand");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LinkedList<Country> llWrite = new LinkedList<>();
        llWrite.add(country1);
        llWrite.add(country2);
        llWrite.add(country3);
        llWrite.add(country4);
        llWrite.add(country5);
        llWrite.add(country6);
        llWrite.add(country7);
        llWrite.add(country8);

        try {
            FileWriter write = new FileWriter("country.json");
            gson.toJson(llWrite, write);
            write.flush();
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileReader reader  = new FileReader("country.json");
            Type countryType = new TypeToken<LinkedList<Country>>(){}.getType();
            LinkedList<Country> llRead = gson.fromJson(reader, countryType);
            llRead.forEach(country -> System.out.println(country.toString()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}