package leetcode;

public class ArraySelectionSort{
    public int[] sort(int[] nums){
        if (nums==null || nums.length<=1){
            return nums;
        }
        for (int i=0;i<nums.length-1;i++){
            int index = findmin(nums,i,nums.length-1);
            swap(nums,index,i);
        }
        return nums;
    }
    private int findmin(int[] nums, int i, int j){
        int min = i;
        for (int k=i;k<=j;k++){
            min = nums[min]<=nums[k]?min:k;
        }
        return min;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}