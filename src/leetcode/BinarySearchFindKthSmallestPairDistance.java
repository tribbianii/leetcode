package leetcode;

import java.util.Arrays;

public class BinarySearchFindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right ++) {
                while (nums[right] - nums[left] > mid) {
                    left ++;
                }
                count += (right - left);
            }
            if (count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
