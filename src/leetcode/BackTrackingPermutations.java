package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BackTrackingPermutations {
    public List<List<Integer>> Permutations(int[] nums){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<>();
        //Hashset can add/remove object and return whether a certain object exist in set
        if (nums==null||nums.length==0){
            return null;
        }
        helper (nums, res, new ArrayList<Integer>(), set);
        return res;
    }

    public static void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> per, HashSet<Integer> set){
        if (per.size()==nums.length){
            res.add(new ArrayList<Integer>(per));
        }
        else{
            if (per.size()<nums.length){
                for (int i=0; i<nums.length; i++){
                    if (!set.contains(nums[i])){
                        set.add(nums[i]);
                        per.add(nums[i]);
                        helper(nums, res, per, set);
                        set.remove(nums[i]);
                        per.remove(per.size()-1);
                    }
                    else{
                        continue;
                    }
                }
            }
        }
    }
}
