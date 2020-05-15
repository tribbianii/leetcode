package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BFSDFSNinetyNineCent{
    //array coins stores values of different coins
    //find all those permutations of coins summing up to target value
    public List<List<Integer>> combinations(int sum, int[] coins){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> combin = new ArrayList<Integer>();
        find(res, combin, coins, 0, sum);
        return res;
    }
    private void find(ArrayList<List<Integer>> res, ArrayList<Integer> combin, int[] coins, int index, int left){
        if (index == coins.length) { 
            if (left == 0){
                res.add(new ArrayList<Integer>(combin));
            }
            return;
        }
        for (int i = 0; i <= (left / coins[index]); i++){
            combin.add(i);
            find(res, combin,coins, index+1, left - coins[index] * i);
            combin.remove(combin.size() - 1);
        }
    }
}