package Matrix;

public class MatrixSearch {


    private static boolean searchInMatrix(int[][] matrix, int key) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < matrix.length && j > 0) {
            if (matrix[i][j] == key) return true;
            if (matrix[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        System.out.println("Is the element found in matrix: " + searchInMatrix(matrix, 29));
    }
}
