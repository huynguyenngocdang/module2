import java.util.Scanner;

public class Navigate {
    static Scanner scanner = new Scanner(System.in);
    static Console console = new Console();
    public static void navigateFirstMenu(StudentList studentList) {
        int choiceFirstMenu;

        console.studentMenu();
        do {

            choiceFirstMenu = scanner.nextInt();
            switch (choiceFirstMenu) {
                case 1:
                    console.displayStudentList(studentList);
                    navigateSelectedStudent();
                    break;
                case 2:

                    setNewStudentData();
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (choiceFirstMenu != 0);
    }

    private static void setNewStudentData() {
        System.out.println("Create new student");
        console.setNewNameConsole();
        String newStudentName = scanner.next();
        console.setNewClassesConsole();
        String newStudentClasses = scanner.next();
        Main.studentList.add(newStudentName, newStudentClasses);
        navigateFirstMenu(Main.studentList);
    }


    private static void navigateSelectedStudent() {
        int index = scanner.nextInt() - 1;
        console.displaySelectedStudentList(index);
        console.changeStudentData();
        int choiceSecond = scanner.nextInt();
        switch (choiceSecond) {
            case 1:
                console.setNewNameConsole();
                Main.studentList.getStudentLists(index).setName(scanner.next());
                navigateFirstMenu(Main.studentList);
                break;
            case 2:
                console.setNewClassesConsole();
                Main.studentList.getStudentLists(index).setClasses(scanner.next());
                navigateFirstMenu(Main.studentList);
                break;
            case 0:
                navigateFirstMenu(Main.studentList);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

    }

}
