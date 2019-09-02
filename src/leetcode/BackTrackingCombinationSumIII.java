package leetcode;

import java.util.ArrayList;
import java.util.List;

//find all combinations each of which consisted with k unique numbers from 1-9 adding up to n
public class BackTrackingCombinationSumIII {
    public List<List<Integer>> CombinationSumIII(int k, int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k<=0||n<=0){
            return res;
        }
        helper(res, new ArrayList<Integer>(), 1,n, k);
        return res;
    }

    public void helper(List<List<Integer>> res, ArrayList<Integer> sum, int candidate, int target, int seat){
        if (target==0&&seat==0){
            res.add(new ArrayList<Integer>(sum));
        }
        if (seat>0){
            for (int i=candidate; i<=9; i++){
                if (target>=seat*i){
                //quicker corner condition to break
                //can also use another strategy as following Helper
                    sum.add(i);
                    helper(res, sum, i+1, target-i, seat-1);
                    sum.remove(sum.size()-1);
                }
                else{
                    break;
                }
            }
        }
    }
    public void Helper(List<List<Integer>> res, ArrayList<Integer> sum, int candidate, int target, int seat){
        if (target==0&&sum.size()==seat){
            res.add(new ArrayList<Integer>(sum));
        }
        if (sum.size()<seat){
            for (int i=candidate; i<=9; i++){
                if (target>=i){
                    sum.add(i);
                    Helper(res, sum, i+1, target-i, seat);
                    sum.remove(sum.size()-1);
                }
                else{
                    break;
                }
            }
        }            
    }
}
