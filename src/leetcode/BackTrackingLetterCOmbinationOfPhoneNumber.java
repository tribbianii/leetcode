package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTrackingLetterCOmbinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        dfs(map, res, new StringBuilder(), digits, 0);
        return res;
    }

    public void dfs(Map<Character, char[]> map,List<String> res, StringBuilder comb, String digits, int index){
        if (index == digits.length()){
            res.add(new String(comb));
        } else{
            char c = digits.charAt(index);
            if (map.containsKey(c)){
                for (char d : map.get(c)){
                    comb.append(d);
                    dfs(map,res, comb, digits, index + 1);
                    comb.deleteCharAt(comb.length() - 1);
                }
            } else {
                dfs(map,res, comb, digits, index + 1);
            }
        }
    }
}
