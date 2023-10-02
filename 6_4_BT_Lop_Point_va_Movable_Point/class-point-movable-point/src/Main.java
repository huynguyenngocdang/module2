public class Main {
    public static void main(String[] args) {
        Point point = new Point(5, 10);
        System.out.println(point.toString());

        var pointMove = new MovablePoint(point.getX(), point.getY(), 10, 20);
        System.out.println(pointMove.toString());
    }
}