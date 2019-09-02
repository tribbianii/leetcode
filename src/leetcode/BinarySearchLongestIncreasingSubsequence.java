package leetcode;

import java.util.Arrays;

public class BinarySearchLongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int max = 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i=1;i<len;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;  
    }
    //DP solution
    public int LengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0;
            int right = size;
            while (left != right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num){
                    left= mid + 1;
                }
                else{
                    right = mid;
                }
            }
            tails[left] = num;
            if (left==size) {
                ++size;
            }
        }
        return size;
    }
    //binary search solution
    //tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i]
    //for every num in nums, do one of following two options
    //(1) if num is larger than all tails, append it, increase the size by 1
    //(2) if tails[i-1] < num <= tails[i], update tails[i]
    //explanation:http://www.cnblogs.com/lightwindy/p/8532391.html
}