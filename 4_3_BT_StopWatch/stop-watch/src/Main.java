import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;
        long elapsed = 0;
        int choice;
        StopWatch stopWatch = new StopWatch(0, 0, false);
        do {
            System.out.println("""
                            \n1. Start stopwatch
                            2. End stopwatch
                            3. Get elapsed time
                            0. Exit
                             """
                    );
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    stopWatch.start();
                    System.out.println("Stop watch start");
                    break;
                case 2:
                    stopWatch.end();
                    System.out.println("Stop watch end");
                    break;
                case 3:
                    elapsed = stopWatch.getElapsedTime();
                    System.out.println("Time elapsed: " + elapsed);
//                    stopWatch.startTime = 0;
//                    stopWatch.endTime = 0;
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (choice != 0);

    }
}