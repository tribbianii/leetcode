package leetcode;

public class BinarySearchFindRangeOfElement{
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1,-1};
        if (nums.length == 0 || nums == null || nums[0] > target || nums[nums.length - 1] < target){
            return range;
        }
        //------------------------------------------
        int start = 0; 
        int end = nums.length - 1;
        while (start < end - 1){
            int mid = start + (end - start) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] != target && nums[end] != target){
            return range;
        }
        range[0] = nums[start] == target ? start : end;
        //-------------------------------------------
        end = nums.length - 1;
        while (start < end - 1){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            }
            else {
                start = mid;
            }
        }
        range[1] = nums[end] == target ? end : start;
        //-------------------------------------------
        return range;
    }
}