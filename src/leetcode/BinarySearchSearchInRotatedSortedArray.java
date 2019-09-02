package leetcode;

//no duplcates in array
public class BinarySearchSearchInRotatedSortedArray{
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return -1;
        }
        int start = 0;
        int len = nums.length;
        int end = len-1;
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]==target){
                return pos;
            }
            if (nums[pos]>target){
                if  (nums[0]>target && nums[0]<=nums[pos]){
                //if checked element in left part, target in right part
                    start = pos+1;
                }
                else {
                    end = pos;
                }
            }
            if (nums[pos]<target){
                if (nums[len-1]<target && nums[len-1]>nums[pos]){
                //if checked element in right part, target in left part
                    end = pos;
                }
                else {
                    start = pos+1;
                }
            }
        }
        return nums[start]==target?start:-1;
    }
    //my method
    public int Search(int[] nums, int target){
        if (nums==null||nums.length==0){
            return -1;
        }
        int start = 0;
        int len = nums.length;
        int end = len-1;
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]==target){
                return pos;
            }
            if (nums[pos]>=nums[start]){
                if (nums[pos]>target && nums[start]<=target){
                    end = pos;
                }
                else {
                    start = pos+1;
                }
                continue;
            }
            if (nums[pos]<nums[start]){
                if (nums[pos]<target && nums[end]>=target){
                    start = pos+1;
                }
                else {
                    end = pos;
                }
                continue;
            }
        }
        return nums[start]==target?start:-1;
    }
    //another method
}