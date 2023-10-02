public class Cylinder extends Circle {
    private double height = 2.0;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSurfaceArea() {
        return super.getPerimeter() * this.height + 2 * super.getArea();
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "This cylinder has the height of " + this.height + " "
                + "with a surface area of " + this.getSurfaceArea() + " "
                + "with a volume area of " + this.getVolume() + " "
                + "with radius of " + super.getRadius() + " "
                + "belong to a super class of \n" + super.toString();
    }
}
