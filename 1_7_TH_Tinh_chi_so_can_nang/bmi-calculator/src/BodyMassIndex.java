import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input body weight: ");
        double weight = scanner.nextDouble();

        System.out.println("Input body height");
        double height = scanner.nextDouble();

        double bmi = weight / Math.pow(height, 2);
        String result;
        if (bmi < 18.5) {
            result = "Underweight";
        } else if (bmi < 25) {
            result = "Normal";
        } else if (bmi < 30) {
            result = "Overweight";
        } else {
            result = "Obese";
        }
        System.out.printf("%.2f kg, %.2f m, BMI %.2f, is %s ", weight, height, bmi, result);
    }
}
