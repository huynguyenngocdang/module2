public class Circle {
    private double r = 1;
    private String color = "red";

    Circle() {

    }

    Circle(double r) {
        this.r = r;
        this.color = color;
    }

    double getRadius() {
        return this.r;
    }
    double getArea () {
        return Math.PI * Math.pow(this.r, 2);
    }

    String getColor() {
        return this.color;
    }
}
