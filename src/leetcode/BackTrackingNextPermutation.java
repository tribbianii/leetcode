package leetcode;

import java.util.Arrays;

public class BackTrackingNextPermutation {
    public void NextPermutation(int[] nums) {
        int end = nums.length - 1;
        int high_digit_to_swap = end - 1;
        while (high_digit_to_swap >= 0 && nums[high_digit_to_swap] >= nums[high_digit_to_swap + 1]) {
            high_digit_to_swap --;
        }
        if (high_digit_to_swap >= 0) {
            int low_digit_to_swap = end;
            while (low_digit_to_swap > high_digit_to_swap && nums[high_digit_to_swap] >= nums[low_digit_to_swap]) {
                low_digit_to_swap --;
            }
            swap(nums, high_digit_to_swap, low_digit_to_swap);
        }
        int reverse_from = high_digit_to_swap + 1;
        while (reverse_from < end) {
            swap(nums, reverse_from ++, end --);
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    //recursion
    public void nextPermutation(int[] input) {
        if (input==null || input.length<=1) {
            return;
        }
        for (int i=input.length-1; i>0; i--) {
            if (input[i] > input[i-1]) {
                for (int j=input.length-1; j>=i; j--) {
                    if (input[j] > input[i-1]) {
                        Swap(input, i-1, j);
                        reverse(input,i);
                        return;
                    }
                }
            }
        }
        reverse(input, 0);
        return;
    }
    static void Swap(int[] input, int one, int two) {
        int temp = input[one];
        input[one] = input[two];
        input[two] = temp;
    }
    static void reverse(int[] input, int start) {
        int end = input.length-1;
        while (start < end) {
            Swap(input, start, end);
            start++;
            end--;
        }
    }
}
