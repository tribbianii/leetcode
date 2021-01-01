package leetcode;

public class DPWildCardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < match.length; i ++) {
            for (int j = 1; j < match[0].length; j ++) {
                if (i == 0) {
                    match[i][j] = p.charAt(j - 1) == '*' && match[i][j - 1];
                    continue;
                }
                if (p.charAt(j - 1) != '*') {
                    match[i][j] = match[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                    continue;
                }
                match[i][j] = match[i][j - 1] || match[i - 1][j];
            }
        }
        return match[match.length - 1][match[0].length - 1];
    }
    //a bit faster, earlier exit
    public boolean IsMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < match.length; i ++) {
            boolean matchExist = false;
            for (int j = 1; j < match[0].length; j ++) {
                if (i == 0) {
                    match[i][j] = p.charAt(j - 1) == '*' && match[i][j - 1];
                } else if (p.charAt(j - 1) != '*') {
                    match[i][j] = match[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                } else {
                    match[i][j] = match[i][j - 1] || match[i - 1][j];
                }
                matchExist = matchExist || match[i][j];
            }
            if (!matchExist && i > 0) {
                return false;
            }
        }
        return match[match.length - 1][match[0].length - 1];
    }
}
