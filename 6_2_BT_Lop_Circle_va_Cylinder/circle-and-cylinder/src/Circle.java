public class Circle {
    private double radius = 1.0;
    private String color = "green";

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "A circle with a "
                + "radius of " + this.getRadius() + " "
                + "perimeter of " + this.getPerimeter() + " "
                + "area of " + this.getArea() + " "
                + "color of " + this.getColor() + " \n";
    }
}
