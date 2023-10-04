public class TriangleType {


    public static String getCheckTriangle (int a, int b, int c) {
        if (checkEquilateralTriangle(a, b, c)) {
            return "Equilateral Triangle";
        } else if (checkIsoscelesTriangle(a,b,c)) {
            return "Isosceles Triangle";
        } else if (checkTriangle(a,b,c)) {
            return "Normal Triangle";
        } else {
            return "Not a Triangle";
        }
    }

    private static boolean checkTriangle(int a, int b, int c) {
        if (a + b > c && b + c > a && a + c > b && a > 0 && b > 0 && c > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkIsoscelesTriangle(int a, int b, int c) {
        if ((a == b || a == c || b == c) && checkTriangle(a,b,c) ) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkEquilateralTriangle(int a, int b, int c) {
        if (a == b && a == c && checkTriangle(a,b,c) ) {
            return true;
        } else {
            return false;
        }
    }
}
