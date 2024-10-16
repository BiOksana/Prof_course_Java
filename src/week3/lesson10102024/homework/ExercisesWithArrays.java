package week3.lesson10102024.homework;

import java.util.Arrays;

public class ExercisesWithArrays {
    public static void main(String[] args) {
//       1. Написать метод generateMatrix(), который будет создавать матрицу размера m на n,
//       у которой на побочной диагонали будут единицы, остальные значения 0.
//        Input: n = 4, m = 3
//        Output:
//        0 0 0
//        0 0 1
//        0 1 0
//        1 0 0
//
//      2.  Написать метод, который проверяет, является ли массив отсортированным.
//      3. Написать метод, который выдает из исходного двумерного массива массив максимумов столбцов.

        int[] array = new int[]{3, 7, 11, 25, 44, 78, 99};

        printMatrix(generateOtherMatrix(4, 3));    //Exercise 1
        System.out.println(isSortedArray(array));           //Exercise 2

        int[][] arrayOfArray = new int[3][4];
        arrayOfArray[0][0] = 1;
        arrayOfArray[0][1] = 2;
        arrayOfArray[0][2] = 3;
        arrayOfArray[0][3] = 4;

        arrayOfArray[1][0] = 5;
        arrayOfArray[1][1] = 6;
        arrayOfArray[1][2] = 7;
        arrayOfArray[1][3] = 8;

        arrayOfArray[2][0] = 12;
        arrayOfArray[2][1] = 11;
        arrayOfArray[2][2] = 10;
        arrayOfArray[2][3] = 9;

        int[][] arrayOfArray2 = new int[3][3];
        arrayOfArray2[0][0] = 1;
        arrayOfArray2[0][1] = 5;
        arrayOfArray2[0][2] = 9;

        arrayOfArray2[1][0] = 3;
        arrayOfArray2[1][1] = 7;
        arrayOfArray2[1][2] = 2;

        arrayOfArray2[2][0] = 4;
        arrayOfArray2[2][1] = 8;
        arrayOfArray2[2][2] = 6;

        int[][] arrayOfArray3 = new int[4][3];
        arrayOfArray3[0][0] = 1;
        arrayOfArray3[0][1] = 2;
        arrayOfArray3[0][2] = 3;

        arrayOfArray3[1][0] = 9;
        arrayOfArray3[1][1] = 4;
        arrayOfArray3[1][2] = 8;

        arrayOfArray3[2][0] = 2;
        arrayOfArray3[2][1] = 7;
        arrayOfArray3[2][2] = 8;

        arrayOfArray3[3][0] = 5;
        arrayOfArray3[3][1] = 7;
        arrayOfArray3[3][2] = 3;

// Exercise 3
        printMatrix(arrayOfArray);
        System.out.println(Arrays.toString(generateMaxColumnArray(arrayOfArray)));
        System.out.println(isSortedArray(generateMaxColumnArray(arrayOfArray)));        // Exercise 2

        printMatrix(arrayOfArray2);
        System.out.println(Arrays.toString(generateMaxColumnArray(arrayOfArray2)));
        System.out.println(isSortedArray(generateMaxColumnArray(arrayOfArray2)));        // Exercise 2

        printMatrix(arrayOfArray3);
        System.out.println(Arrays.toString(generateMaxColumnArray(arrayOfArray3)));
        System.out.println(isSortedArray(generateMaxColumnArray(arrayOfArray3)));        // Exercise 2
    }

    private static int[] generateMaxColumnArray(int[][] matrix) {
        int[] newArray = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > newArray[j]) {
                    newArray[j] = matrix[i][j];
                }
            }
        }
        return newArray;
    }

    private static boolean isSortedArray(int[] array) {
        boolean isAscendingOrder = true;
        boolean isDescendingOrder = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isAscendingOrder = false;
            }
            if (array[i] < array[i + 1]) {
                isDescendingOrder = false;
            }
        }
        return isAscendingOrder || isDescendingOrder;
    }

    private static void printMatrix(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateOtherMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int min = Integer.min(m, n);
        for (int i = 0; i < min; i++) {
            matrix[m - i - 1][i] = 1;
        }
        return matrix;
    }

}
