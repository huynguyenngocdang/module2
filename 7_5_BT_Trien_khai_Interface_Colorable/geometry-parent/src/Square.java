public class Square extends Rectangle implements Colorable {
    private boolean isColorable = false;
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled, boolean isColorable) {
        super(color, filled, side, side);
        this.isColorable = isColorable;
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public boolean isColorable() {
        return isColorable;
    }

    public void setColorable(boolean colorable) {
        isColorable = colorable;
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with area= "
                + getArea()
                + " "
                + (isColorable() ? howToColor() : "" )
                + ", which is a subclass of \n"
                + super.toString();
    }

    @Override
    public String howToColor() {
        return "Color all four sides...";
    }
}