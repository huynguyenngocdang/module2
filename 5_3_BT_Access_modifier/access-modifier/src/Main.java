import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Create a circle");
        double radius = scanner.nextDouble();
        Circle testCircle = new Circle(radius);
        System.out.println("This radius: " + testCircle.getRadius());
        System.out.println("This color: " + testCircle.getColor());
        System.out.println("This area: " + testCircle.getArea());
    }
}