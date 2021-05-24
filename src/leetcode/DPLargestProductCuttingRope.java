package leetcode;

public class DPLargestProductCuttingRope {
    //divide rope into two halves
    //use the max products of two halves to calculate 
    public int cutRope (int n) {
        int[] max = new int [n+1];
        max[0] = 0;
        max[1] = 0;
        for (int i = 2;i <= n;i++) {
            int curmax = 0;
            for (int j = 1;j <= i/2;j++) {
                int product = Math.max(j, max[j]) * Math.max(i-j, max[i-j]);
                curmax = Math.max(curmax, product);
            }
            max[i] = curmax;
        }
        return max[n];
    }
    //divide rope into two halves
    //use one calculated product of first half times another half's length
    public int CutRope (int n) {
        int[] max = new int [n+1];
        max[0] = 0;
        max[1] = 0;
        for (int i = 2;i <= n;i++) {
            int curmax = 0;
            for (int j = 1;j < i;j++) {
                int product = Math.max(j, max[j]) *  (i-j);
                curmax = Math.max(curmax, product);
            }
            max[i] = curmax;
        }
        return max[n];
    }
    //the second idea is more general using in related issues
    //2 solutions above are all dp and time complexity O(n^2)

    //recursion solution with time complexity O(n!)
    public int cutRopeRecursion (int n) {
        if (n <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1;i <= n;i++) {
            int product = Math.max(n-i, cutRopeRecursion(n-i)) * i;
            max = Math.max(max, product);
        }
        return max;
    }
}