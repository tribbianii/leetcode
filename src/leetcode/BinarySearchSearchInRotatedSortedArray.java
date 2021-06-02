package leetcode;

import java.util.Arrays;

//no duplicates in array
//two great solutions and ideas, both good
//second solution with little modification can also apply to array with duplicate
public class BinarySearchSearchInRotatedSortedArray{
    //solution 1: determine whether mid and target are in the same ascending interval
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (target <= nums[len - 1] || nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[0] || nums[mid] <= nums[len - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    //solution 2: determine which interval the mid is located
    public int Search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
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
        return -1;
    }
}