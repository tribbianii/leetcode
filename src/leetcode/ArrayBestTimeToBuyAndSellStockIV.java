package leetcode;

public class ArrayBestTimeToBuyAndSellStockIV{
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k <=0 || len < 2)
            return 0;
        int maxProfit = 0;
        if(k >= len/2) {
            for(int i=1;i<len;i++) {
                int diff = prices[i]-prices[i-1];
                if(diff > 0)
                    maxProfit += diff;
            }
            return maxProfit;
        }
        int[][] local = new int[len][k+1];
        int[][] global = new int[len][k+1]; 
        for(int i=1;i<len;i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1;j<=k;j++) {
                //local[i][j] means the max profit of Day i with last Transation in that Day and at most j Transactions in total
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
                //global[i][j] means the max profit of Day i with at most j Transactions in total
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[len-1][k];
    }
}