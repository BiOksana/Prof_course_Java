package week3.summary_session.matrix;

import java.util.Arrays;

public class ArraysAndMatrix {
    public static void main(String[] args) {
        printMatrix(generateMatrix(3, 4));
        int[] array = {3, 2, 4, -8, 47, 4, 98, 100, 0};
        System.out.println(Arrays.toString(generateArray(array, 2)));
    }
    private static int[] generateArray(int[] array, int k) {
        int count = 0;
        int[] resultArray = new int[array.length];
        for (int i = 0; i < resultArray.length; i++) {
            if (array[i] % k == 0) {
                resultArray[count] = array[i];
                count++;
            }
        }
        resultArray = Arrays.copyOf(resultArray, count);
        return resultArray;
    }
    public static int[][] generateMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        int min = Integer.min(n,m);
        for (int i = 0; i < min; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}