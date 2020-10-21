package leetcode;

public class StringLongestPalindrome {
    // My dp method, slower but intuitive
    public int[] res_index = new int[]{0, 0};
    public String LongestPalindrome(String s) {
        boolean[][] valid = new boolean[s.length()][s.length()];
        boolean[][] visited = new boolean[s.length()][s.length()];
        for (int i = valid.length - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if ((i - j) <= (res_index[1] - res_index[0])) {
                    break;
                }
                dfs(s, valid, visited, j, i);
            }
        }
        return s.substring(res_index[0], res_index[1] + 1);
    }
    public boolean dfs(String s, boolean[][] valid, boolean[][] visited, int from, int end) {
        if (visited[from][end]) {
            return valid[from][end];
        }
        if (from >= end) {
            return true;
        }
        if (s.charAt(from) == s.charAt(end) && dfs(s, valid, visited, from + 1, end - 1)) {
            valid[from][end] = true;
        }
        if (valid[from][end]) {
            if ((end - from) > (res_index[1] - res_index[0])) {
                res_index[0] = from;
                res_index[1] = end;
            }
        }
        visited[from][end] = true;
        return valid[from][end];
    }
    // optimal solution
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}