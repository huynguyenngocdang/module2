public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape(ShapeType.CIRCLE);
        Shape shape2 = factory.getShape(ShapeType.RECTANGLE);
        Shape shape3 = factory.getShape(ShapeType.SQUARE);

        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
