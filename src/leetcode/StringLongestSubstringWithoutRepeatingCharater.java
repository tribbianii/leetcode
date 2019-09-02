package leetcode;

import java.util.HashMap;
import java.util.Map;

public class StringLongestSubstringWithoutRepeatingCharater{
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        char[] strr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        for (int i = 0;i < strr.length;i ++) {
            if (map.containsKey(strr[i]) && map.get(strr[i]) >= start) {
                maxLen = Math.max(maxLen, i - start);
                curLen = i - map.get(strr[i]);
                start = map.get(strr[i]) + 1;
            }
            else {
                curLen ++;
            }
            map.put(strr[i], i);
        }
        return Math.max(maxLen, curLen);
    }
}