package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSDFSPermutationsII {
    public List<String> permutations(String str){
        List<String> res = new ArrayList<String>();
        if (str==null || str.length()==0){
            return res;
        }
        char[] dict = str.toCharArray();
        char[] option = new char[dict.length];
        boolean[] used = new boolean[dict.length];
        find(dict, res, option, used, 0);
        return res;
    }
    private void find(char[] dict, List<String> res, char[] option, boolean[] used, int index){
        if (index==dict.length){
            String per = String.valueOf(option);
            res.add(new String(per));
            return;
        }
        else {
            //Note: This is a problem that consumed almost one day time to debug
            //the key point is that the 'Set<Character> set' has to be declared insides the 'find' function
            //because each call of 'find' is only for one level, so is the 'set', so the lifetime of 'set' has to end when 'find' executed
            //puting Set<Character> set into args of 'find' is wrong  
            Set<Character> set = new HashSet<>();
            for (int i = 0;i < dict.length;i++){
                char ch = dict[i];
                if (used[i]==true || set.contains(ch)){
                    continue;
                }
                option[index] = ch;
                used[i] = true;
                find(dict,res,option,used,index+1);
                used[i] = false;
                set.add(ch);
            }
        }
    }
    //here comes the swap-swap solution
    public List<String> Permutations(String str){
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
            Set<Character> set = new HashSet<>();
            for (int i = index;i < dict.length;i++){
                if (set.contains(dict[i])){
                    continue;
                }
                swap(dict,index,i);
                find(dict,res,index+1);
                swap(dict,index,i);
                set.add(dict[i]);
            }
        }
    }
    private void swap(char[] dict, int i, int j){
        char temp = dict[i];
        dict[i] = dict[j];
        dict[j] = temp;
    }
}