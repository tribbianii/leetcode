package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingSubsetsII {
    //array nums may have duplicated numbers
    public List<List<Integer>> SubsetsII(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums==null||nums.length==0){
            return res;
        }
        helper(nums, res, new ArrayList<Integer>(), 0, true);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> subset, int index, boolean added){
        if (index==nums.length){
            res.add(new ArrayList<>(subset));
        }
        else{
            helper(nums,res,subset,index+1,false);
            if (added==true||nums[index]!=nums[index-1]){
                subset.add(nums[index]);
                helper(nums,res,subset,index+1,true);
                subset.remove(subset.size()-1);
            }
        }
    }
}
