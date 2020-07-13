package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingCombinations {
    //given an array with no duplicated integers, print all combinations of k elements picked from array
    //The first method is THE BEST
    public List<List<Integer>> combinations(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, res, new ArrayList<Integer>(), 0, k);
        return  res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> combin, int index, int needed) {
        if(needed == 0) {
            res.add(new ArrayList<Integer>(combin));
            return;
        }
        if (needed > nums.length - index) {
            return;
        }
        combin.add(nums[index]);
        dfs(nums, res, combin, index + 1, needed - 1);
        combin.remove(combin.size()-1);
        dfs(nums, res, combin, index + 1, needed);
    }
    //find all possible combinations consisted with k numbers from 1 to n, no duplicated numbers in combination and different order doesn't counts
    public List<List<Integer>> Combinations(int n, int k){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n<k||n<=0||k<=0){
            return res;
        }
        helper(res, new ArrayList<Integer>(), 1, 0, n, k);
        return res;
    }

    public static void helper(List<List<Integer>> res, ArrayList<Integer> combin, int start, int index, int n, int k){
        if (index==k){
            res.add(new ArrayList<Integer>(combin));
            return;
            //out put one combination when it's full-filled
        }
        else{
            for (int i=start; i<=n; i++){
                combin.add(i);
                helper(res, combin, i+1, index+1, n, k);
                combin.remove(combin.size()-1);
            }
        }
    }
    //output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
}
