public class CreateNewStudent {
    public static void createNewStudent() {
        String newStudentClass;
        String newStudentName;
        System.out.println("Input student name");
        newStudentName = Main.scanner.next();

        System.out.println("Input student class");
        newStudentClass = Main.scanner.next();
        Main.studentList.add(new Student(newStudentName, newStudentClass));
    }
}
