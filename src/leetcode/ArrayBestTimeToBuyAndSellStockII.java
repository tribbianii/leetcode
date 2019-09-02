package leetcode;

public class ArrayBestTimeToBuyAndSellStockII{
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int prof = 0;
        int buy = prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i] < prices[i-1]){
                prof += (prices[i-1] - buy);
                buy = prices[i];
            }
        }
        if (prices[prices.length-1]>buy){
            return prof+prices[prices.length-1]-buy;
        }
        if (prof==0){
            return prices[prices.length-1]>prices[0]?prices[prices.length-1]-prices[0]:0;
        }
        return prof;
    }
}