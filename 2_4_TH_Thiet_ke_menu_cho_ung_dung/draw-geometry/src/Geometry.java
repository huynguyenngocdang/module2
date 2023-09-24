import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = printMenu();
        String result = choiceInput(choice);
        System.out.println(result);

    }

    private static int printMenu() {
        int choice;
        var input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        return choice;
    }

    private static String choiceInput( int choice) {
        String result;
        var input = new Scanner(System.in);
        int width;
        int height;
        switch (choice) {
            case 1:
                System.out.println("Draw the triangle");
                System.out.println("Input width");
                width = input.nextInt();
                result = drawTriangle(width);
                break;
            case 2:
                System.out.println("Draw the square");
                System.out.println("Input width");
                width = input.nextInt();
                result = drawSquare(width);
                break;

            case 3:
                System.out.println("Draw the rectangle");
                System.out.println("Input width");
                width = input.nextInt();
                System.out.println("Input height");
                height = input.nextInt();
                result = drawRectangle(width, height);
                break;
            case 0:
                System.out.println("Exit");

                result = "Exiting";
                break;
            default:
                result = "No choice!";
                break;
        }
        return  result;
    }

    private static String drawTriangle(int w) {
        String result = "";
        for (int i = 0; i < w; i++) {
            for (int j = w - i; j > 0; j--) {
                result += "*";
            }
            result += "\n";
        }
        return  result;
    }

    private static String drawSquare(int w) {
        String result = "";
        for (int i = 0; i < w; i++) {
            for (int j = w; j > 0; j--) {
                result += "*" + "  ";
            }
            result += "\n";
        }
        return  result;
    }

    private static String drawRectangle(int w, int h) {
        String result = "";
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result += "*" + "  ";
            }
            result += "\n";
        }
        return  result;
    }

}
