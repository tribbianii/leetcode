package leetcode;

public class ArrayRemoveDuplicateFromSortedArray {

	public int RemoveDuplicateFromSortedArray(int[] nums) {
		if (nums.length==0||nums==null) {
			return 0;
		}
		int i = 1;
		for (int j=1;j<nums.length;j++) {
			if (nums[j]!=nums[i-1]) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}

//remove all duplicate elements form SORTED array and return the length of new array

//use two integer variable. one to traverse and one to record
//i starts form 1 not 0. we don't care the first element
//do when element not equal