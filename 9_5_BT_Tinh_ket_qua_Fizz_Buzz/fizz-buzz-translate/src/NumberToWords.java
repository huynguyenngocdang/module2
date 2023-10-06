import java.util.Scanner;

public class NumberToWords {
    private static String[] numNames = {"", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin", "muoi"};
    private static String word = "";

    public static String translate (int number) {

         int numberConvert = number;
        if (numberConvert > 999) {
            return "Out of bound";
        }
        if (numberConvert % 100 <= 10) {
            word =numNames[numberConvert % 100];
            numberConvert /= 100;
        } else{
            word = numNames[numberConvert % 10];
            numberConvert /=10;
            word =numNames [numberConvert % 10] + " muoi " + word;
            numberConvert /= 10;

        }
            if (numberConvert == 0) {
                return  word;
            } else {
                return numNames[numberConvert] + " tram " + word;
            }
    }


}
