package leetcode;

public class DPGuesNumberHigherLower {
    public int getMoneyAmount(int n) {
        if (n<=1){
            return 0;
        }
        int[][] dp = new int[n+1][n+1];
        return helper(1,n,dp);
    }

    public int helper(int i, int j, int[][]dp){
        if (i>=j){
            return 0;
        }
        if (dp[i][j]!=0){
            return dp[i][j];
        }
        int pre = Integer.MAX_VALUE;
        for (int x=i;x<=j;x++){
            pre= Math.min(pre, Math.max(helper(i,x-1,dp), helper(x+1,j,dp))+x);
        }
        dp[i][j] = pre;
        return dp[i][j];
    }
    //one of most confusing problems in leetcode
    //guess the number and pay the value of the number you guessed but not right
    //will be told right answer is greater/less than your guess
    //find the amount to pay that guarantee the right guess
}
