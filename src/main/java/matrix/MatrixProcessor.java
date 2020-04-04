package matrix;

public class MatrixProcessor {

    public double[][] addMatrices(double[][] first, double[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Cannot add matrices of different dimensions.");
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

    public double[][] multiplyMatrixByNumber(double[][] matrix, double number) {
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
            throw new IllegalStateException("Illegal size of matrices.");
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
            case VERTICAL_LINE:
                return transposeVerticalLine(matrix);
            case HORIZONTAL_LINE:
                return transposeHorizontalLine(matrix);
            default:
                throw new IllegalArgumentException("Transposition type cannot be null.");
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

    public double calculateDeterminant(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Cannot calculate determinant for non-square matrix.");
        }

        int size = matrix[0].length;
        if (size == 1) {
            return matrix[0][0];
        }

        double determinant = 0;
        for (int i = 0; i < size; i++) {
            determinant += matrix[0][i] * getCofactor(matrix, 0, i);
        }
        return determinant;
    }

    private double getCofactor(double[][] matrix, int row, int col) {
        return Math.pow(-1, row + col + 2) * calculateDeterminant(getMinor(matrix, row, col));
    }

    private double[][] getMinor(double[][] matrix, int row, int col) {
        int size = matrix.length;

        double[][] minor = new double[size - 1][size - 1];
        int minorRow = 0;
        int minorCol = 0;

        for (int i = 0; i < size; i++) {
            if (i == row) {
                continue;
            }

            for (int j = 0; j < size; j++) {
                if (j == col) {
                    continue;
                }
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }

            minorRow++;
            minorCol = 0;
        }
        return minor;
    }

    public double[][] inverseMatrix(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Cannot inverse non-square matrix.");
        }

        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            throw new IllegalStateException("Cannot inverse matrix. Determinant equals 0.");
        }

        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = getCofactor(matrix, i, j);
            }
        }

        result = transposeMainDiagonal(result);
        result = multiplyMatrixByNumber(result, 1 / determinant);
        return result;
    }
}
