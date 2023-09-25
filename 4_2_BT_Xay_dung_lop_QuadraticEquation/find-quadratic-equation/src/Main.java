import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("ax2 + bx + c = 0");
        System.out.println("Input a: ");
        int a = scanner.nextInt();
        System.out.println("Input b: ");
        int b = scanner.nextInt();
        System.out.println("Input c: ");
        int c = scanner.nextInt();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        if (equation.getDiscriminant() > 0) {
            System.out.println("Root 1: " + equation.getRoot1());
            System.out.println("Root 2: " + equation.getRoot2());
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("Root 1 = root 2 = " + equation.getRoot1());
        } else {
            System.out.println("There is no root for this equation");
        }


    }
}