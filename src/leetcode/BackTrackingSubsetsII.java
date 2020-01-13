package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingSubsetsII {
    //array nums may have duplicated numbers
    //method 1: skip all the duplicate nums
    //fastest
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
        Arrays.sort(nums);
		helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
	}
	public void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> subset, int index){
		if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        helper(nums, res, subset, index + 1);
        subset.remove(subset.size() - 1);
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        helper(nums, res, subset, index + 1);
    }
    //method 2
    public List<List<Integer>> SubsetsII(int[] nums){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
        Arrays.sort(nums);
		helper(nums, res, new ArrayList<Integer>(), 0, true);
        return res;
    }
    //since if (nums[index] == nums[index - 1]), then
    //      (nums[index - 1] added + nums[index] not added)   --> case 1
    //                             = 
    //      (nums[index - 1] not added + nums[index] added)   --> case 2
    //so we avoid case 2
	public void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> subset, int index, boolean added){
		if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
		if (!added && nums[index] == nums[index - 1]) {
            helper(nums, res, subset, index + 1, false);
        }
        else {
            subset.add(nums[index]);
            helper(nums, res, subset, index + 1, true);
            subset.remove(subset.size() - 1);
            helper(nums, res, subset, index + 1, false);
        }
	}
}
