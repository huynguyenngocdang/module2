import java.util.Scanner;

public class ShowGeometry {
    public static void main(String[] args) {
        int menuChoiceInput = menuPrint();
        String result = menuChoice(menuChoiceInput);
        System.out.println(result);
    }

    private static int menuPrint() {
        int menuChoice;
        var scanner = new Scanner(System.in);
        System.out.println("Choose the following");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)");
        System.out.println("3. Print isosceles triangle");
        menuChoice = scanner.nextInt();
        return menuChoice;
    }

    private static String menuChoice(int choice) {
        String result = "";
        var scanner = new Scanner(System.in);
        int width;
        int height;
        switch (choice) {
            case 1:
                System.out.println("--------");
                System.out.println("Print the rectangle");
                System.out.println("Input width: ");
                width = scanner.nextInt();
                System.out.println("Input height: ");
                height = scanner.nextInt();
                result = drawRectangle(width, height);
                break;
            case 2:
                System.out.println("--------");
                System.out.println("Print the square triangle");
                System.out.println("Input width: ");
                width = scanner.nextInt();
                result += "Top left \n";
                result += drawSquareTriangleTopLeft(width);
                result += "\n";
                result += "Top right \n";
                result += drawSquareTriangleTopRight(width);
                result += "\n";
                result += "Bottom left \n";
                result += drawSquareBottomLeft(width);
                result += "\n";
                result += "Bottom right \n";
                result += drawSquareBottomRight(width);
                break;
            case 3:
                System.out.println("--------");
                System.out.println("Print isosceles triangle");
                System.out.println("Input width: ");
                width = scanner.nextInt();
                result += "Isosceles triangle \n";
                result += drawPyramid(width);
                result += "\n";
                result += "Reverted Isosceles triangle \n";
                result += drawInvertedPyramid(width);
                break;

            default:
                result = "Invalid input";
                break;
        }
        return result;
    }

    private static String drawRectangle(int w, int h) {
        String result = "";
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result += "*" + " ";
            }
            result += "\n";
        }
        return result;
    }

    private static String drawSquareTriangleTopLeft(int w) {
        String result = "";
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w - i; j++) {
                result += "*";
            }
            result += "\n";
        }
        return result;
    }

    private static String drawSquareTriangleTopRight(int w) {
        String result = "";
        for (int i = 0; i < w; i++) {

            for (int k = 0; k < i; k++) {
                result += " ";
            }

            for (int j = 0; j < w - i; j++) {
                result += "*";
            }

            result += "\n";
        }
        return result;
    }

    private static String drawSquareBottomLeft(int w) {
        String result = "";
        for (int i = 1; i <= w; i++) {

            for (int j = 0; j < i; j++) {
                result += "*";
            }

            result += "\n";
        }
        return result;
    }

    private static String drawSquareBottomRight(int w) {
        String result = "";
        for (int i = 1; i <= w; i++) {
            for (int k = 0; k < w - i; k++) {
                result += " ";
            }

            for (int j = 0; j < i; j++) {
                result += "*";
            }

            result += "\n";
        }
        return result;
    }

    private static String drawPyramid(int w) {
        String result = "";
        for (int i = 1; i <= w; i++) {
            for (int k = 0; k < w - i; k++) {
                result += " ";
            }

            for (int j = 0; j < i; j++) {
                result += "*" + " ";
            }

            result += "\n";
        }
        return result;
    }

    private static String drawInvertedPyramid(int w) {
        String result = "";
        for (int i = 0; i < w; i++) {
            for (int k = 0; k < i; k++) {
                result += " ";
            }

            for (int j = 0; j < w - i; j++) {
                result += "*" + " ";
            }

            result += "\n";
        }
        return result;
    }
}
