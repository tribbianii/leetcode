package leetcode;

import java.util.Arrays;

//no duplcates in array
public class BinarySearchSearchInRotatedSortedArray{
    //my method
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int len = nums.length;
        int end = len - 1;
        while (start < end) {
            int pos = start + (end - start) / 2;
            if (nums[pos] == target) {
                return pos;
            }
            if (nums[pos] > target) {
                if  (nums[0] > target && nums[0] <= nums[pos]) {
                    //if checked element in left part, target in right part
                    start = pos + 1;
                } else {
                    end = pos - 1;
                }
            } else {
                if (nums[len - 1] < target && nums[len - 1] >= nums[pos]) {
                    //if checked element in right part, target in left part
                    end = pos - 1;
                } else {
                    start = pos + 1;
                }
            }
        }
        return nums[start] == target ? start : -1;
    }
    //first determine the [mid] in left part or right part
    public int Search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { 
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}