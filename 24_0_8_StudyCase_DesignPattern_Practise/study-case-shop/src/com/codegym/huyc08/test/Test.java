package com.codegym.huyc08.test;

import java.util.Stack;

public class Test {
    void method(int x, int y) {
        x = 5;
        y = 5;
    }

    public static void main(String[] args) {
        Test o = new Test();
        int x = 1, y = 1;
        o.method(x, y);
        System.out.printf("x=%d, y=%d", x, y);
    }
    }



