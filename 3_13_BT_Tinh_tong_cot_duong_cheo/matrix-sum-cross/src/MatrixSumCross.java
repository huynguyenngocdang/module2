import java.util.Scanner;

public class MatrixSumCross {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Create an array[i][i]");
        System.out.println("Input array size i");
        int sizeI = scanner.nextInt();
//        System.out.println("Input array size j");
//        int sizeJ = scanner.nextInt();
        int[][] matrix = createMatrix(sizeI, sizeI);

        System.out.println(displayMatrix(matrix, sizeI, sizeI));

        System.out.printf("What row i you want to sum matrix[i][] (%d - %d)" , 0, (sizeI-1));
        int row = scanner.nextInt();

        System.out.printf("What col j you want to sum matrix[i][j] (%d - %d)" , 0, (sizeI-1));
        int col = scanner.nextInt();

        if (col + row < 2 * sizeI && col + row >=0 ) {
            int sumTotal = sumColMatrix(matrix, sizeI, row, col);
            System.out.printf("Sum total axis from [%d][%d]: %d", row, col, sumTotal );
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

    private static int sumColMatrix (int[][] matrix, int sizeI, int row, int col){
        int sumTotal = 0;
        int thisCol = col;
        int thisRow = row;
        for (int i = thisRow; i < sizeI; i++) {
            sumTotal += matrix[thisRow][thisCol];
            if (thisCol < sizeI && thisRow < sizeI) {
                thisCol++;
                thisRow++;
            }
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
