package leetcode;

//may be duplicates in array
public class BinarySearchSearchInRotatedSortedArrayII{
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) {
                left ++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
                right --;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}