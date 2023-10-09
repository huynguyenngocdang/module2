package com.codegym;


import java.util.Stack;

public class Converter {
    private static final Stack<Integer> stk = new Stack<>();

  public static void convertDecimalToBinary(int numberInput) {
      while (numberInput != 0) {
          int d = numberInput % 2;
          stk.push(d);
          numberInput /= 2;
      }
          Menu.printBinary();
      while (!stk.isEmpty()) {
          System.out.print(stk.pop());
      }
      System.out.println("\n");
  }

    public static void convertBinaryToDecimal(long binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                long temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        Menu.printDecimal();
        System.out.print( decimal + "\n \n");
    }

    public static void convertDecimalToHex (int numberInput) {
      Menu.printHexadecimal();
        System.out.print(Integer.toHexString(numberInput) + "\n");

    }

    public static void convertHexToDecimal (String numberInput) {
      Menu.printDecimal();
        System.out.println(Integer.parseInt(numberInput, 16) + "\n");

    }
}
