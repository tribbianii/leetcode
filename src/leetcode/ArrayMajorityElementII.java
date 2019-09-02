package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums==null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        int num = nums[0];
        int time = 1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==num){
                time++;
            }
            else {
                if (time>nums.length*1/3){
                    res.add(num);
                    if (res.size()==2 || i>nums.length*2/3){
                        return res;
                    }
                }
                num = nums[i];
                time = 1;
            }
        }
        if (time>nums.length*1/3){
            res.add(num);
        }
        return res;
    }
}