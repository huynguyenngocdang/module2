public class DisplayMenu {
    public static void displayMenu() {
        int choiceFirst;
        String newStudentName;
        String newStudentClass;
        do {
            System.out.println("""
                    1. Select student
                    2. Create new student
                    0. Exit
                    """);
            choiceFirst = Main.scanner.nextInt();
            switch (choiceFirst) {
                case 1:
                    DisplayStudent.displayStudent();
                    break;

                case 2:
                    CreateNewStudent.createNewStudent();
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (choiceFirst != 0);
    }

    public static class DisplayStudent {
        public static void displayStudent() {
            int size = Main.studentList.size();
            System.out.println("Select from the list of student");
            for (int i = 0; i < Main.studentList.size(); i++) {
                System.out.println((i + 1) + ". " + Main.studentList.get(i).getName() + "\t" + Main.studentList.get(i).getClasses());
            }
            int selectStudent = Main.scanner.nextInt() - 1;

            selectedStudent(selectStudent);

        }

        public static void selectedStudent(int selectStudent) {
            int thisSelect;
            do {
                System.out.println("Selecting " + (selectStudent + 1) + " "
                        + Main.studentList.get(selectStudent).getName()
                        + "\t" + Main.studentList.get(selectStudent).getClasses());
                System.out.println("""
                        1. Set new name
                        2. Set new class
                        0. Exit
                        """);
                thisSelect = Main.scanner.nextInt();
                switch (thisSelect) {
                    case 1:
                        System.out.println("Input new name");
                        Main.studentList.get(selectStudent).setName(Main.scanner.next());
                        break;
                    case 2:
                        System.out.println("Input new class");
                        Main.studentList.get(selectStudent).setClasses(Main.scanner.next());
                        break;
                    case 0:
                        System.out.println("Exiting set student name/class");
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } while (thisSelect != 0);
        }
    }
}
