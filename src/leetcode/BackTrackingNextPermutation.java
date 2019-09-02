package leetcode;

import java.util.Arrays;

public class BackTrackingNextPermutation {
    public void NextPermutation(int[] nums){
        for (int i=nums.length-1;i>=0;i--){
            if (i==0){
                Arrays.sort(nums);
                break;
            }
            //i=0 means curr number is the max, it should change to min
            if (nums[i]<=nums[i-1]){
                continue;
            }
            else{
                for (int j=nums.length-1;j>0;j--){
                    if (nums[i-1]>=nums[j]){
                        continue;
                    }
                    else{
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums,i,nums.length);
                        break;
                    }
                }
                break;
            }
        }
    }
    //much faster solution
    public void nextPermutation(int[] input) {
        if (input==null || input.length<=1) {
            return;
        }
        for (int i=input.length-1; i>0; i--) {
            if (input[i] > input[i-1]) {
                for (int j=input.length-1; j>=i; j--) {
                    if (input[j] > input[i-1]) {
                        swap(input, i-1, j);
                        reverse(input,i);
                        return;
                    }
                }
            }
        }
        reverse(input, 0);
        return;
    }
    static void swap(int[] input, int one, int two) {
        int temp = input[one];
        input[one] = input[two];
        input[two] = temp;
    }
    static void reverse(int[] input, int start) {
        int end = input.length-1;
        while (start < end) {
            swap(input, start, end);
            start++;
            end--;
        }
    }
}
