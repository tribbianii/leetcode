package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingCombinationSum {
    public List<List<Integer>> CombinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates==null||candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        //help to determine the constrain for traversal
        //note: array candidates has no duplicated numbers
        helper(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> sum, int index){
        if (target==0){
            res.add(new ArrayList<Integer>(sum));
        }
        for (int i=index; i<candidates.length; i++) {
            if (target >= candidates[i]) {
                sum.add(candidates[i]);
                helper(res, candidates, target - candidates[i], sum, i);
                //keeping index equal to i but not i+1 enable function to firstly duplicate current number to reach the target
                //Input:[2,3,4,6,7] / 9
                //Output:[[2,2,2,3],[2,3,4],[2,7],[3,3,3],[3,6]]
                //if index changes to i+1, than combination will not contain duplicated numbers
                //Output:[[2,3,4],[2,7],[3,6]]
                sum.remove(sum.size() - 1);
            }
            else {
                break;
            }
        }
    }
}
