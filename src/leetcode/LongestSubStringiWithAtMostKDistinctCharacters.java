package leetcode;

import java.util.HashMap;
import java.util.Map;

class LongestSubStringiWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char d = s.charAt(left++);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
            }
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }
}