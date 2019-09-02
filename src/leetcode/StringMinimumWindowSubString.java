package leetcode;
import java.util.*;

class StringMinimunWindowSubString {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        for (int i=0; i< s.length()-t.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                for (int j=i; j <s.length()-i; j++) {

                }
            }
        }
    }
}