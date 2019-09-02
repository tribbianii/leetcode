package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BFSDFSPermutation {
    //no duplicate char in string
    //II is case with duplicates
    public List<String> permutations(String str){
        List<String> res = new ArrayList<String>();
        if (str==null || str.length()==0){
            return res;
        }
        char[] dict = str.toCharArray();
        find(dict, res, 0);
        return res;
    }
    private void find(char[] dict, List<String> res, int index){
        if (index==dict.length){
            String per = String.valueOf(dict);
            res.add(new String(per));
            return;
        }
        else if (index < dict.length){
            for (int i = index;i < dict.length;i++){
                swap(dict,index,i);
                find(dict,res,index+1);
                swap(dict,index,i);
            }
        }
    }
    private void swap(char[] dict, int i, int j){
        char temp = dict[i];
        dict[i] = dict[j];
        dict[j] = temp;
    }
}