import java.util.Scanner;

public class StudentArray {
    static Scanner scanner = new Scanner(System.in);
    static final String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
    public static void main(String[] args) {
        System.out.println("Enter a student name");
        String inputName = scanner.next();
        if ( isExist(inputName)) {
            System.out.printf("Student %s exist at index %d", inputName, indexExist(inputName));
        } else {
            System.out.printf("Student %s don't exist in array", inputName);
        }
    }

    private static boolean isExist (String input) {
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input)  ) {
                isExist =  true;
                break;
            }
        }
        return  isExist;
    }

    private static int indexExist (String input) {
        int i = -1;
        for (i = 0; i < students.length; i++) {
            if (students[i].equals(input) ) {
                return i;
            }
        }
        return i;
    }
}
