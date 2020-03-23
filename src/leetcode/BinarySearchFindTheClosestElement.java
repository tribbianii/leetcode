package leetcode;

public class BinarySearchFindTheClosestElement{
    public int findclosest(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid;
            }
            else {
                right = mid;
            }   
        }
        return Math.abs(nums[left] - target) <= Math.abs(nums[right] - target) ? left : right;
    }
}