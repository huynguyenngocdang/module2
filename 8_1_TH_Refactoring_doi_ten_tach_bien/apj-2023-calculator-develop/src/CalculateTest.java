public class CalculateTest {
    public static void main(String[] args) {
        var calculator = new Calculator();

        System.out.printf("""
                Testing addition 
                1 + 1  = %d 
                Testing subtraction 
                2 - 1 = %d
                Testing multiplication
                2 * 2 = %d
                Testing division
                6 / 3 = %d
                
                
                """,
                calculator.calculate(1,1,'+'),
                calculator.calculate(2,1,'-'),
                calculator.calculate(2,2,'*'),
                calculator.calculate(6,3,'/')
                );
//        System.out.println("Testing division by zero");
//        System.out.println("2 / 0 = " +calculator.calculate( 2,0,'/'));
        System.out.println("Testing wrong operator");
        System.out.println(calculator.calculate(2,0,'='));

    }
}
