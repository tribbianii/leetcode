package leetcode;

import java.util.Arrays;

public class BinarySearchSplitArrayLargestSum {
    // find the possible minimum value for maximum sum of subarray of array is divided into m subarray
    public int splitArray(int[] nums, int m) {
        long min = 0;
        long max = 0;
        long res = Long.MAX_VALUE;
        for (int num : nums) {
            if (num > min) {
                min = num;
            }
            max += num;
        }
        while (min <= max) {
            long mid = min + (max - min) / 2;
            int groups = 1;
            int sum = 0;
            int maxSum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    groups ++;
                    sum = num;
                } else {
                    sum += num;
                }
                maxSum = Math.max(maxSum, sum);
            }
            if (groups <= m) {
                res = Math.min(res, maxSum);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int)res;
    }
    // find the possible maximum value for minimum sum of subarray of array is divided into k subarray
    // https://www.educative.io/courses/decode-coding-interview-java/Y5AzDWkL9lA
    // Time Complexity: O(n×log(m)), n be the size of the array of integers and m be the sum of the array elements
    public int dividePosts(int[] days, int k) {
        int left = 1;
        int right = Arrays.stream(days).sum() / k;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int target = 0;
            int minSum = Integer.MAX_VALUE;
            int divisions = 0;
            for (int posts : days) {
                target += posts;
                if (target >= mid) {
                    divisions++;
                    minSum = Math.min(target, minSum);
                    target = 0;
                }
            }
            if (divisions <= k) {
                right = mid - 1;
                res = Math.max(minSum, res);
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
