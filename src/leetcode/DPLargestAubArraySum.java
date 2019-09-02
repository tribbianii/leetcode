package leetcode;

class DPLargestSubArraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
          return array[0];
        }
        int max_lastbit = array[0];
        int max_overall = array[0];
        for (int i=1; i< array.length; i++) {
            max_lastbit = max_lastbit < 0 ? array[i] : max_lastbit + array[i];
            max_overall = max_lastbit > max_overall ? max_lastbit : max_overall;
        }
        return max_overall;
    }
}