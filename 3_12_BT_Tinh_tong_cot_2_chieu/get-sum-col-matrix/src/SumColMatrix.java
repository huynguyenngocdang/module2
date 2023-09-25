import java.util.Scanner;

public class SumColMatrix {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Create an array[i][j]");
        System.out.println("Input array size i");
        int sizeI = scanner.nextInt();
        System.out.println("Input array size j");
        int sizeJ = scanner.nextInt();
        int[][] matrix = createMatrix(sizeI, sizeJ);

        System.out.println(displayMatrix(matrix, sizeI, sizeJ));

        System.out.printf("What column you want to sum (%d - %d)" , 0, (sizeJ-1));
        int col = scanner.nextInt();
        if (col < sizeJ && col >=0 ) {
            int sumTotal = sumColMatrix(matrix, sizeI, sizeJ, col);
            System.out.printf("Col %d sum total: %d", col, sumTotal );
        } else {
            System.out.println("Invalid input");
        }

    }

    private static int[][] createMatrix(int sizeI, int sizeJ) {
        int[][] matrix = new int[sizeI][sizeJ];

        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                System.out.printf("Input matrix [%d][%d]", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int sumColMatrix (int[][] matrix, int sizeI, int sizeJ, int col){
        int sumTotal = 0;
        for (int i = 0; i < sizeI; i++) {
            sumTotal += matrix[i][col];
        }
        return sumTotal;
    }

    private static String displayMatrix(int[][] matrix, int sizeI, int sizeJ) {
        String display ="";
        display += "[ \n";
        for (int i = 0; i < sizeI; i++) {
            display += "[";
            for (int j = 0; j < sizeJ; j++) {
                if (j == sizeJ - 1) {
                    display += matrix[i][j] + "] \n";
                } else {

                display += matrix[i][j] + ",";
                }
            }

        }
        display += "]";
        return display;
    }
}
