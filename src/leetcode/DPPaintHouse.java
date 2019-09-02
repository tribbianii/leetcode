package leetcode;

public class DPPaintHouse {
    public int minCost(int[][] costs) {
        if (costs==null||costs.length==0){
            return 0;
        }
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
    //method 1 can be used in variable costs[0].length case but slow
    public int MinCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
    //method 2 is much more faster
}
