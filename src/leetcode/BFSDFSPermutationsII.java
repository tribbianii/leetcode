package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSDFSPermutationsII {
    //containing duplicate letters
    //here comes the swap-swap solution
    public List<String> Permutations(String str){
        List<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0){
            return res;
        }
        char[] dict = str.toCharArray();
        find(dict, res, 0);
        return res;
    }
    private void find(char[] dict, List<String> res, int index){
        if (index == dict.length){
            res.add(new String(dict));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index;i < dict.length;i ++){
            if (set.contains(dict[i])){
                continue;
            }
            swap(dict, index, i);
            find(dict, res, index + 1);
            swap(dict, index, i);
            set.add(dict[i]);
        }
    }
    private void swap(char[] dict, int i, int j){
        char temp = dict[i];
        dict[i] = dict[j];
        dict[j] = temp;
    }
}