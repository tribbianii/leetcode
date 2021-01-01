package leetcode;

import org.jetbrains.annotations.NotNull;

public class StringLongestPalindrome {
    public String longestPalindrome(String s) {
        int[] res_index = new int[]{0, 0};
        boolean[][] valid = new boolean[s.length()][s.length()];
        for (int i = valid.length - 1; i >= 0; i --) {
            for (int j = i; j < valid.length; j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    valid[i][j] = (j - i) < 3 || valid[i + 1][j - 1];
                    if (valid[i][j] && (j - i) > (res_index[1] - res_index[0])) {
                        res_index[0] = i;
                        res_index[1] = j;
                    }
                }
            }
        }
        return s.substring(res_index[0], res_index[1] + 1);
    }
}