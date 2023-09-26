import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Fan fan1 = new Fan("1", "Yellow", 10, 3, true);
    static Fan fan2 = new Fan("2", "Blue", 5, 2, false);
    static List<Fan> fanList = new ArrayList<>();
    
    public static void main(String[] args) {
        fanList.add(fan1);
        fanList.add(fan2);

        int numberFan = fanList.size();
        System.out.printf("Select fan (%d - %d)", 0, numberFan - 1);
        int id = scanner.nextInt();
        selectMenu(id);
    }

    private static void selectMenu(int id) {
        int choice;
        String selectColor;
        int selectRadius;
        int selectSpeed;
        do {
            System.out.println("Selecting fan " + id);
            choice = displayMenu();
            switch (choice) {
                case 1:
                    System.out.println(getInfo(id));
                    break;
                case 2:
                    System.out.println("""
                            Selecting speed
                            1. Slow
                            2. Medium
                            3. High
                            """);
                    selectSpeed = scanner.nextInt();
                    setFanSpeed(id, selectSpeed);
                    break;
                case 3:
                    System.out.println("Input new color");
                    selectColor = scanner.next();
                    setFanColor(id, selectColor);
                    break;
                case 4:
                    System.out.println("Input new radius");
                    selectRadius = scanner.nextInt();
                    setFanRadius(id, selectRadius);
                    break;
                case 5:
                    turnFan(id);
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;

            }
        } while (choice != 0);
    }

    private static int displayMenu() {
        System.out.println("1. Get info");
        System.out.println("2. Set fan speed");
        System.out.println("3. Set fan color");
        System.out.println("4. Set fan radius");
        System.out.println("5. Turn fan on/off");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    private static String getInfo(int id) {
        return fanList.get(id).getFanInfo();
    }

    private static void setFanSpeed(int id, int speed) {
        fanList.get(id).speed = speed;
    }

    private static void setFanColor(int id, String color) {
        fanList.get(id).color = color;
    }

    private static void setFanRadius(int id, int radius) {
        fanList.get(id).radius = radius;
    }

    private static void turnFan(int id) {
        fanList.get(id).status = !fanList.get(id).status;
    }
}