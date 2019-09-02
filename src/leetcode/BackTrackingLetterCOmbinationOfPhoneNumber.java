package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackTrackingLetterCOmbinationOfPhoneNumber {
    public List<String> PhoneNumber(String digits){
        List<String> res = new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        if (digits.length()==0||digits==null){
            return res;
        }
        helper(map, res, new StringBuilder(), digits, 0);
        return res;
    }

    public static void helper(HashMap<Character, char[]> map,List<String> res, StringBuilder comb,String digits, int index_digit){
        if (index_digit==digits.length()){
            String combin = comb.toString();
            res.add(new String(combin));
        }
        else{
            char c = digits.charAt(index_digit);
            if (map.containsKey(c)){
                for (char d : map.get(c)){
                    comb.append(d);
                    helper(map,res, comb, digits, index_digit+1);
                    comb.deleteCharAt(comb.length()-1);
                }
            }
        }
    }
}
