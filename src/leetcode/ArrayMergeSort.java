package leetcode;

public class ArrayMergeSort{
    //top-down array merge sort     
    //time complexity: O(nlog(n))
    //space complexity: O(n + log(n))
    public int[] mergesort(int[] nums, int i, int j){
        if (nums==null || nums.length==0){
            return nums;
        }
        int[] copy = new int[nums.length]; 
        sort (nums, copy, i, j);
        return nums;
    }
    private void sort(int[] nums, int[] copy, int i, int j){
        if (i>=j){
            return;
        }
        int m = i+(j-i)/2;
        sort(nums,copy,i,m);
        sort(nums,copy,m+1,j);
        merge(nums,copy,i,m,j);
    }
    private void merge(int[] nums, int[] copy, int i, int m, int j){
        for (int k=i;k<=j;k++){
            copy[k] = nums[k];
        }
        int left = i;
        int right = m+1;
        while (left<=m && right<=j){
            if (copy[left]<=copy[right]){
                nums[i++]=copy[left++];
            }
            else {
                nums[i++]=copy[right++];
            }
        }
        while (left<=m){
            nums[i++]=copy[left++];
        }
    }
}