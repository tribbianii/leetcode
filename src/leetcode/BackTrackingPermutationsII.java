package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingPermutationsII {
    public List<List<Integer>> Permutations(int[] nums){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        if (nums==null||nums.length==0){
            return null;
        }
        helper (nums, res, new ArrayList<Integer>(), used);
        return res;
    }

    public static void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> per, boolean[] used){
        if (per.size()==nums.length){
            res.add(new ArrayList<Integer>(per));
        }
        else{
            for (int i=0; i<nums.length; i++){
                if (used[i]){
                    continue;
                }
                if (i!=0 && !used[i-1] && nums[i]==nums[i-1]){
                    continue;
                }
                per.add(nums[i]);
                used[i]=true;
                helper(nums, res, per, used);
                per.remove(per.size()-1);
                used[i]=false;
            }
        }
    }
}
