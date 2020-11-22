package leetcode;

public class DPMinDifficultyOfJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }
        int[][] dp = new int[d][jobDifficulty.length];
        for (int i = 0; i < d; i ++) {
            for (int j = i; j < jobDifficulty.length; j ++) {
                if (i == 0) {
                    dp[i][j] = j == 0 ? jobDifficulty[j] : Math.max(dp[i][j - 1], jobDifficulty[j]);
                    continue;
                }
                int maxRemain = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = j; x >= i; x --) {
                    maxRemain = Math.max(maxRemain, jobDifficulty[x]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][x - 1] + maxRemain);
                }
            }
        }
        return dp[d - 1][jobDifficulty.length - 1];
    }
}
