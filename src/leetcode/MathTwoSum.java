package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MathTwoSum {
	public int[] TwoSum(int[] nums, int target) {
		if (nums==null|nums.length<2) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i=0;i<nums.length;i++) {
			if (!map.containsKey(nums[i])) {
				map.put(target-nums[i], i);
			}
			else {
				res[0]=i;
				res[1]=map.get(nums[i]);
				return res;
			}
		}
		return null;
	}
}
