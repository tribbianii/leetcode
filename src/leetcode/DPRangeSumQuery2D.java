package leetcode;

class DPRangeSumQuery2D {
    /*
    Time complexity : O(1) time per query, O(mn) time pre-computation. 
    The pre-computation in the constructor takes O(mn) time. 
    Each sumRegion query takes O(1) time.
    Space complexity : O(mn). 
    The algorithm uses O(mn) space to store the cumulative region sum.
    */
    private int[][] dp;
    
    public DPRangeSumQuery2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}