public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) throws IllegalTriangleException {
        this.a = a;
        this.b = b;
        this.c = c;
        validateTriangle();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public void validateTriangle() throws IllegalTriangleException {
        if(a <= 0 || b <= 0 || c <= 0 ) {
            throw new IllegalTriangleException("a, b, c must be greater than 0");
        }
        if( a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("sum of 2 side must be greater than the last side");
        }
    }
}
