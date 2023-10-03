package com.codegym;

public class CircleTest {
    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle);
//
//        circle = new Circle(3.5);
//        System.out.println(circle);

        Circle circle = new Circle(3.5, "indigo", false);
        System.out.println("Before resize");
        System.out.println("Area: " + circle.getArea());

        System.out.println("After resize");
        System.out.println("Area: " + circle.resize(50));

    }
}