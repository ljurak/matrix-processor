package search;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            System.out.println("ERROR");
        } else {
            printMatrix(addMatrices(firstMatrix, secondMatrix));
        }

        /*showMenu();
        int option;
        while ((option = Integer.parseInt(scanner.nextLine())) != 0) {
            System.out.println();
            switch (option) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    System.out.println("Enter a name or email to search all suitable people.");
                    String query = scanner.nextLine();
                    System.out.println();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Incorrect option! Try again.\n");
                    break;
            }
            showMenu();
        }*/
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        return matrix;
    }

    private static int[][] addMatrices(int[][] first, int[][] second) {
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private static <T> void printData(T[] data, String title) {
        System.out.println(title);
        for (T el : data) {
            System.out.println(el);
        }
        System.out.println();
    }
}
