package leetcode;

public class BinarySearchFindMinimumInRotatedArray{
    public int findMin(int[] nums) {
        if (nums==null||nums.length==0){
            return -1;
        }
        int target = Integer.MIN_VALUE;
        int start = 0;
        int len = nums.length;
        int end = len-1;
        //======================
        if (nums[end]>nums[0]){
            return nums[0];
        }
        //rotated back to original
        //======================
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]>target){
                if  (nums[0]>target && nums[0]<=nums[pos]){
                    start = pos+1;
                }
                else {
                    end = pos;
                }
            }
        }
        return nums[start];
    }
    //my method. think about search the Integer.MIN_VALUE in rotated array
    //search element with certain value in rotated array has been done in project
    //note: array rotated back to original order will be speical case
    public int FindMin(int[] num) {
        int start=0;
        int end=num.length-1;
        while (start<end) {
            if (num[start]<num[end]){
                return num[start];
            }
            int mid = (start+end)/2;
            if (num[mid]>=num[start]) {
                start = mid+1;
            } 
            else {
                end = mid;
            }
        }
        return num[start];
    }
    //other's method. concise and straight-forward thinking
    //if mid in left part then move start forward
    //if mid in right part then move end backward
    //there is no way start and end all in one part so it's not a case
}