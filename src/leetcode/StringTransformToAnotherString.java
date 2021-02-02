package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformToAnotherString {
    public boolean canConvert(String str1, String str2) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> str2Set = new HashSet<>();
        for (int i = 0; i < str1.length(); i ++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            str2Set.add(c2);
            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            } else {
                if (map.get(c1) != c2) {
                    return false;
                }
            }
        }
        return str2Set.size() < 26 || str1.equals(str2);
    }
}
