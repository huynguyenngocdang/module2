import java.util.Scanner;

public class FindLargestMatrix {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,99,5}, {6,7,9}};

        int max = matrix[0][0];
        String display = "{";
        for (int i = 0; i < matrix.length; i++) {
            display += "{";
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }

                if( j == matrix[i].length - 1) {
                    display += matrix[i][j] + "}";
                } else {
                    display += matrix[i][j] + " , ";
                }
            }
            if ( i == matrix.length-1) {
                display += "}";
            } else {
                display += ", ";
            }
        }
        System.out.println("Matrix: " + display);
        System.out.println("Max value is " + max);
    }
}
