package leetcode;

import java.util.*;

public class DPConcatenatedWords {
    //my dfs solution works well
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        Set<String> blacklist = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        for (String word : words) {
            if (dfs(dict, blacklist, word, 0, word.length(), 0)) {
                res.add(word);
            }
        }
        return res;
    }
    public boolean dfs(Set<String> dict, Set<String> blacklist, String word, int from, int end, int level) {
        if (level == 0) {
            if (blacklist.contains(word)) {
                return false;
            }
            for (int i = from + 1; i < end; i ++) {
                if (dfs(dict, blacklist, word, from, i, level + 1) && dfs(dict, blacklist, word, i, end, level + 1)) {
                    dict.add(word);
                    return true;
                }
            }
            blacklist.add(word);
        } else {
            String part = word.substring(from, end);
            if (dict.contains(part)) {
                return true;
            }
            if (blacklist.contains(part)) {
                return false;
            }
            for (int j = from + 1; j < end; j ++) {
                if (dfs(dict, blacklist, word, from, j, level + 1) && dfs(dict, blacklist, word, j, end, level + 1)) {
                    dict.add(part);
                    return true;
                }
            }
            blacklist.add(part);
        }
        return false;
    }
    //dp solution bit better
    public List<String> FindAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String w : words) {
            int len = w.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i <= len; i ++) {
                for (int j = i - 1; j >= 0; j --) {
                    if (dp[j] && dict.contains(w.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (len > 0 && dp[len]) {
                ans.add(w);
            }
            dict.add(w);
        }
        return ans;
    }
}
