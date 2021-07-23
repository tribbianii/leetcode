package leetcode;

public class DPDecodeWays{
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || (int)(s.charAt(i - 1) - '0') > 2) {
                    return 0;
                }
                ways[i + 1] = ways[i - 1];
            } else {
                if (s.charAt(i - 1) == '0') {
                    ways[i + 1] = ways[i];
                } else {
                    ways[i + 1] = ways[i] + (((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) ? ways[i - 1] : 0);
                }
            }
        }
        return ways[ways.length - 1];
    }
}
