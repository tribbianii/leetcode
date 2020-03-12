package leetcode;

public class StringRegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // take empty string into consideration
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        
        // matrix initialization
        // match[j > 0][0] = false
        match[0][0] = true;
        for (int i = 1; i < p.length() + 1; i ++) {
            if (p.charAt(i - 1) == '*') {
                // in this case: "a*" --> ""
                match[0][i] = match[0][i - 2];
            }
        }
        
        // expand the matrix
        for (int j = 1; j < s.length() + 1; j ++) {
            for (int i = 1; i < p.length() + 1; i ++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.') {
                    match[j][i] = match[j - 1][i - 1];
                    continue;
                }
                if (p.charAt(i - 1) == '*') {
                    if (s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.') {
                        // in this case: "a*" --> multiple 'a' || 0 'a'
                        match[j][i] = match[j - 1][i] || match[j][i - 2];
                        continue;
                    }
                    // in this case: "a*" --> ""
                    match[j][i] = match[j][i - 2];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}