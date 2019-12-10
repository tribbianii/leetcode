package leetcode;

public class ArrayMergeSort{
    //top-down array merge sort     
    //time complexity: O(nlog(n))
    //space complexity: O(n + log(n))
    public int[] mergesort(int[] nums){
        if (nums==null || nums.length==0){
            return nums;
        }
        int[] copy = new int[nums.length]; 
        sort (nums, copy, 0, nums.length - 1);
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
        while (left <= m || right <= j){
            if (left > m || right > j){
                nums[i++] = left > m ? copy[right++] : copy[left++];
                continue;
            }
            nums[i++] = copy[left] <= copy[right] ? copy[left++] : copy[right++];
        }
    }

    //one helper funtion version
    public int[] mergeSort (int[] arr) {
        int[] copy = new int[arr.length];
        return Sort(copy, arr, 0, arr.length - 1);
    }
    public int[] Sort (int[] copy, int[] arr, int low, int high) {
        if (high <= low) {
            return arr;
        }
        int mid = (low + high) / 2;
        arr = Sort(copy, arr, low, mid);
        arr = Sort(copy, arr, mid + 1, high);
        for (int i = low; i <= high; i++) {
            copy[i] = arr[i];
        }
        int j = low;
        int m = low;
        int n = mid + 1;
        while (m <= mid || n <= high) {
            if (m > mid || n > high) {
                arr[j++] = m > mid ? copy[n++] : copy[m++];
                continue;
            }
            arr[j++] = copy[m] < copy[n] ? copy[m++] : copy[n++];
        }
        return arr;
    }
}