import java.util.Scanner;

public class PrimeSmaller {
        public static void main(String[] args) {
            var scanner = new Scanner(System.in);
            System.out.println("Input maximum prime number value");
            int amount = scanner.nextInt();

            String result = getPrimeList(amount);

            System.out.println("List of prime number");
            System.out.println(result);
        }

        private static boolean isPrime(int a) {
            boolean result;
            if (a < 2) {
                result = false;
            } else {
                result = true;
                int i = 2;
                while (i <= Math.sqrt(a)) {
                    if (a % i == 0) {
                        result = false;
                        break;
                    }
                    i++;
                }
            }
            return result;
        }

        private static String getPrimeList(int amount) {
            String result = "";
            int count = 0;
            int thisNumber = 2;
            while (thisNumber < amount) {
                if (isPrime(thisNumber)) {
                    result += (count + 1) + ". " + thisNumber + "\n";
                    count++;
                }
                thisNumber += 1;
            }
            return result;
        }
    }


