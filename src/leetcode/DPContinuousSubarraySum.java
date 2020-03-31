package leetcode;

import java.util.HashMap;
import java.util.Map;

class DPContinuousSubarraySum {
    //array filled with non-negative integers
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = i > 0 ? nums[i] + nums[i - 1] : nums[i];
            int remainder = k == 0 ? nums[i] : nums[i] % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            }
            else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}