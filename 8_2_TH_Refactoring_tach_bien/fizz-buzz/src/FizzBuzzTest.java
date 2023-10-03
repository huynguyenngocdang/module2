public class FizzBuzzTest {
    public static void main(String[] args) {
        var fizzBuzzCheck = new FizzBuzz();
        System.out.println("3: " + fizzBuzzCheck.getIsFizzBuzz(3));
        System.out.println("6: " + fizzBuzzCheck.getIsFizzBuzz(6));
        System.out.println("5: " + fizzBuzzCheck.getIsFizzBuzz(5));
        System.out.println("10: " + fizzBuzzCheck.getIsFizzBuzz(10));
        System.out.println("15: " + fizzBuzzCheck.getIsFizzBuzz(15));
        System.out.println("30: " + fizzBuzzCheck.getIsFizzBuzz(30));
        System.out.println("----------------");
        System.out.println("Check Fizz Buzz 1 - 100");

        for (int i = 1; i <= 100 ; i++) {
            System.out.println(i + ": " + fizzBuzzCheck.getIsFizzBuzz(i));
        }

    }
}
