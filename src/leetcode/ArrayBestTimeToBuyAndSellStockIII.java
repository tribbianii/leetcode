package leetcode;

public class ArrayBestTimeToBuyAndSellStockIII{
    //my super slow solution but it works
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i=1;i<prices.length;i++){
            max = Math.max(max, maxprofit(prices, 0, i)+maxprofit(prices, i+1, prices.length-1));
        }
        return max;
    }
    private int maxprofit(int[] prices, int i, int j) {
        if (prices==null||prices.length==0||i>=prices.length-1){
            return 0;
        }
        int minpric = prices[i];
        int maxprof = 0;
        for (int k=i+1;k<=j;k++){
            maxprof = Math.max(maxprof,prices[k]-minpric);
            minpric = Math.min(minpric,prices[k]);
        }
        return maxprof;
    }
    //following is super fast solution...
    public int MaxProfit(int[] prices) {
        if(prices==null||prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //find each day's max profit by one deal
        int[] leftprof = new int[n];
        int minpric = prices[0];
        for (int i=1;i<n;i++){
            leftprof[i] = Math.max(leftprof[i-1],prices[i]-minpric);
            minpric = Math.min(minpric,prices[i]);
        }
        //find each day's max profit by two deals
        int res = leftprof[n-1];
        int rightprof = 0;
        int maxpric = prices[n-1];
        for (int j=n-2;j>=0;j--){
            rightprof = Math.max(rightprof,maxpric-prices[j]);
            maxpric = Math.max(maxpric,prices[j]);
            res = Math.max(res,rightprof+leftprof[j]);
        }
        return res;
    }
}