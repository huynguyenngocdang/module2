import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Create a circle");
        double radius = scanner.nextDouble();
        Circle thisCircle = new Circle(radius);
        System.out.println("This radius: " + thisCircle.getRadius());
        System.out.println("This color: " + thisCircle.color);
        System.out.println("This area: " + thisCircle.getArea());
    }
}