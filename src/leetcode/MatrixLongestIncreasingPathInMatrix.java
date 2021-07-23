package leetcode;

public class MatrixLongestIncreasingPathInMatrix{
    int max;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        max = 1;
        int[][] map = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map[0].length; j ++) {
                dfs(matrix, map, i, j, Integer.MIN_VALUE);
            }
        }
        return max;
    }
    public int dfs(int[][] matrix, int[][] map, int row, int col, int prev) {
        if (row < 0 || row == map.length || col < 0 || col == map[0].length || matrix[row][col] <= prev) {
            return 0;
        }
        if (map[row][col] != 0) {
            return map[row][col];
        }
        int subMax = 0;
        for (int[] dir : directions) {
            subMax = Math.max(subMax, dfs(matrix, map, row + dir[0], col + dir[1], matrix[row][col]));
        }
        map[row][col] = 1 + subMax;
        max = Math.max(map[row][col], max);
        return map[row][col];
    }
}