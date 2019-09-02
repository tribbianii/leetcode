package leetcode;

public class ArrayRemoveElement {

	public int RemoveElement(int[] nums, int val) {
	    if (nums==null||nums.length==0) {
	    	return 0;
	    }	
	    int len = nums.length;
	    int tail = 0;
	    for (int i = 0 ; i < len; i++) {
	    	if (nums[i] != val) {
                nums[tail] = nums[i];
                tail++;
            }
        }
        return tail;
	    }
}
//Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//Do not allocate extra space for another array, you must do this by **modifying the input array in-place ** with O(1) extra memory.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

//create two integer variable, one to traverse array and one to record new length
//tail incremented 1 after every replace so it is the index plus 1 = length