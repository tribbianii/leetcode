package leetcode;

public class BinarySearchSearchInsertPosition{
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]==target){
                return pos;
            }
            else if (nums[pos]>target){
                end = pos;
            }
            else {
                start = pos+1;
                //because x/2 operation will return integer value equal or less than float(x/2
                //when end-start=1, pos will stay at start due to /2 operation
                //so start should move forward one 
            }
        }
        if (nums[start]<target){
            return start+1;
        }   
        else {
            return start;
        }
    }
}