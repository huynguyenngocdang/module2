package com.codegym;

public class RectangleTest {
    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        System.out.println(rectangle);
//
//        rectangle = new Rectangle(2.3, 5.8);
//        System.out.println(rectangle);

        var rectangle = new Rectangle(2, 5, "orange", true);
        System.out.printf("""
                Before resize \n
                Area : %f \n
                """, rectangle.getArea());
        System.out.printf("""
                After resize \n
                Area : %f \n
                """, rectangle.resize(50));
    }
}
