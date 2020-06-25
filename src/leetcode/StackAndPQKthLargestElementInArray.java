package leetcode;

import java.util.PriorityQueue;

public class StackAndPQKthLargestElementInArray{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i ++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else if (nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.poll();
    }
    //following method use quicksort
    public int FindKthLargest(int[] nums, int k) {
        QuickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public void QuickSort(int arr[], int low, int high){ 
        if (low < high){
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi-1); 
            QuickSort(arr, pi+1, high); 
        } 
    }
    private int partition(int arr[], int low, int high){ 
        int pivot = arr[high];  
        int i = low; 
        for (int j=low; j<high; j++) { 
            if (arr[j] <= pivot){ 
                swap(arr,i,j);
                i++;
            } 
        }
        swap(arr,i,high);
        return i; 
    } 
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}