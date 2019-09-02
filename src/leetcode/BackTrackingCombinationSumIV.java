package leetcode;

import java.util.Arrays;

public class BackTrackingCombinationSumIV {
    //first 3 methods are all dynamic programming
    public int CombinationSumIV(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                if (num == i)
                    res[i] += 1;
                if (num < i)
                    res[i] += res[i-num];
            }
        }
        return res[target];
    }

    //bottom-up dp
    public int combinationSumIV(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1; 
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    res[i] += res[i - nums[j]];
                }
            }
        }
        return res[target];
    }

    //top-down dp
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(dp, nums, target);
    }
    private int helper(int[] dp, int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(dp, nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    //method4 is recursive which exceeds time limit when target gets large
    public int CombinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += CombinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }
}
