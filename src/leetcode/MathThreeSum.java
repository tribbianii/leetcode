package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingThreeSum {
    //following solution exceeded time limit on leetcode when input become huge
    //but works fine on laicode
    //classic dfs + sorted_input
    public List<List<Integer>> threeSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length<3 || nums[0]>target){
            return res;
        }
        dfs(nums,0,new ArrayList<Integer>(),res,target);
        return res;
    }
    private void dfs(int[] nums,int index,ArrayList<Integer> combin,ArrayList<List<Integer>> res,int left){
        if (combin.size()==3 && left==0){
            res.add(new ArrayList<Integer>(combin));
            return;
        }
        else if (combin.size() < 3 && left >= 0){
            for (int i=index;i<nums.length;i++){
                if (i!=index && nums[i]==nums[i-1]){
                    continue;
                }
                else if (nums[i] <= (left)/(3-combin.size())){
                    combin.add(nums[i]);
                    left -= nums[i];
                    dfs(nums, i+1, combin, res, left);
                    combin.remove(combin.size()-1);
                    left += nums[i];
                }
                else {
                    return;
                }
            }
        }
        else {
            return;
        }
    }
    //following method accepted by leetcode for 3sum with target=0
    public List<List<Integer>> ThreeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1;
                int hi = num.length-1; 
                int sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
                        }
                        lo++; 
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}