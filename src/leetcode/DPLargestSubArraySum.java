package leetcode;

import java.util.Arrays;

public class DPLargestSubArraySum {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] > 0 ? nums[i - 1] + nums[i] : nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    //follow-up: require to optiimize space use and return subarray indexes
    public static int[] maxSubArrayIndex(int[] nums) {
        int start = 0;
        int solu_start = 0;
        int solu_end = 0;
        int max = nums[0];
        for (int end = 1; end < nums.length; end ++) {
            if (nums[end - 1] > 0) {
                nums[end] = nums[end - 1] + nums[end];
            } else {
                start = end;
            }
            if (nums[end] > max) {
                max = nums[end];
                solu_start = start;
                solu_end = end;
            }
        }
        return new int[]{solu_start, solu_end};
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 4, -1, -7, 10};
        System.out.println(Arrays.toString(maxSubArrayIndex(test)));
    }
}