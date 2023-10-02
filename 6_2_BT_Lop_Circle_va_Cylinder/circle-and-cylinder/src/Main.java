public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3.5, "red");
        System.out.println(circle1.toString());
        var circle2 = new Circle();
        System.out.println(circle2.toString());

        var cylinder = new Cylinder();
        System.out.println(cylinder.toString());
        var cylinder2 = new Cylinder();

    }
}