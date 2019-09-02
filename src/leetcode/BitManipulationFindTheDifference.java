package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BitManipulationFindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        for (int i=0;i<t.length();i++){
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i))==0){
                return t.charAt(i);
            }
            else {
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
        }
        return ' ';
    }
    //following use bit manipulation
    public char FindTheDifference(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}