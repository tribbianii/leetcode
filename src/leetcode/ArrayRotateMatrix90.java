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
    public void rotate(int[][] matrix) {
        int layer = matrix.length / 2;
        int layerLen = matrix.length;
        int upLeft_x = 0;
        int upLeft_y = 0;
        int hop = 4;
        while ((layer --) > 0) {
            // initialize the starting position as up-left of this layer
            int curr_y = upLeft_y;
            for (int i = layerLen; i > 1; i --) {
                // initialize the first hop position
                int next_x = curr_y;
                int next_y = matrix.length - upLeft_x - 1;
                // back up the current position value
                int backup = matrix[upLeft_x][curr_y];
                // hop 4 times
                while ((hop --) > 0) {
                    // replace the hop position with backup value
                    // update backup value
                    int temp = matrix[next_x][next_y];
                    matrix[next_x][next_y] = backup;
                    backup = temp;
                    // determine the next hop position
                    int x_temp = next_x;
                    next_x = next_y;
                    next_y = matrix.length - x_temp - 1;
                }
                // after 4 times hop, move to next position of this layer
                curr_y ++;
                hop = 4;
            }
            // elements number decrease by 2 as layer goes deeper
            layerLen -= 2;
            // up-left position changes as layer changes
            upLeft_x ++;
            upLeft_y ++;
        }
    }
}