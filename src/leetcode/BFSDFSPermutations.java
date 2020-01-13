package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BFSDFSPermutations {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        dfs(nums, res, 0);
        return res;
    }
    public void dfs(int[] nums, ArrayList<List<Integer>> res, int index){
        if (index == nums.length - 1){
            ArrayList<Integer> per = new ArrayList<>();
            for (int num : nums) {
                per.add(num);
            }
            res.add(per);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, res, index + 1);
            swap(nums, index, i);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
