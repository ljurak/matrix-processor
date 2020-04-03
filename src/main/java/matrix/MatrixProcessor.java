package matrix;

public class MatrixProcessor {

    public double[][] addMatrices(double[][] first, double[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Cannot add matrices of different dimensions");
        }

        int rows = first.length;
        int cols = first[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }

    public double[][] multiplyMatrixByNumber(double[][] matrix, int number) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * number;
            }
        }
        return result;
    }

    public double[][] multiplyMatrices(double[][] first, double[][] second) {
        if (first[0].length != second.length) {
            throw new IllegalStateException("Illegal size of matrices");
        }

        int rows = first.length;
        int cols = second[0].length;
        int rowCol = second.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < rowCol; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }

    public double[][] transposeMatrix(double[][] matrix, TranspositionType type) {
        switch (type) {
            case MAIN_DIAGONAL:
                return transposeMainDiagonal(matrix);
            case SIDE_DIAGONAL:
                return transposeSideDiagonal(matrix);
            case HORIZONTAL_LINE:
                return transposeHorizontalLine(matrix);
            case VERTICAL_LINE:
                return transposeVerticalLine(matrix);
            default:
                throw new IllegalArgumentException("Transposition type cannot be null");
        }
    }

    private double[][] transposeMainDiagonal(double[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    private double[][] transposeSideDiagonal(double[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[cols - 1 - j][rows - 1 - i];
            }
        }
        return result;
    }

    private double[][] transposeVerticalLine(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }
        return result;
    }

    private double[][] transposeHorizontalLine(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[rows - 1 - i][j];
            }
        }
        return result;
    }
}
