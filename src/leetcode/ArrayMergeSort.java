package leetcode;

import java.util.Arrays;

public class ArrayMergeSort{    
    //time complexity: O(nlog(n))
    //space complexity: O(n) = O(n/2) + O(n/4) + ......
    //original array doesn't change, return a new array
    public static int[] MergeSort(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        return Sort(nums, 0, nums.length - 1);
    }
    private static int[] Sort(int[] nums, int i, int j) {
        if (i == j) {
            return new int[]{nums[i]};
        }
        int mid = (i + j) / 2;
        return Merge(Sort(nums, i, mid), Sort(nums, mid + 1, j));
    }
    private static int[] Merge(int[] left, int[] right) {
        int i = 0; 
        int l = 0; 
        int r = 0;
        int[] merged = new int[left.length + right.length];
        while (l < left.length || r < right.length){
            if (l >= left.length || r >= right.length){
                merged[i++] = l >= left.length ? right[r++] : left[l++];
                continue;
            }
            merged[i++] = left[l] <= right[r] ? left[l++] : right[r++];
        }
        return merged;
    }
    
    //original array being sorted
    public static int[] mergeSort(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }
        //This is where additional space applied
        int[] copy = new int[nums.length];
        Sort (nums, copy, 0, nums.length - 1);
        return nums;
    }
    private static void Sort(int[] nums, int[] copy, int i, int j){
        if (i >= j){
            return;
        }
        int m = i + (j - i) / 2;
        Sort(nums, copy, i, m);
        Sort(nums, copy, m + 1, j);
        merge(nums, copy, i, m, j);
    }
    private static void merge(int[] nums, int[] copy, int from, int mid, int end){
        int left = from;
        int right = mid + 1;
        for (int i = from; i <= end; i ++) {
            copy[i] = nums[i];
        }
        while (left <= mid && right <= end){
            nums[from ++] = copy[left] <= copy[right] ? copy[left ++] : copy[right ++];
        }
        while (left <= mid) {
            nums[from ++] = copy[left ++];
        }
    }
    
    //one helper function version
    public static int[] mergesort (int[] arr) {
        int[] copy = new int[arr.length];
        return sort(copy, arr, 0, arr.length - 1);
    }
    public static int[] sort (int[] copy, int[] arr, int low, int high) {
        if (high <= low) {
            return arr;
        }
        int mid = (low + high) / 2;
        arr = sort(copy, arr, low, mid);
        arr = sort(copy, arr, mid + 1, high);
        for (int i = low; i <= high; i++) {
            copy[i] = arr[i];
        }
        int j = low;
        int m = low;
        int n = mid + 1;
        while (m <= mid && n <= high) {
            arr[j++] = copy[m] < copy[n] ? copy[m++] : copy[n++];
        }
        while (m <= mid) {
            arr[j++] = copy[m++];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{4,1,7,9,0,6,5,2})));
    }
}