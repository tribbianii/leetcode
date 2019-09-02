package leetcode;

//can paint at most two adjacent posts with same color
//n posts and k colors
public class DPPaintFence {
    public int numWays(int n, int k){
        if(n<=1){
            return n*k;
        }
        int same = k;
        int diff = k*(k-1);
        for (int i=3;i<=n;i++){
            int prediff = diff;
            diff = (diff+same)*(k-1);
            same = prediff;
        }
        return same+diff;
    }
    //reduced space complexity thaa dp[] 'cause we only use two variable
}