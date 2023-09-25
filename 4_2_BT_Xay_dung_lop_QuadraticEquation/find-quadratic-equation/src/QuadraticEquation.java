public class QuadraticEquation {
    int a, b, c;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2)  - 4 * a * c;
    }

    public double getRoot1 () {
        return ( (- b + Math.pow(getDiscriminant(),0.5) )/ (2 * a) );
    }

    public double getRoot2 () {
        return ( (- b - Math.pow(getDiscriminant(),0.5) )/ (2 * a) );
    }

}
