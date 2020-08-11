package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// super dope solution
public class ArraySmallerNumsBehind {
    public static int[] mergeSort(int[] nums){
        int[] backup = Arrays.copyOf(nums, nums.length);
        int[] copy = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        Sort (nums, copy, map,0, nums.length - 1);
        for (int i = 0; i < backup.length; i ++) {
            copy[i] = map.get(backup[i]);
        }
        return copy;
    }
    private static void Sort(int[] nums, int[] copy, Map<Integer, Integer> map, int i, int j){
        if (i < j) {
            int m = i + (j - i) / 2;
            Sort(nums, copy, map, i, m);
            Sort(nums, copy, map, m + 1, j);
            merge(nums, copy, map, i, m, j);
        }
    }
    private static void merge(int[] nums, int[] copy, Map<Integer, Integer> map, int from, int mid, int end){
        int left = from;
        int right = mid + 1;
        for (int i = from; i <= end; i ++) {
            copy[i] = nums[i];
        }
        while (left <= mid && right <= end){
            if (copy[left] > copy[right]) {
                nums[from ++] = copy[right ++];
            } else {
                map.put(copy[left], map.get(copy[left]) + right - mid - 1);
                nums[from++] = copy[left ++];
            }
        }
        while (left <= mid) {
            map.put(copy[left], map.get(copy[left]) + end - mid);
            nums[from ++] = copy[left ++];
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{6,7,5,4,0,3,2,1})));
    }
}
