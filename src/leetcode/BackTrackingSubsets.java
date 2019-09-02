package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingSubsets {

	//array nums has no duplicated numbers
	public List<List<Integer>> Subsets(int[] nums) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums==null||nums.length==0) {
			return res;
		}
		Helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
	}
	
	public void Helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> subset, int index){
		res.add(new ArrayList<>(subset));
		//append updated list, subset to res, so every list in res is different
		//because all previous list in res are called subset, so res.add(subset) will add one list to res and update all lists of res to most updated subset, they are all same
		for (int j=index; j<nums.length; j++) {
			subset.add(nums[j]);
			Helper(nums,res,subset,j+1);
			subset.remove(subset.size()-1);
		}
	}
	//method1 use backtracking that begins with 1 till 3 and track back removing the most newly added element
    //[]->+[1]->+[1,2]->+[1,2,3]->+[1,2]->+[1,3]->+[2]->+[2,3]->+[3]

	public List<List<Integer>> subset(int[] nums){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums==null||nums.length==0) {
			return res;
		}
		helper(nums, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> subset, int index){
		if (index==nums.length){
			res.add(new ArrayList<>(subset));
			//add new subset when whole array traversal completed
		}
		else {
			helper(nums, res, subset, index + 1);
			subset.add(nums[index]);
			helper(nums, res, subset, index + 1);
			subset.remove(subset.size() - 1);
		}
	}
	//method2 use backtracking that subset add new element or not at each level traversal
	//[[]]--->[[],[1]]
	//    or->[[]]
}
