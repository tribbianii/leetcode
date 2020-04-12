package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringFindAllAnagramsinString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }
        int[] s_arr = new int[26];
        int[] p_arr = new int[26];
        int s_len = s.length();
        int p_len = p.length();
        for (int i = 0; i < p_len; i ++) {
            p_arr[p.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < s_len; j ++) {
            s_arr[s.charAt(j) - 'a'] ++;
            if (j >= p_len) {
                s_arr[s.charAt(j - p_len) - 'a'] --;
            }
            if (Arrays.equals(s_arr, p_arr)) {
                res.add(j - p_len + 1);
            }
        }
        return res;
    }
}