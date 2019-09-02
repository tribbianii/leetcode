package leetcode;

public class DPCuttingRod {
    public final int[] price = new int[]{1,5,8,9,10,17,17,20,24,30};
    public int cut(int n) {
        int[] profit = new int[price.length + 1];
        profit[0] = 0;
        profit[1] = price[0];
        for (int i = 2;i <= n;i++) {
            int curmax = 0;
            for (int j = 1;j < i;j++) {
                curmax = Math.max(curmax, profit[i-j] + price[j-1]);
            }
            profit[i] = Math.max(curmax, price[i-1]);
        }
        return profit[n];
    }
}