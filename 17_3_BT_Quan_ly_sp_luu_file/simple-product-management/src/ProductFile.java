import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class ProductFile {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void productFileSave(LinkedList<Product> llProductsWrite){
        try {
            FileWriter writer = new FileWriter("product.json");
            gson.toJson(llProductsWrite, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Can't save file");
            System.out.println(ioe.getMessage());
        }
    }
    public static LinkedList<Product> productFileGet() {
        try{
            FileReader reader = new FileReader("product.json");
            Type typeProduct = new TypeToken<LinkedList<Product>>(){}.getType();
            return gson.fromJson(reader, typeProduct);

        } catch (FileNotFoundException fnf) {
            System.out.println("Can't get file");
            System.out.println(fnf.getMessage());
        }
        return null;
    }

}
