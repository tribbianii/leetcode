package leetcode;

import java.util.Arrays;

public class ArrayRotateMatrix90 {
    public static void Rotate(int[][] matrix) {
        int len = matrix.length;
        dfs (matrix, len, len, 0);
    }
    public static void dfs(int[][] matrix, int maxLen, int len, int layer) {
        if (len <= 1) {
            return;
        }
        int[] buffer = Arrays.copyOfRange(matrix[layer], layer, layer + len);
        for (int i = 0; i < len - 1; i ++) {
            // Up-Row --> Right-Column
            swap(matrix, buffer, i, layer + i, maxLen - layer - 1);
            // Right-Column --> Down-Row
            swap(matrix, buffer, i, maxLen - layer - 1, maxLen - layer - i - 1);
            // Down-Row --> Left-Column
            swap(matrix, buffer, i, maxLen - layer - i - 1, layer);
            // Left-Column --> Up-Row
            swap(matrix, buffer, i, layer, layer + i);
        }
        dfs(matrix, maxLen, len - 2, layer + 1);
    }
    public static void swap(int[][] matrix, int[] buffer, int index, int i, int j) {
        int temp = buffer[index];
        buffer[index] = matrix[i][j];
        matrix[i][j] = temp;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        Rotate(matrix);
        for (int[] level: matrix) {
            System.out.println(Arrays.toString(level));
        }
    }
}