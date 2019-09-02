package leetcode;

import java.util.Arrays;

public class ArrayMajorityElement{
    public int majorityElement(int[] nums) {
        if (nums.length<=2){
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}