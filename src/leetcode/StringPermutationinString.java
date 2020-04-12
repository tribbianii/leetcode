package leetcode;

import java.util.Arrays;

public class StringPermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1_arr = new int[26];
        int[] s2_arr = new int[26];
        int s1_len = s1.length();
        int s2_len = s2.length();
        for (int i = 0; i < s1_len; i ++) {
            s1_arr[s1.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < s2_len; j ++) {
            s2_arr[s2.charAt(j) - 'a'] ++;
            if (j >= s1_len) {
                s2_arr[s2.charAt(j - s1_len) - 'a'] --;
            }
            if (Arrays.equals(s1_arr, s2_arr)) {
                return true;
            }
        }
        return false;
    }
}