package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words
//determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note:
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words

public class DPWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String str : wordDict) {
            minLen = Math.min(minLen, str.length());
            maxLen = Math.max(maxLen, str.length());
            dict.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int right = minLen; right < dp.length; right ++) {
            for (int left = Math.max(0, right - maxLen); left <= right - minLen; left ++) {
                if (dp[left] && dict.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
