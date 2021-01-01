package leetcode;

import java.util.*;

public class DPWordBreakII {
    // use map<String, List<String>> to store match relationship
    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
    }
    public List<String> dfs(String suffix, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(suffix)) {
            return map.get(suffix);
        } else {
            List<String> suffixSentenceList = new ArrayList<>();
            if (dict.contains(suffix)) {
                suffixSentenceList.add(suffix);
            }
            for (int i = 1; i < suffix.length(); i ++) {
                String newPrefix = suffix.substring(0, i);
                if (dict.contains(newPrefix)) {
                    String newSuffix = suffix.substring(i);
                    for (String newSuffixSentence : dfs(newSuffix, dict, map)) {
                        suffixSentenceList.add(newPrefix + " " + newSuffixSentence);
                    }
                }
            }
            map.put(suffix, suffixSentenceList);
            return suffixSentenceList;
        }
    }
    //my two dimension dp + backtracking solution
    //extremely fast on normal case, exceeded time limit on some test cases
    public List<String> WordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        boolean[] visited = new boolean[s.length()];
        Dfs(s, dict, dp, visited, new StringBuilder(), 0, res);
        return  res;
    }
    public void Dfs(String str, Set<String> dict, boolean[][] dp, boolean[] visited, StringBuilder sb, int index, List<String> res) {
        if (index == dp.length - 1) {
            res.add(new String(sb.deleteCharAt(sb.length() - 1)));
            sb.append(" ");
            return;
        }
        if (visited[index]) {
            for (int i = index + 1; i < dp.length; i ++) {
                if (dp[index][i]) {
                    Dfs(str, dict, dp, visited, sb.append(str.substring(index, i)).append(" "), i, res);
                    int len = sb.length();
                    sb.delete((len - i + index - 1), len);
                }
            }
        } else {
            for (int j = index + 1; j < dp.length; j ++) {
                if (dict.contains(str.substring(index, j))) {
                    dp[index][j] = true;
                    Dfs(str, dict, dp, visited, sb.append(str.substring(index, j)).append(" "), j, res);
                    int len = sb.length();
                    sb.delete((len - j + index - 1), len);
                }
            }
            visited[index] = true;
        }
    }
}
