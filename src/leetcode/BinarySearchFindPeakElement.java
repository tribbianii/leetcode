package leetcode;

//find one peak element in array which is greater than neighbors
//array[-1] and array[len] considered as negative infinity(-∞)
public class BinarySearchFindPeakElement{
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    //iteration method
    public int FindPeakElement(int[] nums){
        return helper(0,nums.length-1,nums);
    }
    private int helper(int start, int end, int[] nums){
        if (start==end){
            return start;
        }
        else {
            int mid = start+(end-start)/2;
            if (nums[mid]>nums[mid+1]){
                return helper(start, mid, nums);
            }
            else {
                return helper(mid+1, end, nums);
            }
        }
    }
    //recursion method
}