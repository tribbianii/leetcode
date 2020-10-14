package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLen_left = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for(int right = 0; right < s.length(); right ++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0) {
                    count ++;
                }
                while(count == t.length()) {
                    if(right-left + 1 < minLen) {
                        minLen_left = left;
                        minLen = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if(map.get(s.charAt(left)) > 0) {
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen > s.length()) {
            return "";
        }
        return s.substring(minLen_left,minLen_left + minLen);
    }
}