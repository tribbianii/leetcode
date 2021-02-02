package leetcode;

public class BinarySearchSplitArrayLargestSum {
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
}
