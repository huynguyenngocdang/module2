import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GFG {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {

        // Declaring the String
        System.out.println("Input string");
        String str = scanner.nextLine();
        // Declaring a HashMap of <String, Integer>
        Map<String, Integer> hashMap = new HashMap<>();

        // Splitting the words of string
        // and storing them in the array.
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        String[] words = str.split("");

        for (String word : words) {

            // Asking whether the HashMap contains the
            // key or not. Will return null if not.
            Integer integer = hashMap.get(word);

            if (integer == null)
                // Storing the word as key and its
                // occurrence as value in the HashMap.
                hashMap.put(word, 1);

            else {
                // Incrementing the value if the word
                // is already present in the HashMap.
                hashMap.put(word, integer + 1);
            }
        }
        System.out.println(hashMap);
    }
}