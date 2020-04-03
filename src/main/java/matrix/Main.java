package matrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MatrixProcessor processor = new MatrixProcessor();

        showMenu();
        int option;
        double[][] firstMatrix;
        double[][] secondMatrix;
        while ((option = Integer.parseInt(scanner.nextLine())) != 0) {
            System.out.println();
            switch (option) {
                case 1:
                    firstMatrix = readMatrix(scanner);
                    secondMatrix = readMatrix(scanner);
                    processAddition(firstMatrix, secondMatrix, processor);
                    break;
                case 2:
                    firstMatrix = readMatrix(scanner);
                    System.out.print("Enter a number: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    processMultiplication(firstMatrix, number, processor);
                    break;
                case 3:
                    firstMatrix = readMatrix(scanner);
                    secondMatrix = readMatrix(scanner);
                    processMultiplication(firstMatrix, secondMatrix, processor);
                    break;
                case 4:
                    showTranspositionMenu();
                    TranspositionType transpositionType = TranspositionType.valueOfType(Integer.parseInt(scanner.nextLine()));
                    if (transpositionType == null) {
                        System.out.println("Incorrect option! Try again.\n");
                        break;
                    }
                    firstMatrix = readMatrix(scanner);
                    processTransposition(firstMatrix, processor, transpositionType);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.\n");
                    break;
            }
            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a number");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static void showTranspositionMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
    }

    private static void processAddition(double[][] first, double[][] second, MatrixProcessor processor) {
        if (first.length != second.length || first[0].length != second[0].length) {
            System.out.println("ERROR\n");
        } else {
            System.out.println("The addition result is:");
            printMatrix(processor.addMatrices(first, second));
            System.out.println();
        }
    }

    private static void processMultiplication(double[][] first, double[][] second, MatrixProcessor processor) {
        if (first[0].length != second.length) {
            System.out.println("ERROR\n");
        } else {
            System.out.println("The multiplication result is:");
            printMatrix(processor.multiplyMatrices(first, second));
            System.out.println();
        }
    }

    private static void processMultiplication(double[][] first, int number, MatrixProcessor processor) {
        System.out.println("The multiplication result is:");
        printMatrix(processor.multiplyMatrixByNumber(first, number));
        System.out.println();
    }

    private static void processTransposition(double[][] first, MatrixProcessor processor, TranspositionType transpositionType) {
        System.out.println("The transposition result is:");
        printMatrix(processor.transposeMatrix(first, transpositionType));
        System.out.println();
    }

    private static double[][] readMatrix(Scanner scanner) {
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter matrix:");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }
}
