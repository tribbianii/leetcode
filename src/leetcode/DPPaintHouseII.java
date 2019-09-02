package leetcode;

public class DPPaintHouseII{
    public int minCostII(int[][] costs) {
        if (costs==null||costs.length==0){
            return 0;
        }
        if (costs[0].length==1){
            return costs[0][0];
        }
        //this problem differs with previous one on costs[0].length
        //previous one's is fixed which is 3
        //this one's is varible
        int nums = costs.length;
        int vals = costs[0].length;
        int[][] mins = new int[nums][vals];
        for (int i=0;i<nums;i++){
            for (int j=0;j<vals;j++){
                int pre = Integer.MAX_VALUE;
                for (int k=0;k<vals;k++){
                    if (k==j){
                        continue;
                    }
                    pre = Math.min(pre, costs[i][j]+(i==0?0:mins[i-1][k]));
                }
                mins[i][j]=pre;
            }
        }
        int pre = Integer.MAX_VALUE;
        for (int i=0;i<vals;i++){
            pre = Math.min(pre,mins[nums-1][i]);
        }
        return pre;
    }
    //relatively slow solution to have three for loops
    public int MinCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int min1 = 0;
        int min2 = 0;
        int preminIndex = -1;
        for (int i = 0; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curMinIndex = 0;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == preminIndex ? min2 : min1);
                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curMinIndex = j;
                }
                else if (cost < curMin2) curMin2 = cost;
            }
            min1 = curMin1; 
            min2 = curMin2;
            preminIndex = curMinIndex;
        }
        return min1;
    }
    //DP subproblem is for every house, there are two options for previous houses to inherit
    //one minimum and one less minimum of previous house
    //if the miinimum is adjacent with current color, then choose the less minimum one
}