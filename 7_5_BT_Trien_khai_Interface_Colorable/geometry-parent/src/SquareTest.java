public class SquareTest {
    public static void main(String[] args) {


        Square square1 = new Square(5, "yellow", true, false);
        Square square2 = new Square(10, "red", true, true);
       Square[] squares = {square1, square2};
        for (Square square: squares) {
            System.out.println(square.toString());
        }
    }
}