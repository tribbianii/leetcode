package leetcode;

public class MatrixLongestIncreasingPathInMatrix{
    public int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longest(int[][] matrix) {
        int max = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                dfs(matrix, dp, i, j);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public void dfs(int[][]matrix, int[][]dp, int rowNum, int colNum) {
        if (dp[rowNum][colNum] != 0) {
            return;
        }
        int maxFromHere = 1;
        for (int[] dir : directions) {
            int x = rowNum + dir[0];
            int y = colNum + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[rowNum][colNum]) {
                dfs(matrix, dp, x, y);
                maxFromHere = Math.max(maxFromHere, dp[x][y] + 1);
            }
        }
        dp[rowNum][colNum] = maxFromHere;
    }
}