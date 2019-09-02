package leetcode;

class DPLargestSquareOfOne {
    public static int MaxLen (int[][] matrix) {
        int max = 0;
        int len = matrix[0].length;
        int[][] ans = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i * j == 0) {
                    ans[i][j] = matrix[i][j] == 1 ? 1 : 0;
                }
                else {
                    ans[i][j] = matrix[i][j] == 1 ? 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) : 0;
                }
                max = ans[i][j] > max ? ans[i][j] : max;
            }
        }
        return max;
    }
}