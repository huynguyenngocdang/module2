import java.text.ParseException;

public class Main {
    private static MyQueue queueMale = new MyQueue();
    private static MyQueue queueFemale = new MyQueue();
    private static String result = "";
    public static void main(String[] args) {
        try {

            queueMale.enqueueStudent(new Student("Teo", "male", "13/12/1998"));
            queueMale.enqueueStudent(new Student("Huy", "male", "13/2/1992"));
            queueFemale.enqueueStudent(new Student("Giang", "female", "15/5/1995"));
            queueFemale.enqueueStudent(new Student("Hau", "female", "15/5/2003"));

            queueMale.sortStudentByDob();
            queueFemale.sortStudentByDob();

            while (queueFemale.getStudentLinkedList().size() != 0) {
                result +=  queueFemale.dequeueStudent().toString() + "\n" ;
            }

            while (queueMale.getStudentLinkedList().size() != 0) {
               result +=  queueMale.dequeueStudent().toString() + "\n";
            }

            System.out.println(result);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}