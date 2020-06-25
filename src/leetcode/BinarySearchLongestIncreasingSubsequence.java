package leetcode;

import java.util.Arrays;

public class BinarySearchLongestIncreasingSubsequence {
    //DP solution
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
    //binary search solution
    //tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i]
    //for every num in nums, do one of following two options
    //(1) if num is larger than all tails, append it, increase the size by 1
    //(2) if tails[i-1] < num <= tails[i], update tails[i]
    //explanation:http://www.cnblogs.com/lightwindy/p/8532391.html
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
    public int LengthofLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // Arrays.binarySearch(array, fromIndex[inclusive], toIndex[exclusive], key) 
            // returns the index of the search key, if it is contained in the array within the specified range;
            // returns (-(insertion point) - 1) if not contained
            // e.g. if key <= array[0], which means the key should be inserted at index:0 to replace array[0], returns -(0) - 1 = -1
            // e.g. if array[len - 2] < key <= array[len - 1], means it should be inserted at index:len - 1 to replace current max
            // e.g. if array[len - 1] < key, means it should be appended to update the max, len ++
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                // insertion point = -(index returned + 1)
                i = -(i + 1);
            }
            dp[i] = num;
            System.out.println(Arrays.toString(dp));
            if (i == len) {
                len ++;
            }
        }
        return len;
    }
    
}