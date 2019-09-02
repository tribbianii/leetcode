package leetcode;

//sorted array to find target
public class BinarySearchClassical{
    public int find(int[] nums, int target){
        if (nums==null||nums.length==0||nums[0]>target||nums[nums.length-1]<target){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]<target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }   
        }
        return -1;
    }
}