package leetcode;

public class DPLongestCommonSubString {
    public String longestCommonSubString (String a, String b) {
        if (a == null || b == null || a.length() * b.length() == 0) {
            return "";
        }
        int max = 0;
        int[] pos = new int[2];
        char[] arr_a = a.toCharArray();
        char[] arr_b = b.toCharArray();
        int[][] len = new int[arr_a.length + 1][arr_b.length + 1];
        for (int i = 1; i <= arr_a.length; i ++) {
            for (int j = 1; j <= arr_b.length; j ++) {
                len[i][j] = arr_a[i - 1] == arr_b[j - 1] ? len[i - 1][j - 1] + 1 : 0;
                if (len[i][j] > max) {
                    pos[0] = i;
                    pos[1] = j;
                    max = len[i][j];
                }
            }
        }
        return String.copyValueOf(arr_a, pos[0] - 1 - max, max);
    }
}
