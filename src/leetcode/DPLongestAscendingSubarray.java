package leetcode;

public class DPLongestAscendingSubarray {
    public int longestLength (int[] arr) {
        int max = 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1;i < arr.length;i++) {
            cur = arr[i] > arr[i-1] ? pre + 1 : 1;
            pre = cur;
            max = max > cur ? max : cur;
        }
        return max;
    }
}