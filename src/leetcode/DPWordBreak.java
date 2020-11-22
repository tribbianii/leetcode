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
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String word: wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i ++) {
            for(int j = i - maxLen; j < i; j ++) {
                if(j < 0) {
                    continue;
                }
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
