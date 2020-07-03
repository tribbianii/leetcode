package leetcode;

import java.util.Arrays;

public class ArrayQuickSort {
    public static int[] QuickSort(int[] arr){
        Sort(arr, 0, arr.length-1);
        return arr;
    }
    public static void Sort(int[] arr, int low, int high){ 
        if (low < high){
            int mid = partition(arr, low, high); 
            Sort(arr, low, mid - 1); 
            Sort(arr, mid + 1, high); 
        } 
    }
    private static int partition(int[] arr, int low, int high){ 
        int pivot = arr[high];
        int i = low;
        int j = high - 1;
        while (i <= j) {
            if (arr[i] >= pivot && arr[j] < pivot) {
                swap (arr, i++, j--);
                continue;
            }
            i = arr[i] < pivot ? i + 1: i;
            j = arr[j] >= pivot ? j - 1: j;
        }
        swap(arr, i, high);
        return i; 
    } 
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(QuickSort(new int[]{4,1,7,9,0,6,5,2})));
        System.out.println(((Boolean)false).getClass());
    }
}