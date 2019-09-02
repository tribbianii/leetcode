package leetcode;

public class ArrayRemoveDuplicateFromSortedArrayII {

	public int RemoveDuplicateFromSortedArrayII(int[] nums) {
		if (nums.length<=2) {
			return 2;
		}
		int i = 2;
		for (int j=2;j<nums.length-1;j++) {
			if (nums[j]!=nums[i-2]) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
//Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length