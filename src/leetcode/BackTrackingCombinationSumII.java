package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingCombinationSumII {
    public List<List<Integer>> CombinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates==null||candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        //note: array candidates may have duplicated numbers
        helper(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> sum, int index){
        if (target==0){
            res.add(new ArrayList<Integer>(sum));
        }
        for (int i=index; i<candidates.length; i++){
        //elements before candidates[index] has been used
        //say we have {1,2,2,3} the second 2 can only be considered when first 2 used
            if (target>=candidates[i]){
                if (i!=index&&candidates[i]==candidates[i-1]){
                    continue;
                    //skip the number that is identical with its previous one which has been added and then removed
                }
                else {
                    sum.add(candidates[i]);
                    helper(res, candidates, target - candidates[i], sum, i+1);
                    sum.remove(sum.size() - 1);
                }
            }
            else{
                break;
            }
        }
    }
}
