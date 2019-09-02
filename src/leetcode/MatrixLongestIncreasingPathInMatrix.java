package leetcode;

public class MatrixLongestIncreasingPathInMatrix{
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null||matrix[0].length==0){
            return 0;
        }   
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        int res = 0;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                dp[i][j] = helper(i, j, matrix, height, width, dp);
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //set the increment of x and y for cell to reach its four direction neighbors
    private int helper(int i, int j, int[][]matrix, int height, int width, int[][]dp){
        if (dp[i][j]!=0){
            return dp[i][j];
            //if not 0, which is computed, just return
        }
        int max = 1;
        for(int[] dir: dirs) {
            int x = i+dir[0], y = j+dir[1];
            if(x < 0 || x == height || y < 0 || y == width || matrix[x][y] <= matrix[i][j]){
                continue;
                //if neighbor out of bound or has value less than or equal with cell, then no need to be considered
            }
            int len = 1 + helper(x,y,matrix,height,width,dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }
}