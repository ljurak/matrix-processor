package matrix;

public class MatrixProcessor {

    public int[][] addMatrices(int[][] first, int[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Cannot add matrices of different dimensions");
        }

        int rows = first.length;
        int cols = first[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }

    public int[][] multiplyMatrixByNumber(int[][] matrix, int number) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * number;
            }
        }
        return result;
    }

    public int[][] multiplyMatrices(int[][] first, int[][] second) {
        if (first[0].length != second.length) {
            throw new IllegalStateException("Illegal size of matrices");
        }

        int rows = first.length;
        int cols = second[0].length;
        int rowCol = second.length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < rowCol; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;
    }
}
