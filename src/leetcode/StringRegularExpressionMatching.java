package leetcode;

public class StringRegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) {
            return false;
        }
        //dp[i][j] means if j chars of p match i chars of string s
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //initialize the first column
        //no need to initialize the first row 'cause they are defaultly 'false'
        for (int j = 1;j <= p.length();j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1;i <= s.length();i++) {
            for (int j = 1;j <= p.length();j++) {
                //if i of string s and j of string p doesn't matter
                if (p.charAt(j-1)=='.' || p.charAt(j - 1)==s.charAt(i - 1)) {
                    dp[i][j] = dp[i -1][j - 1];
                }
                /*e.g "a*" can be ——> ""
                                  ——> "a"
                                  ——> "aaaaaa....."
                */
                else if (p.charAt(j-1)=='*') {
                    if (p.charAt(j - 2)==s.charAt(i - 1) || p.charAt(j - 2)=='.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                    else {
                        //if s[i-1]!=p[j-1], then "a*" ——> ""
                        dp[i][j] = dp[i][j - 2];
                    }
                } 
            }
        }
        return dp[s.length()][p.length()];
    }
}