package leetcode;

public class ArrayQuickSort{
    public int[] QuickSort(int[] arr){
        SortinRange(arr, 0, arr.length-1);
        return arr;
    }
    /* 
    The main function that implements QuickSort() 
    arr[] --> Array to be sorted, 
    low  --> Starting index, 
    high  --> Ending index 
    */
    public void SortinRange(int[] arr, int low, int high){ 
        if (low < high){
            int pi = partition(arr, low, high); 
            //do recursion
            SortinRange(arr, low, pi-1); 
            SortinRange(arr, pi+1, high); 
        } 
    }
    //pick arr[high] as pivot
    //afterwards pivot's index probably change 
    //all elements less than pivot move to left of pivot
    //all elements greater than pivot move to right pf pivot
    //return pivot index
    private int partition(int[] arr, int low, int high){ 
        int pivot = arr[high];
        int i = low; 
        for (int j=low; j<=high; j++) { 
            if (arr[j] <= pivot){ 
                swap(arr,i,j);
                i++;
            } 
        }
        return i-1; 
    } 
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}