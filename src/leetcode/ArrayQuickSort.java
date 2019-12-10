package leetcode;

public class ArrayQuickSort{
    public int[] QuickSort(int[] arr){
        Sort(arr, 0, arr.length-1);
        return arr;
    }
    public void Sort(int[] arr, int low, int high){ 
        if (low < high){
            int mid = partition(arr, low, high); 
            Sort(arr, low, mid - 1); 
            Sort(arr, mid + 1, high); 
        } 
    }
    private int partition(int[] arr, int low, int high){ 
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
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}