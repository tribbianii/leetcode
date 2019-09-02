package leetcode;

import java.util.ArrayList;

public class BackTrackingPermutationSequence {
    public String Permutation(int n, int k){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=1;i<=n;i++){
            nums.add(i);
        }
        StringBuilder res = new StringBuilder();
        k--;
        //key step
        for (int j=1;j<=n;j++){
            int left = k%(factorial(n-j));
            int level = k/(factorial(n-j));
            res.append(nums.get(level));
            nums.remove(level);
            k=left;
        }
        return String.valueOf(res);
    }
    public int factorial(int n){
        if (n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
