package leetcode;

public class ArrayBestTimeToBuyAndSellStock{
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int minpric = prices[0];
        int maxprof = 0;
        for (int i=1;i<prices.length;i++){
            maxprof = Math.max(maxprof,prices[i]-minpric);
            minpric = Math.min(minpric,prices[i]);
        }
        return maxprof;
    }
}