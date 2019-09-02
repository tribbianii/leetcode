package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayFindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int center = find(arr,x);
        //arr[center]>=target due to binary search algorithm design
        int left = center-k-1>=0?center-k-1:0;
        int right = center+k-1>=arr.length?arr.length-1:center+k-1;
        while (right-left>=k){
            if (x-arr[left]<=arr[right]-x){
                right--;
            }
            else {
                left++;
            }
        }
        while (left<=right){
            res.add(arr[left]);
            left++;
        }
        return res;
    }
    private int find(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while (start < end){
        //if change to while (start < end-1)
        //will return index which arr[index]<=target
            int pos = start+(end-start)/2;
            if (arr[pos]==target){
                return pos;
            }
            if (arr[pos] < target){
                start = pos+1;
            }
            else {
                end = pos;
            }
        }
        return start;
    }
    //above is my method
    //here comes the python-like solution
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
   }
}