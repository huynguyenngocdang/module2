public class Helper {
    public int largestCommonFactor (int a, int b) {
        if (!isZero(a) && !isZero(b)) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
        }
        return a;

    }
    public boolean isZero (int a) {

        if (a == 0) {
            return true;
        } else {
            return false;
        }
    }
}
